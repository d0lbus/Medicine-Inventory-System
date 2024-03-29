package midproject.SharedClasses.Implementations;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import midproject.SharedClasses.Interfaces.MessageCallback;
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


	public void updateOnlineUsers(int count) {
		System.out.println("Called updateOnlineUsers with count: " + count);
		SwingUtilities.invokeLater(() -> {
				System.out.println("Admin GUI frame is not null. Updating label.");
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

	public CallbackImplementation(User user, AdminGUIFrame adminGUIFrame) throws RemoteException {
		this.user = user;
		this.adminGUIFrame = adminGUIFrame;
	}

	public CallbackImplementation(User user, ClientGUIFrame clientGUIFrame) throws RemoteException {
		this.user = user;
		this.clientGUIFrame = clientGUIFrame;
	}

	public User getUser() throws RemoteException {
		return user;
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

	public void notifyUserArchivedByAdmin(String adminUsername, String archivedUsername) throws RemoteException {
		System.out.println(adminUsername + " archived user " + archivedUsername);
	}

	public void notifyUserUnarchivedByAdmin(String adminUsername, String unarchivedUsername) throws RemoteException {
		System.out.println(adminUsername + " unarchived user " + unarchivedUsername);
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


}