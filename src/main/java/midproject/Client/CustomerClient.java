package midproject.Client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.ViewClasses.ClientGUIFrame;
import midproject.ViewClasses.Login;

import javax.swing.*;

public class CustomerClient {

	private static Login loginFrame = new Login();
	private static ClientGUIFrame clientGUIFrame = new ClientGUIFrame();

	private static User user = new User();


	public static void main(String[] args) {
		initiateLoginProcess();
	}

	private static void initiateLoginProcess() {
		loginFrame.setVisible(true);
		loginFrame.getLogInButton().addActionListener(e -> {
			try {
				String ipAddress = loginFrame.getIpAddressTextField().getText();
				String username = loginFrame.getUsernameTextField().getText();
				String password = new String(loginFrame.getPasswordField().getPassword());

				Registry registry = LocateRegistry.getRegistry(ipAddress);
				ModelInterface msgserver = (ModelInterface) registry.lookup("msgserver");
				CallbackImplementation mci = new CallbackImplementation(user);
				boolean isAuthenticated = msgserver.login(mci, username, password);

				if (isAuthenticated) {
					loginFrame.dispose();
				} else {
					JOptionPane.showMessageDialog(loginFrame, "Authentication failed.");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(loginFrame, "Login error: " + ex.getMessage());
			}
		});

	}
}

