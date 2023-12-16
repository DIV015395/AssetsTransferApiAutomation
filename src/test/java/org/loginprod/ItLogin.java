package org.loginprod;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Link;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.itloginpojo.ItLoginPojo;
import org.itloginpojo.ItPayLoadBuilder;
import utils.EndPointFixed;
import utils.HeaderUtilFixed;
import org.storedatainpropertiesfile.PropertiesLoader;
import org.testng.annotations.Test;

import java.util.Map;


public class ItLogin
{
    @Test
    @Epic("API Tests")
    @Feature("User Authentication")
    @Story("Doctor Login")
    @Description("Test for doctor login using RestAssured")
    @Owner("Your Name")
    @Link(name = "API Documentation", type = "docs", url = "https://api.example.com/docs")
    public void testDoctorLogin()
    {
        ItLoginPojo payload = ItPayLoadBuilder.buildMyPayload();
        Map<String, Object> fixedHeaders = HeaderUtilFixed.fixedHeaders();
        Response response = RestAssured.given()
                .headers(fixedHeaders)
                .contentType(ContentType.JSON)
                .body(payload)
                .post(EndPointFixed.getAuthUrlsignin()).then()
                .log().all().extract().response();
        PropertiesLoader.saveTokenToProperties("itJwtToken", response.jsonPath().getString("jwtToken"));
    }
}
