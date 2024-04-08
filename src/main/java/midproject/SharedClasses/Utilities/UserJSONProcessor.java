package midproject.SharedClasses.Utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import midproject.SharedClasses.ReferenceClasses.User;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserJSONProcessor {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Adds a new user to a JSON file.
     * @param newUser The new User to add.
     * @param filePath The path to the JSON file.
     */
    public static void addUserToJsonFile(User newUser, String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
            List<User> users = gson.fromJson(reader, userListType);
            if (users == null) {
                users = new ArrayList<>();
            }

            users.add(newUser);

            try (FileWriter writer = new FileWriter(filePath)) {
                gson.toJson(users, writer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates the credentials of a user.
     * @param username The username.
     * @param password The password.
     * @param filePath The path to the JSON file containing user data.
     * @param userTypeRequest The type of user to validate against.
     * @return True if the credentials are valid, false otherwise.
     */
    public static boolean isValidCredentials(String username, String password, String filePath, String userTypeRequest) {
        try {
            String json = new String(Files.readAllBytes(Paths.get(filePath)));
            Type userListType = new TypeToken<List<User>>(){}.getType();
            List<User> users = gson.fromJson(json, userListType);

            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password) & Objects.equals(user.getUserType(), userTypeRequest)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Retrieves a User object by its ID from a JSON file.
     * @param filePath The path to the JSON file containing user data.
     * @param userId The ID of the user to retrieve.
     * @return The User object corresponding to the provided ID, or null if not found.
     * @throws Exception If an error occurs during file reading or processing.
     */
    public static User getUserById(String filePath, String userId) throws Exception {
        List<User> users = readUsersFromFile(filePath);
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Retrieves a User object by its username from a JSON file.
     * @param filePath The path to the JSON file containing user data.
     * @param username The username of the user to retrieve.
     * @return The User object corresponding to the provided username, or null if not found.
     * @throws Exception If an error occurs during file reading or processing.
     */
    public static User getUserByUsername(String filePath, String username) throws Exception {
        List<User> users = readUsersFromFile(filePath);
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Retrieves the type of a user by their username from a JSON file.
     * @param filePath The path to the JSON file containing user data.
     * @param username The username of the user.
     * @return The type of the user corresponding to the provided username.
     * @throws Exception If the user is not found or an error occurs during file reading or processing.
     */
    public static String getUserTypeByUsername(String filePath, String username) throws Exception {
        try (FileReader reader = new FileReader(filePath)) {
            Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
            List<User> users = gson.fromJson(reader, userListType);

            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    return user.getUserType();
                }
            }
            throw new Exception("User not found");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error accessing or processing file", e);
        }
    }

    /**
     * Updates a user's information in a JSON file.
     * @param updatedUser The updated User object.
     * @param filePath The path to the JSON file containing user data.
     * @throws Exception If an error occurs during file reading, processing, or writing.
     */
    public static void updateUserInJsonFile(User updatedUser, String filePath) throws Exception {
        List<User> users = readUsersFromFile(filePath);
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUserId().equals(updatedUser.getUserId())) {
                users.set(i, updatedUser);
                break;
            }
        }
        writeUsersToFile(users, filePath);
    }

    /**
     * Transfers a user from one JSON file to another.
     * @param userId The ID of the user to transfer.
     * @param originalFilePath The path to the original JSON file.
     * @param destinationFilePath The path to the destination JSON file.
     */
    public static void transferUserToDifferentFile(String userId, String originalFilePath, String destinationFilePath) {
        try {
            List<User> users = readUsersFromFile(originalFilePath);
            List<User> archivedUsers = readUsersFromFile(destinationFilePath);

            users.removeIf(user -> {
                boolean match = user.getUserId().equals(userId);
                if (match) archivedUsers.add(user);
                return match;
            });

            writeUsersToFile(users, originalFilePath);
            writeUsersToFile(archivedUsers, destinationFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads User objects from a JSON file.
     * @param filePath The path to the JSON file containing user data.
     * @return A list of User objects read from the file.
     * @throws Exception If an error occurs during file reading or processing.
     */
    public static List<User> readUsersFromFile(String filePath) throws Exception {
        String json = new String(Files.readAllBytes(Paths.get(filePath)));
        Type userListType = new TypeToken<List<User>>(){}.getType();
        List<User> users = gson.fromJson(json, userListType);
        return users != null ? users : new ArrayList<>();
    }

    /**
     * Writes User objects to a JSON file.
     * @param users The list of User objects to write.
     * @param filePath The path to the JSON file to write to.
     * @throws Exception If an error occurs during file writing.
     */
    private static void writeUsersToFile(List<User> users, String filePath) throws Exception {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(users, writer);
        }
    }

    /**
     * Loads user IDs from a JSON file and an ID tracker file.
     * @param filePath The path to the JSON file containing user data.
     * @param idTrackerFilePath The path to the ID tracker file.
     * @return A list of user IDs.
     */
    public static List<String> loadUserIdsFromJsonFile(String filePath, String idTrackerFilePath) {
        List<String> userIds = new ArrayList<>();

        try (BufferedReader jsonReader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = jsonReader.readLine()) != null) {
                jsonContent.append(line);
            }

            String json = jsonContent.toString().trim();
            if (json.startsWith("[") && json.endsWith("]")) {
                json = json.substring(1, json.length() - 1);
                String[] userObjects = json.split("\\},\\{");
                for (String userObject : userObjects) {
                    String[] fields = userObject.split(",");
                    for (String field : fields) {
                        if (field.contains("\"userId\":")) {
                            String[] parts = field.split(":");
                            if (parts.length == 2) {
                                String userId = parts[1].replaceAll("\"", "").trim();
                                userIds.add(userId);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(idTrackerFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                userIds.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userIds;
    }

    /**
     * Fetches user information from a data source based on user ID.
     * @param userId The ID of the user to fetch information for.
     * @param filePath The path to the JSON file containing user data.
     * @return The User object corresponding to the provided ID, or null if not found.
     */
    public static User fetchUserInformationFromDataSource(String userId, String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type userListType = new TypeToken<List<User>>(){}.getType();
            List<User> users = gson.fromJson(reader, userListType);

            for (User user : users) {
                if (user.getUserId().equals(userId)) {
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Validates the old password of a user.
     * @param username The username of the user.
     * @param oldPassword The old password to validate.
     * @return True if the old password matches the stored password for the user, false otherwise.
     * @throws Exception If an error occurs during user retrieval.
     */
    public static boolean validateOldPassword(String username, String oldPassword) throws Exception {
        User user = getUserByUsername("res/UserInformation.json", username);
        return user != null && user.getPassword().equals(oldPassword);
    }

    /**
     * Updates the password of a user.
     * @param username The username of the user.
     * @param newPassword The new password to set.
     * @throws Exception If an error occurs during user retrieval or password update.
     */
    public static void updateUserPassword(String username, String newPassword) throws Exception {
        User user = getUserByUsername("res/UserInformation.json", username);
        if (user != null) {
            user.setPassword(newPassword);
            updateUserInJsonFile(user, "res/UserInformation.json");
        }
    }
}
