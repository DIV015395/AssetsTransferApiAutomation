package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Login with jai.malviyanagar1
public class AssetInventoryListing {


    public void testInventoryListing() {
        // Send a GET request with the authorization header
        Response response = RestAssured.given()
                .header("x-authorization", "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySW5mbyI6eyJpZCI6MTQsImZuYW1lIjoiSmFpcHVyIE1hbHZpeWEiLCJsbmFtZSI6Ik5hZ2FyIiwiZW1haWwiOiJiaGF2bmEuc2luZGh3YW5pQGluc3RhbnRzeXMuY29tIiwidXNlclR5cGUiOiJJVCIsImlzTWZhIjoxLCJ0ZW5hbnRzIjp7IjEiOiJRQSIsIjIiOiJERVYiLCIzIjoiVUFUMSJ9LCJhY3RpdmVUZW5hbnQiOjN9LCJwcml2aWxlZ2VzIjpbInIuYSJdLCJzdWIiOiJqYWkubWFsdml5YW5hZ2FyMSIsImF1ZCI6Im4vYSIsInJvbGVzIjpudWxsfQ.1Doi2HwsnfwzTbK6sli45vUYqV5SL6QFF2oh_inCkdU")
                .contentType(ContentType.JSON)
                .when()
                .get("http://ec2-43-205-70-111.ap-south-1.compute.amazonaws.com:8081/asset/inventory"); // Replace with your API endpoint

        int statusCode = response.getStatusCode();
        long responseTime = response.time();
// Optionally, you can convert the response time to seconds
        double responseTimeInSeconds = responseTime / 1000.0;

        System.out.println("Response Time in Seconds: " + responseTimeInSeconds);

        if (statusCode ==200)
        {
            System.out.println("Inventory Listing working fine with Status code : "+statusCode);
        }
        else
        {
            System.out.println("Not Working with Status code : "+statusCode);
        }

        String jsonResponse = response.getBody().asString();
//
        // Create an ObjectMapper with pretty-printing enabled
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        try {
            // Parse the JSON string to a JSON object
            Object json = objectMapper.readValue(jsonResponse, Object.class);

            // Convert the JSON object to a pretty-printed JSON string
            String prettyJson = objectMapper.writeValueAsString(json);

            // Print the formatted JSON
            System.out.println(prettyJson);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
