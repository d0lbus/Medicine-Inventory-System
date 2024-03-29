package midproject.SharedClasses.Utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import midproject.SharedClasses.ReferenceClasses.Medicine;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MedicineJSONProcessor {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static List<Medicine> readMedicinesFromFile(String filePath) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            Type listType = new TypeToken<ArrayList<Medicine>>() {}.getType();
            return gson.fromJson(reader, listType);
        }
    }

    public static void writeMedicinesToFile(List<Medicine> medicines, String filePath) throws IOException {
        try (Writer writer = Files.newBufferedWriter(Paths.get(filePath))) {
            gson.toJson(medicines, writer);
        }
    }

    public static void addMedicineToFile(Medicine medicine, String filePath) throws IOException {
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

    // Example method: Update a medicine
    // This is a simple approach and might need to be adapted based on how you identify unique medicines.
    public static void updateMedicine(Medicine updatedMedicine, String filePath) throws IOException {
        List<Medicine> medicines = readMedicinesFromFile(filePath);
        for (int i = 0; i < medicines.size(); i++) {
            Medicine medicine = medicines.get(i);
            if (medicine.getBrandName().equals(updatedMedicine.getBrandName()) &&
                    medicine.getGenericName().equals(updatedMedicine.getGenericName())) {
                medicines.set(i, updatedMedicine);
                break;
            }
        }
        writeMedicinesToFile(medicines, filePath);
    }

    public static void transferMedicine(String brandName, String fromFilePath, String toFilePath) throws IOException {
        // Load medicines from both files
        List<Medicine> fromMedicines = readMedicinesFromFile(fromFilePath);
        List<Medicine> toMedicines = readMedicinesFromFile(toFilePath);

        // Find and remove the medicine from the source list, then add it to the destination list
        Medicine toTransfer = null;
        for (Medicine medicine : fromMedicines) {
            if (medicine.getBrandName().equalsIgnoreCase(brandName)) {
                toTransfer = medicine;
                break;
            }
        }

        if (toTransfer != null) {
            fromMedicines.remove(toTransfer); // Remove from source
            toMedicines.add(toTransfer); // Add to destination
        } else {
            System.err.println("Medicine with brand name " + brandName + " not found.");
            return;
        }

        // Save the updated lists back to their files
        writeMedicinesToFile(fromMedicines, fromFilePath);
        writeMedicinesToFile(toMedicines, toFilePath);
    }
}
