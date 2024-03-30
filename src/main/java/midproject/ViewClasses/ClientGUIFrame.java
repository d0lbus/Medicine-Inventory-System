package midproject.ViewClasses;

import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;


/**
 * This class is used for designing the whole Client GUI program
 * 
 * @author Encarnacion, Ma. Earl Freskkie
 * @since January 31 - February 17, 2024
 */
public class ClientGUIFrame extends javax.swing.JFrame {

    private static ClientGUIFrame instance;

    /**
     * Creates new form ClientGUIFrame
     */

    public ClientGUIFrame() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public static ClientGUIFrame getInstance() {
        if (instance == null) {
            instance = new ClientGUIFrame();
        }
        return instance;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        iconLabel = new javax.swing.JLabel();
        profileLabel = new javax.swing.JLabel();
        storeLabel = new javax.swing.JLabel();
        cartLabel = new javax.swing.JLabel();
        notificationsLabel = new javax.swing.JLabel();
        footerPanel = new javax.swing.JPanel();
        footerLabel = new javax.swing.JLabel();
        containerPanel = new javax.swing.JPanel();
        choosePanel = new javax.swing.JPanel();
        doctorIcon = new javax.swing.JLabel();
        overthecounterButton = new javax.swing.JButton();
        instructionsLabel1 = new javax.swing.JLabel();
        categoryPanel = new javax.swing.JPanel();
        selectQuantity = new javax.swing.JInternalFrame();
        jSpinner1 = new javax.swing.JSpinner();
        cancelButton = new javax.swing.JButton();
        proceedButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchTextfield = new javax.swing.JTextField();
        searchLabel = new javax.swing.JLabel();
        addToCartButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();
        categoryComboBox = new javax.swing.JComboBox<>();
        backButton = new javax.swing.JButton();
        yourCartMainPanel = new javax.swing.JPanel();
        yourCartLabel = new javax.swing.JLabel();
        searchLabel1 = new javax.swing.JLabel();
        searchTextfield1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        categoryTable1 = new javax.swing.JTable();
        removeButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        backYourCartButton = new javax.swing.JButton();
        editOrderButton1 = new javax.swing.JButton();
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
        checkOutButton = new javax.swing.JButton();
        buttonSeparator = new javax.swing.JSeparator();
        uploadPrescriptionButton = new javax.swing.JButton();
        placedOrderPanel = new javax.swing.JPanel();
        placedOrderLabel = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        placedOrderTextArea = new javax.swing.JTextArea();
        profilePanel = new javax.swing.JPanel();
        profileDetailsPanel = new javax.swing.JPanel();
        profileIcon = new javax.swing.JLabel();
        cartIcon = new javax.swing.JLabel();
        envelopeIcon = new javax.swing.JLabel();
        orderHistoryLabel = new javax.swing.JLabel();
        helpLabel = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        nameOnlyLabel = new javax.swing.JLabel();
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
        notificationsPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        notificationsTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quantum Drugstore");
        setBackground(new java.awt.Color(255, 255, 255));

        headerPanel.setBackground(new java.awt.Color(44, 125, 160));

        titleLabel.setFont(new java.awt.Font("Sitka Heading", 1, 48)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Quantum Drugstore");

        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo.png"))); // NOI18N
        iconLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconLabelMouseClicked(evt);
            }
        });

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

        notificationsLabel.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        notificationsLabel.setForeground(new java.awt.Color(255, 255, 255));
        notificationsLabel.setText("NOTIFICATIONS");
        notificationsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationsLabelMouseClicked(evt);
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
                .addGap(50, 50, 50)
                .addComponent(profileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(notificationsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(storeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
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
                    .addComponent(notificationsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cartLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(storeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, choosePanelLayout.createSequentialGroup()
                .addGap(0, 479, Short.MAX_VALUE)
                .addComponent(instructionsLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(419, 419, 419))
            .addGroup(choosePanelLayout.createSequentialGroup()
                .addGroup(choosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(choosePanelLayout.createSequentialGroup()
                        .addGap(564, 564, 564)
                        .addComponent(doctorIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(choosePanelLayout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(overthecounterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(582, Short.MAX_VALUE))
        );
        choosePanelLayout.setVerticalGroup(
            choosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelLayout.createSequentialGroup()
                .addContainerGap(253, Short.MAX_VALUE)
                .addComponent(doctorIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(overthecounterButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(instructionsLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275))
        );

        containerPanel.add(choosePanel, "choosePanel");

        categoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        selectQuantity.setVisible(true);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        proceedButton.setText("Proceed");
        proceedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Quantity");

        javax.swing.GroupLayout selectQuantityLayout = new javax.swing.GroupLayout(selectQuantity.getContentPane());
        selectQuantity.getContentPane().setLayout(selectQuantityLayout);
        selectQuantityLayout.setHorizontalGroup(
            selectQuantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectQuantityLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(proceedButton)
                .addGap(66, 66, 66))
            .addGroup(selectQuantityLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectQuantityLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );
        selectQuantityLayout.setVerticalGroup(
            selectQuantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectQuantityLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectQuantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(proceedButton))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        searchTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextfieldActionPerformed(evt);
            }
        });
        searchTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextfieldKeyPressed(evt);
            }
        });

        searchLabel.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        searchLabel.setForeground(new java.awt.Color(33, 37, 41));
        searchLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchLabel.setText("Search your generic medicine");

        addToCartButton.setText("Add to cart");
        addToCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartButtonActionPerformed(evt);
            }
        });

        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Category", "Generic Name", "Brand Name", "Form", "Price", "Remaining Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        categoryTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(categoryTable);

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Painkillers", "Sleeping Pills", "Antibiotics", "Flu Medicines", "Supplements" }));
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoryPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(548, 548, 548))
            .addGroup(categoryPanelLayout.createSequentialGroup()
                .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(categoryPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(backButton))
                    .addGroup(categoryPanelLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(categoryPanelLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(categoryPanelLayout.createSequentialGroup()
                                .addComponent(searchTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(categoryPanelLayout.createSequentialGroup()
                    .addGap(460, 460, 460)
                    .addComponent(selectQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(460, Short.MAX_VALUE)))
        );
        categoryPanelLayout.setVerticalGroup(
            categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoryPanelLayout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(searchLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(categoryPanelLayout.createSequentialGroup()
                    .addGap(276, 276, 276)
                    .addComponent(selectQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(277, Short.MAX_VALUE)))
        );

        containerPanel.add(categoryPanel, "categoryPanel");

        yourCartMainPanel.setBackground(new java.awt.Color(255, 255, 255));

        yourCartLabel.setFont(new java.awt.Font("Sitka Heading", 1, 36)); // NOI18N
        yourCartLabel.setForeground(new java.awt.Color(33, 37, 41));
        yourCartLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yourCartLabel.setText("Your Cart");

        searchLabel1.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        searchLabel1.setForeground(new java.awt.Color(33, 37, 41));
        searchLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchLabel1.setText("Search your generic medicine");

        searchTextfield1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextfield1ActionPerformed(evt);
            }
        });
        searchTextfield1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextfield1KeyPressed(evt);
            }
        });

        categoryTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Category", "Generic Name", "Brand Name", "Form", "Price", "Chosen Quantity", "Remaining Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        categoryTable1.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(categoryTable1);

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.setToolTipText("");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        backYourCartButton.setText("Back");
        backYourCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backYourCartButtonCategoryActionPerformed(evt);
            }
        });

        editOrderButton1.setText("Edit Order");
        editOrderButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editOrderButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout yourCartMainPanelLayout = new javax.swing.GroupLayout(yourCartMainPanel);
        yourCartMainPanel.setLayout(yourCartMainPanelLayout);
        yourCartMainPanelLayout.setHorizontalGroup(
            yourCartMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourCartMainPanelLayout.createSequentialGroup()
                .addGroup(yourCartMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(yourCartMainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(yourCartLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE))
                    .addGroup(yourCartMainPanelLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(yourCartMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(yourCartMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(searchLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchTextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70)
                        .addGroup(yourCartMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editOrderButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(yourCartMainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backYourCartButton)
                .addGap(1066, 1066, 1066)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        yourCartMainPanelLayout.setVerticalGroup(
            yourCartMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourCartMainPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(yourCartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchLabel1)
                .addGap(5, 5, 5)
                .addComponent(searchTextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(yourCartMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(yourCartMainPanelLayout.createSequentialGroup()
                        .addComponent(editOrderButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(yourCartMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backYourCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
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

        checkOutButton.setText("Check Out");
        checkOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutButtonActionPerformed(evt);
            }
        });

        uploadPrescriptionButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        uploadPrescriptionButton.setText("Upload");
        uploadPrescriptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadPrescriptionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout yourOrderPanelLayout = new javax.swing.GroupLayout(yourOrderPanel);
        yourOrderPanel.setLayout(yourOrderPanelLayout);
        yourOrderPanelLayout.setHorizontalGroup(
            yourOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourOrderPanelLayout.createSequentialGroup()
                .addGap(431, 431, 431)
                .addComponent(buttonSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(yourOrderPanelLayout.createSequentialGroup()
                .addGroup(yourOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(yourOrderPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(yourOrderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(yourOrderPanelLayout.createSequentialGroup()
                        .addGroup(yourOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(yourOrderPanelLayout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(yourOrderPanelLayout.createSequentialGroup()
                                .addGap(543, 543, 543)
                                .addGroup(yourOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(uploadPrescriptionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        yourOrderPanelLayout.setVerticalGroup(
            yourOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourOrderPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(yourOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(checkOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uploadPrescriptionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
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
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );
        placedOrderPanelLayout.setVerticalGroup(
            placedOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(placedOrderPanelLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(placedOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        containerPanel.add(placedOrderPanel, "placedOrderPanel");

        profilePanel.setBackground(new java.awt.Color(255, 255, 255));

        profileDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        profileDetailsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        profileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profileBig.png"))); // NOI18N

        cartIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/orderHistoryIcon.png"))); // NOI18N

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

        nameOnlyLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        nameOnlyLabel.setForeground(new java.awt.Color(60, 63, 65));
        nameOnlyLabel.setText("jLabel1");

        javax.swing.GroupLayout profileDetailsPanelLayout = new javax.swing.GroupLayout(profileDetailsPanel);
        profileDetailsPanel.setLayout(profileDetailsPanelLayout);
        profileDetailsPanelLayout.setHorizontalGroup(
            profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileDetailsPanelLayout.createSequentialGroup()
                .addGroup(profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profileDetailsPanelLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(profileIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(profileDetailsPanelLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameOnlyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(profileDetailsPanelLayout.createSequentialGroup()
                                .addGroup(profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(envelopeIcon)
                                    .addComponent(cartIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(orderHistoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(helpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        profileDetailsPanelLayout.setVerticalGroup(
            profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profileIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(nameOnlyLabel)
                .addGroup(profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profileDetailsPanelLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(orderHistoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileDetailsPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartIcon)
                        .addGap(29, 29, 29)))
                .addGroup(profileDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(envelopeIcon)
                    .addComponent(helpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
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
                .addContainerGap(58, Short.MAX_VALUE))
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

        notificationsTextArea.setEditable(false);
        notificationsTextArea.setColumns(20);
        notificationsTextArea.setRows(5);
        jScrollPane3.setViewportView(notificationsTextArea);

        javax.swing.GroupLayout notificationsPanelLayout = new javax.swing.GroupLayout(notificationsPanel);
        notificationsPanel.setLayout(notificationsPanelLayout);
        notificationsPanelLayout.setHorizontalGroup(
            notificationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationsPanelLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        notificationsPanelLayout.setVerticalGroup(
            notificationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationsPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        containerPanel.add(notificationsPanel, "card10");

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

    private void overthecounterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        containerPanel.removeAll();
        containerPanel.add(categoryPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }

    private void searchTextfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextfieldKeyPressed

    }//GEN-LAST:event_searchTextfieldKeyPressed

    private void addToCartButtonActionPerformed(java.awt.event.ActionEvent evt) {
        selectQuantity.setVisible(true);

    }
    private void backButtonCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonCategoryActionPerformed
        containerPanel.removeAll();
        containerPanel.add(choosePanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_backButtonCategoryActionPerformed


    private void pickUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickUpButtonActionPerformed

    }//GEN-LAST:event_pickUpButtonActionPerformed

    private void deliveryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_deliveryButtonActionPerformed

    private void nextButtonModeOfPaymennextButtonModeOfDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonModeOfPaymennextButtonModeOfDeliveryActionPerformed
        containerPanel.removeAll();
        containerPanel.add(modeOfPaymentPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_nextButtonModeOfPaymennextButtonModeOfDeliveryActionPerformed

    private void backButtonModeOfDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonModeOfDeliveryActionPerformed
        containerPanel.removeAll();
        containerPanel.add(yourCartMainPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_backButtonModeOfDeliveryActionPerformed

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

    private void cashOnDeliveryLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashOnDeliveryLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cashOnDeliveryLabelMouseClicked

    private void backButtonModeOfPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonModeOfPaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonModeOfPaymentActionPerformed

    private void nextButtonModeOfPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonModeOfPaymentActionPerformed
        containerPanel.removeAll();
        containerPanel.add(yourOrderPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_nextButtonModeOfPaymentActionPerformed

    private void searchTextfield1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextfield1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextfield1KeyPressed

    private void backYourCartButtonCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backYourCartButtonCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backYourCartButtonCategoryActionPerformed

    private void uploadPrescriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadPrescriptionButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uploadPrescriptionButtonActionPerformed

    private void editOrderButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editOrderButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editOrderButton1ActionPerformed

    private void cartLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartLabelMouseClicked
        containerPanel.removeAll();
        containerPanel.add(yourCartMainPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_cartLabelMouseClicked

    private void storeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storeLabelMouseClicked
        containerPanel.removeAll();
        containerPanel.add(choosePanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_storeLabelMouseClicked

    private void profileLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileLabelMouseClicked
        containerPanel.removeAll();
        containerPanel.add(profilePanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_profileLabelMouseClicked

    private void notificationsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationsLabelMouseClicked
        containerPanel.removeAll();
        containerPanel.add(notificationsPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_notificationsLabelMouseClicked

    private void searchTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextfieldActionPerformed

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    private void searchTextfield1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextfield1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextfield1ActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        containerPanel.removeAll();
        containerPanel.add(modeOfDeliveryPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_submitButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void proceedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedButtonActionPerformed
        containerPanel.removeAll();
        containerPanel.add(yourCartMainPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_proceedButtonActionPerformed

    public static void main(String args[]) {
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUIFrame().setVisible(true);
            }
        });
    }

    public JLabel getCVVLabel() {
        return CVVLabel;
    }

    public void setCVVLabel(JLabel CVVLabel) {
        this.CVVLabel = CVVLabel;
    }

    public JTextField getCVVTextfield() {
        return CVVTextfield;
    }

    public void setCVVTextfield(JTextField CVVTextfield) {
        this.CVVTextfield = CVVTextfield;
    }

    public JButton getAddToCartButton() {
        return addToCartButton;
    }

    public void setAddToCartButton(JButton addToCartButton) {
        this.addToCartButton = addToCartButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getBackButtonModeOfDelivery() {
        return backButtonModeOfDelivery;
    }

    public void setBackButtonModeOfDelivery(JButton backButtonModeOfDelivery) {
        this.backButtonModeOfDelivery = backButtonModeOfDelivery;
    }

    public JButton getBackButtonModeOfPayment() {
        return backButtonModeOfPayment;
    }

    public void setBackButtonModeOfPayment(JButton backButtonModeOfPayment) {
        this.backButtonModeOfPayment = backButtonModeOfPayment;
    }

    public JButton getBackYourCartButton() {
        return backYourCartButton;
    }

    public void setBackYourCartButton(JButton backYourCartButton) {
        this.backYourCartButton = backYourCartButton;
    }

    public JSeparator getButtonSeparator() {
        return buttonSeparator;
    }

    public void setButtonSeparator(JSeparator buttonSeparator) {
        this.buttonSeparator = buttonSeparator;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public JLabel getCardNumberLabel() {
        return cardNumberLabel;
    }

    public void setCardNumberLabel(JLabel cardNumberLabel) {
        this.cardNumberLabel = cardNumberLabel;
    }

    public JTextField getCardNumberTextfield() {
        return cardNumberTextfield;
    }

    public void setCardNumberTextfield(JTextField cardNumberTextfield) {
        this.cardNumberTextfield = cardNumberTextfield;
    }

    public JLabel getCartIcon() {
        return cartIcon;
    }

    public void setCartIcon(JLabel cartIcon) {
        this.cartIcon = cartIcon;
    }

    public JLabel getCartLabel() {
        return cartLabel;
    }

    public void setCartLabel(JLabel cartLabel) {
        this.cartLabel = cartLabel;
    }

    public JLabel getCashOnDeliveryLabel() {
        return cashOnDeliveryLabel;
    }

    public void setCashOnDeliveryLabel(JLabel cashOnDeliveryLabel) {
        this.cashOnDeliveryLabel = cashOnDeliveryLabel;
    }

    public JComboBox<String> getCategoryComboBox() {
        return categoryComboBox;
    }

    public void setCategoryComboBox(JComboBox<String> categoryComboBox) {
        this.categoryComboBox = categoryComboBox;
    }

    public JPanel getCategoryPanel() {
        return categoryPanel;
    }

    public void setCategoryPanel(JPanel categoryPanel) {
        this.categoryPanel = categoryPanel;
    }

    public JTable getCategoryTable() {
        return categoryTable;
    }

    public void setCategoryTable(JTable categoryTable) {
        this.categoryTable = categoryTable;
    }

    public JTable getCategoryTable1() {
        return categoryTable1;
    }

    public void setCategoryTable1(JTable categoryTable1) {
        this.categoryTable1 = categoryTable1;
    }

    public JButton getCheckOutButton() {
        return checkOutButton;
    }

    public void setCheckOutButton(JButton checkOutButton) {
        this.checkOutButton = checkOutButton;
    }

    public JPanel getChoosePanel() {
        return choosePanel;
    }

    public void setChoosePanel(JPanel choosePanel) {
        this.choosePanel = choosePanel;
    }

    public JPasswordField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public void setConfirmPasswordField(JPasswordField confirmPasswordField) {
        this.confirmPasswordField = confirmPasswordField;
    }

    public JLabel getConfirmPasswordLabel() {
        return confirmPasswordLabel;
    }

    public void setConfirmPasswordLabel(JLabel confirmPasswordLabel) {
        this.confirmPasswordLabel = confirmPasswordLabel;
    }

    public JPanel getContainerPanel() {
        return containerPanel;
    }

    public void setContainerPanel(JPanel containerPanel) {
        this.containerPanel = containerPanel;
    }

    public JPasswordField getCurrentPasswordField() {
        return currentPasswordField;
    }

    public void setCurrentPasswordField(JPasswordField currentPasswordField) {
        this.currentPasswordField = currentPasswordField;
    }

    public JLabel getCurrentPasswordLabel() {
        return currentPasswordLabel;
    }

    public void setCurrentPasswordLabel(JLabel currentPasswordLabel) {
        this.currentPasswordLabel = currentPasswordLabel;
    }

    public JButton getDeliveryButton() {
        return deliveryButton;
    }

    public void setDeliveryButton(JButton deliveryButton) {
        this.deliveryButton = deliveryButton;
    }

    public JLabel getDoctorIcon() {
        return doctorIcon;
    }

    public void setDoctorIcon(JLabel doctorIcon) {
        this.doctorIcon = doctorIcon;
    }

    public JButton getEditOrderButton1() {
        return editOrderButton1;
    }

    public void setEditOrderButton1(JButton editOrderButton1) {
        this.editOrderButton1 = editOrderButton1;
    }

    public JLabel getEnvelopeIcon() {
        return envelopeIcon;
    }

    public void setEnvelopeIcon(JLabel envelopeIcon) {
        this.envelopeIcon = envelopeIcon;
    }

    public JLabel getFooterLabel() {
        return footerLabel;
    }

    public void setFooterLabel(JLabel footerLabel) {
        this.footerLabel = footerLabel;
    }

    public JPanel getFooterPanel() {
        return footerPanel;
    }

    public void setFooterPanel(JPanel footerPanel) {
        this.footerPanel = footerPanel;
    }

    public JLabel getGcashIcon() {
        return gcashIcon;
    }

    public void setGcashIcon(JLabel gcashIcon) {
        this.gcashIcon = gcashIcon;
    }

    public JPanel getHeaderPanel() {
        return headerPanel;
    }

    public void setHeaderPanel(JPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public JLabel getHelpLabel() {
        return helpLabel;
    }

    public void setHelpLabel(JLabel helpLabel) {
        this.helpLabel = helpLabel;
    }

    public JLabel getIconLabel() {
        return iconLabel;
    }

    public void setIconLabel(JLabel iconLabel) {
        this.iconLabel = iconLabel;
    }

    public JLabel getInstructionsLabel1() {
        return instructionsLabel1;
    }

    public void setInstructionsLabel1(JLabel instructionsLabel1) {
        this.instructionsLabel1 = instructionsLabel1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane10() {
        return jScrollPane10;
    }

    public void setjScrollPane10(JScrollPane jScrollPane10) {
        this.jScrollPane10 = jScrollPane10;
    }

    public JScrollPane getjScrollPane11() {
        return jScrollPane11;
    }

    public void setjScrollPane11(JScrollPane jScrollPane11) {
        this.jScrollPane11 = jScrollPane11;
    }

    public JScrollPane getjScrollPane12() {
        return jScrollPane12;
    }

    public void setjScrollPane12(JScrollPane jScrollPane12) {
        this.jScrollPane12 = jScrollPane12;
    }

    public JScrollPane getjScrollPane18() {
        return jScrollPane18;
    }

    public void setjScrollPane18(JScrollPane jScrollPane18) {
        this.jScrollPane18 = jScrollPane18;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JScrollPane getjScrollPane9() {
        return jScrollPane9;
    }

    public void setjScrollPane9(JScrollPane jScrollPane9) {
        this.jScrollPane9 = jScrollPane9;
    }

    public JSpinner getjSpinner1() {
        return jSpinner1;
    }

    public void setjSpinner1(JSpinner jSpinner1) {
        this.jSpinner1 = jSpinner1;
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    public JButton getLogOutButton() {
        return logOutButton;
    }

    public void setLogOutButton(JButton logOutButton) {
        this.logOutButton = logOutButton;
    }

    public JLabel getMastercardIcon() {
        return mastercardIcon;
    }

    public void setMastercardIcon(JLabel mastercardIcon) {
        this.mastercardIcon = mastercardIcon;
    }

    public JLabel getMayaIcon() {
        return mayaIcon;
    }

    public void setMayaIcon(JLabel mayaIcon) {
        this.mayaIcon = mayaIcon;
    }

    public JLabel getModeOfDeliveryLabel() {
        return modeOfDeliveryLabel;
    }

    public void setModeOfDeliveryLabel(JLabel modeOfDeliveryLabel) {
        this.modeOfDeliveryLabel = modeOfDeliveryLabel;
    }

    public JLabel getModeOfDeliveryLabel1() {
        return modeOfDeliveryLabel1;
    }

    public void setModeOfDeliveryLabel1(JLabel modeOfDeliveryLabel1) {
        this.modeOfDeliveryLabel1 = modeOfDeliveryLabel1;
    }

    public JPanel getModeOfDeliveryPanel() {
        return modeOfDeliveryPanel;
    }

    public void setModeOfDeliveryPanel(JPanel modeOfDeliveryPanel) {
        this.modeOfDeliveryPanel = modeOfDeliveryPanel;
    }

    public JPanel getModeOfPaymentPanel() {
        return modeOfPaymentPanel;
    }

    public void setModeOfPaymentPanel(JPanel modeOfPaymentPanel) {
        this.modeOfPaymentPanel = modeOfPaymentPanel;
    }

    public JLabel getNameCardLabel() {
        return nameCardLabel;
    }

    public void setNameCardLabel(JLabel nameCardLabel) {
        this.nameCardLabel = nameCardLabel;
    }

    public JTextField getNameCardTextfield() {
        return nameCardTextfield;
    }

    public void setNameCardTextfield(JTextField nameCardTextfield) {
        this.nameCardTextfield = nameCardTextfield;
    }

    public JLabel getNameEwalletLabel() {
        return nameEwalletLabel;
    }

    public void setNameEwalletLabel(JLabel nameEwalletLabel) {
        this.nameEwalletLabel = nameEwalletLabel;
    }

    public JTextField getNameEwalletTextfield() {
        return nameEwalletTextfield;
    }

    public void setNameEwalletTextfield(JTextField nameEwalletTextfield) {
        this.nameEwalletTextfield = nameEwalletTextfield;
    }

    public JLabel getNameOnlyLabel() {
        return nameOnlyLabel;
    }

    public void setNameOnlyLabel(JLabel nameOnlyLabel) {
        this.nameOnlyLabel = nameOnlyLabel;
    }

    public JPasswordField getNewPasswordField() {
        return newPasswordField;
    }

    public void setNewPasswordField(JPasswordField newPasswordField) {
        this.newPasswordField = newPasswordField;
    }

    public JLabel getNewPasswordLabel() {
        return newPasswordLabel;
    }

    public void setNewPasswordLabel(JLabel newPasswordLabel) {
        this.newPasswordLabel = newPasswordLabel;
    }

    public JButton getNextButtonModeOfDelivery() {
        return nextButtonModeOfDelivery;
    }

    public void setNextButtonModeOfDelivery(JButton nextButtonModeOfDelivery) {
        this.nextButtonModeOfDelivery = nextButtonModeOfDelivery;
    }

    public JButton getNextButtonModeOfPayment() {
        return nextButtonModeOfPayment;
    }

    public void setNextButtonModeOfPayment(JButton nextButtonModeOfPayment) {
        this.nextButtonModeOfPayment = nextButtonModeOfPayment;
    }

    public JLabel getNotificationsLabel() {
        return notificationsLabel;
    }

    public void setNotificationsLabel(JLabel notificationsLabel) {
        this.notificationsLabel = notificationsLabel;
    }

    public JPanel getNotificationsPanel() {
        return notificationsPanel;
    }

    public void setNotificationsPanel(JPanel notificationsPanel) {
        this.notificationsPanel = notificationsPanel;
    }

    public JTextArea getNotificationsTextArea() {
        return notificationsTextArea;
    }

    public void setNotificationsTextArea(JTextArea notificationsTextArea) {
        this.notificationsTextArea = notificationsTextArea;
    }

    public JLabel getOrderHistoryLabel() {
        return orderHistoryLabel;
    }

    public void setOrderHistoryLabel(JLabel orderHistoryLabel) {
        this.orderHistoryLabel = orderHistoryLabel;
    }

    public JButton getOverthecounterButton() {
        return overthecounterButton;
    }

    public void setOverthecounterButton(JButton overthecounterButton) {
        this.overthecounterButton = overthecounterButton;
    }

    public JPanel getPartOftheProfilePanel() {
        return partOftheProfilePanel;
    }

    public void setPartOftheProfilePanel(JPanel partOftheProfilePanel) {
        this.partOftheProfilePanel = partOftheProfilePanel;
    }

    public JLabel getPersonalInformationLabel() {
        return personalInformationLabel;
    }

    public void setPersonalInformationLabel(JLabel personalInformationLabel) {
        this.personalInformationLabel = personalInformationLabel;
    }

    public JTextArea getPersonalInformationTextArea() {
        return personalInformationTextArea;
    }

    public void setPersonalInformationTextArea(JTextArea personalInformationTextArea) {
        this.personalInformationTextArea = personalInformationTextArea;
    }

    public JLabel getPhoneNumberLabel() {
        return phoneNumberLabel;
    }

    public void setPhoneNumberLabel(JLabel phoneNumberLabel) {
        this.phoneNumberLabel = phoneNumberLabel;
    }

    public JTextField getPhoneNumberTextfield() {
        return phoneNumberTextfield;
    }

    public void setPhoneNumberTextfield(JTextField phoneNumberTextfield) {
        this.phoneNumberTextfield = phoneNumberTextfield;
    }

    public JButton getPickUpButton() {
        return pickUpButton;
    }

    public void setPickUpButton(JButton pickUpButton) {
        this.pickUpButton = pickUpButton;
    }

    public JPanel getPickUpPanel() {
        return pickUpPanel;
    }

    public void setPickUpPanel(JPanel pickUpPanel) {
        this.pickUpPanel = pickUpPanel;
    }

    public JTextArea getPickUpTextArea() {
        return pickUpTextArea;
    }

    public void setPickUpTextArea(JTextArea pickUpTextArea) {
        this.pickUpTextArea = pickUpTextArea;
    }

    public JLabel getPlacedOrderLabel() {
        return placedOrderLabel;
    }

    public void setPlacedOrderLabel(JLabel placedOrderLabel) {
        this.placedOrderLabel = placedOrderLabel;
    }

    public JPanel getPlacedOrderPanel() {
        return placedOrderPanel;
    }

    public void setPlacedOrderPanel(JPanel placedOrderPanel) {
        this.placedOrderPanel = placedOrderPanel;
    }

    public JTextArea getPlacedOrderTextArea() {
        return placedOrderTextArea;
    }

    public void setPlacedOrderTextArea(JTextArea placedOrderTextArea) {
        this.placedOrderTextArea = placedOrderTextArea;
    }

    public JLabel getPrivacyAndPolicyLabel() {
        return privacyAndPolicyLabel;
    }

    public void setPrivacyAndPolicyLabel(JLabel privacyAndPolicyLabel) {
        this.privacyAndPolicyLabel = privacyAndPolicyLabel;
    }

    public JButton getProceedButton() {
        return proceedButton;
    }

    public void setProceedButton(JButton proceedButton) {
        this.proceedButton = proceedButton;
    }

    public JPanel getProfileDetailsPanel() {
        return profileDetailsPanel;
    }

    public void setProfileDetailsPanel(JPanel profileDetailsPanel) {
        this.profileDetailsPanel = profileDetailsPanel;
    }

    public JLabel getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon(JLabel profileIcon) {
        this.profileIcon = profileIcon;
    }

    public JLabel getProfileLabel() {
        return profileLabel;
    }

    public void setProfileLabel(JLabel profileLabel) {
        this.profileLabel = profileLabel;
    }

    public JPanel getProfilePanel() {
        return profilePanel;
    }

    public void setProfilePanel(JPanel profilePanel) {
        this.profilePanel = profilePanel;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public void setRemoveButton(JButton removeButton) {
        this.removeButton = removeButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public JLabel getSearchLabel() {
        return searchLabel;
    }

    public void setSearchLabel(JLabel searchLabel) {
        this.searchLabel = searchLabel;
    }

    public JLabel getSearchLabel1() {
        return searchLabel1;
    }

    public void setSearchLabel1(JLabel searchLabel1) {
        this.searchLabel1 = searchLabel1;
    }

    public JTextField getSearchTextfield() {
        return searchTextfield;
    }

    public void setSearchTextfield(JTextField searchTextfield) {
        this.searchTextfield = searchTextfield;
    }

    public JTextField getSearchTextfield1() {
        return searchTextfield1;
    }

    public void setSearchTextfield1(JTextField searchTextfield1) {
        this.searchTextfield1 = searchTextfield1;
    }

    public JInternalFrame getSelectQuantity() {
        return selectQuantity;
    }

    public void setSelectQuantity(JInternalFrame selectQuantity) {
        this.selectQuantity = selectQuantity;
    }

    public JLabel getSettingLabel() {
        return settingLabel;
    }

    public void setSettingLabel(JLabel settingLabel) {
        this.settingLabel = settingLabel;
    }

    public JLabel getStoreLabel() {
        return storeLabel;
    }

    public void setStoreLabel(JLabel storeLabel) {
        this.storeLabel = storeLabel;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JButton getUploadPrescriptionButton() {
        return uploadPrescriptionButton;
    }

    public void setUploadPrescriptionButton(JButton uploadPrescriptionButton) {
        this.uploadPrescriptionButton = uploadPrescriptionButton;
    }

    public JLabel getVisaIcon() {
        return visaIcon;
    }

    public void setVisaIcon(JLabel visaIcon) {
        this.visaIcon = visaIcon;
    }

    public JLabel getYourCartLabel() {
        return yourCartLabel;
    }

    public void setYourCartLabel(JLabel yourCartLabel) {
        this.yourCartLabel = yourCartLabel;
    }

    public JPanel getYourCartMainPanel() {
        return yourCartMainPanel;
    }

    public void setYourCartMainPanel(JPanel yourCartMainPanel) {
        this.yourCartMainPanel = yourCartMainPanel;
    }

    public JLabel getYourOrderLabel() {
        return yourOrderLabel;
    }

    public void setYourOrderLabel(JLabel yourOrderLabel) {
        this.yourOrderLabel = yourOrderLabel;
    }

    public JPanel getYourOrderPanel() {
        return yourOrderPanel;
    }

    public void setYourOrderPanel(JPanel yourOrderPanel) {
        this.yourOrderPanel = yourOrderPanel;
    }

    public JTextArea getYourOrderTextArea() {
        return yourOrderTextArea;
    }

    public void setYourOrderTextArea(JTextArea yourOrderTextArea) {
        this.yourOrderTextArea = yourOrderTextArea;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CVVLabel;
    private javax.swing.JTextField CVVTextfield;
    private javax.swing.JButton addToCartButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton backButtonModeOfDelivery;
    private javax.swing.JButton backButtonModeOfPayment;
    private javax.swing.JButton backYourCartButton;
    private javax.swing.JSeparator buttonSeparator;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel cardNumberLabel;
    private javax.swing.JTextField cardNumberTextfield;
    private javax.swing.JLabel cartIcon;
    private javax.swing.JLabel cartLabel;
    private javax.swing.JLabel cashOnDeliveryLabel;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JPanel categoryPanel;
    private javax.swing.JTable categoryTable;
    private javax.swing.JTable categoryTable1;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JPanel choosePanel;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JPasswordField currentPasswordField;
    private javax.swing.JLabel currentPasswordLabel;
    private javax.swing.JButton deliveryButton;
    private javax.swing.JLabel doctorIcon;
    private javax.swing.JButton editOrderButton1;
    private javax.swing.JLabel envelopeIcon;
    private javax.swing.JLabel footerLabel;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JLabel gcashIcon;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel helpLabel;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel instructionsLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSpinner jSpinner1;
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
    private javax.swing.JLabel nameOnlyLabel;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JLabel newPasswordLabel;
    private javax.swing.JButton nextButtonModeOfDelivery;
    private javax.swing.JButton nextButtonModeOfPayment;
    private javax.swing.JLabel notificationsLabel;
    private javax.swing.JPanel notificationsPanel;
    private javax.swing.JTextArea notificationsTextArea;
    private javax.swing.JLabel orderHistoryLabel;
    private javax.swing.JButton overthecounterButton;
    private javax.swing.JPanel partOftheProfilePanel;
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
    private javax.swing.JButton proceedButton;
    private javax.swing.JPanel profileDetailsPanel;
    private javax.swing.JLabel profileIcon;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JLabel searchLabel1;
    private javax.swing.JTextField searchTextfield;
    private javax.swing.JTextField searchTextfield1;
    private javax.swing.JInternalFrame selectQuantity;
    private javax.swing.JLabel settingLabel;
    private javax.swing.JLabel storeLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton uploadPrescriptionButton;
    private javax.swing.JLabel visaIcon;
    private javax.swing.JLabel yourCartLabel;
    private javax.swing.JPanel yourCartMainPanel;
    private javax.swing.JLabel yourOrderLabel;
    private javax.swing.JPanel yourOrderPanel;
    private javax.swing.JTextArea yourOrderTextArea;
    // End of variables declaration//GEN-END:variables
}

