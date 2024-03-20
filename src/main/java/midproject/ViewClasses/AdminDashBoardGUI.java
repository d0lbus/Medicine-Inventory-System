/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package midproject.ViewClasses;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

import java.lang.String;

/**
 *
 * @author D0LBUS
 */
public class AdminDashBoardGUI extends javax.swing.JFrame {
    
    private CardLayout cardLayout = new CardLayout();
    /**
     * Creates new form AdminDashBoardGUI
     */
    public AdminDashBoardGUI() {
        initComponents();
        this.cardLayout = (CardLayout) containerPanel.getLayout();
        setResizable(false);
        setLocationRelativeTo(null);
        Image logo = Toolkit.getDefaultToolkit().getImage("Icons/logo.png");
        setIconImage(logo);

        birthdateCalendar.setDateFormatString("dd/MM/yyyy");
        JTextFieldDateEditor editor = (JTextFieldDateEditor) birthdateCalendar.getDateEditor().getUiComponent();
        editor.setEditable(false);
        ageTextField.setEditable(false);

        registeredUsersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        registeredUsersTable.setRowSelectionAllowed(true);
        registeredUsersTable.setColumnSelectionAllowed(false);

        birthdateCalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                birthdateCalendarPropertyChange(evt);
            }
        }
        );

        updateAge();
    }

    private void birthdateCalendarPropertyChange(java.beans.PropertyChangeEvent evt) {
        if ("date".equals(evt.getPropertyName())) {
            updateAge();
        }
    }

    private void updateAge() {
        if (birthdateCalendar.getDate() != null) {

            LocalDate birthDate = birthdateCalendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate currentDate = LocalDate.now();

            if (birthDate.isAfter(currentDate)) {
                JOptionPane.showMessageDialog(this, "Invalid Birthdate.", "Error", JOptionPane.ERROR_MESSAGE);
                birthdateCalendar.setDate(null);
                ageTextField.setText("");
            } else {
                long age = ChronoUnit.YEARS.between(birthDate, currentDate);
                ageTextField.setText(String.valueOf(age));
            }
        }
    }

    private void initComponents() {

        dashboardMenuPanel = new javax.swing.JPanel();
        dashboardButton = new javax.swing.JButton();
        usersButton = new javax.swing.JButton();
        ordersButton = new javax.swing.JButton();
        pendingOrdersButton = new javax.swing.JButton();
        inventoryButton = new javax.swing.JButton();
        createAccountMenuButton = new javax.swing.JButton();
        headerPanel = new javax.swing.JPanel();
        adminDashboardLabel = new javax.swing.JLabel();
        noLabel = new javax.swing.JLabel();
        adminDashboardLabel1 = new javax.swing.JLabel();
        logoutAdminButton = new javax.swing.JButton();
        containerPanel = new javax.swing.JPanel();
        dashBoardPanel = new javax.swing.JPanel();
        totalUsersPanel = new javax.swing.JPanel();
        totalUsersLabel = new javax.swing.JLabel();
        placeUserCountHere = new javax.swing.JLabel();
        totalUsersIcon = new javax.swing.JLabel();
        totalOrdersPanel = new javax.swing.JPanel();
        totalOrdersLabel = new javax.swing.JLabel();
        placeOrdersCountHere = new javax.swing.JLabel();
        ordersIcon = new javax.swing.JLabel();
        currentOnlineUsersPanel = new javax.swing.JPanel();
        onlineUsersLabel = new javax.swing.JLabel();
        placeOnlineUsersCountHere = new javax.swing.JLabel();
        totalUsersIcon1 = new javax.swing.JLabel();
        pendingOrdersCountPanel = new javax.swing.JPanel();
        totalUsersLabel1 = new javax.swing.JLabel();
        placePendingOrdersCountHere = new javax.swing.JLabel();
        ordersIcon1 = new javax.swing.JLabel();
        broadcastMessage = new javax.swing.JButton();
        usersPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        registeredUsersTable = new javax.swing.JTable();
        userSearchBar = new javax.swing.JTextField();
        searchUserLabel = new javax.swing.JLabel();
        deleteUserButton = new javax.swing.JButton();
        viewUserButton = new javax.swing.JButton();
        editUserButton = new javax.swing.JButton();
        ordersPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        orderSearchBar = new javax.swing.JTextField();
        searchUser1Label = new javax.swing.JLabel();
        deleteUserButton1 = new javax.swing.JButton();
        viewUserButton1 = new javax.swing.JButton();
        editUserButton1 = new javax.swing.JButton();
        pendingOrdersPanel = new javax.swing.JPanel();
        deletedLabel = new javax.swing.JLabel();
        inventoryPanel = new javax.swing.JPanel();
        inventoryButtonsPanel = new javax.swing.JPanel();
        painkillerPanelButton = new javax.swing.JButton();
        sleepingPillsPanelButton = new javax.swing.JButton();
        antibioticPanelButton = new javax.swing.JButton();
        coldAndFluPanelButton = new javax.swing.JButton();
        supplementsPanelButton = new javax.swing.JButton();
        medicineTablePanel = new javax.swing.JPanel();
        painkillerTablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        painkillerTable = new javax.swing.JTable();
        addPainkillerButton = new javax.swing.JButton();
        deletePainkillerButton = new javax.swing.JButton();
        editPainkillerButton = new javax.swing.JButton();
        sleepingPillsTablePanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        sleepingPillsTable = new javax.swing.JTable();
        addSleepingPillsButton = new javax.swing.JButton();
        deleteSleepingPillsButton = new javax.swing.JButton();
        editSleepingPillsButton = new javax.swing.JButton();
        antibioticsTablePanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        antibioticsTable = new javax.swing.JTable();
        addAntibioticsButton = new javax.swing.JButton();
        deleteAntibioticsButton = new javax.swing.JButton();
        editAntibioticsButton = new javax.swing.JButton();
        coldAndFluTablePanel = new javax.swing.JPanel();
        //JScrollPane3 = new javax.swing.JScrollPane();
        coldAndFluTable = new javax.swing.JTable();
        addColdAndFluButton = new javax.swing.JButton();
        deleteColdAndFluButton = new javax.swing.JButton();
        editColdAndFluButton = new javax.swing.JButton();
        supplementsTablePanel = new javax.swing.JPanel();
        //JScrollPane4 = new javax.swing.JScrollPane();
        supplementsTable = new javax.swing.JTable();
        addSupplementsButton = new javax.swing.JButton();
        deleteSupplementsButton = new javax.swing.JButton();
        editSupplementsButton = new javax.swing.JButton();
        createAccountPanel = new javax.swing.JPanel();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        middleNameTextField = new javax.swing.JTextField();
        ageTextField = new javax.swing.JTextField();
        genderComboBox = new javax.swing.JComboBox<>();
        pwdCheckBox = new javax.swing.JCheckBox();
        streetAddressTextField = new javax.swing.JTextField();
        optionalDetailsTextField = new javax.swing.JTextField();
        cityMunicipalityTextField = new javax.swing.JTextField();
        provinceTextField = new javax.swing.JTextField();
        postalCodeTextField = new javax.swing.JTextField();
        emailAddressTextField = new javax.swing.JTextField();
        contactNumberTextField = new javax.swing.JTextField();
        setUsernameTextField = new javax.swing.JTextField();
        setPasswordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        createAccountButton = new javax.swing.JButton();
        createAccountLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        middleNameLabel = new javax.swing.JLabel();
        birthdateLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        pwdLabel = new javax.swing.JLabel();
        streetAddressLabel = new javax.swing.JLabel();
        optionalDetailsLabel = new javax.swing.JLabel();
        cityMunicipalityLabel = new javax.swing.JLabel();
        provinceLabel = new javax.swing.JLabel();
        postcodeLabel = new javax.swing.JLabel();
        emailAddressLabel = new javax.swing.JLabel();
        contactNumberLabel = new javax.swing.JLabel();
        setUsernameLabel = new javax.swing.JLabel();
        setPasswordLabel = new javax.swing.JLabel();
        confirmPasswordLabel = new javax.swing.JLabel();
        userTypeComboBox = new javax.swing.JComboBox<>();
        userTypeLabel = new javax.swing.JLabel();
        pendingOrdersTable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        searchUser2Label = new javax.swing.JLabel();
        pendingOrdersSearchBar = new javax.swing.JTextField();
        viewPendingOrdersButton = new javax.swing.JButton();
        sendPrescription = new JButton();
        birthdateCalendar = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(890, 670));
        setTitle("Quantum Drugstore Admin");

        dashboardMenuPanel.setForeground(new java.awt.Color(255, 255, 255));
        dashboardMenuPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 30));

        dashboardButton.setText("Dashboard");
        dashboardButton.setPreferredSize(new java.awt.Dimension(140, 50));
        dashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardButtonActionPerformed(evt);
            }
        });
        dashboardMenuPanel.add(dashboardButton);

        usersButton.setText("Users");
        usersButton.setPreferredSize(new java.awt.Dimension(140, 50));
        usersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersButtonActionPerformed(evt);
            }
        });
        dashboardMenuPanel.add(usersButton);

        ordersButton.setText("Orders");
        ordersButton.setPreferredSize(new java.awt.Dimension(140, 50));
        ordersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersButtonActionPerformed(evt);
            }
        });
        dashboardMenuPanel.add(ordersButton);

        pendingOrdersButton.setText("Pending \nOrders");
        pendingOrdersButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pendingOrdersButton.setPreferredSize(new java.awt.Dimension(140, 50));
        pendingOrdersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingOrdersButtonActionPerformed(evt);
            }
        });
        dashboardMenuPanel.add(pendingOrdersButton);

        inventoryButton.setText("Inventory");
        inventoryButton.setPreferredSize(new java.awt.Dimension(140, 50));
        inventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryButtonActionPerformed(evt);
            }
        });
        dashboardMenuPanel.add(inventoryButton);

        createAccountMenuButton.setText("Create Account");
        createAccountMenuButton.setPreferredSize(new java.awt.Dimension(140, 50));
        createAccountMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountMenuButtonActionPerformed(evt);
            }
        });
        dashboardMenuPanel.add(createAccountMenuButton);

        adminDashboardLabel.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        adminDashboardLabel.setText("ADMIN");

        noLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo.png"))); // NOI18N
        noLabel.setText("noLabel");

        adminDashboardLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        adminDashboardLabel1.setText("WELCOME,");

        logoutAdminButton.setText("LOGOUT");
        logoutAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutAdminButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(noLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273)
                .addComponent(adminDashboardLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutAdminButton)
                .addContainerGap())
            .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPanelLayout.createSequentialGroup()
                    .addGap(208, 208, 208)
                    .addComponent(adminDashboardLabel1)
                    .addContainerGap(563, Short.MAX_VALUE)))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(noLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(adminDashboardLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(logoutAdminButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(adminDashboardLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        containerPanel.setMaximumSize(new java.awt.Dimension(690, 500));
        containerPanel.setPreferredSize(new java.awt.Dimension(690, 500));
        containerPanel.setLayout(new java.awt.CardLayout());

        totalUsersPanel.setBackground(new java.awt.Color(102, 153, 255));

        totalUsersLabel.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        totalUsersLabel.setText("TOTAL USERS");

        placeUserCountHere.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        placeUserCountHere.setText("0");

        totalUsersIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/usersfinal.png"))); // NOI18N
        totalUsersIcon.setText("jLabel6");
        totalUsersIcon.setMaximumSize(new java.awt.Dimension(50, 50));
        totalUsersIcon.setMinimumSize(new java.awt.Dimension(50, 50));
        totalUsersIcon.setPreferredSize(new java.awt.Dimension(20, 21));

        javax.swing.GroupLayout totalUsersPanelLayout = new javax.swing.GroupLayout(totalUsersPanel);
        totalUsersPanel.setLayout(totalUsersPanelLayout);
        totalUsersPanelLayout.setHorizontalGroup(
            totalUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalUsersPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(totalUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalUsersPanelLayout.createSequentialGroup()
                        .addComponent(totalUsersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(142, 142, 142))
                    .addGroup(totalUsersPanelLayout.createSequentialGroup()
                        .addComponent(totalUsersIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(placeUserCountHere)
                        .addGap(50, 50, 50))))
        );
        totalUsersPanelLayout.setVerticalGroup(
            totalUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalUsersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalUsersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(totalUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalUsersIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placeUserCountHere, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        totalOrdersPanel.setBackground(new java.awt.Color(102, 153, 255));

        totalOrdersLabel.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        totalOrdersLabel.setText("TOTAL ORDERS");

        placeOrdersCountHere.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        placeOrdersCountHere.setText("0");

        ordersIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/orders.png"))); // NOI18N
        ordersIcon.setText("jLabel6");
        ordersIcon.setMaximumSize(new java.awt.Dimension(50, 50));
        ordersIcon.setMinimumSize(new java.awt.Dimension(50, 50));
        ordersIcon.setPreferredSize(new java.awt.Dimension(20, 21));

        javax.swing.GroupLayout totalOrdersPanelLayout = new javax.swing.GroupLayout(totalOrdersPanel);
        totalOrdersPanel.setLayout(totalOrdersPanelLayout);
        totalOrdersPanelLayout.setHorizontalGroup(
            totalOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalOrdersPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(totalOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalOrdersPanelLayout.createSequentialGroup()
                        .addComponent(totalOrdersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                        .addGap(140, 140, 140))
                    .addGroup(totalOrdersPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(ordersIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(placeOrdersCountHere)
                        .addGap(64, 64, 64))))
        );
        totalOrdersPanelLayout.setVerticalGroup(
            totalOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalOrdersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalOrdersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(totalOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ordersIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placeOrdersCountHere, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        currentOnlineUsersPanel.setBackground(new java.awt.Color(102, 153, 255));

        onlineUsersLabel.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        onlineUsersLabel.setText("ONLINE USERS");

        placeOnlineUsersCountHere.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        placeOnlineUsersCountHere.setText("0");

        totalUsersIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/onlineusers.png"))); // NOI18N
        totalUsersIcon1.setText("jLabel6");
        totalUsersIcon1.setMaximumSize(new java.awt.Dimension(50, 50));
        totalUsersIcon1.setMinimumSize(new java.awt.Dimension(50, 50));
        totalUsersIcon1.setPreferredSize(new java.awt.Dimension(20, 21));

        javax.swing.GroupLayout currentOnlineUsersPanelLayout = new javax.swing.GroupLayout(currentOnlineUsersPanel);
        currentOnlineUsersPanel.setLayout(currentOnlineUsersPanelLayout);
        currentOnlineUsersPanelLayout.setHorizontalGroup(
            currentOnlineUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentOnlineUsersPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(currentOnlineUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(onlineUsersLabel)
                    .addGroup(currentOnlineUsersPanelLayout.createSequentialGroup()
                        .addComponent(totalUsersIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(placeOnlineUsersCountHere)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        currentOnlineUsersPanelLayout.setVerticalGroup(
            currentOnlineUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentOnlineUsersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(onlineUsersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(currentOnlineUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placeOnlineUsersCountHere, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalUsersIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pendingOrdersCountPanel.setBackground(new java.awt.Color(102, 153, 255));

        totalUsersLabel1.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        totalUsersLabel1.setText("");

        placePendingOrdersCountHere.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        placePendingOrdersCountHere.setText("0");

        ordersIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pendingorders.png"))); // NOI18N
        ordersIcon1.setText("jLabel6");
        ordersIcon1.setMaximumSize(new java.awt.Dimension(50, 50));
        ordersIcon1.setMinimumSize(new java.awt.Dimension(50, 50));
        ordersIcon1.setPreferredSize(new java.awt.Dimension(20, 21));

        javax.swing.GroupLayout pendingOrdersCountPanelLayout = new javax.swing.GroupLayout(pendingOrdersCountPanel);
        pendingOrdersCountPanel.setLayout(pendingOrdersCountPanelLayout);
        pendingOrdersCountPanelLayout.setHorizontalGroup(
            pendingOrdersCountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pendingOrdersCountPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pendingOrdersCountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalUsersLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pendingOrdersCountPanelLayout.createSequentialGroup()
                        .addComponent(ordersIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(placePendingOrdersCountHere)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pendingOrdersCountPanelLayout.setVerticalGroup(
            pendingOrdersCountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pendingOrdersCountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalUsersLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pendingOrdersCountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ordersIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placePendingOrdersCountHere, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        broadcastMessage.setText("SEND PRESCRIPTION");

        sendPrescription.setText("BROADCAST MESSAGE");

        javax.swing.GroupLayout dashBoardPanelLayout = new javax.swing.GroupLayout(dashBoardPanel);
        dashBoardPanel.setLayout(dashBoardPanelLayout);
        dashBoardPanelLayout.setHorizontalGroup(
                dashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dashBoardPanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(dashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(currentOnlineUsersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(totalUsersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sendPrescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)) // Added sendPrescription here
                                .addGap(18, 18, 18)
                                .addGroup(dashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(dashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(totalOrdersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(pendingOrdersCountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(broadcastMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)) // Adjust the preferred size as needed
                                .addContainerGap(43, Short.MAX_VALUE))
        );
        dashBoardPanelLayout.setVerticalGroup(
                dashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dashBoardPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(dashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(totalOrdersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(totalUsersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(currentOnlineUsersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pendingOrdersCountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(23, 23, 23)
                                .addGroup(dashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(sendPrescription)
                                        .addComponent(broadcastMessage))
                                .addGap(12, 12, 12))
        );



        containerPanel.add(dashBoardPanel, "dashboardPanel");

        usersPanel.setMaximumSize(new java.awt.Dimension(690, 500));

        registeredUsersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "User ID", "Last Name", "First Name", "User Type", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        registeredUsersTable.setColumnSelectionAllowed(true);
        registeredUsersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(registeredUsersTable);
        registeredUsersTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (registeredUsersTable.getColumnModel().getColumnCount() > 0) {
            registeredUsersTable.getColumnModel().getColumn(0).setResizable(false);
            registeredUsersTable.getColumnModel().getColumn(1).setResizable(false);
            registeredUsersTable.getColumnModel().getColumn(2).setResizable(false);
            registeredUsersTable.getColumnModel().getColumn(3).setResizable(false);
            registeredUsersTable.getColumnModel().getColumn(4).setResizable(false);
        }

        userSearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userSearchBarActionPerformed(evt);
            }
        });

        searchUserLabel.setText("Search User");

        deleteUserButton.setText("Delete");
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });

        viewUserButton.setText("View User");
        viewUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserButtonActionPerformed(evt);
            }
        });

        editUserButton.setText("Edit User");
        editUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout usersPanelLayout = new javax.swing.GroupLayout(usersPanel);
        usersPanel.setLayout(usersPanelLayout);
        usersPanelLayout.setHorizontalGroup(
            usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(usersPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteUserButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewUserButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editUserButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        usersPanelLayout.setVerticalGroup(
            usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usersPanelLayout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addGroup(usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchUserLabel))
                .addGroup(usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(usersPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(usersPanelLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(deleteUserButton)
                        .addGap(27, 27, 27)
                        .addComponent(viewUserButton)
                        .addGap(27, 27, 27)
                        .addComponent(editUserButton))))
        );

        containerPanel.add(usersPanel, "userPanel");

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID","User ID", "Last Name", "First Name", "Status", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(orderTable);
        orderTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (orderTable.getColumnModel().getColumnCount() > 0) {
            orderTable.getColumnModel().getColumn(0).setResizable(false);
            orderTable.getColumnModel().getColumn(1).setResizable(false);
            orderTable.getColumnModel().getColumn(2).setResizable(false);
            orderTable.getColumnModel().getColumn(3).setResizable(false);
            orderTable.getColumnModel().getColumn(4).setResizable(false);
            orderTable.getColumnModel().getColumn(5).setResizable(false);
        }

        orderSearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderSearchBarActionPerformed(evt);
            }
        });

        searchUser1Label.setText("Search Order ID");

        viewUserButton1.setText("View Orders");
        viewUserButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ordersPanelLayout = new javax.swing.GroupLayout(ordersPanel);
        ordersPanel.setLayout(ordersPanelLayout);
        ordersPanelLayout.setHorizontalGroup(
            ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchUser1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orderSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ordersPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewUserButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        ordersPanelLayout.setVerticalGroup(
            ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ordersPanelLayout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchUser1Label))
                .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ordersPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ordersPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(viewUserButton1))))
        );

        containerPanel.add(ordersPanel, "ordersPanel");

        pendingOrdersTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Order ID","User ID", "Last Name", "First Name", "Status", "Total"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pendingOrdersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(pendingOrdersTable);
        pendingOrdersTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (pendingOrdersTable.getColumnModel().getColumnCount() > 0) {
            pendingOrdersTable.getColumnModel().getColumn(0).setResizable(false);
            pendingOrdersTable.getColumnModel().getColumn(1).setResizable(false);
            pendingOrdersTable.getColumnModel().getColumn(2).setResizable(false);
            pendingOrdersTable.getColumnModel().getColumn(3).setResizable(false);
            pendingOrdersTable.getColumnModel().getColumn(4).setResizable(false);
            pendingOrdersTable.getColumnModel().getColumn(5).setResizable(false);
        }

        orderSearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderSearchBarActionPerformed(evt);
            }
        });

        searchUser2Label.setText("Search Order ID");

        viewPendingOrdersButton.setText("View Orders");

        javax.swing.GroupLayout pendingOrdersPanelLayout = new javax.swing.GroupLayout(pendingOrdersPanel);
        pendingOrdersPanel.setLayout(pendingOrdersPanelLayout);
        pendingOrdersPanelLayout.setHorizontalGroup(
                pendingOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pendingOrdersPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(searchUser2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pendingOrdersSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pendingOrdersPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(pendingOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(viewPendingOrdersButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
        );
        pendingOrdersPanelLayout.setVerticalGroup(
                pendingOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendingOrdersPanelLayout.createSequentialGroup()
                                .addGap(0, 35, Short.MAX_VALUE)
                                .addGroup(pendingOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pendingOrdersSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchUser2Label))
                                .addGroup(pendingOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pendingOrdersPanelLayout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pendingOrdersPanelLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(viewPendingOrdersButton))))
        );
        containerPanel.add(pendingOrdersPanel, "pendingOrdersPanel");

        inventoryButtonsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 20));

        painkillerPanelButton.setText("Painkillers");
        painkillerPanelButton.setMaximumSize(new java.awt.Dimension(100, 23));
        painkillerPanelButton.setMinimumSize(new java.awt.Dimension(100, 23));
        painkillerPanelButton.setPreferredSize(new java.awt.Dimension(100, 23));
        painkillerPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                painkillerPanelButtonActionPerformed(evt);
            }
        });
        inventoryButtonsPanel.add(painkillerPanelButton);

        sleepingPillsPanelButton.setText("Sleeping Pills");
        sleepingPillsPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sleepingPillsPanelButtonActionPerformed(evt);
            }
        });
        inventoryButtonsPanel.add(sleepingPillsPanelButton);

        antibioticPanelButton.setText("Antibiotics");
        antibioticPanelButton.setPreferredSize(new java.awt.Dimension(100, 23));
        antibioticPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                antibioticPanelButtonActionPerformed(evt);
            }
        });
        inventoryButtonsPanel.add(antibioticPanelButton);

        coldAndFluPanelButton.setText("Cold and Flu");
        coldAndFluPanelButton.setMaximumSize(new java.awt.Dimension(120, 23));
        coldAndFluPanelButton.setPreferredSize(new java.awt.Dimension(110, 23));
        coldAndFluPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coldAndFluPanelButtonActionPerformed(evt);
            }
        });
        inventoryButtonsPanel.add(coldAndFluPanelButton);

        supplementsPanelButton.setText("Supplements");
        supplementsPanelButton.setMaximumSize(new java.awt.Dimension(100, 23));
        supplementsPanelButton.setMinimumSize(new java.awt.Dimension(100, 23));
        supplementsPanelButton.setPreferredSize(new java.awt.Dimension(100, 23));
        supplementsPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplementsPanelButtonActionPerformed(evt);
            }
        });
        inventoryButtonsPanel.add(supplementsPanelButton);

        medicineTablePanel.setLayout(new java.awt.CardLayout());

        painkillerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Generic Name", "Brand Name", "Form", "Quantity", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        painkillerTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        painkillerTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        painkillerTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(painkillerTable);
        painkillerTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (painkillerTable.getColumnModel().getColumnCount() > 0) {
            painkillerTable.getColumnModel().getColumn(0).setResizable(false);
            painkillerTable.getColumnModel().getColumn(1).setResizable(false);
            painkillerTable.getColumnModel().getColumn(2).setResizable(false);
            painkillerTable.getColumnModel().getColumn(3).setResizable(false);
            painkillerTable.getColumnModel().getColumn(4).setResizable(false);
        }

        addPainkillerButton.setText("Add");
        addPainkillerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPainkillerButtonActionPerformed(evt);
            }
        });

        deletePainkillerButton.setText("Delete");
        deletePainkillerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePainkillerButtonActionPerformed(evt);
            }
        });

        editPainkillerButton.setText("Edit");
        editPainkillerButton.setToolTipText("");

        javax.swing.GroupLayout painkillerTablePanelLayout = new javax.swing.GroupLayout(painkillerTablePanel);
        painkillerTablePanel.setLayout(painkillerTablePanelLayout);
        painkillerTablePanelLayout.setHorizontalGroup(
            painkillerTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painkillerTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painkillerTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deletePainkillerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editPainkillerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addPainkillerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        painkillerTablePanelLayout.setVerticalGroup(
            painkillerTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painkillerTablePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(painkillerTablePanelLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(addPainkillerButton)
                .addGap(52, 52, 52)
                .addComponent(deletePainkillerButton)
                .addGap(53, 53, 53)
                .addComponent(editPainkillerButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        medicineTablePanel.add(painkillerTablePanel, "painkillerTablePanel");

        sleepingPillsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Generic Name", "Brand Name", "Form", "Quantity", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sleepingPillsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        sleepingPillsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        sleepingPillsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(sleepingPillsTable);
        sleepingPillsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (sleepingPillsTable.getColumnModel().getColumnCount() > 0) {
            sleepingPillsTable.getColumnModel().getColumn(0).setResizable(false);
            sleepingPillsTable.getColumnModel().getColumn(1).setResizable(false);
            sleepingPillsTable.getColumnModel().getColumn(2).setResizable(false);
            sleepingPillsTable.getColumnModel().getColumn(3).setResizable(false);
            sleepingPillsTable.getColumnModel().getColumn(4).setResizable(false);
        }

        addSleepingPillsButton.setText("Add");

        deleteSleepingPillsButton.setText("Delete");
        deleteSleepingPillsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSleepingPillsButtonActionPerformed(evt);
            }
        });

        editSleepingPillsButton.setText("Edit");
        editSleepingPillsButton.setToolTipText("");

        javax.swing.GroupLayout sleepingPillsTablePanelLayout = new javax.swing.GroupLayout(sleepingPillsTablePanel);
        sleepingPillsTablePanel.setLayout(sleepingPillsTablePanelLayout);
        sleepingPillsTablePanelLayout.setHorizontalGroup(
            sleepingPillsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sleepingPillsTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(sleepingPillsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addSleepingPillsButton)
                    .addComponent(deleteSleepingPillsButton)
                    .addComponent(editSleepingPillsButton))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        sleepingPillsTablePanelLayout.setVerticalGroup(
            sleepingPillsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sleepingPillsTablePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sleepingPillsTablePanelLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(addSleepingPillsButton)
                .addGap(52, 52, 52)
                .addComponent(deleteSleepingPillsButton)
                .addGap(53, 53, 53)
                .addComponent(editSleepingPillsButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        medicineTablePanel.add(sleepingPillsTablePanel, "sleepingPillsTablePanel");

        antibioticsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Generic Name", "Brand Name", "Form", "Quantity", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        antibioticsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        antibioticsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        antibioticsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(antibioticsTable);
        antibioticsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (antibioticsTable.getColumnModel().getColumnCount() > 0) {
            antibioticsTable.getColumnModel().getColumn(0).setResizable(false);
            antibioticsTable.getColumnModel().getColumn(1).setResizable(false);
            antibioticsTable.getColumnModel().getColumn(2).setResizable(false);
            antibioticsTable.getColumnModel().getColumn(3).setResizable(false);
            antibioticsTable.getColumnModel().getColumn(4).setResizable(false);
        }

        addAntibioticsButton.setText("Add");

        deleteAntibioticsButton.setText("Delete");
        deleteAntibioticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAntibioticsButtonActionPerformed(evt);
            }
        });

        editAntibioticsButton.setText("Edit");
        editAntibioticsButton.setToolTipText("");

        javax.swing.GroupLayout antibioticsTablePanelLayout = new javax.swing.GroupLayout(antibioticsTablePanel);
        antibioticsTablePanel.setLayout(antibioticsTablePanelLayout);
        antibioticsTablePanelLayout.setHorizontalGroup(
            antibioticsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(antibioticsTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(antibioticsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addAntibioticsButton)
                    .addComponent(deleteAntibioticsButton)
                    .addComponent(editAntibioticsButton))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        antibioticsTablePanelLayout.setVerticalGroup(
            antibioticsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(antibioticsTablePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(antibioticsTablePanelLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(addAntibioticsButton)
                .addGap(52, 52, 52)
                .addComponent(deleteAntibioticsButton)
                .addGap(53, 53, 53)
                .addComponent(editAntibioticsButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        medicineTablePanel.add(antibioticsTablePanel, "antibioticsTablePanel");

        coldAndFluTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Generic Name", "Brand Name", "Form", "Quantity", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        coldAndFluTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        coldAndFluTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        coldAndFluTable.getTableHeader().setReorderingAllowed(false);
        //JScrollPane3.setViewportView(coldAndFluTable);
        coldAndFluTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (coldAndFluTable.getColumnModel().getColumnCount() > 0) {
            coldAndFluTable.getColumnModel().getColumn(0).setResizable(false);
            coldAndFluTable.getColumnModel().getColumn(1).setResizable(false);
            coldAndFluTable.getColumnModel().getColumn(2).setResizable(false);
            coldAndFluTable.getColumnModel().getColumn(3).setResizable(false);
            coldAndFluTable.getColumnModel().getColumn(4).setResizable(false);
        }

        addColdAndFluButton.setText("Add");

        deleteColdAndFluButton.setText("Delete");
        deleteColdAndFluButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteColdAndFluButtonActionPerformed(evt);
            }
        });

        editColdAndFluButton.setText("Edit");
        editColdAndFluButton.setToolTipText("");

        javax.swing.GroupLayout coldAndFluTablePanelLayout = new javax.swing.GroupLayout(coldAndFluTablePanel);
        coldAndFluTablePanel.setLayout(coldAndFluTablePanelLayout);
        coldAndFluTablePanelLayout.setHorizontalGroup(
            coldAndFluTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coldAndFluTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                //.addComponent(JScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(coldAndFluTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addColdAndFluButton)
                    .addComponent(deleteColdAndFluButton)
                    .addComponent(editColdAndFluButton))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        coldAndFluTablePanelLayout.setVerticalGroup(
            coldAndFluTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coldAndFluTablePanelLayout.createSequentialGroup()
                //.addComponent(JScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(coldAndFluTablePanelLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(addColdAndFluButton)
                .addGap(52, 52, 52)
                .addComponent(deleteColdAndFluButton)
                .addGap(53, 53, 53)
                .addComponent(editColdAndFluButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        medicineTablePanel.add(coldAndFluTablePanel, "coldAndFluTablePanel");

        supplementsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Generic Name", "Brand Name", "Form", "Quantity", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        supplementsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        supplementsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        supplementsTable.getTableHeader().setReorderingAllowed(false);
        //JScrollPane4.setViewportView(supplementsTable);
        supplementsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (supplementsTable.getColumnModel().getColumnCount() > 0) {
            supplementsTable.getColumnModel().getColumn(0).setResizable(false);
            supplementsTable.getColumnModel().getColumn(1).setResizable(false);
            supplementsTable.getColumnModel().getColumn(2).setResizable(false);
            supplementsTable.getColumnModel().getColumn(3).setResizable(false);
            supplementsTable.getColumnModel().getColumn(4).setResizable(false);
        }

        addSupplementsButton.setText("Add");

        deleteSupplementsButton.setText("Delete");
        deleteSupplementsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSupplementsButtonActionPerformed(evt);
            }
        });

        editSupplementsButton.setText("Edit");
        editSupplementsButton.setToolTipText("");

        javax.swing.GroupLayout supplementsTablePanelLayout = new javax.swing.GroupLayout(supplementsTablePanel);
        supplementsTablePanel.setLayout(supplementsTablePanelLayout);
        supplementsTablePanelLayout.setHorizontalGroup(
            supplementsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(supplementsTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                //.addComponent(JScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(supplementsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addSupplementsButton)
                    .addComponent(deleteSupplementsButton)
                    .addComponent(editSupplementsButton))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        supplementsTablePanelLayout.setVerticalGroup(
            supplementsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(supplementsTablePanelLayout.createSequentialGroup()
                //.addComponent(JScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(supplementsTablePanelLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(addSupplementsButton)
                .addGap(52, 52, 52)
                .addComponent(deleteSupplementsButton)
                .addGap(53, 53, 53)
                .addComponent(editSupplementsButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        medicineTablePanel.add(supplementsTablePanel, "supplementsTablePanel");

        javax.swing.GroupLayout inventoryPanelLayout = new javax.swing.GroupLayout(inventoryPanel);
        inventoryPanel.setLayout(inventoryPanelLayout);
        inventoryPanelLayout.setHorizontalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inventoryButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(medicineTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        inventoryPanelLayout.setVerticalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addComponent(inventoryButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medicineTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        containerPanel.add(inventoryPanel, "inventoryPanel");

        firstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTextFieldActionPerformed(evt);
            }
        });

        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });

        middleNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middleNameTextFieldActionPerformed(evt);
            }
        });

        ageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageTextFieldActionPerformed(evt);
            }
        });

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        genderComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderComboBoxActionPerformed(evt);
            }
        });

        pwdCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdCheckBoxActionPerformed(evt);
            }
        });

        createAccountButton.setText("Create Account");
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountButtonActionPerformed(evt);
            }
        });

        createAccountLabel.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        createAccountLabel.setText("CREATE ACCOUNT");

        firstNameLabel.setText("First Name");

        lastNameLabel.setText("Last Name");

        middleNameLabel.setText("Middle Name");

        birthdateLabel.setText("Birthdate");

        ageLabel.setText("Age");

        genderLabel.setText("Gender");

        pwdLabel.setText("Person with Disability");

        streetAddressLabel.setText("Street Address");

        optionalDetailsLabel.setText("Apt, suite, etc (optional)");

        cityMunicipalityLabel.setText("City / Municipality");

        provinceLabel.setText("Province");

        postcodeLabel.setText("ZIP / Postal Code");

        emailAddressLabel.setText("Email Address");

        contactNumberLabel.setText("Contact Number");

        setUsernameLabel.setText("Set Username");

        setPasswordLabel.setText("Set Password (6-12 Characters)");

        confirmPasswordLabel.setText("Confirm Password");

        userTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Admin" }));

        userTypeLabel.setText("USER TYPE");

        javax.swing.GroupLayout createAccountPanelLayout = new javax.swing.GroupLayout(createAccountPanel);
        createAccountPanel.setLayout(createAccountPanelLayout);
        createAccountPanelLayout.setHorizontalGroup(
            createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createAccountPanelLayout.createSequentialGroup()
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(firstNameTextField)
                    .addComponent(lastNameTextField)
                    .addComponent(lastNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(firstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(middleNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(middleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwdLabel)
                    .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(pwdCheckBox)
                        .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createAccountPanelLayout.createSequentialGroup()
                                .addComponent(genderLabel)
                                .addGap(18, 18, 18)
                                .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(birthdateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(createAccountPanelLayout.createSequentialGroup()
                        .addComponent(birthdateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ageLabel)
                            .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(35, 35, 35)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createAccountPanelLayout.createSequentialGroup()
                        .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(provinceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(provinceTextField)
                            .addComponent(streetAddressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addComponent(streetAddressTextField)
                            .addComponent(optionalDetailsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cityMunicipalityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cityMunicipalityTextField)
                            .addComponent(optionalDetailsTextField)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createAccountPanelLayout.createSequentialGroup()
                                .addComponent(postcodeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(77, 77, 77)))
                        .addGap(36, 36, 36))
                    .addGroup(createAccountPanelLayout.createSequentialGroup()
                        .addComponent(postalCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(confirmPasswordField)
                    .addComponent(emailAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailAddressTextField)
                    .addComponent(contactNumberTextField)
                    .addComponent(setUsernameTextField)
                    .addComponent(contactNumberLabel)
                    .addComponent(setUsernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confirmPasswordLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(setPasswordField)
                    .addComponent(setPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addGap(25, 25, 25))
            .addGroup(createAccountPanelLayout.createSequentialGroup()
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createAccountPanelLayout.createSequentialGroup()
                        .addComponent(createAccountLabel)
                        .addGap(150, 150, 150)
                        .addComponent(userTypeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(userTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(createAccountPanelLayout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(createAccountButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        createAccountPanelLayout.setVerticalGroup(
            createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createAccountPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createAccountLabel)
                    .addComponent(userTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(streetAddressLabel)
                    .addComponent(emailAddressLabel))
                .addGap(18, 18, 18)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(optionalDetailsLabel)
                    .addComponent(contactNumberLabel))
                .addGap(18, 18, 18)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optionalDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(middleNameLabel)
                    .addComponent(cityMunicipalityLabel)
                    .addComponent(setUsernameLabel))
                .addGap(18, 18, 18)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(middleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityMunicipalityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthdateLabel)
                    .addComponent(provinceLabel)
                    .addComponent(setPasswordLabel)
                    .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(provinceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(setPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(birthdateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(postcodeLabel)
                        .addComponent(confirmPasswordLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(genderLabel)
                        .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pwdLabel)
                            .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(pwdCheckBox))
                    .addComponent(postalCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(createAccountButton)
                .addContainerGap())
        );

        containerPanel.add(createAccountPanel, "createAccountPanel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dashboardMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addComponent(dashboardMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void dashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardButtonActionPerformed
        containerPanel.removeAll();
        containerPanel.add(dashBoardPanel);  
        containerPanel.repaint();
        containerPanel.revalidate();      
        
        
    }//GEN-LAST:event_dashboardButtonActionPerformed

    private void usersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersButtonActionPerformed
        containerPanel.removeAll();
        containerPanel.add(usersPanel);  
        containerPanel.repaint();
        containerPanel.revalidate();

    }//GEN-LAST:event_usersButtonActionPerformed

    private void ordersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersButtonActionPerformed
        containerPanel.removeAll();
        containerPanel.add(ordersPanel);  
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_ordersButtonActionPerformed

    private void pendingOrdersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingOrdersButtonActionPerformed
        containerPanel.removeAll();
        containerPanel.add(pendingOrdersPanel);  
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_pendingOrdersButtonActionPerformed

    private void createAccountMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountMenuButtonActionPerformed
        containerPanel.removeAll();
        containerPanel.add(createAccountPanel);  
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_createAccountMenuButtonActionPerformed

    private void userSearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userSearchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userSearchBarActionPerformed

    private void inventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryButtonActionPerformed
        containerPanel.removeAll();
        containerPanel.add(inventoryPanel);
        containerPanel.repaint();
        containerPanel.revalidate();
    }//GEN-LAST:event_inventoryButtonActionPerformed

    private void createAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountButtonActionPerformed

    }//GEN-LAST:event_createAccountButtonActionPerformed

        private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTextFieldActionPerformed

    private void middleNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middleNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_middleNameTextFieldActionPerformed

    private void pwdCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdCheckBoxActionPerformed

    private void genderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderComboBoxActionPerformed

    private void firstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTextFieldActionPerformed

    private void ageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageTextFieldActionPerformed

    }//GEN-LAST:event_ageTextFieldActionPerformed

    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteUserButtonActionPerformed

    private void viewUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserButtonActionPerformed

    private void editUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editUserButtonActionPerformed

    private void deletePainkillerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePainkillerButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletePainkillerButtonActionPerformed

    private void deleteSupplementsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSupplementsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteSupplementsButtonActionPerformed

    private void deleteColdAndFluButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteColdAndFluButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteColdAndFluButtonActionPerformed

    private void deleteAntibioticsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAntibioticsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteAntibioticsButtonActionPerformed

    private void deleteSleepingPillsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSleepingPillsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteSleepingPillsButtonActionPerformed

    private void painkillerPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_painkillerPanelButtonActionPerformed
        medicineTablePanel.removeAll();
        medicineTablePanel.add(painkillerTablePanel);
        medicineTablePanel.repaint();
        medicineTablePanel.revalidate();
    }//GEN-LAST:event_painkillerPanelButtonActionPerformed

    private void addPainkillerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPainkillerButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addPainkillerButtonActionPerformed

    private void orderSearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderSearchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderSearchBarActionPerformed

    private void deleteUserButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteUserButton1ActionPerformed

    private void viewUserButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserButton1ActionPerformed

    private void editUserButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editUserButton1ActionPerformed

    private void logoutAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutAdminButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutAdminButtonActionPerformed

    private void sleepingPillsPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sleepingPillsPanelButtonActionPerformed
        medicineTablePanel.removeAll();
        medicineTablePanel.add(sleepingPillsTablePanel);
        medicineTablePanel.repaint();
        medicineTablePanel.revalidate();
    }//GEN-LAST:event_sleepingPillsPanelButtonActionPerformed

    private void antibioticPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_antibioticPanelButtonActionPerformed
        medicineTablePanel.removeAll();
        medicineTablePanel.add(antibioticsTablePanel);
        medicineTablePanel.repaint();
        medicineTablePanel.revalidate();
    }//GEN-LAST:event_antibioticPanelButtonActionPerformed

    private void coldAndFluPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coldAndFluPanelButtonActionPerformed
        medicineTablePanel.removeAll();
        medicineTablePanel.add(coldAndFluTablePanel);
        medicineTablePanel.repaint();
        medicineTablePanel.revalidate();
    }//GEN-LAST:event_coldAndFluPanelButtonActionPerformed

    private void supplementsPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplementsPanelButtonActionPerformed
        medicineTablePanel.removeAll();
        medicineTablePanel.add(supplementsTablePanel);
        medicineTablePanel.repaint();
        medicineTablePanel.revalidate();
    }//GEN-LAST:event_supplementsPanelButtonActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminDashBoardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashBoardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashBoardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashBoardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashBoardGUI().setVisible(true);
            }
        });
    }

    private javax.swing.JButton sendPrescription;
    private javax.swing.JButton addAntibioticsButton;
    private javax.swing.JButton addColdAndFluButton;
    private javax.swing.JButton addPainkillerButton;
    private javax.swing.JButton addSleepingPillsButton;
    private javax.swing.JButton addSupplementsButton;
    private javax.swing.JLabel adminDashboardLabel;
    private javax.swing.JLabel adminDashboardLabel1;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JButton antibioticPanelButton;
    private javax.swing.JTable antibioticsTable;
    private javax.swing.JPanel antibioticsTablePanel;
    private com.toedter.calendar.JDateChooser birthdateCalendar;
    private javax.swing.JLabel birthdateLabel;
    private javax.swing.JButton broadcastMessage;
    private javax.swing.JLabel cityMunicipalityLabel;
    private javax.swing.JTextField cityMunicipalityTextField;
    private javax.swing.JButton coldAndFluPanelButton;
    private javax.swing.JTable coldAndFluTable;
    private javax.swing.JPanel coldAndFluTablePanel;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JLabel contactNumberLabel;
    private javax.swing.JTextField contactNumberTextField;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JButton createAccountButton;
    private javax.swing.JLabel createAccountLabel;
    private javax.swing.JButton createAccountMenuButton;
    private javax.swing.JPanel createAccountPanel;
    private javax.swing.JPanel currentOnlineUsersPanel;
    private javax.swing.JPanel dashBoardPanel;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JPanel dashboardMenuPanel;
    private javax.swing.JButton deleteAntibioticsButton;
    private javax.swing.JButton deleteColdAndFluButton;
    private javax.swing.JButton deletePainkillerButton;
    private javax.swing.JButton deleteSleepingPillsButton;
    private javax.swing.JButton deleteSupplementsButton;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JButton deleteUserButton1;
    private javax.swing.JButton editAntibioticsButton;
    private javax.swing.JButton editColdAndFluButton;
    private javax.swing.JButton editPainkillerButton;
    private javax.swing.JButton editSleepingPillsButton;
    private javax.swing.JButton editSupplementsButton;
    private javax.swing.JButton editUserButton;
    private javax.swing.JButton editUserButton1;
    private javax.swing.JLabel emailAddressLabel;
    private javax.swing.JTextField emailAddressTextField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JPanel inventoryButtonsPanel;
    private javax.swing.JPanel inventoryPanel;
    private javax.swing.JLabel noLabel;
    private javax.swing.JLabel searchUserLabel;
    private javax.swing.JLabel deletedLabel;
    private javax.swing.JLabel searchUser1Label;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton logoutAdminButton;
    private javax.swing.JPanel medicineTablePanel;
    private javax.swing.JLabel middleNameLabel;
    private javax.swing.JTextField middleNameTextField;
    private javax.swing.JLabel onlineUsersLabel;
    private javax.swing.JLabel optionalDetailsLabel;
    private javax.swing.JTextField optionalDetailsTextField;
    private javax.swing.JTable orderTable;
    private javax.swing.JButton ordersButton;
    private javax.swing.JLabel ordersIcon;
    private javax.swing.JLabel ordersIcon1;
    private javax.swing.JPanel ordersPanel;
    private javax.swing.JButton painkillerPanelButton;
    private javax.swing.JTable painkillerTable;
    private javax.swing.JPanel painkillerTablePanel;
    private javax.swing.JButton pendingOrdersButton;
    private javax.swing.JPanel pendingOrdersCountPanel;
    private javax.swing.JPanel pendingOrdersPanel;
    private javax.swing.JLabel placeOnlineUsersCountHere;
    private javax.swing.JLabel placeOrdersCountHere;
    private javax.swing.JLabel placePendingOrdersCountHere;
    private javax.swing.JLabel placeUserCountHere;
    private javax.swing.JTextField postalCodeTextField;
    private javax.swing.JLabel postcodeLabel;
    private javax.swing.JLabel provinceLabel;
    private javax.swing.JTextField provinceTextField;
    private javax.swing.JCheckBox pwdCheckBox;
    private javax.swing.JLabel pwdLabel;
    private javax.swing.JTable registeredUsersTable;
    private javax.swing.JPasswordField setPasswordField;
    private javax.swing.JLabel setPasswordLabel;
    private javax.swing.JLabel setUsernameLabel;
    private javax.swing.JTextField setUsernameTextField;
    private javax.swing.JButton sleepingPillsPanelButton;
    private javax.swing.JTable sleepingPillsTable;
    private javax.swing.JPanel sleepingPillsTablePanel;
    private javax.swing.JLabel streetAddressLabel;
    private javax.swing.JTextField streetAddressTextField;
    private javax.swing.JButton supplementsPanelButton;
    private javax.swing.JTable supplementsTable;
    private javax.swing.JPanel supplementsTablePanel;
    private javax.swing.JLabel totalOrdersLabel;
    private javax.swing.JPanel totalOrdersPanel;
    private javax.swing.JLabel totalUsersIcon;
    private javax.swing.JLabel totalUsersIcon1;
    private javax.swing.JLabel totalUsersLabel;
    private javax.swing.JLabel totalUsersLabel1;
    private javax.swing.JPanel totalUsersPanel;
    private javax.swing.JTextField userSearchBar;
    private javax.swing.JTextField orderSearchBar;
    private javax.swing.JComboBox<String> userTypeComboBox;
    private javax.swing.JLabel userTypeLabel;
    private javax.swing.JButton usersButton;
    private javax.swing.JPanel usersPanel;
    private javax.swing.JButton viewUserButton;
    private javax.swing.JButton viewUserButton1;
    private javax.swing.JTable pendingOrdersTable;
    private javax.swing.JLabel searchUser2Label;
    private javax.swing.JTextField pendingOrdersSearchBar;
    private javax.swing.JButton viewPendingOrdersButton;
    //</editor-fold>
}
