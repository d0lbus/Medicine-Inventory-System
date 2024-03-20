package midproject.Server;

import java.rmi.RemoteException;
import java.util.*;
import java.rmi.server.*;

import midproject.SharedClasses.LogInAndLogOutInterface;
import midproject.SharedClasses.MessageCallback;
import midproject.SharedClasses.User;
import midproject.SharedClasses.AlreadyLoggedInException;
import midproject.SharedClasses.UserExistsException;
import midproject.SharedClasses.NotLoggedInException;

// servant class: implementation of MessageServer (rough implementation)
public class ServerImplementation
		extends UnicastRemoteObject implements LogInAndLogOutInterface {
	// name is mapped to a messagecallback object
	private Map<String, MessageCallback> msgCallbacks =
			new Hashtable<>();

	// required constructor that throws RemoteException
	public ServerImplementation() throws RemoteException {
	}

	public void login(MessageCallback msgCallback)
			throws RemoteException, UserExistsException,
			AlreadyLoggedInException {
		User user = msgCallback.getUser();
		// check if callback instance already exists
		if (msgCallbacks.containsValue(msgCallback)) {
			throw new AlreadyLoggedInException("Already logged in... you cannot login using the same client...");
		} else if (msgCallbacks.containsKey(user.getUsername())) {
			// different callback instance but same name
			throw new UserExistsException("User name already exists, use another name...");
		} else {
			// new user, session; add msgCallback to the current collection of online clients
			msgCallbacks.put(user.getUsername(), msgCallback);
			System.out.println("login: " + user.getUsername());
			System.out.print("online: [ ");
			for (String name : msgCallbacks.keySet()) {
				System.out.print(name + " ");
			}
			System.out.println("]");

			// loop to send login notification to all clients
			for (String name : msgCallbacks.keySet()) {
				msgCallbacks.get(name).loginCall(user);
			}
		}
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
		msgCallbacks.remove(user.getName());
		System.out.println("- logout: " + user.getName());
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