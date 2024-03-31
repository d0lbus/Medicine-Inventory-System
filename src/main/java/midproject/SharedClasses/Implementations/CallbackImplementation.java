package midproject.SharedClasses.Implementations;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import midproject.SharedClasses.Interfaces.MessageCallback;
import midproject.SharedClasses.ReferenceClasses.Medicine;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.ReferenceClasses.UserCallBackInfo;
import midproject.ViewClasses.AdminGUIFrame;
import midproject.ViewClasses.ClientGUIFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CallbackImplementation extends UnicastRemoteObject implements MessageCallback, Serializable {
	private User user;
	private UserCallBackInfo userInfo;

	private AdminGUIFrame adminGUIFrame;
	private ClientGUIFrame clientGUIFrame;

	// Get the current date and time
	LocalDateTime now = LocalDateTime.now();

	// Format the date and time
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

	public void updateOnlineUsers(int count) {
		SwingUtilities.invokeLater(() -> {
				String sCount = String.valueOf(count);
				adminGUIFrame.getOnlineUsersLabel().setText(sCount);
				adminGUIFrame.getOnlineUsersLabel().revalidate();
				adminGUIFrame.getOnlineUsersLabel().repaint();
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
			// Check if either Admin GUI or Client GUI frame is not null
			if (adminGUIFrame != null || clientGUIFrame != null) {
				// Update Admin GUI frame table if not null
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

				// Update Client GUI frame table if not null
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
		System.out.println("["+formattedDateTime+"]" + "ADMIN " + adminUsername + " registered user "
				+ "\nID: " + user.getUserId()
				+ "\nUser Type: " + user.getUserType()
				+ "\nUsername: " + user.getUsername()
				+ "\nFirst Name: " + user.getFirstName()
				+ "\nLast Name: " + user.getLastName());

	}
	public void notifyUserArchivedByAdmin(String adminUsername, String archivedUsername) throws RemoteException {
		System.out.println("["+formattedDateTime+"]" + "ADMIN " + adminUsername + " archived user " + archivedUsername);
	}

	public void notifyUserUnarchivedByAdmin(String adminUsername, String unarchivedUsername) throws RemoteException {
		System.out.println("["+formattedDateTime+"]" + "ADMIN " + adminUsername + " unarchived user " + unarchivedUsername);
	}

	public void notifyMedicineAddedByAdmin(String adminUsername, Medicine medicine) throws RemoteException{
		System.out.println("["+formattedDateTime+"]" + "ADMIN " + adminUsername + " added a new medicine: "
				+ "\nMedicine ID" + medicine.getMedicineID()
				+ "\nCategory: " + medicine.getCategory()
				+ "\nGeneric Name: " + medicine.getGenericName()
				+ "\nBrand Name: " + medicine.getBrandName()
				+ "\nForm: " + medicine.getForm()
				+ "\nQuantity: " + medicine.getQuantity()
				+ "\nPrice: " + medicine.getPrice());
	}

	public void notifyMedicineArchivedByAdmin(String adminUsername, Medicine medicine) throws RemoteException{
		System.out.println("["+formattedDateTime+"]" + "ADMIN " + adminUsername + " archived the medicine " + medicine.getGenericName() + " with a brand name " + medicine.getBrandName() + " under the category " + medicine.getCategory());
	}

	public void notifyMedicineUpdatedByAdmin(String adminUsername, Medicine editedMedicine, Medicine originalMedicine) throws RemoteException{
		System.out.println("["+formattedDateTime+"]" + "ADMIN " + adminUsername + " edited the medicine entry. Changes made: "
				+ "\nCategory: from '" + originalMedicine.getCategory() + "' to '" + editedMedicine.getCategory() + "'"
				+ "\nGeneric Name: from '" + originalMedicine.getGenericName() + "' to '" + editedMedicine.getGenericName() + "'"
				+ "\nBrand Name: from '" + originalMedicine.getBrandName() + "' to '" + editedMedicine.getBrandName() + "'"
				+ "\nForm: from '" + originalMedicine.getForm() + "' to '" + editedMedicine.getForm() + "'"
				+ "\nQuantity: from '" + originalMedicine.getQuantity() + "' to '" + editedMedicine.getQuantity() + "'"
				+ "\nPrice: from " + originalMedicine.getPrice() + " to " + editedMedicine.getPrice());
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
		});
	}


	/**CUSTOMER SIDE*/

	public void displayProfileDetails(User user) throws RemoteException{
		clientGUIFrame.getNameOnlyLabel().setText(user.getFirstName() + " " + user.getLastName());
	}

}