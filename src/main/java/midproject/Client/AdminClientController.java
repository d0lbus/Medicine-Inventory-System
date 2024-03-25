package midproject.Client;

import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.NotLoggedInException;
import midproject.ViewClasses.AdminGUIFrame;
import midproject.ViewClasses.ClientGUIFrame;
import midproject.ViewClasses.Login;
import java.awt.event.MouseAdapter;

import javax.swing.*;

public class AdminClientController {

    private static Login loginFrame = new Login();
    private static AdminGUIFrame adminGUIFrame = new AdminGUIFrame();
    private static User user = new User();
    private static Registry registry;
    private static ModelInterface msgserver;
    private static CallbackImplementation mci;

    private static String sessionID;


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

                registry = LocateRegistry.getRegistry(ipAddress);
                msgserver = (ModelInterface) registry.lookup("msgserver");
                mci = new CallbackImplementation(user);
                sessionID = msgserver.login(mci, username, password);

                if (sessionID != null) {
                    loginFrame.dispose();
                    showClientGUI();
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Authentication failed.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(loginFrame, "Login error: " + ex.getMessage());
            }
        });
    }

    private static void showClientGUI(){
        adminGUIFrame.setVisible(true);
        /**
         * 	PROFILE RELATED FUNCTIONS
         *  Logout
         *  Display Profile
         *  Change Password
         * */

    }
}

