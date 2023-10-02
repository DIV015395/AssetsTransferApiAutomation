package org.example;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class AssetTransferTotpVerify {



    public void verifyTotpVerication()
    {
        JSONObject requestBody = new JSONObject();
        requestBody.put("assetIds", new int[]{1});
        requestBody.put("flag", 0);

        // Send a PUT request with the JSON object as the request body
        Response response = RestAssured.given()
                .header("x-authorization", "your-token-here")
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .put("http://ap-south-1.compute.amazonaws.com:8081/asset/verify-transfer"); // Replace with your API endpoint

        // Print the response body
        System.out.println("Response Body: " + response.getBody().asString());

        // Perform assertions on the response as needed
                 response.then()
                .statusCode(200) // Check if the status code is as expected
                .contentType(ContentType.JSON); // Check if the response content type is JSON
    }
}
