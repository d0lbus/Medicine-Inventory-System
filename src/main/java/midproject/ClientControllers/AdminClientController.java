package midproject.ClientControllers;

import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import midproject.SharedClasses.Servants.CallbackImplementation;
import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.ReferenceClasses.Medicine;
import midproject.SharedClasses.ReferenceClasses.Order;
import midproject.SharedClasses.ReferenceClasses.OrderItem;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.*;
import midproject.SharedClasses.Utilities.UserJSONProcessor;
import midproject.ViewClasses.*;

import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import static midproject.SharedClasses.Utilities.UserJSONProcessor.fetchUserInformationFromDataSource;

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
        autoRefreshOrderRelatedComponents();

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
                        throw new SelectionRequiredException("Please select a user first.");
                    } catch (SelectionRequiredException exception) {
                        JOptionPane.showMessageDialog(adminGUIFrame, exception.getMessage(), "Selection Required", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        /**
        adminGUIFrame.getrUsersEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    autoRefreshUserRelatedComponents();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });*/

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
                    try {
                        throw new SelectionRequiredException("Please select a user first.");
                    } catch (SelectionRequiredException ex) {
                        JOptionPane.showMessageDialog(adminGUIFrame, ex.getMessage(), "Selection Required", JOptionPane.WARNING_MESSAGE);
                    }
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

        adminGUIFrame.getrUsersEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = adminGUIFrame.getrUsersTable().getSelectedRow();
                if (selectedRow >= 0) {
                    DefaultTableModel model = (DefaultTableModel) adminGUIFrame.getrUsersTable().getModel();

                    EditUserFrame editUserFrame = new EditUserFrame();
                    editUserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    editUserFrame.setLocationRelativeTo(null);
                    editUserFrame.setVisible(true);

                    User selectedUser = new User();
                    selectedUser.setLastName(model.getValueAt(selectedRow, 1).toString());
                    selectedUser.setFirstName(model.getValueAt(selectedRow, 2).toString());
                    selectedUser.setUserType(model.getValueAt(selectedRow, 3).toString());
                    selectedUser.setUsername(model.getValueAt(selectedRow, 4).toString());

                    String userId = adminGUIFrame.getrUsersTable().getValueAt(selectedRow, 0).toString();
                    selectedUser = fetchUserInformationFromDataSource(userId, "res/UserInformation.json");

                    String selectedUserId = selectedUser.getUserId();

                    editUserFrame.getFirstNameTextField().setText(selectedUser.getFirstName());
                    editUserFrame.getLastNameTextField().setText(selectedUser.getLastName());
                    editUserFrame.getMiddleNameTextField().setText(selectedUser.getMiddleName());
                    editUserFrame.getBirthdateTextField().setText(selectedUser.getBirthdate());
                    editUserFrame.getAgeTextField().setText(selectedUser.getAge());
                    editUserFrame.getGenderComboBox().setSelectedItem(selectedUser.getGender());
                    //editUserFrame.getPersonWithDisabilityCheckBox().setSelected(selectedUser.getPersonWithDisability());
                    editUserFrame.getEmailAddressTextField().setText(selectedUser.getEmail());
                    editUserFrame.getContactNumberTextField().setText(selectedUser.getContactNumber());
                    editUserFrame.getStreetAddressTextField().setText(selectedUser.getStreet());
                    editUserFrame.getOptionalDetailsTextField().setText(selectedUser.getAdditionalAddressDetails());
                    editUserFrame.getCityMunicipalityTextField().setText(selectedUser.getCity());
                    editUserFrame.getProvinceTextField().setText(selectedUser.getProvince());
                    editUserFrame.getPostalCodeTextField().setText(selectedUser.getZip());


                    User finalSelectedUser = selectedUser;
                    editUserFrame.getEditAccountButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            User editedUser = new User();
                            // Get the edited user details from the editUserFrame
                            //User editedUser = editUserFrame.getEditedUser();

                            editedUser.setUserId(selectedUserId);
                            editedUser.setFirstName(editUserFrame.getFirstNameTextField().getText());
                            editedUser.setLastName(editUserFrame.getLastNameTextField().getText());
                            editedUser.setMiddleName(editUserFrame.getMiddleNameTextField().getText());
                            editedUser.setBirthdate(editUserFrame.getBirthdateTextField().getText());
                            editedUser.setAge(editUserFrame.getAgeTextField().getText());
                            editedUser.setGender((String) editUserFrame.getGenderComboBox().getSelectedItem());
                            //editedUser.setPersonWithDisability(editUserFrame.getPersonWithDisabilityCheckBox().getAction().isEnabled());
                            editedUser.setEmail(editUserFrame.getEmailAddressTextField().getText());
                            editedUser.setContactNumber(editUserFrame.getContactNumberTextField().getText());
                            editedUser.setStreet(editUserFrame.getStreetAddressTextField().getText());
                            editedUser.setAdditionalAddressDetails(editUserFrame.getOptionalDetailsTextField().getText());
                            editedUser.setCity(editUserFrame.getCityMunicipalityTextField().getText());
                            editedUser.setProvince(editUserFrame.getProvinceTextField().getText());
                            editedUser.setZip(editUserFrame.getPostalCodeTextField().getText());

                            try {

                                msgserver.updateUser(editedUser, finalSelectedUser, mci, username);

                                autoRefreshUserRelatedComponents();
                                JOptionPane.showMessageDialog(editUserFrame, "User updated successfully.");
                                editUserFrame.dispose();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(editUserFrame, "Error updating user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                } else {
                    try {
                        throw new SelectionRequiredException("Please select a user first.");
                    } catch (SelectionRequiredException exception) {
                        JOptionPane.showMessageDialog(adminGUIFrame, exception.getMessage(), "Selection Required", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        /**
        adminGUIFrame.getrUsersEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = adminGUIFrame.getrUsersTable().getSelectedRow();
                if (selectedRow != -1) {
                    String userId = adminGUIFrame.getrUsersTable().getValueAt(selectedRow, 0).toString();
                    User selectedUser = fetchUserInformationFromDataSource(userId, "res/UserInformation.json");
                    if (selectedUser != null) {
                        EditUserFrame editUserFrame = new EditUserFrame(selectedUser);
                        editUserFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(adminGUIFrame, "Failed to retrieve user information.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    try {
                        throw new SelectionRequiredUserException("Please select a user first.");
                    } catch (SelectionRequiredUserException exception) {
                        JOptionPane.showMessageDialog(adminGUIFrame, exception.getMessage(), "Selection Required", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }); */


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
                        throw new SelectionRequiredException("Please select a user first.");
                    } catch (SelectionRequiredException exception) {
                        JOptionPane.showMessageDialog(adminGUIFrame, exception.getMessage(), "Selection Required", JOptionPane.ERROR_MESSAGE);
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
                        throw new SelectionRequiredException("Please select a user first.");
                    } catch (SelectionRequiredException exception) {
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
                    boolean personWithDisability = Boolean.parseBoolean(adminGUIFrame.getPersonWithDisabilityCheckBox().isSelected() ? "Yes" : "No");
                    String email = adminGUIFrame.getEmailAddressTextField().getText();
                    String contactNumber = adminGUIFrame.getContactNumberTextField().getText();
                    String username = adminGUIFrame.getSetUsernameTextField().getText();
                    String password = new String(adminGUIFrame.getPasswordField().getText());
                    String confirmPassword = new String(adminGUIFrame.getConfirmPasswordField().getText());
                    String street = adminGUIFrame.getStreetAddressTextField().getText();
                    String additionalAddress = adminGUIFrame.getAptSuiteOptionalTextField().getText();
                    String city = adminGUIFrame.getMunicipalityTextField().getText();
                    String province = adminGUIFrame.getProvinceTextField().getText();
                    String zip = adminGUIFrame.getZipCodeTextField().getText();

                    // Perform input validation
                    if (firstName.isEmpty() || lastName.isEmpty() || birthdate.isEmpty() || age.isEmpty() ||
                            gender.isEmpty() || email.isEmpty() || contactNumber.isEmpty() || username.isEmpty() || password.isEmpty() ||
                            street.isEmpty() || city.isEmpty() || province.isEmpty() || zip.isEmpty() || confirmPassword.isEmpty()) {
                        throw new MissingFieldException("Please fill in empty fields.");
                    }

                    // Validate contact number format
                    if (!Pattern.matches("\\d{11}", contactNumber)) {
                        throw new InvalidInputException("Invalid contact number format. Please enter a 11-digit number.");
                    }

                    // Check if password and confirm password match
                    if (!password.equals(confirmPassword)) {
                        throw new InvalidInputException("Passwords do not match. Please re-enter.");
                    }

                    // Validate email format
                    if (!Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{3,}", email)) {
                        throw new InvalidInputException("Invalid email format.");
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
                } catch (MissingFieldException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, ex.getMessage(), "Missing Field", JOptionPane.ERROR_MESSAGE);
                } catch (UsernameAlreadyExistsException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, ex.getMessage(), "Username Already Exists", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        /** ORDERS RELATED METHODS */

        adminGUIFrame.getoViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = adminGUIFrame.getoTable().getSelectedRow();
                if (selectedRow >= 0) {
                    String orderId = (String) adminGUIFrame.getoTable().getValueAt(selectedRow, 0);
                    try {
                        CompleteCancelFrame completeCancelFrame = new CompleteCancelFrame();
                        completeCancelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        completeCancelFrame.setLocationRelativeTo(null);
                        completeCancelFrame.setVisible(true);
                        Order chosenOrder = msgserver.retrieveOrderDetails(orderId);
                        User user = msgserver.getUserDetailsbyId(chosenOrder.getUserId());

                        StringBuilder orderDetails = new StringBuilder();

                        for (OrderItem item : chosenOrder.getItems()) {
                            String itemDetails = String.format("Medicine ID: %s\nGeneric Name: %s\nBrand Name: %s\nForm: %s\nQuantity: %d\nPrice: ₱%.2f\n\n",
                                    item.getMedicineId(), item.getGenericName(), item.getBrandName(), item.getForm(),
                                    item.getQuantity(), item.getPrice());
                            orderDetails.append(itemDetails);
                        }

                        orderDetails.append(String.format("Total: ₱%.2f\n", chosenOrder.getTotal()));

                        byte[] imageBytes = Base64.getDecoder().decode(chosenOrder.getImage());

                        ImageIcon imageIcon = new ImageIcon(imageBytes);

                        StyledDocument doc = (StyledDocument) completeCancelFrame.getAcceptCancelTextpane().getDocument();
                        doc.insertString(doc.getLength(), buildOrderDetailsString(user, orderId, orderDetails, chosenOrder.getModeOfDelivery(), chosenOrder.getPaymentMethod()), null);


                        Style style = doc.addStyle("ImageStyle", null);
                        StyleConstants.setIcon(style, imageIcon);
                        doc.insertString(doc.getLength(), "ignored text", style);

                        completeCancelFrame.getCompleteButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String status = "Completed";
                                try {
                                    msgserver.updateOrderStatus(orderId,status);
                                    JOptionPane.showMessageDialog(completeCancelFrame, "Order " + chosenOrder.getOrderId() + " Completed Successfully", "Complete Order", JOptionPane.INFORMATION_MESSAGE);
                                    completeCancelFrame.setVisible(false);
                                    autoRefreshOrderRelatedComponents();
                                } catch (RemoteException ex) {
                                    throw new RuntimeException(ex);
                                } catch (Exception ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        });

                        completeCancelFrame.getCancelButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String status = "Cancelled";
                                try {
                                    msgserver.updateOrderStatus(orderId ,status);
                                    JOptionPane.showMessageDialog(completeCancelFrame, "Order " + chosenOrder.getOrderId() + " Cancelled Successfully", "Cancel Order", JOptionPane.INFORMATION_MESSAGE);
                                    completeCancelFrame.setVisible(false);
                                    autoRefreshOrderRelatedComponents();
                                } catch (RemoteException ex) {
                                    throw new RuntimeException(ex);
                                } catch (Exception ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        });


                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(adminGUIFrame, "Failed to load order details.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    try {
                        throw new SelectionRequiredException("Please select an order to view.");
                    } catch (SelectionRequiredException ex) {
                        JOptionPane.showMessageDialog(adminGUIFrame, ex.getMessage(), "No Selection", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        adminGUIFrame.getoSearchTextfield().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = adminGUIFrame.getoSearchTextfield().getText().trim().toLowerCase();
                try {
                    msgserver.searchOrders(searchText, mci);
                } catch (NoOrdersFoundException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, ex.getMessage(), "No Order Found", JOptionPane.ERROR_MESSAGE);
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        });

        /** PENDING ORDERS RELATED METHODS */

        adminGUIFrame.getpViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = adminGUIFrame.getpTable().getSelectedRow();
                if (selectedRow >= 0) {
                    String orderId = (String) adminGUIFrame.getpTable().getValueAt(selectedRow, 0);
                    try {
                        AcceptRejectFrame acceptRejectFrame = new AcceptRejectFrame();
                        acceptRejectFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        acceptRejectFrame.setLocationRelativeTo(null);
                        acceptRejectFrame.setVisible(true);
                        Order chosenOrder = msgserver.retrieveOrderDetails(orderId);
                        User user = msgserver.getUserDetailsbyId(chosenOrder.getUserId());

                        StringBuilder orderDetails = new StringBuilder();

                        for (OrderItem item : chosenOrder.getItems()) {
                            String itemDetails = String.format("Medicine ID: %s\nGeneric Name: %s\nBrand Name: %s\nForm: %s\nQuantity: %d\nPrice: ₱%.2f\n\n",
                                    item.getMedicineId(), item.getGenericName(), item.getBrandName(), item.getForm(),
                                    item.getQuantity(), item.getPrice());
                            orderDetails.append(itemDetails);
                        }

                        orderDetails.append(String.format("Total: ₱%.2f\n", chosenOrder.getTotal()));

                        byte[] imageBytes = Base64.getDecoder().decode(chosenOrder.getImage());

                        ImageIcon imageIcon = new ImageIcon(imageBytes);

                        StyledDocument doc = (StyledDocument) acceptRejectFrame.getjTextPane1().getDocument();
                        doc.insertString(doc.getLength(), buildOrderDetailsString(user, orderId, orderDetails, chosenOrder.getModeOfDelivery(), chosenOrder.getPaymentMethod()), null);


                        Style style = doc.addStyle("ImageStyle", null);
                        StyleConstants.setIcon(style, imageIcon);
                        doc.insertString(doc.getLength(), "ignored text", style);

                        acceptRejectFrame.getAcceptButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String status = "Accepted";
                                try {
                                    msgserver.updateOrderStatus(orderId,status);
                                    JOptionPane.showMessageDialog(acceptRejectFrame, "Order " + chosenOrder.getOrderId() + " Accepted Successfully", "Accept Order", JOptionPane.INFORMATION_MESSAGE);
                                    acceptRejectFrame.setVisible(false);
                                    autoRefreshOrderRelatedComponents();
                                } catch (RemoteException ex) {
                                    throw new RuntimeException(ex);
                                } catch (Exception ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        });

                        acceptRejectFrame.getRejectButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String status = "Rejected";
                                try {
                                    msgserver.updateOrderStatus(orderId ,status);
                                    JOptionPane.showMessageDialog(acceptRejectFrame, "Order " + chosenOrder.getOrderId() + " Rejected Successfully", "Reject Order", JOptionPane.INFORMATION_MESSAGE);
                                    acceptRejectFrame.setVisible(false);
                                    autoRefreshOrderRelatedComponents();
                                } catch (RemoteException ex) {
                                    throw new RuntimeException(ex);
                                } catch (Exception ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        });


                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(adminGUIFrame, "Failed to load order details.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    try {
                        throw new SelectionRequiredException("Please select an order to view");
                    } catch (SelectionRequiredException ex) {
                        JOptionPane.showMessageDialog(adminGUIFrame, ex.getMessage(), "Selection Required", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        adminGUIFrame.getpSearchTextfield().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = adminGUIFrame.getpSearchTextfield().getText().trim().toLowerCase();
                try {
                    msgserver.searchPendingOrders(searchText, mci);
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        });

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
                    selectedMedicine.setMedicineID(model.getValueAt(selectedRow,0).toString());
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
                    try {
                        throw new SelectionRequiredException("Please select a medicine to edit.");
                    } catch (SelectionRequiredException ex) {
                        JOptionPane.showMessageDialog(adminGUIFrame, ex.getMessage(), "No Selection", JOptionPane.WARNING_MESSAGE);
                    }
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
                String selectedUsername = (String) adminGUIFrame.getComboBox().getSelectedItem();
                String broadcastMessage = adminGUIFrame.getSendMessageTextArea().getText();

                if (selectedUsername == null || selectedUsername.isEmpty()) {
                    JOptionPane.showMessageDialog(adminGUIFrame, "Please select a user.", "No User Selected", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (broadcastMessage.isEmpty()) {
                    JOptionPane.showMessageDialog(adminGUIFrame, "Please enter a message to send.", "No Message", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    msgserver.broadcast(selectedUsername, broadcastMessage);
                    JOptionPane.showMessageDialog(adminGUIFrame, "Message sent to " + selectedUsername + ".", "Message Sent", JOptionPane.INFORMATION_MESSAGE);
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, "Failed to send the message due to a server error.", "Server Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                } catch (NotLoggedInException ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, "You are not logged in.", "Not Logged In", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(adminGUIFrame, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        adminGUIFrame.getBirthdateCalendar().addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    Date selectedDate = (Date) evt.getNewValue();
                    int age;
                    try {
                        age = calculateAge(selectedDate);
                        adminGUIFrame.getAgeTextField().setText(String.valueOf(age));

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    /** AUTOREFRESH / HELPER METHODS */

    private static void autoRefreshUserRelatedComponents() throws Exception {
        msgserver.updateRegisteredUsersTable();
        msgserver.updateRegisteredUsersCount();
        msgserver.updateArchivedUsersTable();
        msgserver.updateRegisteredUsersTable();
    }

    private static void autoRefreshMedicineRelatedComponents() throws Exception{
        msgserver.updateInventoryTable();
    }

    private static void autoRefreshOrderRelatedComponents() throws Exception{
        msgserver.updateOrdersTable();
        msgserver.updateDashboard();
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
        adminGUIFrame.getPasswordField().setText("");
        adminGUIFrame.getConfirmPasswordField().setText("");
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
            List<User> users = UserJSONProcessor.readUsersFromFile("res/UserInformation.json");

            for (User existingUser : users) {
                if (existingUser.getUsername().equals(username)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static int calculateAge(Date birthdate) throws Exception {
        Calendar birthdateCal = Calendar.getInstance();
        birthdateCal.setTime(birthdate);
        Calendar now = Calendar.getInstance();

        if (now.before(birthdateCal)) {
            return 0;
        }

        int age = now.get(Calendar.YEAR) - birthdateCal.get(Calendar.YEAR);


        birthdateCal.add(Calendar.YEAR, age);
        if (now.before(birthdateCal)) {
            age--;
        }
        autoRefreshMedicineRelatedComponents();
        return age;
    }

    private static String buildOrderDetailsString(User user, String orderID, StringBuilder orderDetails, String modeOfDelivery, String modeOfPayment) {
        StringBuilder details = new StringBuilder();
        details.append("John Doe's Official Receipt("+orderID+")"+"\n\n");
        details.append("Name: ").append(user.getFirstName()).append(" ").append(user.getLastName()).append("\n");
        details.append("Address: ").append(user.getStreet()).append(" ").append(user.getAdditionalAddressDetails()).append(" ");
        details.append(user.getCity()).append(", ").append(user.getProvince()).append(" ").append(user.getZip()).append("\n");
        details.append("Mode of Delivery: ").append(modeOfDelivery).append("\n");
        details.append("Mode of Payment: ").append(modeOfPayment).append("\n\n");
        details.append(orderDetails);
        return details.toString();
    }
}
