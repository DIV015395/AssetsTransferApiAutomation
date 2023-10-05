package org.example;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.ResourceBundle;

public class AssetRequestAccept
{
    ResourceBundle resourceBundle = ResourceBundle.getBundle("baseurl");
    private String baseUrl = resourceBundle.getString("baseUrl");
    private String endpoint = "/asset/accept-reject";
    private String fullUrl = String.format("%s%s", baseUrl, endpoint);
    ResourceBundle resourceBundleLoginToken = ResourceBundle.getBundle("logintoken");
    private String doctorUser = resourceBundleLoginToken.getString("Doctor");

    private ExtentTest test;
    public AssetRequestAccept(ExtentTest test)
    {
        this.test = test;
    }
    public void testAssetRequestAccept()
    {
        // Create a JSON object for the request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("assetId", 1);
        requestBody.put("status", "Working");
        requestBody.put("remark", "Accepted by banipark1 by Api automation ");
        requestBody.put("action" , "Accepted");

        // Create an array for accessories
        JSONArray accessoriesArray = new JSONArray();

        JSONObject accessory1 = new JSONObject();
        accessory1.put("accessoryId", 1);
        accessory1.put("quantity", 1);
        accessory1.put("type", "Essential");
        accessory1.put("senderQty", 1);
        accessoriesArray.put(accessory1);

        JSONObject accessory2 = new JSONObject();
        accessory2.put("accessoryId", 2);
        accessory2.put("quantity", 1);
        accessory2.put("type", "Essential");
        accessory2.put("senderQty", 1);
        accessoriesArray.put(accessory2);

        JSONObject accessory3 = new JSONObject();
        accessory3.put("accessoryId", 3);
        accessory3.put("quantity", 1);
        accessory3.put("type", "Essential");
        accessory3.put("senderQty", 1);
        accessoriesArray.put(accessory3);

        JSONObject accessory4 = new JSONObject();
        accessory4.put("accessoryId", 4);
        accessory4.put("quantity", 1);
        accessory4.put("type", "Essential");
        accessory4.put("senderQty", 1);
        accessoriesArray.put(accessory4);

        JSONObject accessory5 = new JSONObject();
        accessory5.put("accessoryId", 5);
        accessory5.put("quantity", 5);
        accessory5.put("type", "Fixture");
        accessory5.put("senderQty", 5);
        accessoriesArray.put(accessory5);


        requestBody.put("accessories", accessoriesArray);
        // Create an array for images
        JSONArray imagesArray = new JSONArray();

        JSONObject image1 = new JSONObject();
        image1.put("thumbUrl", "Edit S3 URL");
        image1.put("imageUrl", "Edit image URL");
        imagesArray.put(image1);

        requestBody.put("images", imagesArray);


        // Send a POST request with the JSON object as the request body
        Response response = RestAssured.given()
                .header("x-authorization", doctorUser)
                .contentType(ContentType.JSON)
                .body(requestBody.toString()) // Convert the JSON object to a string
                .when()
                .post(fullUrl);

        int statusCode = response.getStatusCode();

        long responseTime = response.time();
// Optionally, you can convert the response time to seconds
        double responseTimeInSeconds = responseTime / 1000.0;

        test.log(Status.INFO, "Post Request for asset request accept");
        test.log(Status.INFO, "Response Time in Seconds: " + responseTimeInSeconds);
        System.out.println("Response Time in Seconds: " + responseTimeInSeconds);
// Optionally, you can also print the response message
        String responseMessage = response.getBody().asString();
        System.out.println("Response Message: " + responseMessage);
        test.log(Status.INFO, "Response Message: " + responseMessage);

        if(statusCode ==200)
        {
            test.pass("Asset Request accept by doctor with status code "+statusCode);
        }
        else
        {
            test.fail("Asset Request accept not working "+statusCode);
        }
    }
}

