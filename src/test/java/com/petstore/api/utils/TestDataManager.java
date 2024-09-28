package com.petstore.api.utils;

import java.io.FileReader;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TestDataManager {

    // Method to load test data from a JSON file
    public static Map<String, Object> getTestData(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            JsonObject jsonData = JsonParser.parseReader(reader).getAsJsonObject();
            return new Gson().fromJson(jsonData, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to read test data from file: " + filePath);
        }
    }
}
