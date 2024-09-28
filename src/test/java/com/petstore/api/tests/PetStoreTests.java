package com.petstore.api.tests;

import com.petstore.api.listeners.TestListener;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Listeners(TestListener.class)
public class PetStoreTests {

    @BeforeClass
    public void setup() {
        // Base URI for PetStore API
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void testFindPetsByStatus() {
        // Sending a GET request to find pets by status
        Response response = RestAssured.given()
                .queryParam("status", "available")
                .when()
                .get("/pet/findByStatus")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        // Assertion to verify that the status code is 200
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200!");

        // Save response as JSON
        saveResponseAsJson(response.asString(), "available_pets_response.json");
    }

    private void saveResponseAsJson(String jsonResponse, String fileName) {
        // Define the file path
        String filePath = "src/test/resources/api-responses/" + fileName;

        // Create a file object
        File file = new File(filePath);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonResponse);
            System.out.println("Response saved to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Failed to save response to JSON file");
        }
    }
}
