package org.example;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class DoctorSideAssetListing {

    public ExtentTest test;
    public DoctorSideAssetListing(ExtentTest test)
    {
        this.test = test;
    }


    public void testDoctorSideAssetListing() {
        // Send a GET request with the authorization header
        Response response = RestAssured.given()
                .header("x-authorization", "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySW5mbyI6eyJpZCI6MTIsImZuYW1lIjoiSmFpcHVyIEJhbmkiLCJsbmFtZSI6IlBhcmsiLCJlbWFpbCI6IiIsInVzZXJUeXBlIjoiRG9jdG9yIiwiaXNNZmEiOjEsInRlbmFudHMiOnsiMSI6IlFBIiwiMiI6IkRFViIsIjMiOiJVQVQxIn0sImFjdGl2ZVRlbmFudCI6M30sInByaXZpbGVnZXMiOlsici5hIl0sInN1YiI6ImphaS5iYW5pcGFyazEiLCJhdWQiOiJuL2EiLCJyb2xlcyI6bnVsbH0.sHwzVxAWIxSNxfVw_nMSWxd1cHutvNUomfZ-9BzXTj4")
                .contentType(ContentType.JSON)
                .when()
                .get("http://ec2-43-205-70-111.ap-south-1.compute.amazonaws.com:8081/asset/doctor-assets?page=1&size=10"); // Replace with your API endpoint

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