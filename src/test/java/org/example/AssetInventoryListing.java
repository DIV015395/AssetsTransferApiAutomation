package org.example;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

//Login with jai.malviyanagar1 = token
public class AssetInventoryListing {


    ResourceBundle resourceBundle = ResourceBundle.getBundle("logintoken");
    String ITUser = resourceBundle.getString("IT");


    public ExtentTest test;
    public AssetInventoryListing(ExtentTest test)
    {
        this.test = test;
    }
    String baseUrl = "http://ec2-43-205-70-111.ap-south-1.compute.amazonaws.com:8081";
    String endpoint = "/asset/inventory";
    String fullUrl = String.format("%s%s", baseUrl, endpoint);
    public void testInventoryListing()
    {
        // Send a GET request with the authorization header
        Response response = RestAssured.given()
                .header("x-authorization", ITUser)
                .contentType(ContentType.JSON)
                .when()
                .get(fullUrl); // Replace with your API endpoint

        int statusCode = response.getStatusCode();
        long responseTime = response.time();
        String responseMessage = response.getBody().asString();
        double responseTimeInSeconds = responseTime / 1000.0;
        test.log(Status.INFO, "Get Request for Asset Inventory Listing");
        System.out.println("Response Time in Seconds: " + responseTimeInSeconds);
        test.log(Status.INFO, "Response Time in Seconds: " + responseTimeInSeconds);

        if (statusCode ==200)
        {
            System.out.println("Inventory Listing working fine with Status code : "+statusCode);
            test.pass("Inventory Listing working fine with Status code : "+statusCode);
        }
        else
        {
            System.out.println("Not Working with Status code : "+statusCode);
            test.fail("Not Working with Status code : "+statusCode);

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
            test.log(Status.INFO, "JSON Response Body : "+prettyJson);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        test.log(Status.INFO, responseMessage);
    }
}
