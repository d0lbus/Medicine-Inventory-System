package midproject.SharedClasses;

import midproject.Client.CallbackImplementation;

import java.rmi.*;

public interface LogInAndLogOutInterface extends Remote {
	// method to log in to the chat system (msgCallback is used
	// as a callback and session manager/identifier)
	public void login(MessageCallback msgCallback, String username, String password)
			throws RemoteException, UserExistsException,
			AlreadyLoggedInException, AuthenticationFailedException;

	// method to broadcast a message to all logged in clients
	// using msgCallback as session manager/identifier
	public void broadcast(MessageCallback msgCallback, String msg)
			throws RemoteException, NotLoggedInException;

	// method to logout from the chat system using msgCallback as
	// the session manager/identifier
	public void logout(MessageCallback msgCallback)
			throws RemoteException, NotLoggedInException;

}