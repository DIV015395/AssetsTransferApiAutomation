//User jai.malviyanagar1 = token

package org.example;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class AssetTransferRevoke {

    public ExtentTest test;
    public AssetTransferRevoke(ExtentTest test)
    {
        this.test = test;
    }
    public void testRevokeAsset() {
        // Create a JSON object for the request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("assetId", 1);
        requestBody.put("senderId", 14);
        requestBody.put("senderRole", "IT");

        // Send a POST request with the JSON object as the request body
        Response response = RestAssured.given()
                .header("x-authorization", "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySW5mbyI6eyJpZCI6MTQsImZuYW1lIjoiSmFpcHVyIE1hbHZpeWEiLCJsbmFtZSI6Ik5hZ2FyIiwiZW1haWwiOiJiaGF2bmEuc2luZGh3YW5pQGluc3RhbnRzeXMuY29tIiwidXNlclR5cGUiOiJJVCIsImlzTWZhIjoxLCJ0ZW5hbnRzIjp7IjEiOiJRQSIsIjIiOiJERVYiLCIzIjoiVUFUMSJ9LCJhY3RpdmVUZW5hbnQiOjN9LCJwcml2aWxlZ2VzIjpbInIuYSJdLCJzdWIiOiJqYWkubWFsdml5YW5hZ2FyMSIsImF1ZCI6Im4vYSIsInJvbGVzIjpudWxsfQ.1Doi2HwsnfwzTbK6sli45vUYqV5SL6QFF2oh_inCkdU")
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post("http://ec2-43-205-70-111.ap-south-1.compute.amazonaws.com:8081/asset/revoke-initiated-asset");

        // Perform assertions on the response as needed
        int statusCode = response.getStatusCode();


        long responseTime = response.time();

        double responseTimeInSeconds = responseTime / 1000.0;

        System.out.println("Response Time in Seconds: " + responseTimeInSeconds);
        String responseMessage = response.getBody().asString();
        System.out.println("Response Message: " + responseMessage);

        test.log(Status.INFO, "Post Request for Asset Transfer Revoke");
        test.log(Status.INFO, "Response Time in Seconds: " + responseTimeInSeconds);
        test.log(Status.INFO,"Response Message : "+responseMessage);
        if (statusCode == 200) {
            // Handle case when status code is 200 (initiated)
            System.out.println("Assets Transfer Revoke");
            test.pass("Asset Transfer Revoke successful "+statusCode);
        }
        else if (statusCode == 404)
        {
            test.fail("Asset Transfer Revoke failed"+statusCode);
            System.out.println("There no assets for Revoke");
        } else {
            // Handle other status codes as needed
            System.out.println("Unknown Status Code: " + statusCode);
            test.fail("Asset Transfer Revoke failed"+statusCode);
        }
        test.log(Status.INFO, responseMessage);
    }
}

