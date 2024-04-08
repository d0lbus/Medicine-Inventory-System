package midproject.ClientControllers;

import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import midproject.SharedClasses.ReferenceClasses.Order;
import midproject.SharedClasses.Servants.CallbackImplementation;
import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.ReferenceClasses.OrderItem;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.*;
import midproject.ViewClasses.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


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
			String oldPassword = new String(clientGUIFrame.getCurrentPasswordField().getPassword());
			String newPassword = new String(clientGUIFrame.getNewPasswordField().getPassword());
			String confirmPassword = new String(clientGUIFrame.getConfirmPasswordField().getPassword());

			// Validate if new password matches confirm password
			if (!newPassword.equals(confirmPassword)) {
				JOptionPane.showMessageDialog(clientGUIFrame, "New password and confirm password do not match.",
						"Password Mismatch", JOptionPane.ERROR_MESSAGE);
				return; // Exit the method if passwords don't match
			}

			// Call the method to change password on the server
			try {
				boolean isPasswordChanged = msgserver.changeUserPassword(username, oldPassword, newPassword, mci);

				if (isPasswordChanged) {
					JOptionPane.showMessageDialog(clientGUIFrame, "Password changed successfully.",
							"Success", JOptionPane.INFORMATION_MESSAGE);
					// Clear password fields after successful password change
					clientGUIFrame.getCurrentPasswordField().setText("");
					clientGUIFrame.getNewPasswordField().setText("");
					clientGUIFrame.getConfirmPasswordField().setText("");
				} else {
					JOptionPane.showMessageDialog(clientGUIFrame, "Failed to change password. Please check your old password.",
							"Password Change Failed", JOptionPane.ERROR_MESSAGE);
				}
			} catch (RemoteException ex) {
				JOptionPane.showMessageDialog(clientGUIFrame, "Error communicating with the server.",
						"Server Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace(); // Print stack trace for debugging
			} catch (PasswordChangeFailedException ex) {
				throw new RuntimeException(ex);
			}

		});

		clientGUIFrame.getOrderHistoryLabel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					msgserver.getOrderHistory(username, mci);
				} catch (RemoteException ex) {
					ex.printStackTrace();
						JOptionPane.showMessageDialog(clientGUIFrame, "Error retrieving order history: " + ex.getMessage(), "Order History Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		clientGUIFrame.getViewOrderHistoryButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = clientGUIFrame.getOrderHistoryTable().getSelectedRow();
				if (selectedRow >= 0) {
					String orderId = (String) clientGUIFrame.getOrderHistoryTable().getValueAt(selectedRow, 0);
					try {
						ViewOrderFrame viewOrderFrame = new ViewOrderFrame();
						viewOrderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						viewOrderFrame.setLocationRelativeTo(null);
						viewOrderFrame.setVisible(true);

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

						StyledDocument doc = (StyledDocument) viewOrderFrame.getjTextPane1().getDocument();
						doc.insertString(doc.getLength(), buildOrderDetailsString(user, orderId, orderDetails, chosenOrder.getModeOfDelivery(), chosenOrder.getPaymentMethod()), null);


						Style style = doc.addStyle("ImageStyle", null);
						StyleConstants.setIcon(style, imageIcon);
						doc.insertString(doc.getLength(), "ignored text", style);

					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(clientGUIFrame, "Failed to load order details.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					try {
						throw new SelectionRequiredException("Please select an order to view");
					} catch (SelectionRequiredException ex) {
						JOptionPane.showMessageDialog(clientGUIFrame, ex.getMessage(), "Selection Required", JOptionPane.WARNING_MESSAGE);
					}
				}
			}

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
							} catch (MedicineOutOfStockException exception) {
								JOptionPane.showMessageDialog(clientGUIFrame, "Medicine is currently out of stock", "Out Of Stock", JOptionPane.ERROR_MESSAGE);
                                throw new RuntimeException(exception);
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
							} catch (MedicineQuantityUpdateFailedException exception) {
                                throw new RuntimeException(exception);
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
						} catch (MedicineRemovalFailedException ex) {
                            throw new RuntimeException(ex);
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
						double total = OrderItem.calculateTotalPrice(orderItems);
						double discountAmount = 0;

						String pwdDiscount = "";

						for (OrderItem item : orderItems) {
							String itemDetails = String.format("Medicine ID: %s\nGeneric Name: %s\nBrand Name: %s\nForm: %s\nQuantity: %d\nPrice: ₱%.2f\n\n",
									item.getMedicineId(), item.getGenericName(), item.getBrandName(), item.getForm(),
									item.getQuantity(), item.getPrice());
							orderDetails.append(itemDetails);
						}

						double discountRate = 0.0;
						if ("yes".equals(user.getPersonWithDisability())) {
							discountRate = 0.2; // Assuming the discount rate is 20% for PWD
							pwdDiscount = "20%";
						} else {
							pwdDiscount = "0%";
						}

						discountAmount = total * discountRate;
						total -= discountAmount;

						orderDetails.append(String.format("PWD Discount: %s\n", pwdDiscount));
						orderDetails.append(String.format("Discount Amount: ₱%.2f\n", discountAmount));
						orderDetails.append(String.format("Total after Discount: ₱%.2f\n", total));

						// Set order details in the GUI
						clientGUIFrame.getYourOrderTextPane().setText(
								"Name: " + user.getFirstName() + " " + user.getLastName() +
										"\nAddress: " + user.getStreet() + " " + user.getAdditionalAddressDetails() + " " +
										user.getCity() + ", " + user.getProvince() + " " + user.getZip() +
										"\nMode of Delivery: " + modeOfDelivery +
										"\nMode of Payment: " + modeOfPayment + "\n\n" +
										orderDetails.toString()
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
						User user = msgserver.getUserDetails(username, mci);
						msgserver.processOrder(user, orderItems, base64Image, modeOfDelivery, modeOfPayment, mci);
						JOptionPane.showMessageDialog(clientGUIFrame, "Order has been placed successfully.", "Order Placed", JOptionPane.INFORMATION_MESSAGE);
					} catch (MedicineOutOfStockException ex) {
						JOptionPane.showMessageDialog(clientGUIFrame, ex.getMessage(), "Stock Insufficient", JOptionPane.WARNING_MESSAGE);
					} catch (RemoteException ex) {
						JOptionPane.showMessageDialog(clientGUIFrame, "Failed to place the order due to server error.", "Server Error", JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(clientGUIFrame, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(clientGUIFrame, "Please upload a prescription before checking out.", "Image Required", JOptionPane.WARNING_MESSAGE);
				}
			});

			/**
			 *
			 *	SEND MESSAGE TO ADMINS
			 *
			 * */

			clientGUIFrame.getSendButton().addActionListener(e -> {
				String message = clientGUIFrame.getSendMessageTextArea().getText();
				try {
					msgserver.sendMessageToAdmins(message, username);

					if (message.isEmpty()) {
						JOptionPane.showMessageDialog(clientGUIFrame, "Please enter a message to send.", "No Message", JOptionPane.ERROR_MESSAGE);
						return;
					}

					JOptionPane.showMessageDialog(clientGUIFrame, "Message sent successfully to admins!","Message Sent", JOptionPane.INFORMATION_MESSAGE);
					clientGUIFrame.getSendMessageTextArea().setText("");
				} catch (RemoteException ex) {
					throw new RuntimeException(ex);
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
			int quantity = (Integer) clientGUIFrame.getCategoryTable1().getValueAt(selectedRow, 6); // Quantity
			double price = (Double) clientGUIFrame.getCategoryTable1().getValueAt(selectedRow, 5); // Price
			orderItems.add(new OrderItem(medicineId, genericName, brandName, form, quantity, price));
		}
		return orderItems;
	}

	private static String buildOrderDetailsString(User user, String orderID, StringBuilder orderDetails, String modeOfDelivery, String modeOfPayment) {
		StringBuilder details = new StringBuilder();
		details.append("("+orderID+")"+"\n\n");
		details.append("Name: ").append(user.getFirstName()).append(" ").append(user.getLastName()).append("\n");
		details.append("Address: ").append(user.getStreet()).append(" ").append(user.getAdditionalAddressDetails()).append(" ");
		details.append(user.getCity()).append(", ").append(user.getProvince()).append(" ").append(user.getZip()).append("\n");
		details.append("Mode of Delivery: ").append(modeOfDelivery).append("\n");
		details.append("Mode of Payment: ").append(modeOfPayment).append("\n\n");
		details.append(orderDetails);
		return details.toString();
	}


}


