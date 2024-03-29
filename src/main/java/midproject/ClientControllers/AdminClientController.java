package midproject.ClientControllers;

import java.awt.event.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import midproject.SharedClasses.Implementations.CallbackImplementation;
import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.*;
import midproject.SharedClasses.Utilities.UserJSONProcessor;
import midproject.ViewClasses.AdminGUIFrame;
import midproject.ViewClasses.Login;
import java.util.List;

import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class AdminClientController {

    private static Login loginFrame = new Login();
    public static AdminGUIFrame adminGUIFrame = AdminGUIFrame.getInstance();
    private static User user = new User();
    private static Registry registry;
    private static ModelInterface msgserver;
    private static CallbackImplementation mci;

    private static String username;

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
                username = loginFrame.getUsernameTextField().getText();
                String password = new String(loginFrame.getPasswordField().getPassword());
                String userTypeRequest = "Admin";

                registry = LocateRegistry.getRegistry(ipAddress);
                msgserver = (ModelInterface) registry.lookup("msgserver");

                mci = new CallbackImplementation(user, adminGUIFrame);
                sessionID = msgserver.login(mci, username, password, userTypeRequest);

                if (sessionID != null) {
                    username = loginFrame.getUsernameTextField().getText();
                    loginFrame.dispose();
                    showClientGUI();
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Authentication failed.");
                }
            } catch (AuthenticationFailedException ex) {
                JOptionPane.showMessageDialog(loginFrame, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            } catch (AlreadyLoggedInException ex) {
                JOptionPane.showMessageDialog(loginFrame, "User already logged in with this client.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            } catch (UserExistsException ex) {
                JOptionPane.showMessageDialog(loginFrame, "Username already exists, choose a different one.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(loginFrame, "Login error: Server may be offline or invalid IP Address", "Login Failed",JOptionPane.ERROR_MESSAGE);
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

        autoRefreshUserRelatedComponents();

        /** LOGOUT RELATED METHODS */
        adminGUIFrame.getLogoutMouseClicked().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    msgserver.logout(mci, sessionID);
                    System.exit(0);
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, "Remote exception occurred.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NotLoggedInException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, "You are not logged in.", "Logout Failed", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
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
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, "Logout Process Failed.", "Logout Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        /** DASHBOARD RELATED METHODS */
        adminGUIFrame.getDashboardButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    autoRefreshUserRelatedComponents();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        /** REGISTERED USERS RELATED METHODS */
        adminGUIFrame.getrUsersViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = adminGUIFrame.getrUsersTable().getSelectedRow();
                if (selectedRow != -1) {
                    try {
                        String userId = adminGUIFrame.getrUsersTable().getValueAt(selectedRow, 0).toString();
                        msgserver.sendRUserDetailsToAdmins(userId,mci);
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                        JOptionPane.showMessageDialog(adminGUIFrame, "Error retrieving user details.", "Remote Exception", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(adminGUIFrame, "Please select a user first.", "Selection Required", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        adminGUIFrame.getrUsersEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    autoRefreshUserRelatedComponents();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        adminGUIFrame.getrUsersArchiveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = adminGUIFrame.getrUsersTable().getSelectedRow();
                if (selectedRow != -1) {
                    try {
                        String userId = adminGUIFrame.getrUsersTable().getValueAt(selectedRow, 0).toString();
                        msgserver.archiveUser(userId,mci, username);
                        autoRefreshUserRelatedComponents();
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                        JOptionPane.showMessageDialog(adminGUIFrame, "Error retrieving user details.", "Remote Exception", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(adminGUIFrame, "Please select a user first.", "Selection Required", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        adminGUIFrame.getrUsersSearchTextfield().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = adminGUIFrame.getrUsersSearchTextfield().getText().trim().toLowerCase();
                try {
                    msgserver.searchUsers(searchText, mci);
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        });


        /** ARCHIVED USERS RELATED METHODS */

        adminGUIFrame.getaUsersViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = adminGUIFrame.getaUsersTable().getSelectedRow();
                if (selectedRow != -1) {
                    try {
                        String userId = adminGUIFrame.getaUsersTable().getValueAt(selectedRow, 0).toString();
                        msgserver.sendAUserDetailsToAdmins(userId,mci);
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                        JOptionPane.showMessageDialog(adminGUIFrame, "Error retrieving user details.", "Remote Exception", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(adminGUIFrame, "Please select a user first.", "Selection Required", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        /*adminGUIFrame.getaUsersUnarchiveButton().addActionListener(new ActionListener() {
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
        }); */

        adminGUIFrame.getaUsersSearchTextfield().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        /** REGISTER USER RELATED METHODS */
        adminGUIFrame.getCreateAccountButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String userType = adminGUIFrame.getUserTypeComboBox().getSelectedItem().toString();
                    String firstName = adminGUIFrame.getFirstNameTextField().getText();
                    String lastName = adminGUIFrame.getLastNameTextField().getText();
                    String middleName = adminGUIFrame.getMiddleNameTextField().getText();
                    String birthdate = adminGUIFrame.getBirthdateTextField().getText();
                    String age = adminGUIFrame.getAgeTextField().getText();
                    String gender = adminGUIFrame.getGenderComboBox().getSelectedItem().toString();
                    String personWithDisability = adminGUIFrame.getPersonWithDisabilityCheckBox().isSelected() ? "Yes" : "No";
                    String email = adminGUIFrame.getEmailAddressTextField().getText();
                    String contactNumber = adminGUIFrame.getContactNumberTextField().getText();
                    String username = adminGUIFrame.getSetUsernameTextField().getText();
                    String password = new String(adminGUIFrame.getSetPasswordTextField().getText());
                    String confirmPassword = new String(adminGUIFrame.getConfirmPasswordTextField().getText());
                    String street = adminGUIFrame.getStreetAddressTextField().getText();
                    String additionalAddress = adminGUIFrame.getAptSuiteOptionalTextField().getText();
                    String city = adminGUIFrame.getMunicipalityTextField().getText();
                    String province = adminGUIFrame.getProvinceTextField().getText();
                    String zip = adminGUIFrame.getZipCodeTextField().getText();

                    // Perform input validation
                    if (firstName.isEmpty() || lastName.isEmpty() || birthdate.isEmpty() || age.isEmpty() ||
                            gender.isEmpty() || email.isEmpty() || contactNumber.isEmpty() || username.isEmpty() || password.isEmpty() ||
                            street.isEmpty() || city.isEmpty() || province.isEmpty() || zip.isEmpty()) {
                        throw new InvalidInputException("Please fill in all required fields.");
                    }

                    // Validate contact number format
                    if (!Pattern.matches("\\d{11}", contactNumber)) {
                        throw new InvalidInputException("Invalid contact number format. Please enter a 11-digit number.");
                    }

                    // Check if password and confirm password match
                    if (!password.equals(confirmPassword)) {
                        throw new InvalidInputException("Passwords do not match. Please re-enter.");
                    }

                    // Check if username is already taken
                    if (isUsernameTaken(username)) {
                        throw new InvalidInputException("Username is already taken. Please choose another username.");
                    }


                    // Create a User object
                    User newUser = new User(null, userType, firstName, lastName, middleName, birthdate, age, gender,
                            personWithDisability, email, contactNumber, username, password, confirmPassword,
                            street, additionalAddress, city, province, zip);


                    msgserver.registerUser(newUser);

                    // Show confirmation message
                    JOptionPane.showMessageDialog(adminGUIFrame, "Account created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Reset text fields
                    resetTextFields(adminGUIFrame);

                    try {
                        autoRefreshUserRelatedComponents();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }

                } catch (RemoteException ex) {
                    ex.printStackTrace();
                } catch (InvalidInputException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        /** ORDERS RELATED METHODS */

        /** PENDING ORDERS RELATED METHODS */

        /** INVENTORY RELATED METHODS */

        /** SEND MESSAGE RELATED METHODS */

        adminGUIFrame.getSendButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String broadcastMessage = adminGUIFrame.getSendMessageTextArea().getText();
                try {
                    msgserver.broadcast(mci, broadcastMessage);
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                } catch (NotLoggedInException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


    }


    /** AUTOREFRESH / HELPER METHODS */

    public static void autoRefreshUserRelatedComponents() throws Exception {
        msgserver.updateRegisteredUsersTable();
        msgserver.updateRegisteredUsersCount();
        msgserver.updateArchivedUsersTable();
    }

    private static void resetTextFields(AdminGUIFrame adminGUIFrame) {
        adminGUIFrame.getFirstNameTextField().setText("");
        adminGUIFrame.getLastNameTextField().setText("");
        adminGUIFrame.getMiddleNameTextField().setText("");
        adminGUIFrame.getBirthdateTextField().setText("");
        adminGUIFrame.getAgeTextField().setText("");
        adminGUIFrame.getGenderComboBox().setSelectedIndex(0);
        adminGUIFrame.getPersonWithDisabilityCheckBox().setSelected(false);
        adminGUIFrame.getEmailAddressTextField().setText("");
        adminGUIFrame.getContactNumberTextField().setText("");
        adminGUIFrame.getSetUsernameTextField().setText("");
        adminGUIFrame.getSetPasswordTextField().setText("");
        adminGUIFrame.getConfirmPasswordTextField().setText("");
        adminGUIFrame.getStreetAddressTextField().setText("");
        adminGUIFrame.getAptSuiteOptionalTextField().setText("");
        adminGUIFrame.getMunicipalityTextField().setText("");
        adminGUIFrame.getProvinceTextField().setText("");
        adminGUIFrame.getZipCodeTextField().setText("");
    }


    // Method to check if username is already taken
    private static boolean isUsernameTaken(String username) throws UsernameTakenException {
        try {
            // Read existing user data from file or database
            List<User> existingUsers = UserJSONProcessor.readUsersFromFile("res/UserInformation.json");

            // Iterate through existing users to check if username is taken
            for (User user : existingUsers) {
                if (user.getUsername().equals(username)) {
                    throw new UsernameTakenException("Username is already taken. Please choose another one.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Username is not taken
    }

    public void unarchiveSelectedUsers(String userId, String originalFilePath, String archiveFilePath) {
        try {
            // Call the server's unarchiveSelectedUsers method
            msgserver.unarchiveSelectedUsers(userId, originalFilePath, archiveFilePath);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error unarchiving user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
