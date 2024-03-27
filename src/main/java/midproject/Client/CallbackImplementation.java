package midproject.Client;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import midproject.SharedClasses.Interfaces.MessageCallback;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.ViewClasses.AdminGUIFrame;
import midproject.ViewClasses.ClientGUIFrame;

import javax.swing.*;

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