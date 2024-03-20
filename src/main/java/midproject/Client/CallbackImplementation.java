package midproject.Client;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import midproject.SharedClasses.Interfaces.MessageCallback;
import midproject.SharedClasses.ReferenceClasses.User;

public class CallbackImplementation extends UnicastRemoteObject implements MessageCallback, Serializable {
	private User user;

	public CallbackImplementation(User user) throws RemoteException {
		this.user = user;
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