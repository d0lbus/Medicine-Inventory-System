package midproject.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        initController();
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

    }

    private static void initController() {
        adminGUIFrame.getaUsersUnarchiveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = adminGUIFrame.getaUsersTable().getSelectedRow();
                if (row != -1) {
                    String userId = (String) adminGUIFrame.getaUsersTable().getValueAt(row, 0);
                    try {
                        // Pass the required arguments to the unarchiveSelectedUsers() method
                        msgserver.unarchiveSelectedUsers(userId, "UserInformation.json", "ArchiveFile.json");
                        JOptionPane.showMessageDialog(adminGUIFrame, "User unarchived successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(adminGUIFrame, "Error unarchiving user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(adminGUIFrame, "Please select a user to unarchive.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        adminGUIFrame.getRegisteredUsersButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
