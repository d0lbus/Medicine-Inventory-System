package integ;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Freskkie
 */
public class ViewOrderFrame extends javax.swing.JFrame {

    /**
     * Creates new form ViewOrderFrame
     */
    public ViewOrderFrame() {
        initComponents();
        Image logo = Toolkit.getDefaultToolkit().getImage("Icons/logo.png");
        setIconImage(logo);
        setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewPanel = new javax.swing.JPanel();
        viewTextPane = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quantum Drugstore");
        setResizable(false);

        viewPanel.setBackground(new java.awt.Color(255, 255, 255));

        viewTextPane.setViewportView(jTextPane1);

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewTextPane, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewTextPane, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                new ViewOrderFrame().setVisible(true);
            }
        });
    }

    public JPanel getViewPanel() {
        return viewPanel;
    }

    public JScrollPane getViewTextPane() {
        return viewTextPane;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JPanel viewPanel;
    private javax.swing.JScrollPane viewTextPane;
    // End of variables declaration//GEN-END:variables
}
