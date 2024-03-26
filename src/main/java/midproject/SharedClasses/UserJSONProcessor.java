package midproject.SharedClasses;

import com.google.gson.Gson;
import midproject.SharedClasses.ReferenceClasses.User;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserJSONProcessor {

    private static final Gson gson = new Gson();

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

    public static boolean isValidCredentials(String username, String password, String filePath) {
        try {
            String json = new String(Files.readAllBytes(Paths.get(filePath)));
            Type userListType = new TypeToken<List<User>>(){}.getType();
            List<User> users = gson.fromJson(json, userListType);

            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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

}
