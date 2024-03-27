package midproject.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.google.gson.*;
import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserJSONProcessor;
import midproject.ViewClasses.AdminGUIFrame;
import midproject.ViewClasses.Login;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
        FlatMacLightLaf.setup();
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
                int row = adminGUIFrame.getrUsersTable().getSelectedRow();
                if (row != -1) {
                    String userId = (String) adminGUIFrame.getrUsersTable().getValueAt(row, 0);
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


        adminGUIFrame.getRegisteredUsersButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jsonFilePath = "res/UserInformation.json";
                try {
                    Gson gson = new Gson();
                    Reader reader = Files.newBufferedReader(Paths.get(jsonFilePath));
                    JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

                    DefaultTableModel model = (DefaultTableModel) adminGUIFrame.getrUsersTable().getModel();

                    model.setRowCount(0);

                    for (JsonElement userElement : jsonArray) {
                        JsonObject userObject = userElement.getAsJsonObject();
                        Object[] rowData = {
                                userObject.get("userId").getAsString(),
                                userObject.get("lastName").getAsString(),
                                userObject.get("firstName").getAsString(),
                                userObject.get("userType").getAsString(),
                                userObject.get("username").getAsString()
                        };
                        model.addRow(rowData);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
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
                if (validateInputs()) {
                    try {
                        String jsonFilePath = "res/UserInfo.json";
                        Gson gson = new Gson();
                        User newUser = new User();
                        newUser.setUserId(generateUserId());
                        newUser.setFirstName(adminGUIFrame.getFirstNameTextField().getText());
                        newUser.setLastName(adminGUIFrame.getLastNameTextField().getText());
                        newUser.setMiddleName(adminGUIFrame.getMiddleNameTextField().getText());
                        newUser.setBirthdate(adminGUIFrame.getBirthdateTextField().getText());
                        newUser.setAge(adminGUIFrame.getAgeTextField().getText());
                        // newUser.setGender(adminGUIFrame.getGenderComboBox().getText());
                        newUser.setPersonWithDisability(adminGUIFrame.getPersonWithDisabilityCheckBox().getText());
                        newUser.setEmail(adminGUIFrame.getEmailAddressTextField().getText());
                        newUser.setContactNumber(adminGUIFrame.getContactNumberTextField().getText());
                        newUser.setUsername(adminGUIFrame.getSetUsernameTextField().getText());
                        newUser.setPassword(new String(adminGUIFrame.getSetPasswordTextField().getText()));
                        newUser.setStreet(adminGUIFrame.getStreetAddressTextField().getText());
                        // newUser.setAdditionalAddressDetails(adminGUIFrame.getAdditionalAddressDetailsField().getText());
                        newUser.setCity(adminGUIFrame.getMunicipalityTextField().getText());
                        newUser.setProvince(adminGUIFrame.getProvinceTextField().getText());
                        newUser.setZip(adminGUIFrame.getZipCodeTextField().getText());

                        String userJson = gson.toJson(newUser);

                        // Read existing content from the file
                        String existingContent = "";
                        try (BufferedReader br = new BufferedReader(new FileReader(jsonFilePath))) {
                            StringBuilder sb = new StringBuilder();
                            String line;
                            while ((line = br.readLine()) != null) {
                                sb.append(line);
                            }
                            existingContent = sb.toString();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        // Update existing content with new user JSON
                        if (existingContent.isEmpty()) {
                            existingContent = "[" + userJson + "]";
                        } else {
                            existingContent = existingContent.substring(0, existingContent.length() - 1) + ",\n" + userJson + "]";
                        }

                        // Write the updated content back to the file
                        FileWriter fileWriter = new FileWriter(jsonFilePath);
                        fileWriter.write(existingContent);
                        fileWriter.close();

                        JOptionPane.showMessageDialog(adminGUIFrame, "User created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                        // Clear form fields after successful creation
                        clearFormFields();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(adminGUIFrame, "Error creating user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private static String generateUserId() {
        // Implement logic to generate user ID
        return "U" + (int) (Math.random() * 1000);
    }

    private static void clearFormFields() {
        // Implement logic to clear form fields after successful creation
        adminGUIFrame.getFirstNameTextField().setText("");
        adminGUIFrame.getLastNameTextField().setText("");
        adminGUIFrame.getMiddleNameTextField().setText("");
        adminGUIFrame.getBirthdateTextField().setText("");
        adminGUIFrame.getAgeTextField().setText("");
        adminGUIFrame.getGenderComboBox().setSelectedIndex(0);
        adminGUIFrame.getPersonWithDisabilityCheckBox().setText("");
        adminGUIFrame.getEmailAddressTextField().setText("");
        adminGUIFrame.getContactNumberTextField().setText("");
        adminGUIFrame.getSetUsernameTextField().setText("");
        adminGUIFrame.getSetPasswordTextField().setText("");
        adminGUIFrame.getStreetAddressTextField().setText("");
        adminGUIFrame.getMunicipalityTextField().setText("");
        adminGUIFrame.getProvinceTextField().setText("");
        adminGUIFrame.getZipCodeTextField().setText("");
    }

    public static boolean validateInputs() {
        if (adminGUIFrame.getFirstNameTextField().getText().isEmpty() ||
                adminGUIFrame.getLastNameTextField().getText().isEmpty() ||
                adminGUIFrame.getMiddleNameTextField().getText().isEmpty() ||
                adminGUIFrame.getAgeTextField().getText().isEmpty() ||
                adminGUIFrame.getStreetAddressTextField().getText().isEmpty() ||
                adminGUIFrame.getMunicipalityTextField().getText().isEmpty() ||
                adminGUIFrame.getProvinceTextField().getText().isEmpty() ||
                adminGUIFrame.getZipCodeTextField().getText().isEmpty() ||
                adminGUIFrame.getEmailAddressTextField().getText().isEmpty() ||
                adminGUIFrame.getContactNumberTextField().getText().isEmpty() ||
                adminGUIFrame.getSetUsernameTextField().getText().isEmpty() ||
                new String(adminGUIFrame.getSetPasswordTextField().getText()).isEmpty()) {
            JOptionPane.showMessageDialog(adminGUIFrame, "There are incomplete fields.", "Incomplete Fields", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String password = new String(adminGUIFrame.getSetPasswordTextField().getText());
        if (password.length() < 6 || password.length() > 12 ||
                !password.matches(".*[A-Z].*") || // At least one capital letter
                !password.matches(".*\\d.*") ||   // At least one digit
                !password.matches(".*[!@#$%^&*()].*")) { // At least one special character
            JOptionPane.showMessageDialog(adminGUIFrame, "Password must be 6-12 characters and contain at least one capital letter (A-Z), one digit(0-9), and one special character.", "Password Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String contactNumber = adminGUIFrame.getContactNumberTextField().getText();
        if (contactNumber.length() != 11) {
            JOptionPane.showMessageDialog(adminGUIFrame, "Contact number must be 11 digits long.", "Contact Number Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}
