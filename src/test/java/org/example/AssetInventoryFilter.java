package org.example;

import com.aventstack.extentreports.ExtentTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class AssetInventoryFilter
{
    ExtentTest test;
    public AssetInventoryFilter(ExtentTest test)
    {
        this.test = test;
    }
    ResourceBundle resourceBundle = ResourceBundle.getBundle("logintoken");
    private String ITUser = resourceBundle.getString("IT");
    ResourceBundle resourceBundles = ResourceBundle.getBundle("baseurl");
    private String baseUrl = resourceBundles.getString("baseUrl");
    private String endpoint = "/asset/filter";
    private String fullUrl = String.format("%s%s", baseUrl, endpoint);
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

        int statusCode = response.statusCode();
        if(statusCode ==200)
        {
            test.pass("Filter Working : SearchValue , SearchBy , Status = Damaged, Category, Flag: "+statusCode);
        }
        else
        {
            test.pass("Filter Working not working : SearchValue , SearchBy , Status = Damaged, Category, Flag: "+statusCode);
        }
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

        int statusCode = response.statusCode();
        if(statusCode ==200)
        {
            test.pass("Filter Working : SearchValue , SearchBy , Status = Working, Category, Flag: "+statusCode);
        }
        else
        {
            test.pass("Filter Working not working : SearchValue , SearchBy , Status = Working, Category, Flag: "+statusCode);
        }
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


        // Perform assertions on the response as needed
        int statusCode = response.statusCode();
        if(statusCode ==200)
        {
            test.pass("Filter Working : SearchValue , SearchBy = name , Category = I.T, Flag: "+statusCode);

        }
        else
        {
            test.pass("Filter Working not Working : SearchValue , SearchBy = name , Category = I.T, Flag: "+statusCode);
        }
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
        int statusCode = response.statusCode();
        if(statusCode ==200)
        {
            test.pass("Filter Working : SearchValue , SearchBy = name , Flag: "+statusCode);
        }
        else
        {
            test.pass("Filter Working not working : SearchValue , SearchBy = name , Flag: "+statusCode);
        }
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



        // Perform assertions on the response as needed
        int statusCode = response.statusCode();
        if(statusCode ==200)
        {
            test.pass("Filter Working : SearchValue , SearchBy = code , Flag: "+statusCode);
        }
        else
        {
            test.pass("Filter Working not working : SearchValue , SearchBy = code , Flag: "+statusCode);
        }
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

        int statusCode = response.statusCode();
        if(statusCode ==200)
        {
            test.pass("Filter Working : SearchValue , SearchBy = serial , Flag: "+statusCode);
        }
        else
        {
            test.pass("Filter Working not working : SearchValue , SearchBy = serial , Flag: "+statusCode);
        }
    }

}
