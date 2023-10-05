package org.example;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

public class DoctorSideAssetListing {



    ResourceBundle resourceBundle = ResourceBundle.getBundle("baseurl");
    private String baseUrl = resourceBundle.getString("baseUrl");
    private String endpoint = "/asset/doctor-assets?page=1&size=10";
    private String fullUrl = String.format("%s%s", baseUrl, endpoint);
    ResourceBundle resourceBundleLoginToken = ResourceBundle.getBundle("logintoken");
    private String doctorUser = resourceBundleLoginToken.getString("Doctor");

    private ExtentTest test;
    public DoctorSideAssetListing(ExtentTest test)
    {
        this.test = test;
    }


    public void testDoctorSideAssetListing() {
        // Send a GET request with the authorization header
        Response response = RestAssured.given()
                .header("x-authorization", doctorUser)
                .contentType(ContentType.JSON)
                .when()
                .get(fullUrl); // Replace with your API endpoint

        int statusCode = response.getStatusCode();
        long responseTime = response.time();
        String responseMessage = response.getBody().asString();
// Optionally, you can convert the response time to seconds
        double responseTimeInSeconds = responseTime / 1000.0;
        System.out.println("Response Time in Seconds: " + responseTimeInSeconds);


        test.log(Status.INFO, "Post Request for Asset Transfer Revoke");
        test.log(Status.INFO, "Response Time in Seconds: " + responseTimeInSeconds);
        test.log(Status.INFO,"Response Message : "+responseMessage);

        if (statusCode ==200)
        {
            System.out.println("Doctor Side Asset Listing working fine with Status code : "+statusCode);
            test.pass("Doctor Assets Listing With Status code "+statusCode);
        }
        else if (statusCode ==404) {
            test.fail("Doctor Assets Listing Failed "+statusCode);
            System.out.println("Asset Not found for Doctor Listing, Empty asset");

        }
        else
        {
            test.fail("Doctor Assets Listing Failed "+statusCode);
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