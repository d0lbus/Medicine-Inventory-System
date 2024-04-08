package midproject.SharedClasses.Utilities;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import midproject.SharedClasses.ReferenceClasses.UserCart;
import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to read and write UserCart objects to/from JSON files.
 */
public class CartJSONProcessor {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Reads all user carts from the centralized UserCarts.json file.
     * @return A map of user IDs to their respective UserCart objects.
     */
    public static Map<String, UserCart> readUserCartsFromFile() {
        try (Reader reader = new FileReader("res/UserCarts.json")) {
            Type typeOfUserCarts = new TypeToken<Map<String, UserCart>>(){}.getType();
            return gson.fromJson(reader, typeOfUserCarts);
        } catch (FileNotFoundException e) {
            return new HashMap<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    /**
     * Writes all user carts to the centralized UserCarts.json file.
     * @param userCarts A map of user IDs to their respective UserCart objects.
     */
    public static void writeUserCartsToFile(Map<String, UserCart> userCarts) {
        try (Writer writer = new FileWriter("res/UserCarts.json")) {
            gson.toJson(userCarts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

