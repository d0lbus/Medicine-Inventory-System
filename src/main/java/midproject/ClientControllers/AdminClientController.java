package midproject.ClientControllers;

import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import midproject.SharedClasses.Implementations.CallbackImplementation;
import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.ReferenceClasses.Medicine;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.*;
import midproject.SharedClasses.Utilities.UserJSONProcessor;
import midproject.ViewClasses.AddMedicineFrame;
import midproject.ViewClasses.AdminGUIFrame;
import midproject.ViewClasses.EditMedicineFrame;
import midproject.ViewClasses.Login;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
            FlatLightLaf.updateUI();
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
            ex.printStackTrace();
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
                JOptionPane.showMessageDialog(loginFrame, "Login error: Server may be offline or invalid IP Address", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private static void showClientGUI() throws Exception {
        adminGUIFrame.setLocationRelativeTo(null);
        adminGUIFrame.setVisible(true);

        autoRefreshUserRelatedComponents();
        autoRefreshMedicineRelatedComponents();

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
                        msgserver.sendRUserDetailsToAdmins(userId, mci);
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                        JOptionPane.showMessageDialog(adminGUIFrame, "Error retrieving user details.", "Remote Exception", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    try {
                        throw new SelectionRequiredViewUserException("Please select a user first.");
                    } catch (SelectionRequiredViewUserException exception) {
                        JOptionPane.showMessageDialog(adminGUIFrame, exception.getMessage(), "Selection Required", JOptionPane.WARNING_MESSAGE);
                    }
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
                        msgserver.archiveUser(userId, mci, username);
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
                } catch (NoUserFoundException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, ex.getMessage(), "No User Found", JOptionPane.ERROR_MESSAGE);
                }  catch (RemoteException ex) {
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
                        msgserver.sendAUserDetailsToAdmins(userId, mci);
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                        JOptionPane.showMessageDialog(adminGUIFrame, "Error retrieving user details.", "Remote Exception", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    try {
                        throw new SelectionRequiredViewUserException("Please select a user first.");
                    } catch (SelectionRequiredViewUserException exception) {
                        JOptionPane.showMessageDialog(adminGUIFrame, exception.getMessage(), "Selection Required", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        adminGUIFrame.getaUsersUnarchiveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = adminGUIFrame.getaUsersTable().getSelectedRow();
                if (selectedRow != -1) {
                    try {
                        String userId = adminGUIFrame.getaUsersTable().getValueAt(selectedRow, 0).toString();
                        msgserver.unarchiveUser(userId, mci, username);
                        autoRefreshUserRelatedComponents();
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                        JOptionPane.showMessageDialog(adminGUIFrame, "Error retrieving user details.", "Remote Exception", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    try {
                        throw new SelectionRequiredUnarchiveUserException("Please select a user first.");
                    } catch (SelectionRequiredUnarchiveUserException exception) {
                        JOptionPane.showMessageDialog(adminGUIFrame, exception.getMessage(), "Selection Required", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        adminGUIFrame.getaUsersSearchTextfield().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = adminGUIFrame.getaUsersSearchTextfield().getText().trim().toLowerCase();
                try {
                    msgserver.searchArchivedUsers(searchText, mci);
                } catch (NoUserFoundException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, ex.getMessage(), "No User Found", JOptionPane.ERROR_MESSAGE);
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
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
                    String birthdate = String.valueOf(adminGUIFrame.getBirthdate().getDate());
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

                    // Check if username already exists
                    if (isUsernameAlreadyExists(username)) {
                        throw new UsernameAlreadyExistsException("Username already exists, please choose a different one.");
                    }

                    // Create a User object
                    User newUser = new User(null, userType, firstName, lastName, middleName, birthdate, age, gender,
                            personWithDisability, email, contactNumber, username, password, confirmPassword,
                            street, additionalAddress, city, province, zip);


                    msgserver.registerUser(newUser, username);

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
                } catch (UsernameAlreadyExistsException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, ex.getMessage(), "Username Already Exists", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        /** ORDERS RELATED METHODS */








        /** PENDING ORDERS RELATED METHODS */

        /** INVENTORY RELATED METHODS */

        adminGUIFrame.getiSearchTextfield().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = adminGUIFrame.getiSearchTextfield().getText().trim().toLowerCase();
                try {
                    msgserver.searchMedicine(searchText, mci);
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        });

        adminGUIFrame.getiAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddMedicineFrame addMedicineFrame = new AddMedicineFrame();
                addMedicineFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addMedicineFrame.setLocationRelativeTo(null);
                addMedicineFrame.setVisible(true);
                addMedicineFrame.getAddMedicineButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Medicine medicine = new Medicine();
                        medicine.setCategory(addMedicineFrame.getCategoryTextField().getText());
                        medicine.setGenericName(addMedicineFrame.getGenericNameTextField().getText());
                        medicine.setBrandName(addMedicineFrame.getBrandNameTextField().getText());
                        medicine.setForm(addMedicineFrame.getFormTextField().getText());
                        medicine.setQuantity(Integer.parseInt(addMedicineFrame.getQuantityTextField().getText()));
                        medicine.setPrice(Double.parseDouble(addMedicineFrame.getAmmountTextField().getText()));
                        try {
                            msgserver.addMedicine(medicine, mci, username);
                            autoRefreshMedicineRelatedComponents();
                            JOptionPane.showMessageDialog(addMedicineFrame, "Medicine updated successfully.");
                            addMedicineFrame.dispose();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(addMedicineFrame, "Error updating medicine: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
            }
        });

        adminGUIFrame.getiEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = adminGUIFrame.getiTable().getSelectedRow();
                if (selectedRow >= 0) {
                    DefaultTableModel model = (DefaultTableModel) adminGUIFrame.getiTable().getModel();

                    EditMedicineFrame editMedicineFrame = new EditMedicineFrame();
                    editMedicineFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    editMedicineFrame.setLocationRelativeTo(null);
                    editMedicineFrame.setVisible(true);

                    Medicine selectedMedicine = new Medicine();
                    selectedMedicine.setMedicineID(model.getValueAt(selectedRow, 0).toString());
                    selectedMedicine.setCategory(model.getValueAt(selectedRow, 1).toString());
                    selectedMedicine.setGenericName(model.getValueAt(selectedRow, 2).toString());
                    selectedMedicine.setBrandName(model.getValueAt(selectedRow, 3).toString());
                    selectedMedicine.setForm(model.getValueAt(selectedRow, 4).toString());
                    selectedMedicine.setQuantity(Integer.parseInt(model.getValueAt(selectedRow, 5).toString()));
                    selectedMedicine.setPrice(Double.parseDouble(model.getValueAt(selectedRow, 6).toString()));

                    String selectedMedicineID = selectedMedicine.getMedicineID();

                    editMedicineFrame.getCategoryTextField().setText(selectedMedicine.getCategory());
                    editMedicineFrame.getGenericNameTextField().setText(selectedMedicine.getGenericName());
                    editMedicineFrame.getBrandNameTextField().setText(selectedMedicine.getBrandName());
                    editMedicineFrame.getFormTextField().setText(selectedMedicine.getForm());
                    editMedicineFrame.getQuantityTextField().setText(String.valueOf(selectedMedicine.getQuantity()));
                    editMedicineFrame.getAmmountTextField().setText(String.format("%.2f", selectedMedicine.getPrice()));

                    editMedicineFrame.getEditButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Medicine editedMedicine = new Medicine();

                            editedMedicine.setMedicineID(selectedMedicineID);
                            editedMedicine.setCategory(editMedicineFrame.getCategoryTextField().getText());
                            editedMedicine.setGenericName(editMedicineFrame.getGenericNameTextField().getText());
                            editedMedicine.setBrandName(editMedicineFrame.getBrandNameTextField().getText());
                            editedMedicine.setForm(editMedicineFrame.getFormTextField().getText());
                            editedMedicine.setQuantity(Integer.parseInt(editMedicineFrame.getQuantityTextField().getText()));
                            editedMedicine.setPrice(Double.parseDouble(editMedicineFrame.getAmmountTextField().getText()));

                            try {
                                msgserver.updateMedicine(editedMedicine, selectedMedicine, mci, username);
                                autoRefreshMedicineRelatedComponents();
                                JOptionPane.showMessageDialog(editMedicineFrame, "Medicine updated successfully.");
                                editMedicineFrame.dispose();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(editMedicineFrame, "Error updating medicine: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(adminGUIFrame, "Please select a medicine to edit.", "No Selection", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        adminGUIFrame.getiDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = adminGUIFrame.getiTable().getSelectedRow();
                if (selectedRow != -1) {
                    try {
                        Medicine medicineToDelete = new Medicine();
                        medicineToDelete.setMedicineID(adminGUIFrame.getiTable().getValueAt(selectedRow, 0).toString());
                        medicineToDelete.setCategory(adminGUIFrame.getiTable().getValueAt(selectedRow, 1).toString());
                        medicineToDelete.setGenericName(adminGUIFrame.getiTable().getValueAt(selectedRow, 2).toString());
                        medicineToDelete.setBrandName(adminGUIFrame.getiTable().getValueAt(selectedRow, 3).toString());
                        medicineToDelete.setForm(adminGUIFrame.getiTable().getValueAt(selectedRow, 4).toString());
                        medicineToDelete.setQuantity((Integer) adminGUIFrame.getiTable().getValueAt(selectedRow, 5));
                        medicineToDelete.setPrice((Double) adminGUIFrame.getiTable().getValueAt(selectedRow, 6));

                        msgserver.deleteMedicine(medicineToDelete, mci, username);
                        autoRefreshMedicineRelatedComponents();

                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                        JOptionPane.showMessageDialog(adminGUIFrame, "Error retrieving user details.", "Remote Exception", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(adminGUIFrame, "Please select a medicine first.", "Selection Required", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        /** SEND MESSAGE RELATED METHODS */

        adminGUIFrame.getSendButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String broadcastMessage = adminGUIFrame.getSendMessageTextArea().getText();
                try {
                    msgserver.broadcast(broadcastMessage);
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                } catch (NotLoggedInException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        adminGUIFrame.getBirthdateCalendar().addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    // Get the selected date from the JDateChooser
                    Date selectedDate = (Date) evt.getNewValue();

                    // Calculate age based on the selected date
                    int age = calculateAge(selectedDate);

                    // Update the ageTextField
                    adminGUIFrame.getAgeTextField().setText(String.valueOf(age));
                }
            }
        });
    }

    private static int calculateAge(Date birthdate) {
        Calendar birthdateCal = Calendar.getInstance();
        birthdateCal.setTime(birthdate);
        Calendar now = Calendar.getInstance();

        int age = now.get(Calendar.YEAR) - birthdateCal.get(Calendar.YEAR);
        if (now.get(Calendar.DAY_OF_YEAR) < birthdateCal.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }


    /** AUTOREFRESH / HELPER METHODS */

    private static void autoRefreshUserRelatedComponents() throws Exception {
        msgserver.updateRegisteredUsersTable();
        msgserver.updateRegisteredUsersCount();
        msgserver.updateArchivedUsersTable();
    }

    private static void autoRefreshMedicineRelatedComponents() throws Exception{
        msgserver.updateInventoryTable();
    }

    private static void resetTextFields(AdminGUIFrame adminGUIFrame) {
        adminGUIFrame.getFirstNameTextField().setText("");
        adminGUIFrame.getLastNameTextField().setText("");
        adminGUIFrame.getMiddleNameTextField().setText("");
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
        adminGUIFrame.getBirthdateCalendar().setDate(new Date());
    }

    // Method to check if username already exists
    private static boolean isUsernameAlreadyExists(String username) {
        try {
            // Retrieve all users from file or database
            List<User> users = UserJSONProcessor.readUsersFromFile("res/UserInformation.json");

            // Check if any user has the same username
            for (User existingUser : users) {
                if (existingUser.getUsername().equals(username)) {
                    return true; // Username already exists
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Username does not exist
    }

}
