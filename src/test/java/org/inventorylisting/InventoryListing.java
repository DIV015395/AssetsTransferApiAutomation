package org.inventorylisting;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.EndPointFixed;
import utils.HeaderUtilFixed;
import utils.JwtToken;
import java.util.Map;
public class InventoryListing
{
    @Test(description = "Positive Scenario", priority = 1)
    public void inventoryListing()
    {
        JwtToken jwtToken = new JwtToken();
        Map<String, Object> fixedHeaders = HeaderUtilFixed.fixedHeaders();
        Response response = RestAssured.given()
                .headers(fixedHeaders)
                .header("x-authorization", jwtToken.getItJwtToken())
                .contentType(ContentType.JSON)
                .get(EndPointFixed.getInventoryListing()).then()
                .log().all().extract().response();
    }
    @Test (description = "Negative Scenerio without device complete headers",priority = 2)
    public void inventoryListing1()
    {
        JwtToken jwtToken = new JwtToken();
        Map<String, Object> fixedHeaders = HeaderUtilFixed.fixedHeaders();
        Response response = RestAssured.given()
                .header("x-authorization", jwtToken.getItJwtToken())
                .contentType(ContentType.JSON)
                .get(EndPointFixed.getInventoryListing()).then()
                .log().all().extract().response();
    }
    @Test (description = "Negative Scenerio with doctor JWT Token",priority = 3)
    public void inventoryListing2()
    {
        JwtToken jwtToken = new JwtToken();
        Map<String, Object> fixedHeaders = HeaderUtilFixed.fixedHeaders();
        Response response = RestAssured.given()
                .headers(fixedHeaders)
                .header("x-authorization", jwtToken.getDoctorJwtToken())
                .contentType(ContentType.JSON)
                .get(EndPointFixed.getInventoryListing()).then()
                .log().all().extract().response();
    }
    @Test (description ="Without X-Hmac",priority = 4 )
    public void inventoryListing3()
    {
        JwtToken jwtToken = new JwtToken();
        Response response = RestAssured.given()
                .headers(HeaderUtilFixed.withoutInXhmacHeaders())
                .header("x-authorization", jwtToken.getItJwtToken())
                .contentType(ContentType.JSON)
                .get(EndPointFixed.getInventoryListing()).then()
                .log().all().extract().response();
    }
    @Test (description ="Without Device Id",priority = 5 )
    public void inventoryListing4()
    {
        JwtToken jwtToken = new JwtToken();
        Response response = RestAssured.given()
                .headers(HeaderUtilFixed.withoutInDeviceIdHeaders())
                .header("x-authorization", jwtToken.getItJwtToken())
                .contentType(ContentType.JSON)
                .get(EndPointFixed.getInventoryListing()).then()
                .log().all().extract().response();
    }
    @Test (description ="Without OS Version Id",priority = 6 )
    public void inventoryListing5()
    {
        JwtToken jwtToken = new JwtToken();
        Response response = RestAssured.given()
                .headers(HeaderUtilFixed.withoutInOsVersionIdHeaders())
                .header("x-authorization", jwtToken.getItJwtToken())
                .contentType(ContentType.JSON)
                .get(EndPointFixed.getInventoryListing()).then()
                .log().all().extract().response();
    }
    @Test (description ="Without OS Version",priority = 7 )
    public void inventoryListing6()
    {
        JwtToken jwtToken = new JwtToken();
        Response response = RestAssured.given()
                .headers(HeaderUtilFixed.withoutInOsVersionHeaders())
                .header("x-authorization",jwtToken.getItJwtToken())
                .contentType(ContentType.JSON)
                .get(EndPointFixed.getInventoryListing()).then()
                .log().all().extract().response();
    }
    @Test (description ="Blank All Header Value",priority = 8 )
    public void inventoryListing7()
    {
        JwtToken jwtToken = new JwtToken();
        Response response = RestAssured.given()
                .headers(HeaderUtilFixed.blankValuesHeaders())
                .header("x-authorization", jwtToken.getItJwtToken())
                .contentType(ContentType.JSON)
                .get(EndPointFixed.getInventoryListing()).then()
                .log().all().extract().response();
    }
    @Test (description ="Invailid I.T Jwt Token",priority = 9 )
    public void inventoryListing8()
    {
        JwtToken jwtToken = new JwtToken();
        Response response = RestAssured.given()
                .headers(HeaderUtilFixed.fixedHeaders())
                .header("x-authorization", jwtToken.getInvailidJwtToken())
                .contentType(ContentType.JSON)
                .get(EndPointFixed.getInventoryListing()).then()
                .log().all().extract().response();
    }
}
