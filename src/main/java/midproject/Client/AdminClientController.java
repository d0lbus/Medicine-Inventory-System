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
import midproject.SharedClasses.UserDefinedExceptions.UsernameTakenException;
import midproject.SharedClasses.UserJSONProcessor;
import midproject.ViewClasses.AdminGUIFrame;
import midproject.ViewClasses.Login;
import java.util.List;
import java.util.regex.Matcher;

import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class AdminClientController {

    private static Login loginFrame = new Login();
    public static AdminGUIFrame adminGUIFrame = AdminGUIFrame.getInstance();
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

                    // Register the user
                    ServerImplementation server = new ServerImplementation();
                    server.registerUser(newUser);

                    // Show confirmation message
                    JOptionPane.showMessageDialog(adminGUIFrame, "Account created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Reset text fields
                    resetTextFields(adminGUIFrame);

                    // Auto refresh user-related components
                    autoRefreshUserRelatedComponents();

                } catch (RemoteException ex) {
                    ex.printStackTrace();
                } catch (InvalidInputException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
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

    public static void autoRefreshUserRelatedComponents() throws Exception {
        msgserver.updateRegisteredUsersTable(mci);
        msgserver.updateRegisterUsersCount(mci);
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
