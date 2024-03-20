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
    public static User parseUserFromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, User.class);
    }

    public static String userToJson(User user) {
        Gson gson = new Gson();
        return gson.toJson(user);
    }
    public static void addUserToJsonFile(User newUser, String filePath) {
        Gson gson = new Gson();
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
            Gson gson = new Gson();

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
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
            List<User> users = gson.fromJson(reader, userListType);
            if (users == null) {
                users = new ArrayList<>();
                System.out.println("No users found.");
                return;
            }

            // Find the user to update
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



}
