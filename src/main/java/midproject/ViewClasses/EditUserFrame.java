package midproject.ViewClasses;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import midproject.SharedClasses.ReferenceClasses.User;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 *
 * @author Cian Talosig
 */
public class EditUserFrame extends javax.swing.JFrame {

    /**
     * Creates new form EditUserFrame
     */
    public EditUserFrame() {
        initComponents();
        Image logo = Toolkit.getDefaultToolkit().getImage("Icons/logo.png");
        setIconImage(logo);
        setLocationRelativeTo(null);
    }

    private User userToEdit;
    private User editedUser;

    public EditUserFrame (User user) {
        initComponents();;
        userToEdit = user;
        populateFields();
    }

    private void populateFields() {
        firstNameTextField.setText(userToEdit.getFirstName());
        lastNameTextField.setText(userToEdit.getLastName());
        middleNameTextField.setText(userToEdit.getMiddleName());
        birthdateTextField.setText(userToEdit.getBirthdate());
        ageTextField.setText(userToEdit.getAge());
        genderComboBox.setSelectedItem(userToEdit.getGender());
        personWithDisabilityCheckBox.setSelected(userToEdit.getPersonWithDisability());
        emailAddressTextField.setText(userToEdit.getEmail());
        contactNumberTextField.setText(userToEdit.getContactNumber());
        streetAddressTextField.setText(userToEdit.getStreet());
        optionalDetailsTextField.setText(userToEdit.getAdditionalAddressDetails());
        cityMunicipalityTextField.setText(userToEdit.getCity());
        provinceTextField.setText(userToEdit.getProvince());
        postalCodeTextField.setText(userToEdit.getZip());
        setUsernameTextField.setText(userToEdit.getUsername());
        userTypeComboBox.setSelectedItem(userToEdit.getUserType());
        setUsernameTextField.setEditable(false);
        setUsernameTextField.setEnabled(false);
        passwordField.setEditable(false);
        passwordField.setEnabled(false);
        userTypeComboBox.setEnabled(false);
        userTypeComboBox.setEditable(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lastNameTextField = new javax.swing.JTextField();
        middleNameTextField = new javax.swing.JTextField();
        birthdateTextField = new javax.swing.JTextField();
        genderComboBox = new javax.swing.JComboBox<>();
        personWithDisabilityCheckBox = new javax.swing.JCheckBox();
        streetAddressTextField = new javax.swing.JTextField();
        userTypeComboBox = new javax.swing.JComboBox<>();
        optionalDetailsTextField = new javax.swing.JTextField();
        cityMunicipalityTextField = new javax.swing.JTextField();
        provinceTextField = new javax.swing.JTextField();
        userTypeLabel = new javax.swing.JLabel();
        emailAddressTextField = new javax.swing.JTextField();
        streetAddressLabel = new javax.swing.JLabel();
        contactNumberTextField = new javax.swing.JTextField();
        optionalDetailsLabel = new javax.swing.JLabel();
        cityMunicipalityLabel = new javax.swing.JLabel();
        provinceLabel = new javax.swing.JLabel();
        editAccountButton = new javax.swing.JButton();
        postalCodeLabel = new javax.swing.JLabel();
        ageTextField = new javax.swing.JTextField();
        emailAddressLabel = new javax.swing.JLabel();
        postalCodeTextField = new javax.swing.JTextField();
        contactNumberLabel = new javax.swing.JLabel();
        setUsernameTextField = new javax.swing.JTextField();
        setUsernameLabel = new javax.swing.JLabel();
        setPasswordLabel = new javax.swing.JLabel();
        editAccountLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        middleNameLabel = new javax.swing.JLabel();
        birthdateLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        personWithDisabilityLabel = new javax.swing.JLabel();
        //confirmPasswordLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        //confirmPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit User");
        setResizable(false);


        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        userTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Customer" }));

        userTypeLabel.setText("USER TYPE");

        streetAddressLabel.setText("Street Address");

        optionalDetailsLabel.setText("Additional Address Details (Apt, Suite etc (optional))");

        cityMunicipalityLabel.setText("City / Municipality");

        provinceLabel.setText("Province");

        editAccountButton.setText("Edit Account");
        editAccountButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editAccountButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        postalCodeLabel.setText("ZIP / Postal Code");

        emailAddressLabel.setText("Email Address");

        contactNumberLabel.setText("Contact Number");

        setUsernameLabel.setText("Username");

        setPasswordLabel.setText("Password");

        editAccountLabel.setText("EDIT ACCOUNT");

        firstNameLabel.setText("First Name");

        lastNameLabel.setText("Last Name");

        middleNameLabel.setText("Middle Name");

        birthdateLabel.setText("Birthdate");

        ageLabel.setText("Age");

        genderLabel.setText("Gender");

        personWithDisabilityLabel.setText("Person with Disability");

        //confirmPasswordLabel.setText("Confirm Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lastNameLabel)
                                .addGap(245, 245, 245)
                                .addComponent(optionalDetailsLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(middleNameLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(birthdateLabel)
                                        .addGap(90, 90, 90)
                                        .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(personWithDisabilityLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(personWithDisabilityCheckBox)))
                                .addGap(128, 128, 128)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cityMunicipalityLabel)
                                    .addComponent(provinceLabel)
                                    .addComponent(postalCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(firstNameLabel)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(birthdateTextField)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(middleNameTextField)
                                        .addComponent(lastNameTextField)
                                        .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(genderLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(editAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(postalCodeLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(userTypeLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(userTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(streetAddressLabel)
                                        .addComponent(optionalDetailsTextField)
                                        .addComponent(streetAddressTextField)
                                        .addComponent(cityMunicipalityTextField)
                                        .addComponent(provinceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailAddressLabel)
                            .addComponent(contactNumberLabel)
                            .addComponent(setUsernameLabel)
                            //.addComponent(confirmPasswordLabel)
                            .addComponent(emailAddressTextField)
                            .addComponent(contactNumberTextField)
                            .addComponent(setUsernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(setPasswordLabel)
                            .addComponent(passwordField)))
                            //.addComponent(confirmPasswordField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(editAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userTypeLabel)
                            .addComponent(userTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(editAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(streetAddressLabel)
                    .addComponent(emailAddressLabel))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(optionalDetailsLabel)
                    .addComponent(contactNumberLabel))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optionalDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(middleNameLabel)
                    .addComponent(cityMunicipalityLabel)
                    .addComponent(setUsernameLabel))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(middleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityMunicipalityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthdateLabel)
                    .addComponent(ageLabel)
                    .addComponent(provinceLabel)
                    .addComponent(setPasswordLabel))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(provinceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel)
                    .addComponent(postalCodeLabel)
                    //.addComponent(confirmPasswordLabel)
                    .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(personWithDisabilityLabel)
                    .addComponent(personWithDisabilityCheckBox)
                    .addComponent(postalCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    //.addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(editAccountButton)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditUserFrame().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JLabel birthdateLabel;
    private javax.swing.JTextField birthdateTextField;
    private javax.swing.JLabel cityMunicipalityLabel;
    private javax.swing.JTextField cityMunicipalityTextField;
    private javax.swing.JLabel contactNumberLabel;
    private javax.swing.JTextField contactNumberTextField;
    private javax.swing.JButton editAccountButton;
    private javax.swing.JLabel editAccountLabel;
    private javax.swing.JLabel emailAddressLabel;
    private javax.swing.JTextField emailAddressTextField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JCheckBox personWithDisabilityCheckBox;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JLabel middleNameLabel;
    private javax.swing.JTextField middleNameTextField;
    private javax.swing.JLabel optionalDetailsLabel;
    private javax.swing.JTextField optionalDetailsTextField;
    private javax.swing.JTextField postalCodeTextField;
    private javax.swing.JLabel postalCodeLabel;
    private javax.swing.JLabel provinceLabel;
    private javax.swing.JTextField provinceTextField;
    private javax.swing.JLabel personWithDisabilityLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel setPasswordLabel;
    private javax.swing.JLabel setUsernameLabel;
    private javax.swing.JTextField setUsernameTextField;
    private javax.swing.JLabel streetAddressLabel;
    private javax.swing.JTextField streetAddressTextField;
    private javax.swing.JComboBox<String> userTypeComboBox;
    private javax.swing.JLabel userTypeLabel;

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public JTextField getMiddleNameTextField() {
        return middleNameTextField;
    }

    public void setMiddleNameTextField(JTextField middleNameTextField) {
        this.middleNameTextField = middleNameTextField;
    }

    public JTextField getBirthdateTextField() {
        return birthdateTextField;
    }


    public JComboBox<String> getGenderComboBox() {
        return genderComboBox;
    }

    public void setPersonWithDisabilityCheckBox(JCheckBox personWithDisabilityCheckBox) {
        this.personWithDisabilityCheckBox = personWithDisabilityCheckBox;
    }

    public JTextField getStreetAddressTextField() {
        return streetAddressTextField;
    }

    public JTextField getOptionalDetailsTextField() {
        return optionalDetailsTextField;
    }

    public JTextField getCityMunicipalityTextField() {
        return cityMunicipalityTextField;
    }

    public JTextField getProvinceTextField() {
        return provinceTextField;
    }

    public JTextField getEmailAddressTextField() {
        return emailAddressTextField;
    }

    public JTextField getContactNumberTextField() {
        return contactNumberTextField;
    }

    public void setContactNumberTextField(JTextField contactNumberTextField) {
        this.contactNumberTextField = contactNumberTextField;
    }

    public JButton getEditAccountButton() {
        return editAccountButton;
    }

    public JTextField getAgeTextField() {
        return ageTextField;
    }

    public JTextField getPostalCodeTextField() {
        return postalCodeTextField;
    }

    public JTextField getFirstNameTextField() {
        return firstNameTextField;
    }
}
