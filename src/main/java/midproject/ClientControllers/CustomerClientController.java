package midproject.ClientControllers;

import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import midproject.SharedClasses.Implementations.CallbackImplementation;
import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.NotLoggedInException;
import midproject.ViewClasses.ClientGUIFrame;
import midproject.ViewClasses.QuantityFrame;
import midproject.ViewClasses.Login;
import java.awt.event.MouseAdapter;

import javax.swing.*;


public class CustomerClientController {

	private static Login loginFrame = new Login();
	private static ClientGUIFrame clientGUIFrame = ClientGUIFrame.getInstance();
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
				String userTypeRequest = "Customer";

				registry = LocateRegistry.getRegistry(ipAddress);
				msgserver = (ModelInterface) registry.lookup("msgserver");
				mci = new CallbackImplementation(user, clientGUIFrame);
				sessionID = msgserver.login(mci, username, password, userTypeRequest);

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
		private static void showClientGUI() {
			try {
				UIManager.setLookAndFeel(new FlatLightLaf());
			} catch (Exception ex) {
				System.err.println("Failed to initialize FlatLaf for AdminGUIFrame");
			}

			clientGUIFrame.setVisible(true);

			try{
				msgserver.updateInventoryTable();
			}
			catch (Exception e){
				e.printStackTrace();
			}

		/**
		 * 	PROFILE RELATED FUNCTIONS
		 *  Logout
		 *  Display Profile
		 *  Change Password
		 * */
		clientGUIFrame.getLogOutButton().addActionListener(e ->{
			try {
				msgserver.logout(mci, sessionID);
				System.exit(0);
			} catch (RemoteException ex) {
				JOptionPane.showMessageDialog(clientGUIFrame, "Remote exception occurred.", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (NotLoggedInException ex) {
				JOptionPane.showMessageDialog(clientGUIFrame, "You are not logged in.", "Logout Failed", JOptionPane.ERROR_MESSAGE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(clientGUIFrame, "Logout Process Failed.", "Logout Failed", JOptionPane.ERROR_MESSAGE);
            }

        });

		clientGUIFrame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					try {
						msgserver.logout(mci, sessionID);
						System.exit(0);
					} catch (RemoteException ex) {
						JOptionPane.showMessageDialog(clientGUIFrame, "Remote exception occurred.", "Error", JOptionPane.ERROR_MESSAGE);
					} catch (NotLoggedInException ex) {
						JOptionPane.showMessageDialog(clientGUIFrame, "You are not logged in.", "Logout Failed", JOptionPane.ERROR_MESSAGE);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(clientGUIFrame, "Logout Process Failed.", "Logout Failed", JOptionPane.ERROR_MESSAGE);
					}
				}
			});

		clientGUIFrame.getProfileLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					msgserver.getUserDetails(username, mci);
				}  catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
		});

		clientGUIFrame.getSaveButton().addActionListener(e ->{

		});

		/**
		 * 	SHOPPING FOR MEDICINE RELATED FUNCTIONS
		 *
		 *
		 * */
			clientGUIFrame.getSearchTextfield().addActionListener(e ->{
				String searchText = clientGUIFrame.getSearchTextfield().getText().trim().toLowerCase();
				try {
					msgserver.searchMedicine(searchText, mci);
				} catch (RemoteException ex) {
					ex.printStackTrace();
				}
			});

			clientGUIFrame.getCartLabel().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					try {
						msgserver.getCartDetails(username, mci);
					}  catch (Exception ex) {
						throw new RuntimeException(ex);
					}
				}
			});

			clientGUIFrame.getSearchTextfield1().addActionListener(e ->{
				String searchText = clientGUIFrame.getSearchTextfield1().getText().trim().toLowerCase();
				try {
					msgserver.searchMedicine(searchText, mci);
				} catch (RemoteException ex) {
					ex.printStackTrace();
				}
			});

			clientGUIFrame.getAddToCartButton().addActionListener(e ->{
				int selectedRow = clientGUIFrame.getCategoryTable().getSelectedRow();
				if (selectedRow >= 0) {
					String medicineId = clientGUIFrame.getCategoryTable().getValueAt(selectedRow, 0).toString();

					QuantityFrame quantityFrame = new QuantityFrame();
					quantityFrame.setLocationRelativeTo(clientGUIFrame);
					quantityFrame.setVisible(true);
					quantityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					quantityFrame.getProceedButton().addActionListener(ex -> {
						int quantity = quantityFrame.getSelectedQuantity();
						if(quantity > 0) {
							try {
								msgserver.addMedicineToCart(medicineId, quantity, mci, username);
								JOptionPane.showMessageDialog(clientGUIFrame, "Item added to cart successfully", "Add To Cart Successful",JOptionPane.INFORMATION_MESSAGE);
								quantityFrame.dispose();
							} catch (RemoteException exc) {
								throw new RuntimeException(exc);
							}
						}
					});
				} else {
					JOptionPane.showMessageDialog(clientGUIFrame, "No item selected", "Add To Cart Failed",JOptionPane.ERROR_MESSAGE);
				}
			});

			clientGUIFrame.getEditOrderButton1().addActionListener(e -> {
				int[] selectedRows = clientGUIFrame.getCategoryTable1().getSelectedRows();
				if (selectedRows.length == 1) {
					int selectedRow = selectedRows[0];
					String medicineId = clientGUIFrame.getCategoryTable1().getValueAt(selectedRow, 0).toString();
					QuantityFrame quantityFrame = new QuantityFrame();
					quantityFrame.setLocationRelativeTo(clientGUIFrame);
					quantityFrame.setVisible(true);
					quantityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					quantityFrame.getProceedButton().addActionListener(ex -> {
						int newQuantity = quantityFrame.getSelectedQuantity();
						if (newQuantity > 0) {
							try {
								msgserver.updateMedicineQuantityInCart(medicineId, newQuantity, mci, username);
								JOptionPane.showMessageDialog(quantityFrame, "Quantity updated successfully.");
								quantityFrame.dispose();
							} catch (RemoteException exc) {
								JOptionPane.showMessageDialog(quantityFrame, "Failed to update quantity: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(quantityFrame, "Please select a valid quantity.", "Invalid Quantity", JOptionPane.WARNING_MESSAGE);
						}
					});
				} else if (selectedRows.length > 1) {
					JOptionPane.showMessageDialog(clientGUIFrame, "Please select only one row to edit.", "Multiple Rows Selected", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(clientGUIFrame, "Please select a row to edit.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
				}
			});

			clientGUIFrame.getRemoveButton().addActionListener(e -> {
				int[] selectedRows = clientGUIFrame.getCategoryTable1().getSelectedRows();
				if (selectedRows.length > 0) {
					for (int i = selectedRows.length - 1; i >= 0; i--) {
						int rowIndex = selectedRows[i];
						String medicineId = (String) clientGUIFrame.getCategoryTable1().getValueAt(rowIndex, 0);

						try {
							msgserver.removeMedicineInCart(medicineId, mci, username);
						} catch (RemoteException exc) {
							JOptionPane.showMessageDialog(clientGUIFrame, "Failed to remove item from cart: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					JOptionPane.showMessageDialog(clientGUIFrame, "Selected items removed from cart successfully.", "Items Removed", JOptionPane.INFORMATION_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(clientGUIFrame, "Please select at least one item to remove.", "No Items Selected", JOptionPane.WARNING_MESSAGE);
				}
			});

	}
}

