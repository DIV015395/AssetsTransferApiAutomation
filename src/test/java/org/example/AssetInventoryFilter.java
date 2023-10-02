package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class AssetInventoryFilter
{
    ResourceBundle resourceBundle = ResourceBundle.getBundle("logintoken");
    String ITUser = resourceBundle.getString("IT");
    ResourceBundle resourceBundles = ResourceBundle.getBundle("baseurl");
    String baseUrl = resourceBundles.getString("baseUrl");
    String endpoint = "/asset/filter";
    String fullUrl = String.format("%s%s", baseUrl, endpoint);
    public void inventoryListingFilterStatusDamaged()
    {
        JSONObject requestBody = new JSONObject();
        requestBody.put("searchValue", "scanner");
        requestBody.put("searchBy", "name");
        requestBody.put("status", "Damaged");
        requestBody.put("category", "1");
        requestBody.put("flag", "0");

        Response response = RestAssured.given()
                .header("x-authorization", ITUser)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(fullUrl);

        System.out.println("Response Body: " + response.getBody().asString());

        // Perform assertions on the response as needed
        response.then()
                .statusCode(200) // Check if the status code is as expected
                .contentType(ContentType.JSON); // Check if the response content type is JSON
    }

    public void inventoryListingFilterStatusWorking() {
        // Create a JSON object for the request payload
        JSONObject requestBody = new JSONObject();
        requestBody.put("searchValue", "scanner");
        requestBody.put("searchBy", "name");
        requestBody.put("status", "Working");
        requestBody.put("category", "1");
        requestBody.put("flag", "0");

        // Send a POST request with the JSON object as the request body
        Response response = RestAssured.given()
                .header("x-authorization", ITUser)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(fullUrl); // Replace with your API endpoint

        // Print the response body
        System.out.println("Response Body: " + response.getBody().asString());

        // Perform assertions on the response as needed
        response.then()
                .statusCode(200) // Check if the status code is as expected
                .contentType(ContentType.JSON); // Check if the response content type is JSON
    }

    public void inventoryListingUsingFilterCategory() {
        // Create a JSON object for the request payload
        JSONObject requestBody = new JSONObject();
        requestBody.put("searchValue", "scanner");
        requestBody.put("searchBy", "name");
        requestBody.put("category", "1");
        requestBody.put("flag", "0");

        // Send a POST request with the JSON object as the request body
        Response response = RestAssured.given()
                .header("x-authorization", ITUser)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(fullUrl); // Replace with your API endpoint

        // Print the response body
        System.out.println("Response Body: " + response.getBody().asString());

        // Perform assertions on the response as needed
        response.then()
                .statusCode(200) // Check if the status code is as expected
                .contentType(ContentType.JSON); // Check if the response content type is JSON
    }

    public void inventoryListingSearchByName() {
        // Create a JSON object for the request payload
        JSONObject requestBody = new JSONObject();
        requestBody.put("searchValue", "scanner");
        requestBody.put("searchBy", "Name");
        requestBody.put("flag", "0");

        // Send a POST request with the JSON object as the request body
        Response response = RestAssured.given()
                .header("x-authorization", ITUser)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(fullUrl); // Replace with your API endpoint

        // Print the response body
        System.out.println("Response Body: " + response.getBody().asString());

        // Perform assertions on the response as needed
        response.then()
                .statusCode(200) // Check if the status code is as expected
                .contentType(ContentType.JSON); // Check if the response content type is JSON
    }
    public void inventoryListingSearchByCode() {
        // Create a JSON object for the request payload
        JSONObject requestBody = new JSONObject();
        requestBody.put("searchValue", "DEIOS00018");
        requestBody.put("searchBy", "code");
        requestBody.put("flag", "0");

        // Send a POST request with the JSON object as the request body
        Response response = RestAssured.given()
                .header("x-authorization", ITUser)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(fullUrl); // Replace with your API endpoint

        // Print the response body
        System.out.println("Response Body: " + response.getBody().asString());

        // Perform assertions on the response as needed
        response.then()
                .statusCode(200) // Check if the status code is as expected
                .contentType(ContentType.JSON); // Check if the response content type is JSON
    }

    public void inventoryListingSearchBySerial() {
        // Create a JSON object for the request payload
        JSONObject requestBody = new JSONObject();
        requestBody.put("searchValue", "BG2303100042");
        requestBody.put("searchBy", "serial");
        requestBody.put("flag", "0");

        // Send a POST request with the JSON object as the request body
        Response response = RestAssured.given()
                .header("x-authorization", ITUser)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(fullUrl); // Replace with your API endpoint

        // Print the response body
        System.out.println("Response Body: " + response.getBody().asString());

        // Perform assertions on the response as needed
                 response.then()
                .statusCode(200) // Check if the status code is as expected
                .contentType(ContentType.JSON); // Check if the response content type is JSON
    }

}
