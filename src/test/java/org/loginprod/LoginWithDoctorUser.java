package org.loginprod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import javax.print.Doc;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class LoginWithDoctorUser {

    ResourceBundle resourceBundle = ResourceBundle.getBundle("userid");
    private String Doctoruser = resourceBundle.getString("Doctor");
    private String Password = resourceBundle.getString("Password");
    private String jwtToken;
    @Test(priority = 1)
    public void signInTest() {
        // Base URL of the API
        String baseUrl = "http://ec2-43-205-70-111.ap-south-1.compute.amazonaws.com:8081";

        // Create a JSON object for the request body
        JSONObject requestBody = new JSONObject()
                .put("username", Doctoruser)
                .put("password", Password);

        // Send a POST request and capture the response
        Response response = (Response) RestAssured.given()
                .baseUri(baseUrl)
                .basePath("/auth/signin")
                .contentType(ContentType.JSON)
                .body(requestBody.toString()) // Convert the JSON object to a string
                .when()
                .post();


        // Get the response message
        String responseBody = response.getBody().asString();

        // Print the response message
        System.out.println("Response Message: " + responseBody);

        // You can also get other details from the response, such as status code, headers, etc.
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);

        jwtToken = response.path("jwtToken");

        // Print the JWT token in JSON format
        System.out.println("JWT Token in JSON format: " + jwtToken);

    }
    @Test(priority = 2)
    public void tokenChange()
    {
        // Load the ResourceBundle
        ResourceBundle resourceBundle = ResourceBundle.getBundle("logintoken");

        String currentITValue = resourceBundle.getString("Doctor");

        String newDoctorValue = jwtToken; // Change this to your desired value

        // Update the properties file
        try {
            String propertiesFilePath = "C:\\Users\\ManjeetSharma\\Downloads\\AssetsTransferApiAutomation\\resources\\logintoken.properties";
            FileInputStream fileInputStream = new FileInputStream(propertiesFilePath);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();

            // Update the IT property value
            properties.setProperty("Doctor", newDoctorValue);

            // Save the updated properties to the file
            FileOutputStream fileOutputStream = new FileOutputStream(propertiesFilePath);
            properties.store(fileOutputStream, null);
            fileOutputStream.close();

            System.out.println("Property 'Doctor' updated to " + newDoctorValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
