//Login with Doctor Token =  12 ; jai.banipark1


package org.example;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

public class InitiatedAssetListing
{
    public ExtentTest test;
    public InitiatedAssetListing(ExtentTest test)
    {
        this.test = test;
    }
    public void testGetInitiatedAssets() {
        // Set the base URI for the API

        // Send a GET request with the "x-authorization" token
        Response response = RestAssured.given()
                .header("x-authorization", "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySW5mbyI6eyJpZCI6MTIsImZuYW1lIjoiSmFpcHVyIEJhbmkiLCJsbmFtZSI6IlBhcmsiLCJlbWFpbCI6IiIsInVzZXJUeXBlIjoiRG9jdG9yIiwiaXNNZmEiOjEsInRlbmFudHMiOnsiMSI6IlFBIiwiMiI6IkRFViIsIjMiOiJVQVQxIn0sImFjdGl2ZVRlbmFudCI6M30sInByaXZpbGVnZXMiOlsici5hIl0sInN1YiI6ImphaS5iYW5pcGFyazEiLCJhdWQiOiJuL2EiLCJyb2xlcyI6bnVsbH0.sHwzVxAWIxSNxfVw_nMSWxd1cHutvNUomfZ-9BzXTj4") // Replace with your actual token
                .when()
                .get("http://ec2-43-205-70-111.ap-south-1.compute.amazonaws.com:8081/asset/initiated-assets");

        int statusCode = response.getStatusCode();
        long responseTime = response.time();
        double responseTimeInSeconds = responseTime / 1000.0;
        String responseMessage = response.getBody().asString();
        System.out.println("Response Time in Seconds: " + responseTimeInSeconds);


        test.log(Status.INFO, "Get Request for Initiate Asset Listing");
        test.log(Status.INFO, "Response Time in Seconds: " + responseTimeInSeconds);
        test.log(Status.INFO,"Response Message : "+responseMessage);

        if (statusCode == 200) {
            // Handle case when status code is 200 (initiated)
            System.out.println("Showing Initiated Assets Listing Requesting");
            test.pass("Initiate assets listing Successful with status code : "+statusCode);
        } else {
            test.fail("Initiate assets listing Failed with status code : " +statusCode);
            // Handle other status codes as needed
            System.out.println("Not Working: " + statusCode);
        }

//        String jsonResponse = response.getBody().asString();
//
//        // Create an ObjectMapper with pretty-printing enabled
//        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
//
//        try {
//            // Parse the JSON string to a JSON object
//            Object json = objectMapper.readValue(jsonResponse, Object.class);
//
//            // Convert the JSON object to a pretty-printed JSON string
//            String prettyJson = objectMapper.writeValueAsString(json);
//
//            // Print the formatted JSON
//            System.out.println(prettyJson);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String jsonResponse = response.getBody().asString();

        JsonPath jsonPath = new JsonPath(jsonResponse);

        // Extract and print specific data from the "content" array
        int assetId = jsonPath.getInt("content[0].assetId");
        String name = jsonPath.getString("content[0].name");
        String serial = jsonPath.getString("content[0].serial");
        String code = jsonPath.getString("content[0].code");
        String qrCode = jsonPath.getString("content[0].qrCode");

        // Print the extracted data
        System.out.println("Asset ID: " + assetId);
        System.out.println("Name: " + name);
        System.out.println("Serial: " + serial);
        System.out.println("Code: " + code);
        System.out.println("QR Code: " + qrCode);
    }
}
