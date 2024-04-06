package midproject.SharedClasses.Utilities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import midproject.SharedClasses.ReferenceClasses.Order;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class OrderJSONProcessor {
    private static final String ORDER_FILE_PATH = "res/Orders.json";
    private static final String ORDER_ID_FILE = "res/LastOrderId.txt";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void writeOrderToFile(Order order) throws IOException {
        List<Order> orders = new ArrayList<>();

        File orderFile = new File(ORDER_FILE_PATH);
        if (orderFile.exists() && !orderFile.isDirectory()) {
            try (Reader reader = new FileReader(orderFile)) {
                orders = gson.fromJson(reader, new TypeToken<List<Order>>() {}.getType());
                // If the file doesn't exist or isn't a valid JSON, start with an empty list
                if (orders == null) {
                    orders = new ArrayList<>();
                }
            } catch (FileNotFoundException e) {
                System.err.println("Order file not found, starting with an empty list.");
            }
        }

        orders.add(order);

        try (Writer writer = new FileWriter(ORDER_FILE_PATH)) {
            gson.toJson(orders, writer);
        }
    }

    public static List<Order> readOrdersFromFile() throws IOException {
        File orderFile = new File(ORDER_FILE_PATH);
        if (orderFile.exists() && !orderFile.isDirectory()) {
            try (Reader reader = new FileReader(orderFile)) {
                // Return the list of orders read from the file
                List<Order> orders = gson.fromJson(reader, new TypeToken<List<Order>>() {}.getType());
                if (orders != null) {
                    return orders;
                }
            } catch (FileNotFoundException e) {
                // Log the error or handle it as deemed appropriate
                System.err.println("Order file not found, returning an empty list.");
            }
        }
        return new ArrayList<>();
    }

    // Generates a new order ID
    public static String generateOrderId() throws IOException {
        int lastOrderId = getLastOrderId();
        int newOrderId = lastOrderId + 1;
        saveLastOrderId(newOrderId);
        return String.format("ORD%05d", newOrderId); // Formats ID with prefix and leading zeros
    }

    // Retrieves the last order ID from the file
    private static int getLastOrderId() throws IOException {
        try {
            String lastIdStr = new String(Files.readAllBytes(Paths.get(ORDER_ID_FILE)));
            return Integer.parseInt(lastIdStr);
        } catch (FileNotFoundException | NumberFormatException e) {
            return 0; // If file does not exist or is empty, start from 0
        }
    }

    // Saves the last used order ID to the file
    private static void saveLastOrderId(int lastOrderId) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDER_ID_FILE))) {
            writer.write(Integer.toString(lastOrderId));
        }
    }
}