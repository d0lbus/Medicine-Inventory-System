package midproject.Admin.View;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Cian Talosig
 */
public class AddMedicineFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddMedicineFrame
     */
    public AddMedicineFrame() {
        initComponents();
        Image logo = Toolkit.getDefaultToolkit().getImage("Icons/logo.png");
        setIconImage(logo);
        setLocationRelativeTo(null);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMedicineButton = new javax.swing.JButton();
        formLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        genericNameTextField = new javax.swing.JTextField();
        categoryTextField = new javax.swing.JTextField();
        brandNameTextField = new javax.swing.JTextField();
        formTextField = new javax.swing.JTextField();
        addMedicineLabel = new javax.swing.JLabel();
        genericNameLabel = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        brandNameLabel = new javax.swing.JLabel();
        quantityTextField = new javax.swing.JTextField();
        ammountTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Add Medicine");

        addMedicineButton.setText("Add Medicine");

        formLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        formLabel.setText("Form:");

        quantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantityLabel.setText("Quantity:");

        amountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amountLabel.setText("Price:");

        addMedicineLabel.setText("ADD MEDICINE");

        genericNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        genericNameLabel.setText("Generic Name:");

        categoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoryLabel.setText("Category:");

        brandNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        brandNameLabel.setText("Brand Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(genericNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(amountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quantityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(brandNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(formLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(addMedicineLabel)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(genericNameTextField)
                        .addComponent(brandNameTextField)
                        .addComponent(formTextField)
                        .addComponent(quantityTextField)
                        .addComponent(ammountTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                        .addComponent(addMedicineButton))
                    .addComponent(categoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(addMedicineLabel)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(categoryLabel)
                    .addComponent(categoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(brandNameLabel)
                            .addComponent(brandNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(formLabel)
                            .addComponent(formTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantityLabel)
                            .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amountLabel)
                            .addComponent(ammountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(addMedicineButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(genericNameLabel)
                        .addComponent(genericNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
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
                new AddMedicineFrame().setVisible(true);
            }
        });
    }


    private javax.swing.JButton addMedicineButton;

    public JButton getAddMedicineButton() {
        return addMedicineButton;
    }


    public JTextField getAmmountTextField() {
        return ammountTextField;
    }

    public JTextField getBrandNameTextField() {
        return brandNameTextField;
    }

    public JTextField getCategoryTextField() {
        return categoryTextField;
    }

    public JTextField getFormTextField() {
        return formTextField;
    }

    public JTextField getGenericNameTextField() {
        return genericNameTextField;
    }

    public JTextField getQuantityTextField() {
        return quantityTextField;
    }

    private javax.swing.JLabel addMedicineLabel;
    private javax.swing.JTextField ammountTextField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JLabel brandNameLabel;
    private javax.swing.JTextField brandNameTextField;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JTextField categoryTextField;
    private javax.swing.JLabel formLabel;
    private javax.swing.JTextField formTextField;
    private javax.swing.JLabel genericNameLabel;
    private javax.swing.JTextField genericNameTextField;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextField;
}
