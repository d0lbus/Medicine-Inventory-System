package midproject.ViewClasses;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Freskkie
 *         Abitan, Julianne
 */
public class LoginFrame extends javax.swing.JFrame {

    public LoginFrame() {
        initComponents();
    }

    public JTextField getIpAddressTextField() {
        return ipAddressTextField;
    }

    // <editor-fold defaultstate="collapsed" desc="More Codes">
    private void initComponents() {
        ipAddressTextField = new JTextField();
        blueColoredPanel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        quantumLabel = new javax.swing.JLabel();
        logInLabel = new javax.swing.JLabel();
        usernameTextfield = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        logInButton = new javax.swing.JToggleButton();
        usernameLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        JLabel ipAddressLabel = new JLabel("IP Address");
        ipAddressLabel.setHorizontalAlignment(JLabel.CENTER);
        ipAddressLabel.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        ipAddressLabel.setForeground(new java.awt.Color(60, 63, 65));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quantum Drugstore");
        setBackground(new java.awt.Color(44, 125, 160));

        blueColoredPanel.setBackground(new java.awt.Color(44, 125, 160));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        quantumLabel.setFont(new java.awt.Font("Sitka Heading", 1, 48)); // NOI18N
        quantumLabel.setForeground(new java.awt.Color(60, 63, 65));
        quantumLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantumLabel.setText("Quantum Drugstore");

        logInLabel.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        logInLabel.setForeground(new java.awt.Color(60, 63, 65));
        logInLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logInLabel.setText("Log in");

        passwordLabel.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(60, 63, 65));
        passwordLabel.setText("Password");

        logInButton.setText("Log in");

        usernameLabel.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(60, 63, 65));
        usernameLabel.setText("Username");

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(logInLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(usernameTextfield, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                                        .addComponent(ipAddressTextField, 150, 150, 250)
                                        .addComponent(ipAddressLabel)
                                        .addComponent(ipAddressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(317, 317, 317))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(logInButton)
                                .addGap(520, 520, 520))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(243, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(quantumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(292, 292, 292))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(quantumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ipAddressLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED) // Control space between label and field
                            .addComponent(ipAddressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    )
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)))
                .addComponent(logInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(logInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout blueColoredPanelLayout = new javax.swing.GroupLayout(blueColoredPanel);
        blueColoredPanel.setLayout(blueColoredPanelLayout);
        blueColoredPanelLayout.setHorizontalGroup(
            blueColoredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, blueColoredPanelLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        blueColoredPanelLayout.setVerticalGroup(
            blueColoredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blueColoredPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(blueColoredPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(blueColoredPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Add getter methods for the username textfield, password field, and login button
    public JTextField getUsernameTextfield() {
        return usernameTextfield;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JToggleButton getLogInButton() {
        return logInButton;
    }

    private javax.swing.JTextField ipAddressTextField;

    private javax.swing.JPanel blueColoredPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton logInButton;
    private javax.swing.JLabel logInLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel quantumLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextfield;
}
