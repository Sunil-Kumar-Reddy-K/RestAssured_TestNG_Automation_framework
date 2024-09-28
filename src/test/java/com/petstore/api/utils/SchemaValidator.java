package com.petstore.api.utils;

import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidator {

    // Method to validate the response body against the schema
    public static void validateResponseSchema(Response response, String schemaFilePath) {
        response.then().assertThat().body(matchesJsonSchemaInClasspath(schemaFilePath));
    }
}
