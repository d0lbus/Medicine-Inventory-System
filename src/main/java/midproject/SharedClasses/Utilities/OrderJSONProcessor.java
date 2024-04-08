package midproject.SharedClasses.Utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import midproject.SharedClasses.ReferenceClasses.Order;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class OrderJSONProcessor {
    private static final String ORDER_FILE_PATH = "res/Orders.json";
    private static final String ORDER_ID_FILE = "res/LastOrderId.txt";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Writes an order to the orders JSON file.
     * @param updatedOrder The order to write.
     * @throws IOException If an I/O error occurs.
     */
    public static void writeOrderToFile(Order updatedOrder) throws IOException {
        List<Order> orders = new ArrayList<>();
        File orderFile = new File(ORDER_FILE_PATH);
        if (orderFile.exists() && !orderFile.isDirectory()) {
            try (Reader reader = new FileReader(orderFile)) {
                orders = gson.fromJson(reader, new TypeToken<List<Order>>() {}.getType());
                if (orders == null) {
                    orders = new ArrayList<>();
                }
            } catch (FileNotFoundException e) {
                System.err.println("Order file not found, starting with an empty list.");
            }
        }
        orders.removeIf(order -> order.getOrderId().equals(updatedOrder.getOrderId()));
        orders.add(updatedOrder);
        try (Writer writer = new FileWriter(ORDER_FILE_PATH)) {
            gson.toJson(orders, writer);
        }
    }

    /**
     * Reads orders from the specified file path.
     * @param filepath The path to the JSON file containing orders.
     * @return A list of Order objects.
     * @throws IOException If an I/O error occurs.
     */
    public static List<Order> readOrdersFromFile(String filepath) throws IOException {
        File orderFile = new File(filepath);
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

    /**
     * Reads an order by its ID.
     * @param orderId The ID of the order to read.
     * @return The Order object corresponding to the provided ID, or null if not found.
     * @throws IOException If an I/O error occurs.
     */
    public static Order readOrderById(String orderId) throws IOException {
        List<Order> orders = readOrdersFromFile(ORDER_FILE_PATH);
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                return order;
            }
        }
        return null; // Order not found
    }


    /**
     * Generates a new order ID.
     * @return The newly generated order ID.
     * @throws IOException If an I/O error occurs.
     */
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
            return 0;
        }
    }

    // Saves the last used order ID to the file
    private static void saveLastOrderId(int lastOrderId) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDER_ID_FILE))) {
            writer.write(Integer.toString(lastOrderId));
        }
    }

    public static List<Order> getOrdersByUserId(String filePath, String userId) {
        List<Order> orders = new ArrayList<>();

        try (FileReader reader = new FileReader("res/Orders.json")) {
            // Read the JSON file and parse it into a list of orders
            Gson gson = new Gson();
            Type orderListType = new TypeToken<List<Order>>() {}.getType();
            List<Order> allOrders = gson.fromJson(reader, orderListType);

            // Filter orders by user ID
            for (Order order : allOrders) {
                if (order.getUserId().equals(userId)) {
                    orders.add(order);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle IOException
        }

        return orders;
    }
}