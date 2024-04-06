package midproject.ClientControllers;

import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import midproject.SharedClasses.Implementations.CallbackImplementation;
import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.ReferenceClasses.OrderItem;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.NotLoggedInException;
import midproject.ViewClasses.ClientGUIFrame;
import midproject.ViewClasses.QuantityFrame;
import midproject.ViewClasses.Login;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLEditorKit;


public class CustomerClientController {

	private static Login loginFrame = new Login();
	private static ClientGUIFrame clientGUIFrame = ClientGUIFrame.getInstance();
	private static User user = new User();
	private static Registry registry;
	private static ModelInterface msgserver;
	private static CallbackImplementation mci;

	private static String username;
	private static String sessionID;

	private static boolean isModeOfDeliverySelected = false;

	private static boolean isImageUploaded = false;

	private static List<OrderItem> orderItems = new ArrayList<OrderItem>();

	private static File selectedFile;
	private static String modeOfDelivery = "";
	private static String modeOfPayment = "";

	private static String base64Image = "";

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
						orderItems.clear();
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

			clientGUIFrame.getSubmitButton().addActionListener(e ->{
				boolean isValid = true;
				StringBuilder invalidMedicines = new StringBuilder();

				for (int selectedRow : clientGUIFrame.getCategoryTable1().getSelectedRows()) {
					String medicineId = (String) clientGUIFrame.getCategoryTable1().getValueAt(selectedRow, 0);
					int selectedQuantity = (Integer) clientGUIFrame.getCategoryTable1().getValueAt(selectedRow, 6);

					try {
						int currentStock = (Integer) clientGUIFrame.getCategoryTable1().getValueAt(selectedRow, 7);
						if (selectedQuantity > currentStock) {
							isValid = false;
							invalidMedicines.append("\n").append((String) clientGUIFrame.getCategoryTable1().getValueAt(selectedRow, 3));
						}
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(clientGUIFrame, "Error checking stock for medicine: " + medicineId, "Stock Check Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				if (!isValid) {
					JOptionPane.showMessageDialog(clientGUIFrame, "Selected quantity exceeds available stock for: " + invalidMedicines.toString(), "Quantity Error", JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						orderItems = getOrderItemsFromSelectedRows();
					} catch (Exception ex){
						ex.printStackTrace();
					}
					if (orderItems.isEmpty()){
						JOptionPane.showMessageDialog(clientGUIFrame, "No items selected. Please select an item first.", "No Items Selected", JOptionPane.WARNING_MESSAGE);
					} else {
						isModeOfDeliverySelected = false;
						isImageUploaded = false;
						JPanel containerPanel = clientGUIFrame.getContainerPanel();
						JPanel modeOfDeliveryPanel = clientGUIFrame.getModeOfDeliveryPanel();
						containerPanel.removeAll();
						containerPanel.add(modeOfDeliveryPanel);
						containerPanel.repaint();
						containerPanel.revalidate();
					}
				}
			});

			clientGUIFrame.getPickUpButton().addActionListener(e -> {
				modeOfDelivery = "Pick-up";
				modeOfPayment = "On-site";
				clientGUIFrame.getPickUpTextPane().setText("You may pay your order on our physical store.");
				isModeOfDeliverySelected = true;
			});

			clientGUIFrame.getDeliveryButton().addActionListener(e -> {
				modeOfDelivery = "Delivery";
				modeOfPayment = "Cash on Delivery";
				clientGUIFrame.getPickUpTextPane().setText("You may pay your order once delivered");
				isModeOfDeliverySelected = true;
			});

			clientGUIFrame.getNextButtonModeOfDelivery().addActionListener(e -> {
				if (isModeOfDeliverySelected) {
					try {
						StringBuilder orderDetails = new StringBuilder();
						User user = msgserver.getUserDetails(username, mci);
						double total = 0;
						double discountAmount = 0;

						String pwdDiscount = "";

						for (OrderItem item : orderItems) {
							String itemDetails = String.format("Medicine ID: %s\nGeneric Name: %s\nBrand Name: %s\nForm: %s\nQuantity: %d\nPrice: ₱%.2f\n\n",
									item.getMedicineId(), item.getGenericName(), item.getBrandName(), item.getForm(),
									item.getQuantity(), item.getPrice());
							orderDetails.append(itemDetails);
							if ("yes".equals(user.getPersonWithDisability())) {
								pwdDiscount = "20%";
								discountAmount = total * 0.2;
								total -= discountAmount;
							} else {
								total += item.getPrice() * item.getQuantity();
								pwdDiscount = "0%";
							}

						}

						orderDetails.append(String.format("PWD Discount: %s\n", pwdDiscount));
						orderDetails.append(String.format("Discount Amount: ₱%.2f\n", discountAmount));
						orderDetails.append(String.format("Total after Discount: ₱%.2f\n", total));


						clientGUIFrame.getYourOrderTextPane().setText
								("Name: " + user.getFirstName() + " " + user.getLastName()
										+ "\nAddress: " + user.getStreet() + " " + user.getAdditionalAddressDetails() + " " +
										user.getCity() + ", " + user.getProvince() + " " + user.getZip()
										+ "\n"
										+ "Mode of Delivery: " + modeOfDelivery + "\n"
										+ "Mode of Payment: " + modeOfPayment + "\n\n"
										+ orderDetails.toString()

								);
					} catch (Exception ex) {
						throw new RuntimeException(ex);
					}

					JPanel containerPanel = clientGUIFrame.getContainerPanel();
					JPanel yourOrderPanel = clientGUIFrame.getYourOrderPanel();

					containerPanel.removeAll();
					containerPanel.add(yourOrderPanel);
					containerPanel.repaint();
					containerPanel.revalidate();
				} else {
					JOptionPane.showMessageDialog(clientGUIFrame, "Please select a mode of delivery before proceeding.", "Mode of Delivery Required", JOptionPane.WARNING_MESSAGE);
				}
			});

			clientGUIFrame.getUploadPrescriptionButton().addActionListener(e -> {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPEG, PNG, and PDF files", "jpg", "jpeg", "png", "pdf");
				fileChooser.setFileFilter(filter);
				fileChooser.setAcceptAllFileFilterUsed(false);

				int result = fileChooser.showOpenDialog(clientGUIFrame);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					long fileSizeInBytes = selectedFile.length();

					if (fileSizeInBytes > 25 * 1024 * 1024) { // 25 MB limit
						JOptionPane.showMessageDialog(clientGUIFrame, "The file is too large. Please select a file less than 25 MB.", "File Too Large", JOptionPane.ERROR_MESSAGE);
					} else {
						try (FileInputStream fileInputStream = new FileInputStream(selectedFile)) {
							byte[] fileContent = new byte[(int) selectedFile.length()];
							int offset = 0;
							int numRead;
							while (offset < fileContent.length
									&& (numRead = fileInputStream.read(fileContent, offset, fileContent.length - offset)) >= 0) {
								offset += numRead;
							}
							if (offset < fileContent.length) {
								throw new IOException("Could not completely read file " + selectedFile.getName());
							}
							base64Image = Base64.getEncoder().encodeToString(fileContent);
							isImageUploaded = true;
							JOptionPane.showMessageDialog(clientGUIFrame, "File uploaded successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
							clientGUIFrame.getCheckOutButton().setEnabled(true);
						} catch (IOException ex) {
							JOptionPane.showMessageDialog(clientGUIFrame, "Error reading the file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});

			clientGUIFrame.getCheckOutButton().addActionListener(e -> {
				if (isImageUploaded) {
					try {
					User user = msgserver.getUserDetails(username,mci);
					msgserver.processOrder(user, orderItems, base64Image, modeOfDelivery, modeOfPayment, mci);
					} catch (Exception ex) {
						throw new RuntimeException(ex);
					}
				} else {
					JOptionPane.showMessageDialog(clientGUIFrame, "Please upload a prescription before checking out.", "Image Required", JOptionPane.WARNING_MESSAGE);
				}
			});

		}


	/**HELPER METHODS**/

	private static List<OrderItem> getOrderItemsFromSelectedRows() {
		List<OrderItem> orderItems = new ArrayList<>();
		for (int selectedRow : clientGUIFrame.getCategoryTable1().getSelectedRows()) {
			String medicineId = (String) clientGUIFrame.getCategoryTable1().getValueAt(selectedRow, 0);
			String genericName = (String) clientGUIFrame.getCategoryTable1().getValueAt(selectedRow, 2);
			String brandName = (String) clientGUIFrame.getCategoryTable1().getValueAt(selectedRow, 3);
			String form = (String) clientGUIFrame.getCategoryTable1().getValueAt(selectedRow, 4);
			int quantity = (Integer) clientGUIFrame.getCategoryTable1().getValueAt(selectedRow, 6);
			double price = (Double) clientGUIFrame.getCategoryTable1().getValueAt(selectedRow, 5);
			orderItems.add(new OrderItem(medicineId, genericName, brandName, form, quantity, price));
		}
		return orderItems;
	}


}


