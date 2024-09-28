package com.petstore.api.tests;

import com.petstore.api.listeners.TestListener;
import com.petstore.api.utils.SchemaValidator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Optional;

import static io.restassured.RestAssured.given;

@Listeners(TestListener.class)
public class GetPetTest {

    @Test(dependsOnMethods = "com.petstore.api.tests.PostCreateNewPetTest.createNewPet")
    public void getPetById() {
        // Set the base URI for the PetStore API
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        // Use the createdPetId from PostCreateNewPetTest
        int petId = Optional.ofNullable(PostCreateNewPetTest.createdPetId).orElseThrow(() ->
                new RuntimeException("Pet ID not found. Make sure POST test ran successfully."));

        // Get the pet by ID
        Response response = given()
                .pathParam("petId", petId) // Use the created pet ID here
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(200)  // Assert status code
                .log().all()      // Log response
                .extract()
                .response();

        // Print the response
        System.out.println("Response Body:");
        System.out.println(response.asPrettyString());

        // Validate a response field using the same pet ID variable
        Assert.assertEquals(response.jsonPath().getInt("id"), petId, "ID should match");
        SchemaValidator.validateResponseSchema(response, "schemas/getPetTestSchema.json");

    }
}
