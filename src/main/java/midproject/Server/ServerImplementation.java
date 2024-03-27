package midproject.Server;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.*;
import java.rmi.server.*;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.Interfaces.MessageCallback;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.AlreadyLoggedInException;
import midproject.SharedClasses.UserDefinedExceptions.AuthenticationFailedException;
import midproject.SharedClasses.UserDefinedExceptions.NotLoggedInException;
import midproject.SharedClasses.UserDefinedExceptions.UserExistsException;
import midproject.SharedClasses.UserJSONProcessor;

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

    @Override
    public void unarchiveSelectedUsers(String userId, String originalFilePath, String archiveFilePath) throws Exception {

        // Retrieve the list of archived users
        List<User> archivedUsers = UserJSONProcessor.readUsersFromFile(archiveFilePath);

        // Find the user with the specified ID
        User userToUnarchive = null;
        for (User user : archivedUsers) {
            if (user.getUserId().equals(userId)) {
                userToUnarchive = user;
                break;
            }
        }

        // If user is not found in archive, throw exception
        if (userToUnarchive == null) {
            throw new Exception("User not found in archive");
        }

        // Add the user to the original file
        UserJSONProcessor.addUserToJsonFile(userToUnarchive, originalFilePath);

        // Remove the user from the archive file
        archivedUsers.remove(userToUnarchive);
        UserJSONProcessor.saveUsersToFile(archivedUsers, archiveFilePath);
    }

    public User viewArchivedUserDetails(String userId, String archiveFilePath) throws RemoteException, Exception {
        User archivedUser = UserJSONProcessor.getArchivedUser(userId, archiveFilePath);
        if (archivedUser != null) {
            return archivedUser;
        } else {
            throw new Exception("User not found in archive.");
        }
    }

    public List<User> getRegisteredUsers() throws RemoteException {
        String jsonFilePath = "res/UserInformation.json";
        List<User> users = new ArrayList<>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(jsonFilePath));
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            Gson gson = new Gson();
            for (JsonElement userElement : jsonArray) {
                User user = gson.fromJson(userElement, User.class);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RemoteException("Error reading from JSON file: " + e.getMessage());
        }
        return users;
    }

    /*
    public void searchArchivedUsers(String searchText) throws RemoteException {
        try {
            // Retrieve the list of archived users
            List<User> archivedUsers = UserJSONProcessor.searchArchivedUsers(searchText, "res/ArchivedUsers.json");

            for (MessageCallback callback : msgCallbacks.values()) {
                callback.sendArchivedUsersList(archivedUsers);
            }
        } catch (Exception e) {
            // Handle exceptions, if any
            e.printStackTrace();
            throw new RemoteException("Error searching archived user: " + e.getMessage());
        }
    }*/
}
