package midproject.Server;

import java.rmi.RemoteException;
import java.util.*;
import java.rmi.server.*;

import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.Interfaces.MessageCallback;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.AlreadyLoggedInException;
import midproject.SharedClasses.UserDefinedExceptions.AuthenticationFailedException;
import midproject.SharedClasses.UserDefinedExceptions.NotLoggedInException;
import midproject.SharedClasses.UserDefinedExceptions.UserExistsException;

import static midproject.SharedClasses.UserJSONProcessor.isValidCredentials;

public class ServerImplementation
		extends UnicastRemoteObject implements ModelInterface {

	private Map<String, MessageCallback> msgCallbacks =
			new Hashtable<>();


	public ServerImplementation() throws RemoteException {
	}

	public boolean login(MessageCallback msgCallback, String username, String password)
			throws RemoteException, UserExistsException, AlreadyLoggedInException, AuthenticationFailedException {
			User user = msgCallback.getUser();
			String filepath = "res/UserInformation.json";

		if (!isValidCredentials(username, password, filepath)) {
			throw new AuthenticationFailedException("Invalid username or password.");
		}
		if (msgCallbacks.containsValue(msgCallback)) {
			throw new AlreadyLoggedInException("Already logged in... you cannot login using the same client...");
		} else if (msgCallbacks.containsKey(username)) {
			throw new UserExistsException("Username already exists, use another name...");
		} else {
			msgCallbacks.put(username, msgCallback);
			System.out.println("Login successful: " + username);
		}
        return false;
    }


	// broadcast method implementation
	public void broadcast(MessageCallback msgCallback, String msg)
			throws RemoteException, NotLoggedInException {
		// check if msgCallback/session is not in the existing callback objects
		if (!msgCallbacks.containsValue(msgCallback)) {
			throw new NotLoggedInException();
		}
		// get user of mc/callback
		User user = msgCallback.getUser();
		// loop to send broadcast to all clients/callbacks
		for (String name : msgCallbacks.keySet()) {
			msgCallbacks.get(name).broadcastCall(user, msg);
		}
	}

	public void logout(MessageCallback msgCallback)
			throws RemoteException, NotLoggedInException {
		// check if msgCallback/session is not in the table of callbacks/clients
		// if callback is not found, the method is being called without
		// first logging in.
		if (!msgCallbacks.containsValue(msgCallback)) {
			throw new NotLoggedInException();
		}
		// get current user of callback
		User user = msgCallback.getUser();
		// remove session/callback from the table
		msgCallbacks.remove(user.getUsername());
		System.out.println("- logout: " + user.getUsername());
		System.out.print("online: [ ");
		for (String name : msgCallbacks.keySet()) {
			System.out.print(name + " ");
		}
		System.out.println("]");

		// loop to send logout message to all clients
		for (String name : msgCallbacks.keySet()) {
			msgCallbacks.get(name).logoutCall(user);
		}
	}

}