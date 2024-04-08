package midproject.SharedClasses.Servants;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import midproject.SharedClasses.Interfaces.MessageCallback;
import midproject.SharedClasses.ReferenceClasses.*;
import midproject.SharedClasses.Utilities.MedicineJSONProcessor;
import midproject.Admin.View.AdminGUIFrame;
import midproject.Customer.View.ClientGUIFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class CallbackImplementation extends UnicastRemoteObject implements MessageCallback, Serializable {
	private User user;
	private AdminGUIFrame adminGUIFrame;
	private ClientGUIFrame clientGUIFrame;
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String formattedDateTime = now.format(formatter);

	public CallbackImplementation(User user, AdminGUIFrame adminGUIFrame) throws RemoteException {
		this.user = user;
		this.adminGUIFrame = adminGUIFrame;
	}

	public CallbackImplementation(User user, ClientGUIFrame clientGUIFrame) throws RemoteException {
		this.user = user;
		this.clientGUIFrame = clientGUIFrame;
	}

	public void loginCall(User user) throws RemoteException {
		System.out.println(user.getUsername() + " logged in...");
	}

	public void broadcastCall(String msg) throws RemoteException {
		SwingUtilities.invokeLater(() -> {
			if (clientGUIFrame != null) {
				clientGUIFrame.getNotificationsTextArea().append("[SERVER NOTIFICATION]: " + msg + "\n");
			} else {
				System.err.println("Client GUI frame is null.");
			}
		});
	}

	public void logoutCall(User user) throws RemoteException  {
		System.out.println(user.getUsername() + " logged out...");
	}

	public void updateOnlineUsers(int count, List<String> onlineUserNames) {
		SwingUtilities.invokeLater(() -> {
				String sCount = String.valueOf(count);
				adminGUIFrame.getOnlineUsersLabel().setText(sCount);
				adminGUIFrame.getOnlineUsersLabel().revalidate();
				adminGUIFrame.getOnlineUsersLabel().repaint();

			for (String username : onlineUserNames) {
				adminGUIFrame.getComboBox().addItem(username);
			}

		});
	}

	public void updateOrdersCount(int count) throws RemoteException{
		SwingUtilities.invokeLater(() -> {
			String sCount = String.valueOf(count);
			adminGUIFrame.getTotalOrdersLabel().setText(sCount);
			adminGUIFrame.getTotalOrdersLabel().revalidate();
			adminGUIFrame.getTotalOrdersLabel().repaint();
		});
	}

	public void updatePendingOrdersCount (int count) throws RemoteException{
		SwingUtilities.invokeLater(() -> {
			String sCount = String.valueOf(count);
			adminGUIFrame.getPendingOrdersLabel().setText(sCount);
			adminGUIFrame.getPendingOrdersLabel().revalidate();
			adminGUIFrame.getPendingOrdersLabel().repaint();
		});
	}

	public void readRUsersList(List<User> users) {
		SwingUtilities.invokeLater(() -> {
			if (adminGUIFrame != null) {
				DefaultTableModel model = (DefaultTableModel) adminGUIFrame.getrUsersTable().getModel();
				model.setRowCount(0);

				for (User user : users) {
					Object[] rowData = {
							user.getUserId(),
							user.getLastName(),
							user.getFirstName(),
							user.getUserType(),
							user.getUsername()
					};
					model.addRow(rowData);
				}
			} else {
				System.err.println("Admin GUI frame is null.");
			}
		});
	}

	public void readAUsersList(List<User> users) {
		SwingUtilities.invokeLater(() -> {
			if (adminGUIFrame != null) {
				DefaultTableModel model = (DefaultTableModel) adminGUIFrame.getaUsersTable().getModel();
				model.setRowCount(0);

				for (User user : users) {
					Object[] rowData = {
							user.getUserId(),
							user.getLastName(),
							user.getFirstName(),
							user.getUserType(),
							user.getUsername()
					};
					model.addRow(rowData);
				}
			} else {
				System.err.println("Admin GUI frame is null.");
			}
		});
	}

	public void readOrdersList(List<Order> orders){
		SwingUtilities.invokeLater(() -> {
			if (adminGUIFrame != null) {
				DefaultTableModel pendingModel = (DefaultTableModel) adminGUIFrame.getpTable().getModel();
				pendingModel.setRowCount(0);

				DefaultTableModel otherStatusModel = (DefaultTableModel) adminGUIFrame.getoTable().getModel();
				otherStatusModel.setRowCount(0);

				for (Order order : orders) {
					if ("Pending".equals(order.getStatus())) {
						Object[] rowData = {
								order.getOrderId(),
								order.getUserId(),
								order.getModeOfDelivery(),
								order.getPaymentMethod(),
								order.getStatus(),
								order.getTotal()
						};
						pendingModel.addRow(rowData);
					} else {
						Object[] rowData = {
								order.getOrderId(),
								order.getUserId(),
								order.getModeOfDelivery(),
								order.getPaymentMethod(),
								order.getStatus(),
								order.getTotal()
						};
						otherStatusModel.addRow(rowData);
					}
				}
			} else {
				System.err.println("Admin GUI frame is null.");
			}
		});
	}

	public void countUsersList(List<User> users) {
		int count = users.size();
		SwingUtilities.invokeLater(() -> {
			if (adminGUIFrame != null) {
				String sCount = String.valueOf(count);
				adminGUIFrame.getTotalUsersLabel().setText(sCount);
				adminGUIFrame.getTotalUsersLabel().revalidate();
				adminGUIFrame.getTotalUsersLabel().repaint();

			} else {
				System.err.println("Admin GUI frame is null.");
			}
		});
	}

	public void readMedicineList(List<Medicine> medicineList) {
		SwingUtilities.invokeLater(() -> {
			if (adminGUIFrame != null || clientGUIFrame != null) {
				if (adminGUIFrame != null) {
					DefaultTableModel adminModel = (DefaultTableModel) adminGUIFrame.getiTable().getModel();
					adminModel.setRowCount(0);
					for (Medicine medicine : medicineList) {
						Object[] adminRowData = {
								medicine.getMedicineID(),
								medicine.getCategory(),
								medicine.getGenericName(),
								medicine.getBrandName(),
								medicine.getForm(),
								medicine.getQuantity(),
								medicine.getPrice()
						};
						adminModel.addRow(adminRowData);
					}
				}


				if (clientGUIFrame != null) {
					DefaultTableModel clientModel = (DefaultTableModel) clientGUIFrame.getCategoryTable().getModel();
					clientModel.setRowCount(0);
					for (Medicine medicine : medicineList) {
						Object[] clientRowData = {
								medicine.getMedicineID(),
								medicine.getCategory(),
								medicine.getGenericName(),
								medicine.getBrandName(),
								medicine.getForm(),
								medicine.getPrice(),
								medicine.getQuantity()
						};
						clientModel.addRow(clientRowData);
					}
				}
			} else {
				System.err.println("Both Admin GUI and Client GUI frames are null.");
			}
		});
	}
	public User getUser() throws RemoteException {
		return user;
	}
	public void displayUserDetails(User user) throws RemoteException {
		SwingUtilities.invokeLater(() -> {
			String userDetails = "<html>User ID: " + user.getUserId() + "<br>" +
					"User Type: " + user.getUserType() + "<br>" +
					"Name: " + user.getFirstName() + " " + (user.getMiddleName() != null ? user.getMiddleName() + " " : "") + user.getLastName() + "<br>" +
					"Birthdate: " + user.getBirthdate() + "<br>" +
					"Age: " + user.getAge() + "<br>" +
					"Gender: " + user.getGender() + "<br>" +
					"Person with Disability: " + user.getPersonWithDisability() + "<br>" +
					"Email: " + user.getEmail() + "<br>" +
					"Contact Number: " + user.getContactNumber() + "<br>" +
					"Username: " + user.getUsername() + "<br>" +
					"Street: " + user.getStreet() + "<br>" +
					"Additional Address Details: " + user.getAdditionalAddressDetails() + "<br>" +
					"City: " + user.getCity() + "<br>" +
					"Province: " + user.getProvince() + "<br>" +
					"ZIP: " + user.getZip() + "</html>";

			JOptionPane.showMessageDialog(null, userDetails, "Details of " + user.getFirstName() + " " + user.getLastName(), JOptionPane.INFORMATION_MESSAGE);
		});
	}
	public void notifyUserRegisteredByAdmin(String adminUsername, User user) throws RemoteException{
		SwingUtilities.invokeLater(() -> {
			String message = "["+formattedDateTime+"]" + "ADMIN " + adminUsername + " registered user "
					+ "\nID: " + user.getUserId()
					+ "\nUser Type: " + user.getUserType()
					+ "\nUsername: " + user.getUsername()
					+ "\nFirst Name: " + user.getFirstName()
					+ "\nLast Name: " + user.getLastName() +
					"\n";
			adminGUIFrame.getServerLogsTextArea().append(message);
		});
	}
	public void notifyUserArchivedByAdmin(String adminUsername, String archivedUsername) throws RemoteException {
		SwingUtilities.invokeLater(() -> {
			String message = "["+formattedDateTime+"]" + "ADMIN " + adminUsername + " archived user " + archivedUsername+"\n";
			adminGUIFrame.getServerLogsTextArea().append(message);
		});
	}
	public void notifyUserUnarchivedByAdmin(String adminUsername, String unarchivedUsername) throws RemoteException {
		SwingUtilities.invokeLater(() -> {
			String message = "["+formattedDateTime+"]" + "ADMIN " + adminUsername + " unarchived user " + unarchivedUsername+"\n";
			adminGUIFrame.getServerLogsTextArea().append(message);
		});
	}
	public void notifyMedicineAddedByAdmin(String adminUsername, Medicine medicine) throws RemoteException{
		SwingUtilities.invokeLater(() -> {
			String message =
					"["+formattedDateTime+"]" + "ADMIN " + adminUsername + " added a new medicine: "
							+ "\nMedicine ID" + medicine.getMedicineID()
							+ "\nCategory: " + medicine.getCategory()
							+ "\nGeneric Name: " + medicine.getGenericName()
							+ "\nBrand Name: " + medicine.getBrandName()
							+ "\nForm: " + medicine.getForm()
							+ "\nQuantity: " + medicine.getQuantity()
							+ "\nPrice: " + medicine.getPrice() + "\n";
			adminGUIFrame.getServerLogsTextArea().append(message);
		});
	}
	public void notifyMedicineArchivedByAdmin(String adminUsername, Medicine medicine) throws RemoteException{
		SwingUtilities.invokeLater(() -> {
		String message = "["+formattedDateTime+"]" + "ADMIN " + adminUsername + " deleted the medicine " + medicine.getGenericName() + " " +
				"with a brand name " + medicine.getBrandName() + " under the category " + medicine.getCategory()+"\n";
		adminGUIFrame.getServerLogsTextArea().append(message);
		});
	}
	public void notifyMedicineUpdatedByAdmin(String adminUsername, Medicine editedMedicine, Medicine originalMedicine) throws RemoteException{
		SwingUtilities.invokeLater(() -> {
			String message = "["+formattedDateTime+"]" + "ADMIN " + adminUsername + " edited the medicine entry. Changes made: "
					+ "\nCategory: from '" + originalMedicine.getCategory() + "' to '" + editedMedicine.getCategory() + "'"
					+ "\nGeneric Name: from '" + originalMedicine.getGenericName() + "' to '" + editedMedicine.getGenericName() + "'"
					+ "\nBrand Name: from '" + originalMedicine.getBrandName() + "' to '" + editedMedicine.getBrandName() + "'"
					+ "\nForm: from '" + originalMedicine.getForm() + "' to '" + editedMedicine.getForm() + "'"
					+ "\nQuantity: from '" + originalMedicine.getQuantity() + "' to '" + editedMedicine.getQuantity() + "'"
					+ "\nPrice: from " + originalMedicine.getPrice() + " to " + editedMedicine.getPrice()+"\n";

			if (adminGUIFrame != null || clientGUIFrame != null) {
				if (adminGUIFrame != null) {
					adminGUIFrame.getServerLogsTextArea().append(message);
				}
				if (clientGUIFrame != null) {
					clientGUIFrame.getNotificationsTextArea().append(message);
				}
			} else {
				System.err.println("Both Admin GUI and Client GUI frames are null.");
			}
		});
	}
	public void notifyUserUpdatedByAdmin(String adminUsername, User editedUser, User originalUser) throws RemoteException {
		SwingUtilities.invokeLater(() -> {
			String message = "["+formattedDateTime+"]" + "ADMIN " + adminUsername + " edited the user entry. Changes made: "
					+ "\nFirst Name: from '" + originalUser.getFirstName() + "' to '" + editedUser.getFirstName() + "'"
					+ "\nLast Name: from '" + originalUser.getLastName() + "' to '" + editedUser.getLastName() + "'"
					+ "\nMiddle Name: from '" + originalUser.getMiddleName() + "' to '" + editedUser.getMiddleName() + "'"
					+ "\nBirthdate: from '" + originalUser.getBirthdate() + "' to '" + editedUser.getBirthdate() + "'"
					+ "\nAge: from '" + originalUser.getAge() + "' to '" + editedUser.getAge() + "'"
					+ "\nGender: from '" + originalUser.getGender() + "' to '" + editedUser.getGender() + "'"
					+ "\nStreet Address: from '" + originalUser.getStreet() + "' to '" + editedUser.getStreet() + "'"
					+ "\nAdditional Address Details: from '" + originalUser.getAdditionalAddressDetails() + "' to '"
					+ editedUser.getAdditionalAddressDetails() + "'"
					+ "\nCity: from '" + originalUser.getCity() + "' to '" + editedUser.getCity() + "'"
					+ "\nProvince: from '" + originalUser.getProvince() + "' to '" + editedUser.getProvince() + "'"
					+ "\nZip: from '" + originalUser.getZip() + "' to '" + editedUser.getZip() + "'"
					+ "\nEmail: from '" + originalUser.getEmail() + "' to '" + editedUser.getEmail() + "'"
					+ "\nContact Number: from '" + originalUser.getContactNumber() + "' to '" + editedUser.getContactNumber() + "'\n";
					adminGUIFrame.getServerLogsTextArea().append(message);
		});
	}
	public void notifyUserOrdersToAdmins(String username, String orderId) throws RemoteException{
		SwingUtilities.invokeLater(() -> {
			String message =
					"User " + username + " has placed an order ("+orderId+")\n";
			adminGUIFrame.getServerLogsTextArea().append(message);
		});
	}
	public void sendSearchResults(List<User> results) throws RemoteException {
		SwingUtilities.invokeLater(() -> {
			DefaultTableModel model = (DefaultTableModel) adminGUIFrame.getrUsersTable().getModel();
			model.setRowCount(0);
			for (User user : results) {
				Object[] rowData = {
						user.getUserId(),
						user.getFirstName(),
						user.getLastName(),
						user.getUserType(),
						user.getUsername(),
				};
				model.addRow(rowData);
			}
		});
	}
	public void sendMedicineSearchResults(List<Medicine> results) throws RemoteException {
		SwingUtilities.invokeLater(() -> {
			if (adminGUIFrame != null || clientGUIFrame != null) {
				if (adminGUIFrame != null) {
				DefaultTableModel model = (DefaultTableModel) adminGUIFrame.getiTable().getModel();
				model.setRowCount(0);

				for (Medicine medicine : results) {
					Object[] rowData = {
							medicine.getMedicineID(),
							medicine.getCategory(),
							medicine.getGenericName(),
							medicine.getBrandName(),
							medicine.getForm(),
							medicine.getQuantity(),
							medicine.getPrice()
					};
					model.addRow(rowData);
				}

				}
				if (clientGUIFrame != null) {
				DefaultTableModel clientModel = (DefaultTableModel) clientGUIFrame.getCategoryTable().getModel();
				clientModel.setRowCount(0);

				for (Medicine medicine : results) {
					Object[] rowData = {
							medicine.getMedicineID(),
							medicine.getCategory(),
							medicine.getGenericName(),
							medicine.getBrandName(),
							medicine.getForm(),
							medicine.getQuantity(),
							medicine.getPrice()
					};
					clientModel.addRow(rowData);
				}
				}
			}

		});
	}

	public void sendOrderSearchResults(List<Order> searchResults) throws RemoteException{
		SwingUtilities.invokeLater(() -> {
			DefaultTableModel model = (DefaultTableModel) adminGUIFrame.getoTable().getModel();
			model.setRowCount(0);
			for (Order order : searchResults) {
				Object[] rowData = {
						order.getOrderId(),
						order.getUserId(),
						order.getModeOfDelivery(),
						order.getPaymentMethod(),
						order.getStatus(),
						order.getTotal()
				};
				model.addRow(rowData);
			}
		});
	}

	public void sendPendingOrderSearchResults(List<Order> searchResults) throws RemoteException{
		SwingUtilities.invokeLater(() -> {
			DefaultTableModel model = (DefaultTableModel) adminGUIFrame.getpTable().getModel();
			model.setRowCount(0);
			for (Order order : searchResults) {
				Object[] rowData = {
						order.getOrderId(),
						order.getUserId(),
						order.getModeOfDelivery(),
						order.getPaymentMethod(),
						order.getStatus(),
						order.getTotal()
				};
				model.addRow(rowData);
			}
		});
	}
	@Override
	public void sendArchivedUserSearchResults(List<User> searchResults) throws RemoteException {
		SwingUtilities.invokeLater(() -> {
			DefaultTableModel model = (DefaultTableModel) adminGUIFrame.getaUsersTable().getModel();
			model.setRowCount(0);

			for (User user : searchResults) {
				Object[] rowData = {
						user.getUserId(),
						user.getFirstName(),
						user.getLastName(),
						user.getUserType(),
						user.getUsername()
				};
				model.addRow(rowData);
			}
		});
	}
	/**CUSTOMER SIDE*/
	public void displayProfileDetails(User user) throws RemoteException{
		clientGUIFrame.getNameOnlyLabel().setText(user.getFirstName() + " " + user.getLastName());
		StringBuilder userDetails = new StringBuilder();
		userDetails.append("Name: ").append(user.getFirstName()).append(" ").append(user.getLastName()).append("\n");
		userDetails.append("Birthdate: ").append(user.getBirthdate()).append("\n");
		userDetails.append("Age: ").append(user.getAge()).append("\n");
		userDetails.append("Gender: ").append(user.getGender()).append("\n");
		userDetails.append("Email: ").append(user.getEmail()).append("\n");
		userDetails.append("Address: ").append(user.getStreet()).append(" ").append(user.getAdditionalAddressDetails()).append(" ");
		userDetails.append(user.getCity()).append(", ").append(user.getProvince()).append(" ").append(user.getZip()).append("\n");
		userDetails.append("City: ").append(user.getCity()).append("\n");
		userDetails.append("Province: ").append(user.getProvince()).append("\n");
		userDetails.append("Zip: ").append(user.getZip()).append("\n");
		userDetails.append("Email: ").append(user.getEmail()).append("\n");
		userDetails.append("Phone: ").append(user.getContactNumber()).append("\n");
		clientGUIFrame.getPersonalInformationTextArea().setText(String.valueOf(userDetails));
	}
	public void notifyPasswordChangeResult(boolean isSuccess, String message) throws RemoteException {
		if (isSuccess) {
			System.out.println("Password changed successfully for user: " + user.getUsername());
		} else {
			System.out.println("Failed to change password for user: " + user.getUsername() + ". Reason: " + message);
		}
	}
	
	public void updateCart(UserCart userCart) throws RemoteException {
		SwingUtilities.invokeLater(() -> {
			DefaultTableModel model = (DefaultTableModel) clientGUIFrame.getCategoryTable1().getModel();
			model.setRowCount(0);
			userCart.getItems().forEach((medicineId, quantity) -> {
				try {
					Medicine medicine = MedicineJSONProcessor.getMedicineById("res/Medicine.json", medicineId);
					if(medicine != null) {
						model.addRow(new Object[]{medicine.getMedicineID(), medicine.getCategory(), medicine.getGenericName(),
								medicine.getBrandName(), medicine.getForm(), medicine.getPrice(), quantity, medicine.getQuantity()});
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		});
	}
	public void notifyOrderProcessed(String orderId, User user, List<OrderItem> orderItems, byte[] imageBytes, String modeOfDelivery, String modeOfPayment) throws RemoteException {
		SwingUtilities.invokeLater(() -> {
			try {
				StringBuilder orderDetails = new StringBuilder();
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
					discountRate = 0.2;
					pwdDiscount = "20%";
				} else {
					pwdDiscount = "0%";
				}

				discountAmount = total * discountRate;
				total -= discountAmount;

				orderDetails.append(String.format("PWD Discount: %s\n", pwdDiscount));
				orderDetails.append(String.format("Discount Amount: ₱%.2f\n", discountAmount));
				orderDetails.append(String.format("Total after Discount: ₱%.2f\n", total));

				ImageIcon imageIcon = new ImageIcon(imageBytes);

				StyledDocument doc = (StyledDocument) clientGUIFrame.getOrderPlacedTextpane().getDocument();
				doc.insertString(doc.getLength(), buildOrderDetailsString(user, orderId, orderDetails, modeOfDelivery, modeOfPayment), null);

				Style style = doc.addStyle("ImageStyle", null);
				StyleConstants.setIcon(style, imageIcon);
				doc.insertString(doc.getLength(), "ignored text", style);

				JPanel containerPanel = clientGUIFrame.getContainerPanel();
				JPanel placedOrderPanel = clientGUIFrame.getPlacedOrderPanel();

				containerPanel.removeAll();
				containerPanel.add(placedOrderPanel);
				containerPanel.repaint();
				containerPanel.revalidate();

				String message = "[SERVER NOTIFICATION][" + formattedDateTime + "]Your order " + orderId + " has been placed. Please wait while we review your uploaded prescription.\n";
				clientGUIFrame.getNotificationsTextArea().append(message);

			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		});
	}

	public void getUserMessage(String message, String username) throws RemoteException{
		SwingUtilities.invokeLater(() -> {
			adminGUIFrame.getServerLogsTextArea().append("["+formattedDateTime+"][FROM USER: " + username+"]"+message);
		});
	}

	public void notifyOrderStatusChanged(String orderID, String newStatus) throws RemoteException{
		SwingUtilities.invokeLater(() -> {
			String message = "[SERVER NOTIFICATION]["+formattedDateTime+"]Your order " + orderID + " has been "+newStatus+".\n";
			clientGUIFrame.getNotificationsTextArea().append(message);
		});
	}
	private static String buildOrderDetailsString(User user, String orderID, StringBuilder orderDetails, String modeOfDelivery, String modeOfPayment) {
		StringBuilder details = new StringBuilder();
		details.append("Official Receipt("+orderID+")"+"\n\n");
		details.append("Name: ").append(user.getFirstName()).append(" ").append(user.getLastName()).append("\n");
		details.append("Address: ").append(user.getStreet()).append(" ").append(user.getAdditionalAddressDetails()).append(" ");
		details.append(user.getCity()).append(", ").append(user.getProvince()).append(" ").append(user.getZip()).append("\n");
		details.append("Mode of Delivery: ").append(modeOfDelivery).append("\n");
		details.append("Mode of Payment: ").append(modeOfPayment).append("\n\n");
		details.append(orderDetails);
		return details.toString();
	}

	public void displayOrderHistory(List<Order> orderHistory) {
		SwingUtilities.invokeLater(() -> {
			DefaultTableModel model = (DefaultTableModel) clientGUIFrame.getOrderHistoryTable().getModel();
			model.setRowCount(0);
			for (Order order : orderHistory) {
				String orderId = order.getOrderId();
				String userId = order.getUserId();
				String status = order.getStatus();
				String modeOfDelivery = order.getModeOfDelivery();
				String paymentMethod = order.getPaymentMethod();
				String total = String.valueOf(order.getTotal());

				Object[] rowData = {orderId, userId, status, modeOfDelivery, paymentMethod, "₱"+total};

				model.addRow(rowData);
			}
		});
	}
}