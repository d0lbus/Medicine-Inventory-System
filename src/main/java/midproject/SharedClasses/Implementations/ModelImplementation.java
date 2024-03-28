package midproject.SharedClasses.Implementations;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.*;
import java.rmi.server.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.Interfaces.MessageCallback;
import midproject.SharedClasses.ReferenceClasses.User;
import midproject.SharedClasses.UserDefinedExceptions.*;
import midproject.SharedClasses.Utilities.UserJSONProcessor;

import static midproject.SharedClasses.Utilities.SessionIDGenerator.generateUniqueSessionId;
import static midproject.SharedClasses.Utilities.UserJSONProcessor.isValidCredentials;

public class ModelImplementation extends UnicastRemoteObject implements ModelInterface {

    private Map<String, MessageCallback> msgCallbacks = new ConcurrentHashMap<>();
    private Map<String, String> sessionUserMap = new ConcurrentHashMap<>();

    public ModelImplementation() throws RemoteException {
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

        notifyOnlineUsersChanged();
        return sessionId;
    }


    public void notifyOnlineUsersChanged() {
        int onlineUsersCount = sessionUserMap.size();
        System.out.println("Updating online users count...");
        msgCallbacks.values().forEach(callback -> {
            try {
                callback.updateOnlineUsers(onlineUsersCount);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
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

        notifyOnlineUsersChanged();
        msgCallback.logoutCall(user);

        System.out.println("> User " + username + "logged out");
    }

    public synchronized void updateRegisteredUsersTable(MessageCallback msgCallback) throws Exception {
        String filepath = "res/UserInformation.json";
        List<User> usersList = UserJSONProcessor.readUsersFromFile(filepath);
        msgCallback.readUsersList(usersList);
    }

    public synchronized void updateRegisterUsersCount(MessageCallback msgCallback) throws Exception {
        String filepath = "res/UserInformation.json";
        List<User> usersList = UserJSONProcessor.readUsersFromFile(filepath);
        msgCallback.countUsersList(usersList);
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
    public void registerUser(User newUser) throws RemoteException, InvalidInputException {
        // Generate unique user ID
        String userId = generateUserId(newUser.getUserType());
        newUser.setUserId(userId);
        // Add the user to the JSON file
        String filePath = "res/UserInformation.json";
        UserJSONProcessor.addUserToJsonFile(newUser, filePath);

    }

    private String generateUserId(String userType) {
        List<String> userIds = UserJSONProcessor.loadUserIdsFromJsonFile("res/UserInformation.json", "res/UserIDTracker.txt");
        int maxId = 0;
        Pattern pattern = Pattern.compile("[A-Z](\\d+)");
        for (String userId : userIds) {
            Matcher matcher = pattern.matcher(userId);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                if (id > maxId) {
                    maxId = id;
                }
            }
        }
        String prefix = userType.equals("Admin") ? "A" : "C";
        return prefix + (maxId + 1);
    }
}
