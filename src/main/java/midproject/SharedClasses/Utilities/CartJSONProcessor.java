package midproject.SharedClasses.Utilities;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import midproject.SharedClasses.ReferenceClasses.UserCart;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartJSONProcessor {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Method to read all user carts from the centralized UserCarts.json file
    public static Map<String, UserCart> readUserCartsFromFile() {
        try (Reader reader = new FileReader("res/UserCarts.json")) {
            Type typeOfUserCarts = new TypeToken<Map<String, UserCart>>(){}.getType();
            return gson.fromJson(reader, typeOfUserCarts);
        } catch (FileNotFoundException e) {
            // Handle case where the UserCarts.json does not exist
            return new HashMap<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    // Method to write all user carts to the centralized UserCarts.json file
    public static void writeUserCartsToFile(Map<String, UserCart> userCarts) {
        try (Writer writer = new FileWriter("res/UserCarts.json")) {
            gson.toJson(userCarts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

