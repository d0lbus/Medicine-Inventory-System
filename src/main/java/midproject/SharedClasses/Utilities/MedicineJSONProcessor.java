package midproject.SharedClasses.Utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import midproject.SharedClasses.ReferenceClasses.*;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to read and write Medicine objects to/from JSON files.
 */
public class MedicineJSONProcessor {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final String ID_TRACKER_FILE_PATH = "res/medicineIDTracker.txt";

    /**
     * Reads medicines from a JSON file.
     * @param filePath The path to the JSON file.
     * @return A list of Medicine objects read from the file.
     * @throws IOException If an I/O error occurs.
     */
    public static List<Medicine> readMedicinesFromFile(String filePath) throws IOException {
        try {
            String json = new String(Files.readAllBytes(Paths.get(filePath)));
            Type medicineListType = new TypeToken<List<Medicine>>(){}.getType();
            List<Medicine> medicine = gson.fromJson(json, medicineListType);
            return medicine != null ? medicine : new ArrayList<>();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            throw new IOException("Failed to deserialize the JSON content.", e);
        }
    }

    /**
     * Retrieves a medicine by its ID.
     * @param filePath The path to the JSON file containing medicines.
     * @param medicineId The ID of the medicine to retrieve.
     * @return The Medicine object corresponding to the provided ID.
     * @throws Exception If the medicine with the given ID is not found.
     */
    public static Medicine getMedicineById(String filePath, String medicineId) throws Exception {
        List<Medicine> medicineList = readMedicinesFromFile(filePath);

        for (Medicine medicine : medicineList) {
            if (medicine.getMedicineID().equals(medicineId)) {
                return medicine;
            }
        }
        return null;
    }

    /**
     * Retrieves the price of a medicine by its ID.
     * @param filePath The path to the JSON file containing medicines.
     * @param medicineId The ID of the medicine to retrieve the price for.
     * @return The price of the medicine corresponding to the provided ID.
     * @throws IOException If the medicine with the given ID is not found.
     */
    public static double getPriceById(String filePath, String medicineId) throws IOException {
        List<Medicine> medicineList = readMedicinesFromFile(filePath);

        for (Medicine medicine : medicineList) {
            if (medicine.getMedicineID().equals(medicineId)) {
                return medicine.getPrice();
            }
        }
        throw new IOException("Medicine with ID " + medicineId + " not found.");
    }
    public static void writeMedicinesToFile(List<Medicine> medicines, String filePath) throws IOException {
        try (Writer writer = Files.newBufferedWriter(Paths.get(filePath))) {
            gson.toJson(medicines, writer);
        }
    }

    /**
     * Writes medicines to a JSON file.
     * @param filePath The path to the JSON file to write to.
     * @throws IOException If an I/O error occurs.
     */
    public static void addMedicineToFile(Medicine medicine, String filePath) throws IOException {
        medicine.setMedicineID(generateNextMedicineId());
        List<Medicine> medicines = readMedicinesFromFile(filePath);
        medicines.add(medicine);
        writeMedicinesToFile(medicines, filePath);
    }

    /**
     * Adds a medicine to a JSON file.
     * @param filePath The path to the JSON file to add the medicine to.
     * @throws IOException If an I/O error occurs.
     */
    public static List<Medicine> findMedicinesByCategory(String category, String filePath) throws IOException {
        List<Medicine> allMedicines = readMedicinesFromFile(filePath);
        List<Medicine> filteredMedicines = new ArrayList<>();
        for (Medicine medicine : allMedicines) {
            if (medicine.getCategory().equalsIgnoreCase(category)) {
                filteredMedicines.add(medicine);
            }
        }
        return filteredMedicines;
    }

    /**
     * Updates a medicine in the JSON file.
     * @param updatedMedicine The updated medicine object.
     * @param filePath The path to the JSON file containing medicines.
     * @throws IOException If an I/O error occurs.
     */
    public static void updateMedicine(Medicine updatedMedicine, String filePath) throws IOException {
        List<Medicine> medicines = readMedicinesFromFile(filePath);
        for (int i = 0; i < medicines.size(); i++) {
            Medicine medicine = medicines.get(i);
            if (medicine.getMedicineID().equals(updatedMedicine.getMedicineID())) {
                medicines.set(i, updatedMedicine);
                break;
            }
        }
        writeMedicinesToFile(medicines, filePath);
    }

    /**
     * Removes a specific medicine from the JSON file.
     * @param targetMedicine The medicine to remove.
     * @param filePath The path to the JSON file containing medicines.
     * @throws IOException If an I/O error occurs.
     */
    public static void removeSpecificMedicine(Medicine targetMedicine, String filePath) throws IOException {
        List<Medicine> medicines = readMedicinesFromFile(filePath);

        medicines.removeIf(medicine ->
                medicine.getMedicineID().equals(targetMedicine.getMedicineID()) &&
                medicine.getCategory().equals(targetMedicine.getCategory()) &&
                        medicine.getGenericName().equals(targetMedicine.getGenericName()) &&
                        medicine.getBrandName().equals(targetMedicine.getBrandName()) &&
                        medicine.getForm().equals(targetMedicine.getForm()) &&
                        medicine.getQuantity() == targetMedicine.getQuantity() &&
                        medicine.getPrice() == targetMedicine.getPrice()
        );

        writeMedicinesToFile(medicines, filePath);
    }

    // Generates the next medicine ID with synchronized for thread safety
    public static synchronized String generateNextMedicineId() {
        int lastIdNumber = readLastIdNumber();
        int nextIdNumber = lastIdNumber + 1;
        updateIdTrackerFile(nextIdNumber);
        return "M" + nextIdNumber;
    }

    // Reads the last ID number from the tracker file, also synchronized
    private static synchronized int readLastIdNumber() {
        try {
            File file = new File(ID_TRACKER_FILE_PATH);
            if (!file.exists()) {
                return 0;
            }
            String content = new String(Files.readAllBytes(Paths.get(ID_TRACKER_FILE_PATH)));
            return Integer.parseInt(content.trim());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return 0; // Default to 0 in case of error
        }
    }

    // Updates the tracker file with the new last used ID number, also synchronized
    private static synchronized void updateIdTrackerFile(int newLastIdNumber) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ID_TRACKER_FILE_PATH))) {
            writer.write(Integer.toString(newLastIdNumber));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
