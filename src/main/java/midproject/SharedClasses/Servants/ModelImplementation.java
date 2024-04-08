package midproject.SharedClasses.Servants;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.*;
import java.rmi.server.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import midproject.SharedClasses.Interfaces.ModelInterface;
import midproject.SharedClasses.Interfaces.MessageCallback;
import midproject.SharedClasses.ReferenceClasses.*;
import midproject.SharedClasses.UserDefinedExceptions.*;
import midproject.SharedClasses.Utilities.MedicineJSONProcessor;
import midproject.SharedClasses.Utilities.OrderJSONProcessor;
import midproject.SharedClasses.Utilities.UserJSONProcessor;
import midproject.SharedClasses.Utilities.CartJSONProcessor;

import static midproject.SharedClasses.Utilities.OrderJSONProcessor.readOrdersFromFile;
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
            boolean containsUsername = false;

            for (UserCallBackInfo key : msgCallbacks.keySet()) {
                if (key.getUsername().equals(username)) {
                    containsUsername = true;
                    break;
                }
            }
            if (!isValidCredentials(username, password, filepath, userTypeRequest)) {
                throw new AuthenticationFailedException("Invalid username or password.");
            }
            if (msgCallbacks.containsValue(msgCallback)) {
                throw new AlreadyLoggedInException("Already logged in... you cannot login using the same client...");
            } else if (containsUsername) {
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

    public synchronized void logout(MessageCallback msgCallback, String sessionID) throws Exception{
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

    /**ADMIN SIDE**/

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

    public void sendRUserDetailsToAdmins(String userId, MessageCallback messageCallback) {
        try {
        User user = getUserById("res/UserInformation.json", userId);
            messageCallback.displayUserDetails(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void archiveUser(String userId, MessageCallback callback, String adminUsername) throws RemoteException {
        try {
            User userToArchive = getUserById("res/UserInformation.json", userId);
            UserJSONProcessor.transferUserToDifferentFile(userId, "res/UserInformation.json", "res/ArchivedUsers.json");

            for (Map.Entry<UserCallBackInfo, MessageCallback> entry : msgCallbacks.entrySet()) {
                UserCallBackInfo userInfo = entry.getKey();
                MessageCallback adminCallback = entry.getValue();

                if ("Admin".equals(userInfo.getUserType())) {
                    adminCallback.notifyUserArchivedByAdmin(adminUsername, userToArchive.getUsername());
                }
            }
        } catch (Exception e) {
            throw new RemoteException("Failed to archive user: " + e.getMessage());
        }
    }

    public void searchUsers(String searchText, MessageCallback callback) throws RemoteException, NoUserFoundException {
        try {
            List<User> allUsers = readUsersFromFile("res/UserInformation.json");

            List<User> searchResults = allUsers.stream()
                    .filter(user ->
                                    user.getUserType().toLowerCase().contains(searchText.toLowerCase()) ||
                            user.getUserId().toLowerCase().contains(searchText.toLowerCase()) ||
                            user.getUsername().toLowerCase().contains(searchText.toLowerCase()) ||
                            user.getFirstName().toLowerCase().contains(searchText.toLowerCase()) ||
                            user.getLastName().toLowerCase().contains(searchText.toLowerCase())
                    )
                    .collect(Collectors.toList());

            if (searchResults.isEmpty()) {
                throw new NoUserFoundException("No user '" + searchText + "' found");
            }

            callback.sendSearchResults(searchResults);
        } catch (NoUserFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RemoteException("Error while searching users", e);
        }
    }

    public void updateUser(User editedUser, User originalUser, MessageCallback callback, String adminUsername) throws RemoteException, SelectionRequiredException {

        try {
            UserJSONProcessor.updateUserInJsonFile(editedUser, "res/UserInformation.json");


            for (Map.Entry<UserCallBackInfo, MessageCallback> entry : msgCallbacks.entrySet()) {
                UserCallBackInfo userInfo = entry.getKey();
                MessageCallback adminCallback = entry.getValue();

                if ("Admin".equals(userInfo.getUserType()) || "Customer".equals(userInfo.getUserType())) {
                    adminCallback.notifyUserUpdatedByAdmin(adminUsername, editedUser, originalUser);
                }
            }
        } catch (SelectionRequiredException e) {
            throw new SelectionRequiredException("Please select a user first.");
        } catch (Exception e) {
            throw new RemoteException("Error while editing user", e);
        }


    }

    /**
     *
     * ARCHIVED USERS RELATED METHODS
     *
     * */

    public void unarchiveUser(String userId, MessageCallback callback, String adminUsername) throws UserUnarchiveException {
        try {
            User userToUnarchive = getUserById("res/ArchivedUsers.json", userId);
            UserJSONProcessor.transferUserToDifferentFile(userId, "res/ArchivedUsers.json", "res/UserInformation.json");

            for (Map.Entry<UserCallBackInfo, MessageCallback> entry : msgCallbacks.entrySet()) {
                UserCallBackInfo userInfo = entry.getKey();
                MessageCallback adminCallback = entry.getValue();

                if ("Admin".equals(userInfo.getUserType())) {
                    adminCallback.notifyUserUnarchivedByAdmin(adminUsername, userToUnarchive.getUsername());
                }
            }
        } catch (Exception e) {
            throw new UserUnarchiveException("Failed to unarchive user: " + e.getMessage());
        }
    }

    public void sendAUserDetailsToAdmins(String userId, MessageCallback messageCallback) {
        try {
            User user = getUserById("res/ArchivedUsers.json", userId);
            messageCallback.displayUserDetails(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void searchArchivedUsers(String searchText, MessageCallback callback) throws RemoteException, NoUserFoundException {
        try {
            List<User> allUsers = readUsersFromFile("res/ArchivedUsers.json");

            List<User> searchResults = allUsers.stream()
                    .filter(user ->
                            user.getUserType().toLowerCase().contains(searchText.toLowerCase()) ||
                                    user.getUserId().toLowerCase().contains(searchText.toLowerCase()) ||
                                    user.getUsername().toLowerCase().contains(searchText.toLowerCase()) ||
                                    user.getFirstName().toLowerCase().contains(searchText.toLowerCase()) ||
                                    user.getLastName().toLowerCase().contains(searchText.toLowerCase())
                    )
                    .collect(Collectors.toList());

            if (searchResults.isEmpty()) {
                throw new NoUserFoundException("No user '" + searchText + "' found");
            }

            callback.sendArchivedUserSearchResults(searchResults);
        } catch (NoUserFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RemoteException("Error while searching users", e);
        }
    }

    /**
     *
     * REGISTER USER RELATED METHODS
     *
     * */

    public void registerUser(User newUser, String adminUsername) throws RemoteException, InvalidInputException {
        String userId = generateUserId(newUser.getUserType());
        newUser.setUserId(userId);
        String filePath = "res/UserInformation.json";
        UserJSONProcessor.addUserToJsonFile(newUser, filePath);

        for (Map.Entry<UserCallBackInfo, MessageCallback> entry : msgCallbacks.entrySet()) {
            UserCallBackInfo userInfo = entry.getKey();
            MessageCallback adminCallback = entry.getValue();
            if ("Admin".equals(userInfo.getUserType())) {
                adminCallback.notifyUserRegisteredByAdmin(adminUsername, newUser);
            }
        }

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

    /**
     *
     * ORDERS AND PENDING ORDERS RELATED METHODS
     *
     * */

    public void updateOrderStatus(String orderId, String newStatus) throws RemoteException{
        try {
            Order order = OrderJSONProcessor.readOrderById(orderId);
            order.setStatus(newStatus);
            OrderJSONProcessor.writeOrderToFile(order);
            updateOrdersTable();
            String userId = order.getUserId();
            User user = getUserDetailsbyId(userId);
            msgCallbacks.entrySet().stream()
                    .filter(entry -> entry.getKey().getUsername().equals(user.getUsername()))
                    .findFirst()
                    .ifPresent(entry -> {
                        try {
                            entry.getValue().notifyOrderStatusChanged(orderId, newStatus);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    });
        notifyNewPendingOrders();
        notifyNewOrders();
        } catch (Exception e){
        }
    }

    public void searchOrders(String searchText, MessageCallback callback) throws RemoteException {
        try {
            List<Order> allOrders = OrderJSONProcessor.readOrdersFromFile("res/Orders.json");

            // Filter the orders to exclude any with "Pending" status.
            List<Order> searchResults = allOrders.stream()
                    .filter(order -> !order.getStatus().equalsIgnoreCase("Pending") &&
                            (order.getOrderId().toLowerCase().contains(searchText.toLowerCase()) ||
                                    order.getUserId().toLowerCase().contains(searchText.toLowerCase()) ||
                                    order.getPaymentMethod().toLowerCase().contains(searchText.toLowerCase()) ||
                                    order.getModeOfDelivery().toLowerCase().contains(searchText.toLowerCase()) ||
                                    order.getTotal().toString().contains(searchText.toLowerCase())))
                    .collect(Collectors.toList());

            // Send the filtered results back to the client
            callback.sendOrderSearchResults(searchResults);
        } catch (Exception e) {
            throw new RemoteException("Error while searching orders", e);
        }
    }

    public void searchPendingOrders(String searchText, MessageCallback callback) throws RemoteException {
        try {
            List<Order> allOrders = OrderJSONProcessor.readOrdersFromFile("res/Orders.json");

            // Filter the orders to include only those with "Pending" status.
            List<Order> searchResults = allOrders.stream()
                    .filter(order -> order.getStatus().equalsIgnoreCase("Pending") &&
                            (order.getOrderId().toLowerCase().contains(searchText.toLowerCase()) ||
                                    order.getUserId().toLowerCase().contains(searchText.toLowerCase()) ||
                                    order.getPaymentMethod().toLowerCase().contains(searchText.toLowerCase()) ||
                                    order.getModeOfDelivery().toLowerCase().contains(searchText.toLowerCase()) ||
                                    order.getTotal().toString().contains(searchText.toLowerCase())))
                    .collect(Collectors.toList());

            // Send the filtered results back to the client
            callback.sendPendingOrderSearchResults(searchResults);
        } catch (Exception e) {
            throw new RemoteException("Error while searching orders", e);
        }
    }
    /**
     *
     *
     * INVENTORY RELATED METHODS
     *
     * */

    public void addMedicine(Medicine medicine, MessageCallback callback, String adminUsername) throws Exception{
        MedicineJSONProcessor.addMedicineToFile(medicine, "res/Medicine.json");
        for (Map.Entry<UserCallBackInfo, MessageCallback> entry : msgCallbacks.entrySet()) {
            UserCallBackInfo userInfo = entry.getKey();
            MessageCallback adminCallback = entry.getValue();
            if ("Admin".equals(userInfo.getUserType())) {
                adminCallback.notifyMedicineAddedByAdmin(adminUsername, medicine);
            }
        }
    }

    public void deleteMedicine(Medicine medicine, MessageCallback callback, String adminUsername) throws Exception{
        MedicineJSONProcessor.removeSpecificMedicine(medicine, "res/Medicine.json");

        for (Map.Entry<UserCallBackInfo, MessageCallback> entry : msgCallbacks.entrySet()) {
            UserCallBackInfo userInfo = entry.getKey();
            MessageCallback adminCallback = entry.getValue();

            if ("Admin".equals(userInfo.getUserType())) {
                adminCallback.notifyMedicineArchivedByAdmin(adminUsername, medicine);
            }
        }
    }

    public void searchMedicine(String searchText, MessageCallback callback) throws RemoteException {
        try {
            List<Medicine> allMedicine = MedicineJSONProcessor.readMedicinesFromFile("res/Medicine.json");

            List<Medicine> searchResults = allMedicine.stream()
                    .filter(medicine ->
                            medicine.getMedicineID().toLowerCase().contains(searchText.toLowerCase()) ||
                            medicine.getCategory().toLowerCase().contains(searchText.toLowerCase()) ||
                                    medicine.getBrandName().toLowerCase().contains(searchText.toLowerCase()) ||
                                    medicine.getGenericName().toLowerCase().contains(searchText.toLowerCase()) ||
                                    medicine.getForm().toLowerCase().contains(searchText.toLowerCase()) ||
                                    String.valueOf(medicine.getQuantity()).contains(searchText) ||
                                    String.valueOf(medicine.getPrice()).contains(searchText)
                    )
                    .collect(Collectors.toList());
            callback.sendMedicineSearchResults(searchResults);
        } catch (Exception e) {
            throw new RemoteException("Error while searching users", e);
        }
    }

    public void updateMedicine(Medicine editedMedicine, Medicine originalMedicine, MessageCallback callback, String adminUsername) throws Exception {
        MedicineJSONProcessor.updateMedicine(editedMedicine, "res/Medicine.json");

        msgCallbacks.entrySet().forEach(entry -> {UserCallBackInfo userInfo = entry.getKey();
            MessageCallback callBack = entry.getValue();
            if ("Admin".equals(userInfo.getUserType()) || "Customer".equals(userInfo.getUserType())) {
                try {
                    callBack.notifyMedicineUpdatedByAdmin(adminUsername, editedMedicine, originalMedicine);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }});

        Map<String, UserCart> allUserCarts = CartJSONProcessor.readUserCartsFromFile();
        boolean cartUpdated = false;

        for (Map.Entry<String, UserCart> entry : allUserCarts.entrySet()) {
            String userId = entry.getKey();
            UserCart cart = entry.getValue();

            if (cart.getItems().containsKey(editedMedicine.getMedicineID())) {
                cart.addOrUpdateItem(editedMedicine.getMedicineID(), cart.getItems().get(editedMedicine.getMedicineID()));
                cartUpdated = true;

            }
        }

        if (cartUpdated) {
            CartJSONProcessor.writeUserCartsToFile(allUserCarts);
        }

        for (Map.Entry<UserCallBackInfo, MessageCallback> entry : msgCallbacks.entrySet()) {
            UserCallBackInfo userInfo = entry.getKey();
            MessageCallback customerCallback = entry.getValue();
            if ("Customer".equals(userInfo.getUserType())) {
                try {
                    String userId = "";
                    try {
                        User user = UserJSONProcessor.getUserByUsername("res/UserInformation.json", userInfo.getUsername());
                        if (user != null) {
                            userId = user.getUserId();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    UserCart updatedCart = allUserCarts.get(userId);
                    if (updatedCart != null && !updatedCart.getItems().isEmpty()) {
                        customerCallback.updateCart(updatedCart);
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * MESSAGE RELATED METHODS
     *
     * */

    public synchronized void broadcast(String username, String msg) throws Exception {
        User user = UserJSONProcessor.getUserByUsername("res/UserInformation.json", username);

        if (username.equals("All")){
            for (Map.Entry<UserCallBackInfo, MessageCallback> entry : msgCallbacks.entrySet()) {
                UserCallBackInfo userInfo = entry.getKey();
                MessageCallback callback = entry.getValue();

                if ("Customer".equals(userInfo.getUserType())) {
                    try {
                        callback.broadcastCall(msg);
                    } catch (RemoteException e) {
                        System.err.println("Failed to broadcast message to " + userInfo.getUsername() + ": " + e.getMessage());
                    }
                }
            }
        } else {
            msgCallbacks.entrySet().stream()
                    .filter(entry -> entry.getKey().getUsername().equals(user.getUsername()))
                    .findFirst()
                    .ifPresent(entry -> {
                        try {
                            entry.getValue().broadcastCall(msg);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    /**
     *
     * AUTO REFRESH REALTED METHODS
     *
     * */

    public void updateDashboard() throws Exception{
        notifyNewPendingOrders();
        notifyNewOrders();
    }
    public void updateRegisteredUsersTable() throws Exception {
        String filepath = "res/UserInformation.json";
        List<User> usersList = UserJSONProcessor.readUsersFromFile(filepath);

        msgCallbacks.entrySet().forEach(entry -> {
            UserCallBackInfo userInfo = entry.getKey();
            MessageCallback callback = entry.getValue();

            if ("Admin".equals(userInfo.getUserType())) {
                try {
                    callback.readRUsersList(usersList);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void updateArchivedUsersTable() throws Exception {
        String filepath = "res/ArchivedUsers.json";
        List<User> usersList = UserJSONProcessor.readUsersFromFile(filepath);

        msgCallbacks.entrySet().forEach(entry -> {
            UserCallBackInfo userInfo = entry.getKey();
            MessageCallback callback = entry.getValue();

            if ("Admin".equals(userInfo.getUserType())) {
                try {
                    callback.readAUsersList(usersList);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void updateInventoryTable() throws Exception{
        String filepath = "res/Medicine.json";
        List<Medicine> medicineList = MedicineJSONProcessor.readMedicinesFromFile(filepath);
        msgCallbacks.entrySet().forEach(entry -> {
            UserCallBackInfo userInfo = entry.getKey();
            MessageCallback callback = entry.getValue();
            if ("Admin".equals(userInfo.getUserType()) || "Customer".equals(userInfo.getUserType())) {
                try {
                    callback.readMedicineList(medicineList);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void updateUnarchivedUsersTable() throws Exception {
        String filepath = "res.UserInformation.json";
        List<User> userList = UserJSONProcessor.readUsersFromFile(filepath);

        msgCallbacks.entrySet().forEach( entry -> {
            UserCallBackInfo userInfo = entry.getKey();
            MessageCallback callback = entry.getValue();

            if ("Admin".equals(userInfo.getUserType())) {
                try {
                    callback.readRUsersList(userList);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void updateRegisteredUsersCount() throws Exception {
        String filepath = "res/UserInformation.json";
        List<User> usersList = UserJSONProcessor.readUsersFromFile(filepath);
        msgCallbacks.entrySet().forEach(entry -> {
            UserCallBackInfo userInfo = entry.getKey();
            MessageCallback callback = entry.getValue();

            if ("Admin".equals(userInfo.getUserType())) {
                try {
                    callback.countUsersList(usersList); // Adjust callback method to accept count directly
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void updateOrdersTable() throws Exception {
        String filepath = "res/Orders.json";
        List<Order> orderList = readOrdersFromFile(filepath);

        msgCallbacks.entrySet().forEach(entry -> {
            UserCallBackInfo userInfo = entry.getKey();
            MessageCallback callback = entry.getValue();

            if ("Admin".equals(userInfo.getUserType())) {
                try {
                    callback.readOrdersList(orderList);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Order retrieveOrderDetails(String orderId) throws RemoteException{
        Order order = new Order();
        try {
            order = OrderJSONProcessor.readOrderById(orderId);
        } catch (Exception e){

        }
        return order;
    }

    /**
     *
     * NOTIFICATION FOR ADMINS RELATED METHODS
     *
     * */

    public void notifyOnlineUsersChanged() throws RemoteException {
        int onlineUsersCount = sessionUserMap.size();
        List<String> onlineUserNames = getOnlineUsernames();
        System.out.println("Updating online users count...");
        if (onlineUsersCount == 0) {
            System.out.println("No users are online.");
        } else {
            msgCallbacks.entrySet().forEach(entry -> {
                UserCallBackInfo userInfo = entry.getKey();
                MessageCallback callback = entry.getValue();
                if ("Admin".equals(userInfo.getUserType())) {
                    try {
                        callback.updateOnlineUsers(onlineUsersCount, onlineUserNames);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public List<String> getOnlineUsernames() throws RemoteException {
        return new ArrayList<>(sessionUserMap.values());
    }
    public void notifyNewOrders() throws IOException {
        List<Order> orders = readOrdersFromFile("res/Orders.json");
        long pendingCount = orders.stream()
                .filter(order -> "Pending".equals(order.getStatus()))
                .count();
        long otherCount = orders.size() - pendingCount;

        msgCallbacks.entrySet().forEach(entry -> {
            UserCallBackInfo userInfo = entry.getKey();
            MessageCallback callback = entry.getValue();
            if ("Admin".equals(userInfo.getUserType())) {
                try {
                    callback.updateOrdersCount((int) otherCount);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void notifyNewPendingOrders() throws IOException {
        List<Order> orders = readOrdersFromFile("res/Orders.json");
        long pendingCount = orders.stream()
                .filter(order -> "Pending".equals(order.getStatus()))
                .count();
        msgCallbacks.entrySet().forEach(entry -> {
            UserCallBackInfo userInfo = entry.getKey();
            MessageCallback callback = entry.getValue();
            if ("Admin".equals(userInfo.getUserType())) {
                try {
                    callback.updatePendingOrdersCount((int) pendingCount);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**CUSTOMER SIDE**/

    public User getUserDetailsbyId(String userID) throws Exception {
        User user = UserJSONProcessor.getUserById("res/UserInformation.json", userID);;
        return user;
    }
    public User getUserDetails(String username, MessageCallback msgCallback) throws Exception {
        User user = UserJSONProcessor.getUserByUsername("res/UserInformation.json", username);
        msgCallback.displayProfileDetails(user);
        return user;
    }

    public User getUserByUsername(String username) throws RemoteException {
        try {
            return UserJSONProcessor.getUserByUsername("res/UserInformation.json", username);
        } catch (Exception e) {
            throw new RemoteException("Error retrieving user information: " + e.getMessage(), e);
        }
    }

    public boolean validateOldPassword(String username, String oldPassword) throws RemoteException {
        try {
            return UserJSONProcessor.validateOldPassword(username, oldPassword);
        } catch (Exception e) {
            throw new RemoteException("Error validating old password: " + e.getMessage(), e);
        }
    }

    public void updateUserPassword(String username, String newPassword) throws RemoteException {
        try {
            UserJSONProcessor.updateUserPassword(username, newPassword);
        } catch (Exception e) {
            throw new RemoteException("Error updating user password: " + e.getMessage(), e);
        }
    }

    public boolean changeUserPassword(String username, String oldPassword, String newPassword, MessageCallback clientCallback) throws RemoteException {
        try {
            if (validateOldPassword(username, oldPassword)) {
                updateUserPassword(username, newPassword);
                clientCallback.notifyPasswordChangeResult(true, "Password changed successfully.");
                return true;
            } else {
                clientCallback.notifyPasswordChangeResult(false, "Invalid old password.");
                return false;
            }
        } catch (Exception e) {
            clientCallback.notifyPasswordChangeResult(false, "Error changing password: " + e.getMessage());
            return false;
        }
    }

    public List<Order> getOrderHistory(String username, MessageCallback clientCallback) throws RemoteException {
        try {
            User user = UserJSONProcessor.getUserByUsername("res/UserInformation.json", username);
            String userId = user.getUserId();
            List<Order> orderHistory = OrderJSONProcessor.getOrdersByUserId("res/Orders.json", userId);
            clientCallback.displayOrderHistory(orderHistory); // Call the displayOrderHistory method
            return orderHistory;
        } catch (Exception e) {
            throw new RemoteException("Error retrieving order history: " + e.getMessage(), e);
        }
    }

    public void getCartDetails(String username, MessageCallback clientCallback) throws RemoteException{
        try {
            User user = UserJSONProcessor.getUserByUsername("res/UserInformation.json", username);
            String userID = user.getUserId();
            Map<String, UserCart> userCarts = CartJSONProcessor.readUserCartsFromFile();
            UserCart userCart = userCarts.getOrDefault(userID, new UserCart(userID));
            userCarts.put(userID, userCart);
            clientCallback.updateCart(userCart);
        } catch (Exception e){

        }
    }
    public synchronized void addMedicineToCart(String medicineId, int quantity, MessageCallback clientCallback, String username) throws RemoteException {
        try {
            // Retrieve user by username to get the userID
            User user = UserJSONProcessor.getUserByUsername("res/UserInformation.json", username);
            String userID = user.getUserId();

            // Retrieve all user carts
            Map<String, UserCart> userCarts = CartJSONProcessor.readUserCartsFromFile();

            // Get the user's cart from the map, create a new one if it doesn't exist
            UserCart userCart = userCarts.getOrDefault(userID, new UserCart(userID));

            // Add the medicine to the cart
            userCart.addOrUpdateItem(medicineId, quantity);

            // Put the updated cart back in the map
            userCarts.put(userID, userCart);

            // Save the updated map of all user carts back to the file
            CartJSONProcessor.writeUserCartsToFile(userCarts);

            clientCallback.updateCart(userCart);
        } catch (Exception e) {
            // Handle exceptions
            throw new RemoteException("Error adding medicine to cart: " + e.getMessage(), e);
        }
    }
    public synchronized void updateMedicineQuantityInCart(String medicineId, int newQuantity, MessageCallback clientCallback, String username) throws RemoteException {
        try {
            Map<String, UserCart> userCarts = CartJSONProcessor.readUserCartsFromFile();

            User user = UserJSONProcessor.getUserByUsername("res/UserInformation.json", username);
            String userId = user.getUserId();

            if (userId == null || !userCarts.containsKey(userId)) {
                throw new RemoteException("Cart for user not found.");
            }

            // Retrieve the user's cart.
            UserCart userCart = userCarts.get(userId);

            if (userCart == null) {
                throw new RemoteException("Cart not initialized correctly.");
            }

            // Update the quantity of the specified medicine in the cart.
            userCart.updateMedicineQuantity(medicineId, newQuantity);

            // Save the updated cart back to the file.
            CartJSONProcessor.writeUserCartsToFile(userCarts);

            // Notify the user's client about the cart update.
            clientCallback.updateCart(userCart);

        } catch (Exception e) {
            throw new RemoteException("Error updating medicine quantity in cart: " + e.getMessage(), e);
        }
    }
    public synchronized void removeMedicineInCart(String medicineId, MessageCallback clientCallback, String username) throws RemoteException {
        try {

            Map<String, UserCart> userCarts = CartJSONProcessor.readUserCartsFromFile();
            User user = UserJSONProcessor.getUserByUsername("res/UserInformation.json", username);
            String userId = user.getUserId();

            // Retrieve the current cart for the user
            UserCart userCart = userCarts.get(userId);

            // Remove the medicine from the cart
            userCart.removeItem(medicineId); // Assuming UserCart class has this method implemented

            // Save the updated cart
            CartJSONProcessor.writeUserCartsToFile(userCarts);
            clientCallback.updateCart(userCart);

        } catch (Exception e) {
            throw new RemoteException("Error removing medicine from cart: " + e.getMessage(), e);
        }
    }
    public synchronized int retrieveMedicineStock(String medicineId) throws RemoteException{
        int medicineStock = 0;
        Medicine medicine = new Medicine();
        try {
            medicine = MedicineJSONProcessor.getMedicineById("res/Medicine.json", medicineId);
        } catch (Exception e){

        }
        medicineStock = medicine.getQuantity();
        return medicineStock;
    }
    public void processOrder(User user, List<OrderItem> orderItems, String base64Image, String modeOfDelivery, String modeOfPayment, MessageCallback clientCallback) throws RemoteException, MedicineOutOfStockException {
        try {
        for (OrderItem item : orderItems) {
            Medicine medicine = MedicineJSONProcessor.getMedicineById("res/Medicine.json", item.getMedicineId());
            if (medicine.getQuantity() < item.getQuantity()) {
                throw new MedicineOutOfStockException("Not enough stock for medicine: " + item.getMedicineId());
            }
        }
        String orderId = OrderJSONProcessor.generateOrderId();

        String status = "Pending";

        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

        double total = getTotal(user, orderItems);

        Order order = new Order(orderId, user.getUserId(), orderItems, status, modeOfDelivery, modeOfPayment, base64Image, total);
        OrderJSONProcessor.writeOrderToFile(order);

        String userId = user.getUserId();
        Map<String, UserCart> userCarts = CartJSONProcessor.readUserCartsFromFile();
        UserCart userCart = userCarts.get(userId);

        for (OrderItem item : orderItems) {
            Medicine medicine = MedicineJSONProcessor.getMedicineById("res/Medicine.json", item.getMedicineId());
            assert medicine != null;
            int newStock = medicine.getQuantity() - item.getQuantity();
            medicine.setQuantity(newStock);
            MedicineJSONProcessor.updateMedicine(medicine, "res/Medicine.json");
            userCart.removeItem(item.getMedicineId());
        }

        CartJSONProcessor.writeUserCartsToFile(userCarts);
        clientCallback.updateCart(userCart);

        msgCallbacks.entrySet().stream()
                    .filter(entry -> entry.getKey().getUsername().equals(user.getUsername()))
                    .findFirst()
                    .ifPresent(entry -> {
                        try {
                            entry.getValue().notifyOrderProcessed(orderId, user, orderItems, imageBytes, modeOfDelivery, modeOfPayment);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    });

        for (Map.Entry<UserCallBackInfo, MessageCallback> entry : msgCallbacks.entrySet()) {
                UserCallBackInfo userInfo = entry.getKey();
                MessageCallback adminCallback = entry.getValue();

                if ("Admin".equals(userInfo.getUserType())) {
                    adminCallback.notifyUserOrdersToAdmins(user.getUsername(), orderId);
                }
            }

        updateInventoryTable();
        updateOrdersTable();
        notifyNewPendingOrders();
        notifyNewOrders();

        } catch (RemoteException ex){
            ex.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void sendMessageToAdmins(String message, String username) throws RemoteException{
        msgCallbacks.entrySet().forEach(entry -> {
            UserCallBackInfo userInfo = entry.getKey();
            MessageCallback callback = entry.getValue();
            if ("Admin".equals(userInfo.getUserType())) {
                try {
                    callback.getUserMessage(message, username);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private static double getTotal(User user, List<OrderItem> orderItems) {
        double total;

        // Calculate total price of order items
        total = OrderItem.calculateTotalPrice(orderItems);

        // Apply discount if applicable
        double discountRate = 0.0;
        if ("yes".equals(user.getPersonWithDisability())) {
            discountRate = 0.2; // Assuming the discount rate is 20% for PWD
            double discountAmount = total * discountRate;
            total -= discountAmount;
        }

        return total;
    }


}
