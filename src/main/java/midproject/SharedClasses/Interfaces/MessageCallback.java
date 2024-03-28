package midproject.SharedClasses.Interfaces;

import midproject.SharedClasses.ReferenceClasses.User;
import midproject.ViewClasses.AdminGUIFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface MessageCallback extends Remote {
	// method to get the current user of the callback/session
	public User getUser() throws RemoteException;

	// method called by server when other clients log in
	// user data is sent as parameter
	public void loginCall(User user) throws RemoteException;

	// method called by server when a message is sent by clients
	// user/sender and message sent as parameter
	public void broadcastCall(User user, String msg) throws RemoteException;

	// method called by server when a user logs out from the system
	// user logging out sent as parameter

	public void logoutCall(User user) throws RemoteException;
    //public void sendArchivedUsersList(List<User> archivedUsers);

	public void updateOnlineUsers(int count) throws RemoteException;

	public void readUsersList(List<User> users) throws RemoteException;

	public void countUsersList(List<User> users) throws RemoteException;


}