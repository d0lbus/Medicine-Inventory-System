package midproject.Client;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import midproject.SharedClasses.Interfaces.MessageCallback;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.ViewClasses.AdminGUIFrame;
import midproject.ViewClasses.ClientGUIFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CallbackImplementation extends UnicastRemoteObject implements MessageCallback, Serializable {
	private User user;
	private AdminGUIFrame adminGUIFrame;
	private ClientGUIFrame clientGUIFrame;


	public void updateOnlineUsers(int count) {
		System.out.println("Called updateOnlineUsers with count: " + count);
		SwingUtilities.invokeLater(() -> {
			if (adminGUIFrame != null) {
				System.out.println("Admin GUI frame is not null. Updating label.");
				String sCount = String.valueOf(count);
				adminGUIFrame.getOnlineUsersLabel().setText(sCount);
				adminGUIFrame.getOnlineUsersLabel().revalidate();
				adminGUIFrame.getOnlineUsersLabel().repaint();
			} else {
				System.err.println("Admin GUI frame is null.");
			}
		});
	}

	public void readUsersList(List<User> users) {
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

	public void updateRegisteredUsersTable(List<User> users) throws RemoteException {
		SwingUtilities.invokeLater(() -> {
			if (adminGUIFrame != null) {
				DefaultTableModel model = (DefaultTableModel) adminGUIFrame.getrUsersTable().getModel();
				model.setRowCount(0); // Clear the existing rows

				// Populate the table with the new list of users
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

	public void broadcastCall(User user, String msg) throws RemoteException {
		System.out.println("[" + user.getUsername() + "]: " + msg);
	}

	public void logoutCall(User user) throws RemoteException  {
		System.out.println(user.getUsername() + " logged out...");
	}
}