package midproject.Client;

import java.awt.event.*;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.google.gson.*;
import midproject.Server.ServerImplementation;
import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.InvalidInputException;
import midproject.SharedClasses.UserDefinedExceptions.NotLoggedInException;
import midproject.ViewClasses.AdminGUIFrame;
import midproject.ViewClasses.Login;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class AdminClientController {

    private static Login loginFrame = new Login();
    private static AdminGUIFrame adminGUIFrame = AdminGUIFrame.getInstance();
    private static User user = new User();
    private static Registry registry;
    private static ModelInterface msgserver;
    private static CallbackImplementation mci;

    private static String sessionID;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
        }

        SwingUtilities.invokeLater(() -> {
            loginFrame = new Login();
            initiateLoginProcess();
            loginFrame.setVisible(true);
        });
    }

    private static void initiateLoginProcess() {
        FlatMacLightLaf.setup();
        loginFrame.setVisible(true);
        loginFrame.getLogInButton().addActionListener(e -> {
            try {
                String ipAddress = loginFrame.getIpAddressTextField().getText();
                String username = loginFrame.getUsernameTextField().getText();
                String password = new String(loginFrame.getPasswordField().getPassword());

                registry = LocateRegistry.getRegistry(ipAddress);
                msgserver = (ModelInterface) registry.lookup("msgserver");

                mci = new CallbackImplementation(user, adminGUIFrame);
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

    private static void showClientGUI() throws Exception {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf for AdminGUIFrame");
        }

        adminGUIFrame.setVisible(true);

        msgserver.updateRegisteredUsersTable(mci);
        msgserver.updateRegisterUsersCount(mci);

        adminGUIFrame.getDashboardButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        adminGUIFrame.getLogoutMouseClicked().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    msgserver.logout(mci, sessionID);
                    System.exit(0);
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, "Remote exception occurred.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NotLoggedInException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, "You are not logged in.", "Logout Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        adminGUIFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    msgserver.logout(mci, sessionID);
                    System.exit(0);
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, "Remote exception occurred.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NotLoggedInException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, "You are not logged in.", "Logout Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        adminGUIFrame.getaUsersUnarchiveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = adminGUIFrame.getaUsersTable().getSelectedRow();
                if (row != -1) {
                    String userId = (String) adminGUIFrame.getaUsersTable().getValueAt(row, 0);
                    try {
                        // Pass the required arguments to the unarchiveSelectedUsers() method
                        msgserver.unarchiveSelectedUsers(userId, "res/UserInformation.json", "res/ArchiveFile.json");
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

        adminGUIFrame.getaUsersViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = adminGUIFrame.getaUsersTable().getSelectedRow();
                if (row != -1) {
                    String userId = (String) adminGUIFrame.getaUsersTable().getValueAt(row, 0);
                    try {
                        User archivedUser = msgserver.viewArchivedUserDetails(userId, "res/ArchiveFile.json");
                        if (archivedUser != null) {
                            String userInfo = "User ID: " + archivedUser.getUserId() + "\n" +
                                    "First Name: " + archivedUser.getFirstName() + "\n" +
                                    "Last Name: " + archivedUser.getLastName() + "\n" +
                                    "Middle Name: " + archivedUser.getMiddleName() + "\n" +
                                    "Birthdate: " + archivedUser.getBirthdate() + "\n" +
                                    "Age: " + archivedUser.getAge() + "\n" +
                                    "Gender: " + archivedUser.getGender() + "\n" +
                                    "Person with Disability: " + archivedUser.getPersonWithDisability() + "\n" +
                                    "Email: " + archivedUser.getEmail() + "\n" +
                                    "Contact Number: " + archivedUser.getContactNumber() + "\n" +
                                    "Username: " + archivedUser.getUsername() + "\n" +
                                    "Password: " + archivedUser.getPassword() + "\n" +
                                    "Street: " + archivedUser.getStreet() + "\n" +
                                    "Additional Address Details: " + archivedUser.getAdditionalAddressDetails() + "\n" +
                                    "City: " + archivedUser.getCity() + "\n" +
                                    "Province: " + archivedUser.getProvince() + "\n" +
                                    "ZIP: " + archivedUser.getZip();
                            JOptionPane.showMessageDialog(adminGUIFrame, userInfo, "Archived User Information", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(adminGUIFrame, "User not found in archive.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(adminGUIFrame, "Error retrieving archived user information: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(adminGUIFrame, "Please select a user from the table.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        adminGUIFrame.getaUsersSearchTextfield().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        adminGUIFrame.getrUsersSearchTextfield().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(adminGUIFrame.getrUsersTable().getModel());
                adminGUIFrame.getrUsersTable().setRowSorter(sorter);
                String searchText = adminGUIFrame.getrUsersSearchTextfield().getText().trim().toLowerCase();

                if (searchText.isEmpty()) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(searchText), 1));
                }
            }
        });

        adminGUIFrame.getrUsersViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        adminGUIFrame.getCreateAccountButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ServerImplementation server = new ServerImplementation();
                    server.registerUser(adminGUIFrame);
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                } catch (InvalidInputException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
