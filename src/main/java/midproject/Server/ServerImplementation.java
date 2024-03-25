package midproject.Server;

import java.rmi.RemoteException;
import java.util.*;
import java.rmi.server.*;
import java.util.concurrent.ConcurrentHashMap;

import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.Interfaces.MessageCallback;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.AlreadyLoggedInException;
import midproject.SharedClasses.UserDefinedExceptions.AuthenticationFailedException;
import midproject.SharedClasses.UserDefinedExceptions.NotLoggedInException;
import midproject.SharedClasses.UserDefinedExceptions.UserExistsException;

import static midproject.SharedClasses.SessionIDGenerator.generateUniqueSessionId;
import static midproject.SharedClasses.UserJSONProcessor.isValidCredentials;

public class ServerImplementation
		extends UnicastRemoteObject implements ModelInterface {

	private Map<String, MessageCallback> msgCallbacks = new ConcurrentHashMap<>();
	private Map<String, String> sessionUserMap = new ConcurrentHashMap<>();



	public ServerImplementation() throws RemoteException {
	}

	public synchronized String login(MessageCallback msgCallback, String username, String password)
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
		}

		user.setUsername(username);
		String sessionId = generateUniqueSessionId();
		sessionUserMap.put(sessionId, username);
		msgCallbacks.put(username, msgCallback);
		msgCallback.loginCall(user);

		System.out.println("> User " + username + "logged in");

		return sessionId;
    }

	// broadcast method implementation
	public synchronized void broadcast(MessageCallback msgCallback, String msg)
			throws RemoteException, NotLoggedInException {
		// check if msgCallback/session is not in the existing callback objects
		if (!msgCallbacks.containsValue(msgCallback)) {
			//throw new NotLoggedInException();
		}
		// get user of mc/callback
		User user = msgCallback.getUser();
		// loop to send broadcast to all clients/callbacks
		for (String name : msgCallbacks.keySet()) {
			msgCallbacks.get(name).broadcastCall(user, msg);
		}
	}

	public synchronized void logout(MessageCallback msgCallback, String sessionID) throws RemoteException, NotLoggedInException {
		String username = sessionUserMap.get(sessionID);
		if (username == null || !msgCallbacks.containsKey(username)) {
			throw new NotLoggedInException("User not logged in or session not found.");
		}

		User user = msgCallback.getUser();
		user.setUsername(username);

		msgCallbacks.remove(username);
		sessionUserMap.remove(sessionID);
		msgCallback.logoutCall(user);
		System.out.println("> User " + username + "logged out");
	}

}