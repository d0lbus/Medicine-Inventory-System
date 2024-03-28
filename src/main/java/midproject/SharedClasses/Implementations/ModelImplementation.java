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
import midproject.SharedClasses.ReferenceClasses.*;
import midproject.SharedClasses.UserDefinedExceptions.*;
import midproject.SharedClasses.Utilities.UserJSONProcessor;

import static midproject.SharedClasses.Utilities.SessionIDGenerator.generateUniqueSessionId;
import static midproject.SharedClasses.Utilities.UserJSONProcessor.*;


public class ModelImplementation extends UnicastRemoteObject implements ModelInterface {

    private Map<UserCallBackInfo, MessageCallback> msgCallbacks = new ConcurrentHashMap<>();
    private Map<String, String> sessionUserMap = new ConcurrentHashMap<>();

    public ModelImplementation() throws RemoteException {
    }

    /**
    *
    * LOGIN AND LOGOUT METHODS
    *
    * */

    public synchronized String login(MessageCallback msgCallback, String username, String password, String userTypeRequest)
            throws RemoteException, UserExistsException, AlreadyLoggedInException, AuthenticationFailedException {
        try {
            User user = msgCallback.getUser();
            String filepath = "res/UserInformation.json";

            if (!isValidCredentials(username, password, filepath, userTypeRequest)) {
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

            UserCallBackInfo userCallBackInfo = new UserCallBackInfo(username, userTypeRequest);
            msgCallbacks.put(userCallBackInfo, msgCallback);

            msgCallback.loginCall(user);
            System.out.println("> User " + username + "logged in");

            notifyOnlineUsersChanged();

            return sessionId;

        } catch (AuthenticationFailedException e) {
            // Handle invalid credentials
            System.err.println("Authentication failed: " + e.getMessage());
            throw e;
        } catch (AlreadyLoggedInException e) {
            // Handle already logged in
            System.err.println("User already logged in: " + e.getMessage());
            throw e;
        } catch (UserExistsException e) {
            // Handle user already exists
            System.err.println("Username already exists: " + e.getMessage());
            throw e;
        } catch (RemoteException e) {
            // Handle RemoteException
            System.err.println("Remote exception occurred: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            // Catch-all for other exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
            // Consider what to do here: rethrow, convert to a specific exception, etc.
            throw new RemoteException("An unexpected error occurred.", e);
        }
    }

    public synchronized void logout(MessageCallback msgCallback, String sessionID) throws Exception {
        String username = sessionUserMap.get(sessionID);
        String userType = getUserTypeByUsername("res/UserInformation.json", username);

        UserCallBackInfo lookupKey = new UserCallBackInfo(username, userType);

        boolean containsUsername = false;
        for (UserCallBackInfo key : msgCallbacks.keySet()) {
            if (key.getUsername().equals(username)) {
                containsUsername = true;
                break;
            }
        }
        if (username == null || !containsUsername) {
            throw new NotLoggedInException("User not logged in or session not found.");
        }

        User user = msgCallback.getUser();
        user.setUsername(username);

        // When removing, ensure we're using the lookupKey variable
        msgCallbacks.remove(lookupKey);
        sessionUserMap.remove(sessionID);

        notifyOnlineUsersChanged();
        msgCallback.logoutCall(user);

        System.out.println("> User " + username + "logged out");
    }


    /**
     * BROADCASTING METHODS
     *
     * */


    public synchronized void broadcast(MessageCallback msgCallback, String msg)
            throws RemoteException, NotLoggedInException {
        if (!msgCallbacks.containsValue(msgCallback)) {
            //throw new NotLoggedInException();
        }
        for (UserCallBackInfo userCallBackInfo : msgCallbacks.keySet()) {
            msgCallbacks.get(userCallBackInfo.getUsername()).broadcastCall(msg);
        }
    }


    /**
     *
     * DASHBOARD RELATED METHODS
     *
     * */

    /**
     *
     * REGISTERED USERS RELATED METHODS
     *
     * */

    /**
     *
     * ARCHIVED USERS RELATED METHODS
     *
     * */

    /**
     *
     * REGISTER USER RELATED METHODS
     *
     * */

    /**
     *
     * ORDERS RELATED METHODS
     *
     * */

    /**
     *
     * PENDING ORDERS RELATED METHODS
     *
     * */




    public void notifyOnlineUsersChanged() {
        int onlineUsersCount = sessionUserMap.size();
        System.out.println("Updating online users count...");
        msgCallbacks.entrySet().forEach(entry -> {
            UserCallBackInfo userInfo = entry.getKey();
            MessageCallback callback = entry.getValue();
            if ("Admin".equals(userInfo.getUserType())) {
                try {
                    callback.updateOnlineUsers(onlineUsersCount);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
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
