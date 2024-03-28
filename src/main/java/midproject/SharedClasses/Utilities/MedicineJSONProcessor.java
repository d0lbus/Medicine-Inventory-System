package midproject.SharedClasses.Utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import midproject.SharedClasses.ReferenceClasses.GenericName;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicineJSONProcessor {

    private static final Gson gson = new Gson();

    public static Map<String, List<GenericName>> parseMedicineFromJson(String json) {
        Type medicineType = new TypeToken<HashMap<String, List<GenericName>>>() {}.getType();
        return gson.fromJson(json, medicineType);
    }

    public static String medicineToJson(Map<String, List<GenericName>> medicine) {
        return gson.toJson(medicine);
    }

    public static void addMedicineToJsonFile(GenericName newMedicine, String filePath, String category) {
        try (FileReader reader = new FileReader(filePath)) {
            Type medicineType = new TypeToken<HashMap<String, List<GenericName>>>() {}.getType();
            Map<String, List<GenericName>> medicines = gson.fromJson(reader, medicineType);
            if (medicines == null) {
                medicines = new HashMap<>();
            }

            List<GenericName> categoryMedicines = medicines.getOrDefault(category, new ArrayList<>());
            categoryMedicines.add(newMedicine);
            medicines.put(category, categoryMedicines);

            try (FileWriter writer = new FileWriter(filePath)) {
                gson.toJson(medicines, writer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editMedicineInJsonFile(GenericName updatedMedicine, String filePath, String category) {
        try (FileReader reader = new FileReader(filePath)) {
            Type medicineType = new TypeToken<HashMap<String, List<GenericName>>>() {}.getType();
            Map<String, List<GenericName>> medicines = gson.fromJson(reader, medicineType);
            if (medicines == null) {

                return;
            }

            List<GenericName> categoryMedicines = medicines.get(category);
            if (categoryMedicines != null) {
                for (int i = 0; i < categoryMedicines.size(); i++) {
                    if (categoryMedicines.get(i).equals(updatedMedicine)) {
                        categoryMedicines.set(i, updatedMedicine);
                        break;
                    }
                }
            }

            try (FileWriter writer = new FileWriter(filePath)) {
                gson.toJson(medicines, writer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void archiveMedicine(String genericName, String originalFilePath, String archiveFilePath) {
        try {
            Map<String, List<GenericName>> medicines = readMedicinesFromFile(originalFilePath);
            Map<String, List<GenericName>> archivedMedicines = readMedicinesFromFile(archiveFilePath);

            List<GenericName> toArchive = medicines.getOrDefault("Painkillers", new ArrayList<>());
            toArchive.removeIf(gName -> {
                boolean match = gName.get_gname().equals(genericName);
                if (match) {
                    archivedMedicines.computeIfAbsent("Painkillers", k -> new ArrayList<>()).add(gName);
                }
                return match;
            });

            writeMedicinesToFile(medicines, originalFilePath);
            writeMedicinesToFile(archivedMedicines, archiveFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<GenericName>> readMedicinesFromFile(String filePath) throws Exception {
        String json = new String(Files.readAllBytes(Paths.get(filePath)));
        Type medicineType = new TypeToken<HashMap<String, List<GenericName>>>(){}.getType();
        Map<String, List<GenericName>> medicines = gson.fromJson(json, medicineType);
        return medicines != null ? medicines : new HashMap<>();
    }

    private static void writeMedicinesToFile(Map<String, List<GenericName>> medicines, String filePath) throws Exception {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(medicines, writer);
        }
    }
}
