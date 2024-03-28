package midproject.SharedClasses.Utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import midproject.SharedClasses.ReferenceClasses.User;


import com.google.gson.Gson;
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

    public static User parseUserFromJson(String json) {
        return gson.fromJson(json, User.class);
    }

    public static String userToJson(User user) {
        return gson.toJson(user);
    }

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

    public static String getUserTypeByUsername(String filePath, String username) throws Exception {
        try (FileReader reader = new FileReader(filePath)) {
            Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
            List<User> users = gson.fromJson(reader, userListType);

            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    return user.getUserType(); // Assuming User class has a getUserType method
                }
            }
            throw new Exception("User not found");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error accessing or processing file", e);
        }
    }

    public static void updateUserInJsonFile(User updatedUser, String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
            List<User> users = gson.fromJson(reader, userListType);
            if (users == null) {
                users = new ArrayList<>();
                System.out.println("No users found.");
                return;
            }
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUserId().equals(updatedUser.getUserId())) {
                    users.set(i, updatedUser);
                    break;
                }
            }
            try (FileWriter writer = new FileWriter(filePath)) {
                gson.toJson(users, writer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void archiveUser(String userId, String originalFilePath, String archiveFilePath) {
        try {
            List<User> users = readUsersFromFile(originalFilePath);
            List<User> archivedUsers = readUsersFromFile(archiveFilePath);

            users.removeIf(user -> {
                boolean match = user.getUserId().equals(userId);
                if (match) archivedUsers.add(user);
                return match;
            });

            writeUsersToFile(users, originalFilePath);
            writeUsersToFile(archivedUsers, archiveFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<User> readUsersFromFile(String filePath) throws Exception {
        String json = new String(Files.readAllBytes(Paths.get(filePath)));
        Type userListType = new TypeToken<List<User>>(){}.getType();
        List<User> users = gson.fromJson(json, userListType);
        return users != null ? users : new ArrayList<>();
    }

    private static void writeUsersToFile(List<User> users, String filePath) throws Exception {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(users, writer);
        }
    }

    public static void saveUsersToFile(List<User> archivedUsers, String archiveFilePath) {
        try {
            try (FileWriter writer = new FileWriter(archiveFilePath)) {
                gson.toJson(archivedUsers, writer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getArchivedUser(String userId, String archiveFilePath) {
        try {
            List<User> archivedUsers = readUsersFromFile(archiveFilePath);
            for (User user : archivedUsers) {
                if (user.getUserId().equals(userId)) {
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<User> searchArchivedUsers(String searchText, String filePath) throws Exception {
        List<User> archivedUsers = new ArrayList<>();
        try {
            List<User> allUsers = readUsersFromFile(filePath);
            for (User user : allUsers) {
                // Check if the user is archived and matches the search text
                if (user.isArchived() && containsSearchText(user, searchText)) {
                    archivedUsers.add(user);
                }
            }
        } catch (Exception e) {
            throw new Exception("Error searching archived users: " + e.getMessage());
        }
        return archivedUsers;
    }

    private static boolean containsSearchText(User user, String searchText) {
        // Modify this method according to your search criteria
        // For example, you can check if the user's name contains the search text
        return user.getFirstName().toLowerCase().contains(searchText.toLowerCase()) ||
                user.getLastName().toLowerCase().contains(searchText.toLowerCase());
    }
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
                json = json.substring(1, json.length() - 1); // Remove square brackets
                String[] userObjects = json.split("\\},\\{"); // Split by '},{'
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

        // Read and update ID tracker file
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

    public static void appendIdToTrackerFile(String id, String idTrackerFilePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(idTrackerFilePath, true))) {
            bw.write(id);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
