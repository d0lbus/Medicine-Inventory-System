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


public class MedicineJSONProcessor {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final String ID_TRACKER_FILE_PATH = "res/medicineIDTracker.txt";

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

    public static Medicine getMedicineById(String filePath, String medicineId) throws Exception {
        List<Medicine> medicineList = readMedicinesFromFile(filePath);

        for (Medicine medicine : medicineList) {
            if (medicine.getMedicineID().equals(medicineId)) {
                return medicine;
            }
        }
        return null;
    }

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

    public static void addMedicineToFile(Medicine medicine, String filePath) throws IOException {
        medicine.setMedicineID(generateNextMedicineId());
        List<Medicine> medicines = readMedicinesFromFile(filePath);
        medicines.add(medicine);
        writeMedicinesToFile(medicines, filePath);
    }

    // Example method: Find by category
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
                return 0; // Start from 0 because we'll increment before using
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
