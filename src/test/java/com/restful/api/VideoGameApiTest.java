package com.restful.api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import restful.api.pojo.VideoGame;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class VideoGameApiTest {

    @Test
    public void createVideoGameTest() {
        // Create a VideoGame object
        VideoGame newGame = new VideoGame("Platform", "Mario", "Mature", "2012-05-04", 85);

        // Send POST request
        given()
                .baseUri("https://videogamedb.uk") // Base URL
                .basePath("/api/v2") // API version
                .contentType(ContentType.JSON)
                .body(newGame) // Convert Java object to JSON
                .when()
                .post("/videogame") // Endpoint for creating a video game
                .then()
                .log().all()
                .statusCode(200) // Expected status code
                .body("name", equalTo("Mario"))
                .body("category", equalTo("Platform"))
                .body("rating", equalTo("Mature"))
                .body("releaseDate", equalTo("2012-05-04"))
                .body("reviewScore", equalTo(85));
    }

}
