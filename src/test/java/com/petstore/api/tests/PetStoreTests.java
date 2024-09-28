package com.petstore.api.tests;

import com.petstore.api.listeners.TestListener;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
    }
}
