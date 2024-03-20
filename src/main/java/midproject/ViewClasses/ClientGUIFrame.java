package midproject.ViewClasses;

import java.awt.*;

/**
 * This class is used for designing the whole Client GUI program
 * 
 * @author Encarnacion, Ma. Earl Freskkie
 * @since January 31 - February 17, 2024
 */
public class ClientGUIFrame extends javax.swing.JFrame {

    /**
     * Creates new form ClientGUIFrame
     */
    private CardLayout cardLayout = new CardLayout();

    public ClientGUIFrame() {
        initComponents();
        setResizable(false);
        this.cardLayout = (CardLayout) containerPanel.getLayout();
        setLocationRelativeTo(null);
        Image logo = Toolkit.getDefaultToolkit().getImage("/Icons/logo.png");
        setIconImage(logo);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        iconLabel = new javax.swing.JLabel();
        profileLabel = new javax.swing.JLabel();
        storeLabel = new javax.swing.JLabel();
        cartLabel = new javax.swing.JLabel();
        footerPanel = new javax.swing.JPanel();
        footerLabel = new javax.swing.JLabel();
        containerPanel = new javax.swing.JPanel();
        choosePanel = new javax.swing.JPanel();
        doctorIcon = new javax.swing.JLabel();
        overthecounterButton = new javax.swing.JButton();
        instructionsLabel1 = new javax.swing.JLabel();
        categoryPanel = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        searchTextfield = new javax.swing.JTextField();
        comboBox1 = new javax.swing.JComboBox<>();
        comboBox2 = new javax.swing.JComboBox<>();
        comboBox3 = new javax.swing.JComboBox<>();
        comboBox4 = new javax.swing.JComboBox<>();
        comboBox5 = new javax.swing.JComboBox<>();
        selectLabel = new javax.swing.JLabel();
        searchLabel = new javax.swing.JLabel();
        categorySpinner1 = new javax.swing.JSpinner();
        categorySpinner2 = new javax.swing.JSpinner();
        categorySpinner3 = new javax.swing.JSpinner();
        categorySpinner4 = new javax.swing.JSpinner();
        categorySpinner5 = new javax.swing.JSpinner();
        addToCartButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        yourCartMainPanel = new javax.swing.JPanel();
        yourCartLabel = new javax.swing.JLabel();
        yourCartPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        yourCartTextArea1 = new javax.swing.JTextArea();
        cartCheckbox1 = new javax.swing.JCheckBox();
        removeCartButton1 = new javax.swing.JButton();
        yourCartPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        yourCartTextArea2 = new javax.swing.JTextArea();
        cartCheckbox2 = new javax.swing.JCheckBox();
        removeCartButton2 = new javax.swing.JButton();
        yourCartPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        yourCartTextArea3 = new javax.swing.JTextArea();
        cartCheckbox3 = new javax.swing.JCheckBox();
        removeCartButton3 = new javax.swing.JButton();
        yourCartPanel4 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        yourCartTextArea4 = new javax.swing.JTextArea();
        cartCheckbox4 = new javax.swing.JCheckBox();
        removeCartButton4 = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        yourCartPanel5 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        yourCartTextArea5 = new javax.swing.JTextArea();
        cartCheckbox5 = new javax.swing.JCheckBox();
        removeCartButton5 = new javax.swing.JButton();
        modeOfDeliveryPanel = new javax.swing.JPanel();
        modeOfDeliveryLabel = new javax.swing.JLabel();
        pickUpButton = new javax.swing.JButton();
        deliveryButton = new javax.swing.JButton();
        nextButtonModeOfDelivery = new javax.swing.JButton();
        backButtonModeOfDelivery = new javax.swing.JButton();
        pickUpPanel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        pickUpTextArea = new javax.swing.JTextArea();
        modeOfPaymentPanel = new javax.swing.JPanel();
        modeOfDeliveryLabel1 = new javax.swing.JLabel();
        gcashIcon = new javax.swing.JLabel();
        mayaIcon = new javax.swing.JLabel();
        visaIcon = new javax.swing.JLabel();
        mastercardIcon = new javax.swing.JLabel();
        cashOnDeliveryLabel = new javax.swing.JLabel();
        nameEwalletTextfield = new javax.swing.JTextField();
        phoneNumberLabel = new javax.swing.JLabel();
        nameEwalletLabel = new javax.swing.JLabel();
        phoneNumberTextfield = new javax.swing.JTextField();
        nameCardLabel = new javax.swing.JLabel();
        nameCardTextfield = new javax.swing.JTextField();
        cardNumberLabel = new javax.swing.JLabel();
        cardNumberTextfield = new javax.swing.JTextField();
        CVVLabel = new javax.swing.JLabel();
        CVVTextfield = new javax.swing.JTextField();
        backButtonModeOfPayment = new javax.swing.JButton();
        nextButtonModeOfPayment = new javax.swing.JButton();
        yourOrderPanel = new javax.swing.JPanel();
        yourOrderLabel = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        yourOrderTextArea = new javax.swing.JTextArea();
        editOrderButton = new javax.swing.JButton();
        checkOutButton = new javax.swing.JButton();
        buttonSeparator = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        uploadButton = new javax.swing.JButton();
        placedOrderPanel = new javax.swing.JPanel();
        placedOrderLabel = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        placedOrderTextArea = new javax.swing.JTextArea();
        profilePanel = new javax.swing.JPanel();
        profileDetailsPanel = new javax.swing.JPanel();
        profileIcon = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        nameTextArea = new javax.swing.JTextArea();
        cartIcon = new javax.swing.JLabel();
        envelopeIcon = new javax.swing.JLabel();
        orderHistoryLabel = new javax.swing.JLabel();
        helpLabel = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        partOftheProfilePanel = new javax.swing.JPanel();
        settingLabel = new javax.swing.JLabel();
        personalInformationLabel = new javax.swing.JLabel();
        privacyAndPolicyLabel = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        personalInformationTextArea = new javax.swing.JTextArea();
        confirmPasswordLabel = new javax.swing.JLabel();
        currentPasswordLabel = new javax.swing.JLabel();
        newPasswordLabel = new javax.swing.JLabel();
        currentPasswordField = new javax.swing.JPasswordField();
        newPasswordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        saveButton = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        pendingOrdersPanel = new javax.swing.JPanel();
        pendingOrderLabel = new javax.swing.JLabel();
        pendingCheckBoxPanel1 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        pendingTextArea1 = new javax.swing.JTextArea();
        pendingCheckbox1 = new javax.swing.JCheckBox();
        removePendingButton1 = new javax.swing.JButton();
        pendingCheckBoxPanel3 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        pendingTextArea3 = new javax.swing.JTextArea();
        pendingCheckbox3 = new javax.swing.JCheckBox();
        removePendingButton3 = new javax.swing.JButton();
        pendingCheckBoxPanel4 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        pendingTextArea4 = new javax.swing.JTextArea();
        pendingCheckbox4 = new javax.swing.JCheckBox();
        removePendingButton4 = new javax.swing.JButton();
        pendingCheckBoxPanel2 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        pendingTextArea2 = new javax.swing.JTextArea();
        pendingCheckbox2 = new javax.swing.JCheckBox();
        removePendingButton2 = new javax.swing.JButton();
        backButtonPendingOrder = new javax.swing.JButton();
        checkOutForPendingOrdersButton = new javax.swing.JButton();
        pendingCheckBoxPanel5 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        pendingTextArea5 = new javax.swing.JTextArea();
        pendingCheckbox5 = new javax.swing.JCheckBox();
        removePendingButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quantum Drugstore");
        setBackground(new java.awt.Color(255, 255, 255));

        headerPanel.setBackground(new java.awt.Color(44, 125, 160));

        titleLabel.setFont(new java.awt.Font("Sitka Heading", 1, 48)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Quantum Drugstore");

        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo.png"))); // NOI18N

        profileLabel.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        profileLabel.setForeground(new java.awt.Color(255, 255, 255));
        profileLabel.setText("PROFILE");
        profileLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileLabelMouseClicked(evt);
            }
        });

        storeLabel.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        storeLabel.setForeground(new java.awt.Color(255, 255, 255));
        storeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        storeLabel.setText("STORE");
        storeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                storeLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                storeLabelMouseEntered(evt);
            }
        });

        cartLabel.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        cartLabel.setForeground(new java.awt.Color(255, 255, 255));
        cartLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cartLabel.setText("CART");
        cartLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(261, 261, 261)
                .addComponent(profileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(storeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(cartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(iconLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(storeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cartLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        footerPanel.setBackground(new java.awt.Color(17, 138, 178));

        footerLabel.setForeground(new java.awt.Color(255, 255, 255));
        footerLabel.setText("© Quantum Tech 2024");

        javax.swing.GroupLayout footerPanelLayout = new javax.swing.GroupLayout(footerPanel);
        footerPanel.setLayout(footerPanelLayout);
        footerPanelLayout.setHorizontalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(footerLabel)
                .addGap(578, 578, 578))
        );
        footerPanelLayout.setVerticalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerPanelLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(footerLabel)
                .addContainerGap())
        );

        containerPanel.setBackground(new java.awt.Color(255, 255, 255));
        containerPanel.setLayout(new java.awt.CardLayout());

        choosePanel.setBackground(new java.awt.Color(255, 255, 255));

        doctorIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        doctorIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/storeIcon.png"))); // NOI18N
        doctorIcon.setText("jLabel1");

        overthecounterButton.setText("Over-The-Counter");
        overthecounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overthecounterButtonActionPerformed(evt);
            }
        });

        instructionsLabel1.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        instructionsLabel1.setForeground(new java.awt.Color(33, 37, 41));
        instructionsLabel1.setText("Select from a range of non-prescription drugs");

        javax.swing.GroupLayout choosePanelLayout = new javax.swing.GroupLayout(choosePanel);
        choosePanel.setLayout(choosePanelLayout);
        choosePanelLayout.setHorizontalGroup(
            choosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelLayout.createSequentialGroup()
                .addGroup(choosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelLayout.createSequentialGroup()
                        .addGap(564, 564, 564)
                        .addComponent(doctorIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(choosePanelLayout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(overthecounterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, choosePanelLayout.createSequentialGroup()
                .addGap(0, 479, Short.MAX_VALUE)
                .addComponent(instructionsLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(419, 419, 419))
        );
        choosePanelLayout.setVerticalGroup(
            choosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelLayout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(doctorIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(overthecounterButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(instructionsLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275))
        );

        containerPanel.add(choosePanel, "choosePanel");

        categoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        searchPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        searchTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextfieldKeyPressed(evt);
            }
        });

        comboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));

        comboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));

        comboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));

        comboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));

        comboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));

        selectLabel.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        selectLabel.setForeground(new java.awt.Color(33, 37, 41));
        selectLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        selectLabel.setText("Select what brand of medicine");

        searchLabel.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        searchLabel.setForeground(new java.awt.Color(33, 37, 41));
        searchLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchLabel.setText("Search your generic medicine");

        categorySpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        categorySpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        categorySpinner3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        categorySpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        categorySpinner5.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        addToCartButton.setText("Add to cart");
        addToCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categorySpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categorySpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categorySpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categorySpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categorySpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(530, 530, 530)
                        .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(282, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(searchLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(selectLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categorySpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categorySpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categorySpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categorySpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categorySpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout categoryPanelLayout = new javax.swing.GroupLayout(categoryPanel);
        categoryPanel.setLayout(categoryPanelLayout);
        categoryPanelLayout.setHorizontalGroup(
            categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoryPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backButton)
                .addGap(24, 1192, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoryPanelLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        categoryPanelLayout.setVerticalGroup(
            categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoryPanelLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        containerPanel.add(categoryPanel, "categoryPanel");

        yourCartMainPanel.setBackground(new java.awt.Color(255, 255, 255));

        yourCartLabel.setFont(new java.awt.Font("Sitka Heading", 1, 36)); // NOI18N
        yourCartLabel.setForeground(new java.awt.Color(33, 37, 41));
        yourCartLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yourCartLabel.setText("Your Cart");

        yourCartPanel1.setBackground(new java.awt.Color(237, 237, 233));

        yourCartTextArea1.setEditable(false);
        yourCartTextArea1.setColumns(20);
        yourCartTextArea1.setRows(5);
        jScrollPane5.setViewportView(yourCartTextArea1);

        cartCheckbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartCheckbox1ActionPerformed(evt);
            }
        });

        removeCartButton1.setText("Remove");
        removeCartButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCartButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout yourCartPanel1Layout = new javax.swing.GroupLayout(yourCartPanel1);
        yourCartPanel1.setLayout(yourCartPanel1Layout);
        yourCartPanel1Layout.setHorizontalGroup(
            yourCartPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourCartPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cartCheckbox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeCartButton1)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        yourCartPanel1Layout.setVerticalGroup(
            yourCartPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourCartPanel1Layout.createSequentialGroup()
                .addGroup(yourCartPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(yourCartPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(yourCartPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(cartCheckbox1)))
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourCartPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(removeCartButton1)
                .addGap(36, 36, 36))
        );

        yourCartPanel2.setBackground(new java.awt.Color(237, 237, 233));

        yourCartTextArea2.setEditable(false);
        yourCartTextArea2.setColumns(20);
        yourCartTextArea2.setRows(5);
        jScrollPane6.setViewportView(yourCartTextArea2);

        cartCheckbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartCheckbox2ActionPerformed(evt);
            }
        });

        removeCartButton2.setText("Remove");
        removeCartButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCartButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout yourCartPanel2Layout = new javax.swing.GroupLayout(yourCartPanel2);
        yourCartPanel2.setLayout(yourCartPanel2Layout);
        yourCartPanel2Layout.setHorizontalGroup(
            yourCartPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourCartPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cartCheckbox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeCartButton2)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        yourCartPanel2Layout.setVerticalGroup(
            yourCartPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourCartPanel2Layout.createSequentialGroup()
                .addGroup(yourCartPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(yourCartPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(yourCartPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(cartCheckbox2)))
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourCartPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(removeCartButton2)
                .addGap(37, 37, 37))
        );

        yourCartPanel3.setBackground(new java.awt.Color(237, 237, 233));

        yourCartTextArea3.setEditable(false);
        yourCartTextArea3.setColumns(20);
        yourCartTextArea3.setRows(5);
        jScrollPane7.setViewportView(yourCartTextArea3);

        cartCheckbox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartCheckbox3ActionPerformed(evt);
            }
        });

        removeCartButton3.setText("Remove");
        removeCartButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCartButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout yourCartPanel3Layout = new javax.swing.GroupLayout(yourCartPanel3);
        yourCartPanel3.setLayout(yourCartPanel3Layout);
        yourCartPanel3Layout.setHorizontalGroup(
            yourCartPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourCartPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cartCheckbox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeCartButton3)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        yourCartPanel3Layout.setVerticalGroup(
            yourCartPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourCartPanel3Layout.createSequentialGroup()
                .addGroup(yourCartPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(yourCartPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(yourCartPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(cartCheckbox3)))
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourCartPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(removeCartButton3)
                .addGap(37, 37, 37))
        );

        yourCartPanel4.setBackground(new java.awt.Color(237, 237, 233));

        yourCartTextArea4.setEditable(false);
        yourCartTextArea4.setColumns(20);
        yourCartTextArea4.setRows(5);
        jScrollPane8.setViewportView(yourCartTextArea4);

        cartCheckbox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartCheckbox4ActionPerformed(evt);
            }
        });

        removeCartButton4.setText("Remove");
        removeCartButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCartButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout yourCartPanel4Layout = new javax.swing.GroupLayout(yourCartPanel4);
        yourCartPanel4.setLayout(yourCartPanel4Layout);
        yourCartPanel4Layout.setHorizontalGroup(
            yourCartPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourCartPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cartCheckbox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeCartButton4)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        yourCartPanel4Layout.setVerticalGroup(
            yourCartPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourCartPanel4Layout.createSequentialGroup()
                .addGroup(yourCartPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(yourCartPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(yourCartPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(cartCheckbox4)))
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourCartPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(removeCartButton4)
                .addGap(36, 36, 36))
        );

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        yourCartPanel5.setBackground(new java.awt.Color(237, 237, 233));

        yourCartTextArea5.setEditable(false);
        yourCartTextArea5.setColumns(20);
        yourCartTextArea5.setRows(5);
        jScrollPane19.setViewportView(yourCartTextArea5);

        cartCheckbox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartCheckbox5ActionPerformed(evt);
            }
        });

        removeCartButton5.setText("Remove");
        removeCartButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCartButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout yourCartPanel5Layout = new javax.swing.GroupLayout(yourCartPanel5);
        yourCartPanel5.setLayout(yourCartPanel5Layout);
        yourCartPanel5Layout.setHorizontalGroup(
            yourCartPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourCartPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cartCheckbox5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeCartButton5)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        yourCartPanel5Layout.setVerticalGroup(
            yourCartPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourCartPanel5Layout.createSequentialGroup()
                .addGroup(yourCartPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(yourCartPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(yourCartPanel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(cartCheckbox5)))
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourCartPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(removeCartButton5)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout yourCartMainPanelLayout = new javax.swing.GroupLayout(yourCartMainPanel);
        yourCartMainPanel.setLayout(yourCartMainPanelLayout);
        yourCartMainPanelLayout.setHorizontalGroup(
            yourCartMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourCartMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(yourCartLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourCartMainPanelLayout.createSequentialGroup()
                .addGap(20, 346, Short.MAX_VALUE)
                .addGroup(yourCartMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(yourCartMainPanelLayout.createSequentialGroup()
                        .addGroup(yourCartMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yourCartPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yourCartPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yourCartPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yourCartPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(326, 326, 326))
                    .addGroup(yourCartMainPanelLayout.createSequentialGroup()
                        .addComponent(yourCartPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        yourCartMainPanelLayout.setVerticalGroup(
            yourCartMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourCartMainPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(yourCartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(yourCartMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yourCartPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(yourCartPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yourCartPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yourCartPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yourCartPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        containerPanel.add(yourCartMainPanel, "yourCartMainPanel");

        modeOfDeliveryPanel.setBackground(new java.awt.Color(255, 255, 255));

        modeOfDeliveryLabel.setFont(new java.awt.Font("Sitka Heading", 1, 36)); // NOI18N
        modeOfDeliveryLabel.setForeground(new java.awt.Color(33, 37, 41));
        modeOfDeliveryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        modeOfDeliveryLabel.setText("Mode of Delivery");

        pickUpButton.setText("Pick Up");
        pickUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickUpButtonActionPerformed(evt);
            }
        });

        deliveryButton.setText("Delivery");
        deliveryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryButtonActionPerformed(evt);
            }
        });

        nextButtonModeOfDelivery.setText("Next");
        nextButtonModeOfDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonModeOfPaymennextButtonModeOfDeliveryActionPerformed(evt);
            }
        });

        backButtonModeOfDelivery.setText("Back");
        backButtonModeOfDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonModeOfDeliveryActionPerformed(evt);
            }
        });

        pickUpTextArea.setEditable(false);
        pickUpTextArea.setColumns(20);
        pickUpTextArea.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        pickUpTextArea.setRows(5);
        jScrollPane9.setViewportView(pickUpTextArea);

        javax.swing.GroupLayout pickUpPanelLayout = new javax.swing.GroupLayout(pickUpPanel);
        pickUpPanel.setLayout(pickUpPanelLayout);
        pickUpPanelLayout.setHorizontalGroup(
            pickUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pickUpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addContainerGap())
        );
        pickUpPanelLayout.setVerticalGroup(
            pickUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pickUpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout modeOfDeliveryPanelLayout = new javax.swing.GroupLayout(modeOfDeliveryPanel);
        modeOfDeliveryPanel.setLayout(modeOfDeliveryPanelLayout);
        modeOfDeliveryPanelLayout.setHorizontalGroup(
            modeOfDeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modeOfDeliveryPanelLayout.createSequentialGroup()
                .addGroup(modeOfDeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(modeOfDeliveryLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(modeOfDeliveryPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(backButtonModeOfDelivery)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextButtonModeOfDelivery)))
                .addGap(20, 20, 20))
            .addGroup(modeOfDeliveryPanelLayout.createSequentialGroup()
                .addGroup(modeOfDeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modeOfDeliveryPanelLayout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(pickUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(234, 234, 234)
                        .addComponent(deliveryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(modeOfDeliveryPanelLayout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(pickUpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(348, Short.MAX_VALUE))
        );
        modeOfDeliveryPanelLayout.setVerticalGroup(
            modeOfDeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modeOfDeliveryPanelLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(modeOfDeliveryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(modeOfDeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pickUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deliveryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(pickUpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addGroup(modeOfDeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButtonModeOfDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButtonModeOfDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        containerPanel.add(modeOfDeliveryPanel, "modeOfDeliveryPanel");

        modeOfPaymentPanel.setBackground(new java.awt.Color(255, 255, 255));

        modeOfDeliveryLabel1.setFont(new java.awt.Font("Sitka Heading", 1, 36)); // NOI18N
        modeOfDeliveryLabel1.setForeground(new java.awt.Color(33, 37, 41));
        modeOfDeliveryLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        modeOfDeliveryLabel1.setText("Mode of Payment");

        gcashIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/gcash.png"))); // NOI18N

        mayaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/maya.png"))); // NOI18N

        visaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/visa.png"))); // NOI18N

        mastercardIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/mastercard.png"))); // NOI18N

        cashOnDeliveryLabel.setFont(new java.awt.Font("Sitka Display", 0, 24)); // NOI18N
        cashOnDeliveryLabel.setForeground(new java.awt.Color(60, 63, 65));
        cashOnDeliveryLabel.setText("Cash On Delivery");
        cashOnDeliveryLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashOnDeliveryLabelMouseClicked(evt);
            }
        });

        phoneNumberLabel.setFont(new java.awt.Font("Sitka Display", 0, 18)); // NOI18N
        phoneNumberLabel.setForeground(new java.awt.Color(60, 63, 65));
        phoneNumberLabel.setText("Phone Number");

        nameEwalletLabel.setFont(new java.awt.Font("Sitka Display", 0, 18)); // NOI18N
        nameEwalletLabel.setForeground(new java.awt.Color(60, 63, 65));
        nameEwalletLabel.setText("Name");

        nameCardLabel.setFont(new java.awt.Font("Sitka Display", 0, 18)); // NOI18N
        nameCardLabel.setForeground(new java.awt.Color(60, 63, 65));
        nameCardLabel.setText("Name");

        cardNumberLabel.setFont(new java.awt.Font("Sitka Display", 0, 18)); // NOI18N
        cardNumberLabel.setForeground(new java.awt.Color(60, 63, 65));
        cardNumberLabel.setText("Card Number");

        CVVLabel.setFont(new java.awt.Font("Sitka Display", 0, 18)); // NOI18N
        CVVLabel.setForeground(new java.awt.Color(60, 63, 65));
        CVVLabel.setText("CVV");

        backButtonModeOfPayment.setText("Back");
        backButtonModeOfPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonModeOfPaymentActionPerformed(evt);
            }
        });

        nextButtonModeOfPayment.setText("Next");
        nextButtonModeOfPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonModeOfPaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout modeOfPaymentPanelLayout = new javax.swing.GroupLayout(modeOfPaymentPanel);
        modeOfPaymentPanel.setLayout(modeOfPaymentPanelLayout);
        modeOfPaymentPanelLayout.setHorizontalGroup(
            modeOfPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modeOfPaymentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(modeOfDeliveryLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modeOfPaymentPanelLayout.createSequentialGroup()
                .addGroup(modeOfPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modeOfPaymentPanelLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(gcashIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mayaIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cashOnDeliveryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))
                    .addGroup(modeOfPaymentPanelLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(modeOfPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneNumberTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameEwalletLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameEwalletTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(modeOfPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CVVTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameCardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(modeOfPaymentPanelLayout.createSequentialGroup()
                        .addComponent(visaIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mastercardIcon))
                    .addComponent(nameCardTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardNumberTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CVVLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110))
            .addGroup(modeOfPaymentPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backButtonModeOfPayment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextButtonModeOfPayment)
                .addGap(24, 24, 24))
        );
        modeOfPaymentPanelLayout.setVerticalGroup(
            modeOfPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modeOfPaymentPanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(modeOfDeliveryLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(modeOfPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gcashIcon)
                    .addGroup(modeOfPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(mayaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mastercardIcon))
                    .addGroup(modeOfPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cashOnDeliveryLabel)
                        .addComponent(visaIcon)))
                .addGap(44, 44, 44)
                .addGroup(modeOfPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameEwalletLabel)
                    .addComponent(nameCardLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modeOfPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameEwalletTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameCardTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(modeOfPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberLabel)
                    .addComponent(cardNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modeOfPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardNumberTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(CVVLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CVVTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(modeOfPaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButtonModeOfPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButtonModeOfPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        containerPanel.add(modeOfPaymentPanel, "card11");

        yourOrderPanel.setBackground(new java.awt.Color(255, 255, 255));

        yourOrderLabel.setFont(new java.awt.Font("Sitka Heading", 1, 36)); // NOI18N
        yourOrderLabel.setForeground(new java.awt.Color(33, 37, 41));
        yourOrderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yourOrderLabel.setText("Your Order");

        yourOrderTextArea.setEditable(false);
        yourOrderTextArea.setColumns(20);
        yourOrderTextArea.setFont(new java.awt.Font("Sitka Heading", 0, 14)); // NOI18N
        yourOrderTextArea.setRows(5);
        jScrollPane10.setViewportView(yourOrderTextArea);

        editOrderButton.setText("Edit Order");
        editOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editOrderButtonActionPerformed(evt);
            }
        });

        checkOutButton.setText("Check Out");
        checkOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sitka Display", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(60, 63, 65));
        jLabel1.setText("Upload your prescription (optional)");

        uploadButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        uploadButton.setText("Upload");

        javax.swing.GroupLayout yourOrderPanelLayout = new javax.swing.GroupLayout(yourOrderPanel);
        yourOrderPanel.setLayout(yourOrderPanelLayout);
        yourOrderPanelLayout.setHorizontalGroup(
            yourOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourOrderPanelLayout.createSequentialGroup()
                .addGroup(yourOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(yourOrderPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(yourOrderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE))
                    .addGroup(yourOrderPanelLayout.createSequentialGroup()
                        .addGap(545, 545, 545)
                        .addComponent(checkOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourOrderPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(yourOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourOrderPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(395, 395, 395))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourOrderPanelLayout.createSequentialGroup()
                        .addComponent(buttonSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(429, 429, 429))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourOrderPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(419, 419, 419))
            .addGroup(yourOrderPanelLayout.createSequentialGroup()
                .addGroup(yourOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(yourOrderPanelLayout.createSequentialGroup()
                        .addGap(545, 545, 545)
                        .addComponent(editOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(yourOrderPanelLayout.createSequentialGroup()
                        .addGap(549, 549, 549)
                        .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        yourOrderPanelLayout.setVerticalGroup(
            yourOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourOrderPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(yourOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(checkOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        containerPanel.add(yourOrderPanel, "yourOrderPanel");

        placedOrderPanel.setBackground(new java.awt.Color(255, 255, 255));

        placedOrderLabel.setFont(new java.awt.Font("Sitka Heading", 1, 36)); // NOI18N
        placedOrderLabel.setForeground(new java.awt.Color(33, 37, 41));
        placedOrderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        placedOrderLabel.setText("Your order has been placed!");

        placedOrderTextArea.setEditable(false);
        placedOrderTextArea.setColumns(20);
        placedOrderTextArea.setRows(5);
        jScrollPane11.setViewportView(placedOrderTextArea);

        javax.swing.GroupLayout placedOrderPanelLayout = new javax.swing.GroupLayout(placedOrderPanel);
        placedOrderPanel.setLayout(placedOrderPanelLayout);
        placedOrderPanelLayout.setHorizontalGroup(
            placedOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(placedOrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(placedOrderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, placedOrderPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246))
        );
        placedOrderPanelLayout.setVerticalGroup(
            placedOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(placedOrderPanelLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(placedOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        containerPanel.add(placedOrderPanel, "placedOrderPanel");

        profilePanel.setBackground(new java.awt.Color(255, 255, 255));

        profileDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        profileDetailsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        profileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profileBig.png"))); // NOI18N

        nameTextArea.setEditable(false);
        nameTextArea.setBackground(new java.awt.Color(255, 255, 255));
        nameTextArea.setColumns(20);
        nameTextArea.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        nameTextArea.setRows(5);
        jScrollPane13.setViewportView(nameTextArea);

        cartIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cartIcon.png"))); // NOI18N

        envelopeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/envelopeIcon.png"))); // NOI18N

        orderHistoryLabel.setFont(new java.awt.Font("Sitka Heading", 0, 24)); // NOI18N
        orderHistoryLabel.setForeground(new java.awt.Color(33, 37, 41));
        orderHistoryLabel.setText("Order History");
        orderHistoryLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderHistoryLabelMouseClicked(evt);
            }
        });

        helpLabel.setFont(new java.awt.Font("Sitka Heading", 0, 24)); // NOI18N
        helpLabel.setForeground(new java.awt.Color(33, 37, 41));
        helpLabel.setText("Help");
        helpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpLabelMouseClicked(evt);
            }
        });

        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profileDetailsPanelLayout = new javax.swing.GroupLayout(profileDetailsPanel);
        profileDetailsPanel.setLayout(profileDetailsPanelLayout);
        profileDetailsPanelLayout.setHorizontalGroup(
            profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileDetailsPanelLayout.createSequentialGroup()
                .addGroup(profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profileDetailsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane13))
                    .addGroup(profileDetailsPanelLayout.createSequentialGroup()
                        .addGroup(profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(profileDetailsPanelLayout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(profileIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(profileDetailsPanelLayout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cartIcon)
                                    .addComponent(envelopeIcon))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(orderHistoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(helpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );
        profileDetailsPanelLayout.setVerticalGroup(
            profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profileIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profileDetailsPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(cartIcon))
                    .addGroup(profileDetailsPanelLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(orderHistoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(envelopeIcon)
                    .addComponent(helpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        partOftheProfilePanel.setBackground(new java.awt.Color(237, 237, 233));

        settingLabel.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        settingLabel.setForeground(new java.awt.Color(33, 37, 41));
        settingLabel.setText("Settings");

        personalInformationLabel.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        personalInformationLabel.setForeground(new java.awt.Color(33, 37, 41));
        personalInformationLabel.setText("Personal Information");

        privacyAndPolicyLabel.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        privacyAndPolicyLabel.setForeground(new java.awt.Color(33, 37, 41));
        privacyAndPolicyLabel.setText("Privacy and Policy");

        personalInformationTextArea.setEditable(false);
        personalInformationTextArea.setColumns(20);
        personalInformationTextArea.setFont(new java.awt.Font("Sitka Heading", 0, 12)); // NOI18N
        personalInformationTextArea.setRows(5);
        jScrollPane12.setViewportView(personalInformationTextArea);

        confirmPasswordLabel.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        confirmPasswordLabel.setForeground(new java.awt.Color(33, 37, 41));
        confirmPasswordLabel.setText("Confirm Password");

        currentPasswordLabel.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        currentPasswordLabel.setForeground(new java.awt.Color(33, 37, 41));
        currentPasswordLabel.setText("Current Password");

        newPasswordLabel.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        newPasswordLabel.setForeground(new java.awt.Color(33, 37, 41));
        newPasswordLabel.setText("New Password");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(33, 37, 41));
        jTextArea1.setRows(5);
        jTextArea1.setText("\nWe collect personal details necessary for account setup, order processing, and \nservice improvement. Your information allows us to fulfill orders, enhance our \nservice, and communicate with you. You can access, correct, or delete your \npersonal information upon request. We will notify you of any policy changes and \nrecommend regular review of this policy. ");
        jScrollPane18.setViewportView(jTextArea1);

        javax.swing.GroupLayout partOftheProfilePanelLayout = new javax.swing.GroupLayout(partOftheProfilePanel);
        partOftheProfilePanel.setLayout(partOftheProfilePanelLayout);
        partOftheProfilePanelLayout.setHorizontalGroup(
            partOftheProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(partOftheProfilePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(partOftheProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane18)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                    .addComponent(personalInformationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(privacyAndPolicyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                    .addComponent(settingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(partOftheProfilePanelLayout.createSequentialGroup()
                        .addGroup(partOftheProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(currentPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(partOftheProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(partOftheProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(partOftheProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(saveButton)
                                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        partOftheProfilePanelLayout.setVerticalGroup(
            partOftheProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(partOftheProfilePanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(personalInformationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(privacyAndPolicyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(settingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(partOftheProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentPasswordLabel)
                    .addComponent(newPasswordLabel)
                    .addComponent(confirmPasswordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(partOftheProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(profileDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(partOftheProfilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(partOftheProfilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(profileDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        containerPanel.add(profilePanel, "profilePanel");

        pendingOrdersPanel.setBackground(new java.awt.Color(255, 255, 255));

        pendingOrderLabel.setFont(new java.awt.Font("Sitka Heading", 1, 36)); // NOI18N
        pendingOrderLabel.setForeground(new java.awt.Color(33, 37, 41));
        pendingOrderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pendingOrderLabel.setText("Pending Orders");

        pendingCheckBoxPanel1.setBackground(new java.awt.Color(237, 237, 233));

        pendingTextArea1.setEditable(false);
        pendingTextArea1.setColumns(20);
        pendingTextArea1.setRows(5);
        jScrollPane14.setViewportView(pendingTextArea1);

        pendingCheckbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingCheckbox1ActionPerformed(evt);
            }
        });

        removePendingButton1.setText("Remove");
        removePendingButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePendingButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pendingCheckBoxPanel1Layout = new javax.swing.GroupLayout(pendingCheckBoxPanel1);
        pendingCheckBoxPanel1.setLayout(pendingCheckBoxPanel1Layout);
        pendingCheckBoxPanel1Layout.setHorizontalGroup(
            pendingCheckBoxPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendingCheckBoxPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pendingCheckbox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removePendingButton1)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        pendingCheckBoxPanel1Layout.setVerticalGroup(
            pendingCheckBoxPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pendingCheckBoxPanel1Layout.createSequentialGroup()
                .addGroup(pendingCheckBoxPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pendingCheckBoxPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pendingCheckBoxPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(pendingCheckbox1)))
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendingCheckBoxPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(removePendingButton1)
                .addGap(37, 37, 37))
        );

        pendingCheckBoxPanel3.setBackground(new java.awt.Color(237, 237, 233));

        pendingTextArea3.setEditable(false);
        pendingTextArea3.setColumns(20);
        pendingTextArea3.setRows(5);
        jScrollPane15.setViewportView(pendingTextArea3);

        pendingCheckbox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingCheckbox3ActionPerformed(evt);
            }
        });

        removePendingButton3.setText("Remove");
        removePendingButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePendingButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pendingCheckBoxPanel3Layout = new javax.swing.GroupLayout(pendingCheckBoxPanel3);
        pendingCheckBoxPanel3.setLayout(pendingCheckBoxPanel3Layout);
        pendingCheckBoxPanel3Layout.setHorizontalGroup(
            pendingCheckBoxPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendingCheckBoxPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pendingCheckbox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removePendingButton3)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        pendingCheckBoxPanel3Layout.setVerticalGroup(
            pendingCheckBoxPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pendingCheckBoxPanel3Layout.createSequentialGroup()
                .addGroup(pendingCheckBoxPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pendingCheckBoxPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pendingCheckBoxPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(pendingCheckbox3)))
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendingCheckBoxPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(removePendingButton3)
                .addGap(37, 37, 37))
        );

        pendingCheckBoxPanel4.setBackground(new java.awt.Color(237, 237, 233));

        pendingTextArea4.setEditable(false);
        pendingTextArea4.setColumns(20);
        pendingTextArea4.setRows(5);
        jScrollPane16.setViewportView(pendingTextArea4);

        pendingCheckbox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingCheckbox4ActionPerformed(evt);
            }
        });

        removePendingButton4.setText("Remove");
        removePendingButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePendingButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pendingCheckBoxPanel4Layout = new javax.swing.GroupLayout(pendingCheckBoxPanel4);
        pendingCheckBoxPanel4.setLayout(pendingCheckBoxPanel4Layout);
        pendingCheckBoxPanel4Layout.setHorizontalGroup(
            pendingCheckBoxPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendingCheckBoxPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pendingCheckbox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removePendingButton4)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        pendingCheckBoxPanel4Layout.setVerticalGroup(
            pendingCheckBoxPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pendingCheckBoxPanel4Layout.createSequentialGroup()
                .addGroup(pendingCheckBoxPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pendingCheckBoxPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pendingCheckBoxPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(pendingCheckbox4)))
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendingCheckBoxPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(removePendingButton4)
                .addGap(37, 37, 37))
        );

        pendingCheckBoxPanel2.setBackground(new java.awt.Color(237, 237, 233));

        pendingTextArea2.setEditable(false);
        pendingTextArea2.setColumns(20);
        pendingTextArea2.setRows(5);
        jScrollPane17.setViewportView(pendingTextArea2);

        pendingCheckbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingCheckbox2ActionPerformed(evt);
            }
        });

        removePendingButton2.setText("Remove");
        removePendingButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePendingButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pendingCheckBoxPanel2Layout = new javax.swing.GroupLayout(pendingCheckBoxPanel2);
        pendingCheckBoxPanel2.setLayout(pendingCheckBoxPanel2Layout);
        pendingCheckBoxPanel2Layout.setHorizontalGroup(
            pendingCheckBoxPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendingCheckBoxPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pendingCheckbox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removePendingButton2)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        pendingCheckBoxPanel2Layout.setVerticalGroup(
            pendingCheckBoxPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pendingCheckBoxPanel2Layout.createSequentialGroup()
                .addGroup(pendingCheckBoxPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pendingCheckBoxPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pendingCheckBoxPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(pendingCheckbox2)))
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendingCheckBoxPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(removePendingButton2)
                .addGap(37, 37, 37))
        );

        backButtonPendingOrder.setText("Back");
        backButtonPendingOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonPendingOrderbackButtonActionPerformed(evt);
            }
        });

        checkOutForPendingOrdersButton.setText("Check Out");
        checkOutForPendingOrdersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutForPendingOrdersButtonActionPerformed(evt);
            }
        });

        pendingCheckBoxPanel5.setBackground(new java.awt.Color(237, 237, 233));

        pendingTextArea5.setEditable(false);
        pendingTextArea5.setColumns(20);
        pendingTextArea5.setRows(5);
        jScrollPane20.setViewportView(pendingTextArea5);

        pendingCheckbox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingCheckbox5ActionPerformed(evt);
            }
        });

        removePendingButton5.setText("Remove");
        removePendingButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePendingButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pendingCheckBoxPanel5Layout = new javax.swing.GroupLayout(pendingCheckBoxPanel5);
        pendingCheckBoxPanel5.setLayout(pendingCheckBoxPanel5Layout);
        pendingCheckBoxPanel5Layout.setHorizontalGroup(
            pendingCheckBoxPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendingCheckBoxPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pendingCheckbox5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removePendingButton5)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        pendingCheckBoxPanel5Layout.setVerticalGroup(
            pendingCheckBoxPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pendingCheckBoxPanel5Layout.createSequentialGroup()
                .addGroup(pendingCheckBoxPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pendingCheckBoxPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pendingCheckBoxPanel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(pendingCheckbox5)))
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendingCheckBoxPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(removePendingButton5)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout pendingOrdersPanelLayout = new javax.swing.GroupLayout(pendingOrdersPanel);
        pendingOrdersPanel.setLayout(pendingOrdersPanelLayout);
        pendingOrdersPanelLayout.setHorizontalGroup(
            pendingOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pendingOrdersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pendingOrderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendingOrdersPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(backButtonPendingOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pendingOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pendingOrdersPanelLayout.createSequentialGroup()
                        .addComponent(pendingCheckBoxPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179)
                        .addComponent(checkOutForPendingOrdersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pendingCheckBoxPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pendingCheckBoxPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pendingCheckBoxPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pendingCheckBoxPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        pendingOrdersPanelLayout.setVerticalGroup(
            pendingOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pendingOrdersPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(pendingOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pendingCheckBoxPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pendingCheckBoxPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pendingCheckBoxPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pendingOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pendingOrdersPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pendingOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(backButtonPendingOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkOutForPendingOrdersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(pendingOrdersPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pendingCheckBoxPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pendingCheckBoxPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))))
        );

        containerPanel.add(pendingOrdersPanel, "pendingOrdersPanel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(footerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iconLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconLabelMouseClicked
    }//GEN-LAST:event_iconLabelMouseClicked

    private void cartLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartLabelMouseClicked
        containerPanel.removeAll();
        containerPanel.add(yourCartMainPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_cartLabelMouseClicked

    private void profileLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileLabelMouseClicked
        containerPanel.removeAll();
        containerPanel.add(profilePanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_profileLabelMouseClicked

    private void storeLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storeLabelMouseEntered
        containerPanel.removeAll();
        containerPanel.add(choosePanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_storeLabelMouseEntered

    private void overthecounterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        containerPanel.removeAll();
        containerPanel.add(categoryPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }

    private void searchTextfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextfieldKeyPressed

    }//GEN-LAST:event_searchTextfieldKeyPressed

    private void addToCartButtonActionPerformed(java.awt.event.ActionEvent evt) {
        containerPanel.removeAll();
        containerPanel.add(yourCartMainPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }
    private void backButtonCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonCategoryActionPerformed
        containerPanel.removeAll();
        containerPanel.add(choosePanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_backButtonCategoryActionPerformed


    private void removeCartButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCartButton4ActionPerformed

    }//GEN-LAST:event_removeCartButton4ActionPerformed

    private void removeCartButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCartButton2ActionPerformed

    }//GEN-LAST:event_removeCartButton2ActionPerformed

    private void removeCartButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCartButton3ActionPerformed

    }//GEN-LAST:event_removeCartButton3ActionPerformed

    private void removeCartButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCartButton1ActionPerformed

    }//GEN-LAST:event_removeCartButton1ActionPerformed

    private void removeCartButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCartButton5ActionPerformed

    }//GEN-LAST:event_removeCartButton5ActionPerformed

    private void cartCheckbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartCheckbox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartCheckbox1ActionPerformed

    private void cartCheckbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartCheckbox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartCheckbox2ActionPerformed

    private void cartCheckbox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartCheckbox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartCheckbox3ActionPerformed

    private void cartCheckbox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartCheckbox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartCheckbox4ActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        containerPanel.removeAll();
        containerPanel.add(modeOfDeliveryPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_submitButtonActionPerformed

    private void pickUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickUpButtonActionPerformed

    }//GEN-LAST:event_pickUpButtonActionPerformed

    private void deliveryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_deliveryButtonActionPerformed

    private void nextButtonModeOfPaymennextButtonModeOfDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonModeOfPaymennextButtonModeOfDeliveryActionPerformed
        containerPanel.removeAll();
        containerPanel.add(yourOrderPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_nextButtonModeOfPaymennextButtonModeOfDeliveryActionPerformed

    private void backButtonModeOfDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonModeOfDeliveryActionPerformed
        containerPanel.removeAll();
        containerPanel.add(yourCartMainPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_backButtonModeOfDeliveryActionPerformed

    private void editOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editOrderButtonActionPerformed
        containerPanel.removeAll();
        containerPanel.add(categoryPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_editOrderButtonActionPerformed

    private void checkOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutButtonActionPerformed
        containerPanel.removeAll();
        containerPanel.add(placedOrderPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_checkOutButtonActionPerformed

    private void orderHistoryLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderHistoryLabelMouseClicked
    }//GEN-LAST:event_orderHistoryLabelMouseClicked

    private void helpLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpLabelMouseClicked
    }//GEN-LAST:event_helpLabelMouseClicked

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed

    }//GEN-LAST:event_logOutButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
    }//GEN-LAST:event_saveButtonActionPerformed

    private void pendingCheckbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingCheckbox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pendingCheckbox1ActionPerformed

    private void pendingCheckbox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingCheckbox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pendingCheckbox3ActionPerformed

    private void pendingCheckbox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingCheckbox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pendingCheckbox4ActionPerformed

    private void pendingCheckbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingCheckbox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pendingCheckbox2ActionPerformed

    private void removePendingButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePendingButton1ActionPerformed
    }//GEN-LAST:event_removePendingButton1ActionPerformed

    private void removePendingButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePendingButton2ActionPerformed
    }//GEN-LAST:event_removePendingButton2ActionPerformed

    private void removePendingButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePendingButton3ActionPerformed
    }//GEN-LAST:event_removePendingButton3ActionPerformed

    private void removePendingButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePendingButton4ActionPerformed
    }//GEN-LAST:event_removePendingButton4ActionPerformed

    private void removePendingButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePendingButton5ActionPerformed
    }//GEN-LAST:event_removePendingButton5ActionPerformed

    private void backButtonPendingOrderbackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonPendingOrderbackButtonActionPerformed
        containerPanel.removeAll();
        //containerPanel.add(uploadPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_backButtonPendingOrderbackButtonActionPerformed

    private void checkOutForPendingOrdersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutForPendingOrdersButtonActionPerformed
        containerPanel.removeAll();
        containerPanel.add(modeOfDeliveryPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_checkOutForPendingOrdersButtonActionPerformed

    private void cartCheckbox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartCheckbox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartCheckbox5ActionPerformed

    private void pendingCheckbox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingCheckbox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pendingCheckbox5ActionPerformed

    private void storeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storeLabelMouseClicked
        containerPanel.removeAll();
        containerPanel.add(choosePanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_storeLabelMouseClicked

    private void cashOnDeliveryLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashOnDeliveryLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cashOnDeliveryLabelMouseClicked

    private void backButtonModeOfPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonModeOfPaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonModeOfPaymentActionPerformed

    private void nextButtonModeOfPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonModeOfPaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextButtonModeOfPaymentActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUIFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CVVLabel;
    private javax.swing.JTextField CVVTextfield;
    private javax.swing.JButton addToCartButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton backButtonModeOfDelivery;
    private javax.swing.JButton backButtonModeOfPayment;
    private javax.swing.JButton backButtonPendingOrder;
    private javax.swing.JSeparator buttonSeparator;
    private javax.swing.JLabel cardNumberLabel;
    private javax.swing.JTextField cardNumberTextfield;
    private javax.swing.JCheckBox cartCheckbox1;
    private javax.swing.JCheckBox cartCheckbox2;
    private javax.swing.JCheckBox cartCheckbox3;
    private javax.swing.JCheckBox cartCheckbox4;
    private javax.swing.JCheckBox cartCheckbox5;
    private javax.swing.JLabel cartIcon;
    private javax.swing.JLabel cartLabel;
    private javax.swing.JLabel cashOnDeliveryLabel;
    private javax.swing.JPanel categoryPanel;
    private javax.swing.JSpinner categorySpinner1;
    private javax.swing.JSpinner categorySpinner2;
    private javax.swing.JSpinner categorySpinner3;
    private javax.swing.JSpinner categorySpinner4;
    private javax.swing.JSpinner categorySpinner5;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JButton checkOutForPendingOrdersButton;
    private javax.swing.JPanel choosePanel;
    private javax.swing.JComboBox<String> comboBox1;
    private javax.swing.JComboBox<String> comboBox2;
    private javax.swing.JComboBox<String> comboBox3;
    private javax.swing.JComboBox<String> comboBox4;
    private javax.swing.JComboBox<String> comboBox5;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JPasswordField currentPasswordField;
    private javax.swing.JLabel currentPasswordLabel;
    private javax.swing.JButton deliveryButton;
    private javax.swing.JLabel doctorIcon;
    private javax.swing.JButton editOrderButton;
    private javax.swing.JLabel envelopeIcon;
    private javax.swing.JLabel footerLabel;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JLabel gcashIcon;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel helpLabel;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel instructionsLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JLabel mastercardIcon;
    private javax.swing.JLabel mayaIcon;
    private javax.swing.JLabel modeOfDeliveryLabel;
    private javax.swing.JLabel modeOfDeliveryLabel1;
    private javax.swing.JPanel modeOfDeliveryPanel;
    private javax.swing.JPanel modeOfPaymentPanel;
    private javax.swing.JLabel nameCardLabel;
    private javax.swing.JTextField nameCardTextfield;
    private javax.swing.JLabel nameEwalletLabel;
    private javax.swing.JTextField nameEwalletTextfield;
    private javax.swing.JTextArea nameTextArea;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JLabel newPasswordLabel;
    private javax.swing.JButton nextButtonModeOfDelivery;
    private javax.swing.JButton nextButtonModeOfPayment;
    private javax.swing.JLabel orderHistoryLabel;
    private javax.swing.JButton overthecounterButton;
    private javax.swing.JPanel partOftheProfilePanel;
    private javax.swing.JPanel pendingCheckBoxPanel1;
    private javax.swing.JPanel pendingCheckBoxPanel2;
    private javax.swing.JPanel pendingCheckBoxPanel3;
    private javax.swing.JPanel pendingCheckBoxPanel4;
    private javax.swing.JPanel pendingCheckBoxPanel5;
    private javax.swing.JCheckBox pendingCheckbox1;
    private javax.swing.JCheckBox pendingCheckbox2;
    private javax.swing.JCheckBox pendingCheckbox3;
    private javax.swing.JCheckBox pendingCheckbox4;
    private javax.swing.JCheckBox pendingCheckbox5;
    private javax.swing.JLabel pendingOrderLabel;
    private javax.swing.JPanel pendingOrdersPanel;
    private javax.swing.JTextArea pendingTextArea1;
    private javax.swing.JTextArea pendingTextArea2;
    private javax.swing.JTextArea pendingTextArea3;
    private javax.swing.JTextArea pendingTextArea4;
    private javax.swing.JTextArea pendingTextArea5;
    private javax.swing.JLabel personalInformationLabel;
    private javax.swing.JTextArea personalInformationTextArea;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JTextField phoneNumberTextfield;
    private javax.swing.JButton pickUpButton;
    private javax.swing.JPanel pickUpPanel;
    private javax.swing.JTextArea pickUpTextArea;
    private javax.swing.JLabel placedOrderLabel;
    private javax.swing.JPanel placedOrderPanel;
    private javax.swing.JTextArea placedOrderTextArea;
    private javax.swing.JLabel privacyAndPolicyLabel;
    private javax.swing.JPanel profileDetailsPanel;
    private javax.swing.JLabel profileIcon;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JButton removeCartButton1;
    private javax.swing.JButton removeCartButton2;
    private javax.swing.JButton removeCartButton3;
    private javax.swing.JButton removeCartButton4;
    private javax.swing.JButton removeCartButton5;
    private javax.swing.JButton removePendingButton1;
    private javax.swing.JButton removePendingButton2;
    private javax.swing.JButton removePendingButton3;
    private javax.swing.JButton removePendingButton4;
    private javax.swing.JButton removePendingButton5;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextfield;
    private javax.swing.JLabel selectLabel;
    private javax.swing.JLabel settingLabel;
    private javax.swing.JLabel storeLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton uploadButton;
    private javax.swing.JLabel visaIcon;
    private javax.swing.JLabel yourCartLabel;
    private javax.swing.JPanel yourCartMainPanel;
    private javax.swing.JPanel yourCartPanel1;
    private javax.swing.JPanel yourCartPanel2;
    private javax.swing.JPanel yourCartPanel3;
    private javax.swing.JPanel yourCartPanel4;
    private javax.swing.JPanel yourCartPanel5;
    private javax.swing.JTextArea yourCartTextArea1;
    private javax.swing.JTextArea yourCartTextArea2;
    private javax.swing.JTextArea yourCartTextArea3;
    private javax.swing.JTextArea yourCartTextArea4;
    private javax.swing.JTextArea yourCartTextArea5;
    private javax.swing.JLabel yourOrderLabel;
    private javax.swing.JPanel yourOrderPanel;
    private javax.swing.JTextArea yourOrderTextArea;
    // End of variables declaration//GEN-END:variables
}

