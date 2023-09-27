package org.example;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
public class AssetTransferEdit {
    public ExtentTest test;
    public AssetTransferEdit(ExtentTest test)
    {
        this.test = test;
    }
    public void assetTransferEdit() {
        // Create a JSON object for the request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("assetTransId", EditAssetTransferIdFromDatabase.maxIdFromUatPrmJava());
        requestBody.put("receiverId", 12);
        requestBody.put("receiverType", "Doctor");
        requestBody.put("status", "Working");
        requestBody.put("remark", "Edit edit edit Api Automation");

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
        accessory5.put("senderQty", 4);
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
                .header("x-authorization", "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySW5mbyI6eyJpZCI6MTQsImZuYW1lIjoiSmFpcHVyIE1hbHZpeWEiLCJsbmFtZSI6Ik5hZ2FyIiwiZW1haWwiOiJiaGF2bmEuc2luZGh3YW5pQGluc3RhbnRzeXMuY29tIiwidXNlclR5cGUiOiJJVCIsImlzTWZhIjoxLCJ0ZW5hbnRzIjp7IjEiOiJRQSIsIjIiOiJERVYiLCIzIjoiVUFUMSJ9LCJhY3RpdmVUZW5hbnQiOjN9LCJwcml2aWxlZ2VzIjpbInIuYSJdLCJzdWIiOiJqYWkubWFsdml5YW5hZ2FyMSIsImF1ZCI6Im4vYSIsInJvbGVzIjpudWxsfQ.1Doi2HwsnfwzTbK6sli45vUYqV5SL6QFF2oh_inCkdU")
                .contentType(ContentType.JSON)
                .body(requestBody.toString()) // Convert the JSON object to a string
                .when()
                .post("http://ec2-43-205-70-111.ap-south-1.compute.amazonaws.com:8081/asset/edit-initiated-asset");

        int statusCode = response.getStatusCode();
        long responseTime = response.time();
        double responseTimeInSeconds = responseTime / 1000.0;
        System.out.println("Response Time in Seconds: " + responseTimeInSeconds);
        String responseMessage = response.getBody().asString();
        System.out.println("Response Message: " + responseMessage);

        test.log(Status.INFO, "Post Request for Asset Transfer Edit");
        test.log(Status.INFO, "Response Time in Seconds: " + responseTimeInSeconds);
        test.log(Status.INFO,"Response Message : "+ responseMessage);


        if (statusCode == 200) {
            // Handle case when status code is 200 (initiated)
            System.out.println("Asset Transfer Edit Successful");
            test.pass("Asset Transfer Edit Successful");

        }
        else
        {
            test.fail("Asset Transfer Edit Failed with Status code "+statusCode);
            System.out.println("Unknown Status Code: " + statusCode);
        }
    }
}
