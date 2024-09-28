package com.petstore.api.tests;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PostCreateNewPetTest {

    public static int createdPetId = 0; // Static variable to store the created pet ID (0 as default)
    private Faker faker = new Faker(); // Create a Faker instance
    private Gson gson = new Gson(); // Gson instance

    @Test
    public void createNewPet() {
        // Check if the pet is already created
        if (createdPetId != 0) {
            // Skip the test if a pet has already been created
            throw new SkipException("Skipping the test as the Pet is already created with ID: " + createdPetId);
        }

        // Base URI for the Petstore API
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        // Create the pet details dynamically
        Map<String, Object> petDetails = createPetDetails();

        // Convert the petDetails map to a JSON string using Gson
        String jsonBody = gson.toJson(petDetails);

        // Log the JSON body that will be sent in the POST request
        System.out.println("Request Body: " + jsonBody);

        // Make the POST request to add a new pet
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(jsonBody)  // Send the JSON body
                .post("/pet");

        // Log the response body to the console
        System.out.println("Response Body: " + response.getBody().asString());

        // Validate that the status code is 200 (success)
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 but found " + response.getStatusCode());

        // Store the created pet ID to be used in the GET request
        createdPetId = response.jsonPath().getInt("id");
        System.out.println("Created Pet ID: " + createdPetId);
    }

    // Helper method to create dynamic pet details using Faker
    private Map<String, Object> createPetDetails() {
        Map<String, Object> petDetails = new HashMap<>();

        // Generate random data for the pet
        int petId = faker.number().numberBetween(1000, 9999);  // Random ID
        String petName = faker.name().firstName();  // Random pet name

        // Create category details
        Map<String, Object> category = new HashMap<>();
        category.put("id", faker.number().numberBetween(1, 10));  // Random category ID
        category.put("name", faker.animal().name());  // Random category name

        // Create tag details
        Map<String, Object> tag = new HashMap<>();
        tag.put("id", faker.number().numberBetween(1, 10));  // Random tag ID
        tag.put("name", faker.animal().name());  // Random tag name

        // Populate the main pet details
        petDetails.put("id", petId);
        petDetails.put("name", petName);
        petDetails.put("status", "available");  // Status can be "available", "pending", or "sold"
        petDetails.put("category", category);
        petDetails.put("tags", new Map[]{tag});

        return petDetails;
    }
}
