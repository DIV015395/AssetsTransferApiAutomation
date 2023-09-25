//User jai.malviyanagar1 = token

package org.example;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class AssetTransferInitiated {

    public void testAssetTransfer() {
        // Create a JSON object for the entire request
        JSONObject requestBody = new JSONObject();
        // Add the receiver details
        requestBody.put("receiverId", "12");
        requestBody.put("receiverType", "Doctor");

        // Create an array for assets
        JSONArray assetsArray = new JSONArray();

        // Create an asset object
        JSONObject assetObject = new JSONObject();
        assetObject.put("assetId", "1");
        assetObject.put("status", "Working");
        assetObject.put("remark", "15-09-23 testing android");

        // Create an array for accessories
        JSONArray accessoriesArray = new JSONArray();

        // Create accessory objects and add them to the accessories array
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

        // Create an array for images
        JSONArray imagesArray = new JSONArray();
        // Create image objects and add them to the images array
        JSONObject image1 = new JSONObject();
        image1.put("thumbUrl", "S3 URL");
        image1.put("imageUrl", "image URL");
        imagesArray.put(image1);

        // Add accessories and images arrays to the asset object
        assetObject.put("accessories", accessoriesArray);
        assetObject.put("images", imagesArray);

        // Add the asset object to the assets array
        assetsArray.put(assetObject);

        // Add the assets array to the main request body
        requestBody.put("assets", assetsArray);

        // Send a POST request with the JSON object as the request body
        Response response = RestAssured.given()
                .header("x-authorization", "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySW5mbyI6eyJpZCI6MTQsImZuYW1lIjoiSmFpcHVyIE1hbHZpeWEiLCJsbmFtZSI6Ik5hZ2FyIiwiZW1haWwiOiJiaGF2bmEuc2luZGh3YW5pQGluc3RhbnRzeXMuY29tIiwidXNlclR5cGUiOiJJVCIsImlzTWZhIjoxLCJ0ZW5hbnRzIjp7IjEiOiJRQSIsIjIiOiJERVYiLCIzIjoiVUFUMSJ9LCJhY3RpdmVUZW5hbnQiOjN9LCJwcml2aWxlZ2VzIjpbInIuYSJdLCJzdWIiOiJqYWkubWFsdml5YW5hZ2FyMSIsImF1ZCI6Im4vYSIsInJvbGVzIjpudWxsfQ.1Doi2HwsnfwzTbK6sli45vUYqV5SL6QFF2oh_inCkdU")
                .contentType(ContentType.JSON)
                .body(requestBody.toString()) // Convert the JSON object to a string
                .when()
                .post("http://ec2-43-205-70-111.ap-south-1.compute.amazonaws.com:8081/asset/init-transfer");

        int statusCode = response.getStatusCode();
        long responseTime = response.time();
// Optionally, you can convert the response time to seconds
        double responseTimeInSeconds = responseTime / 1000.0;

        System.out.println("Response Time in Seconds: " + responseTimeInSeconds);
// Optionally, you can also print the response message
        String responseMessage = response.getBody().asString();
        System.out.println("Response Message: " + responseMessage);


// Conditionally handle different status codes
        if (statusCode == 200) {
            // Handle case when status code is 200 (initiated)
            System.out.println("Initiated");
        } else if (statusCode == 208) {
            // Handle case when status code is 208 (already initiated)
            System.out.println("Already Initiated");
        } else if (statusCode == 400) {
            // Handle case when status code is 404 (server-side issue)
            System.out.println("Failed to read request, Bad Request");
        } else {
            // Handle other status codes as needed
            System.out.println("Unknown Status Code: " + statusCode);
        }
    }
}
