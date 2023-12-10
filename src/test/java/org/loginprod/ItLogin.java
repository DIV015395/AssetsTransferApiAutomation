package org.loginprod;

import io.restassured.RestAssured;
import org.example.EndPointFixed;
import org.example.HeaderUtilFixed;
import org.pojoclass.AuthRequestForIT;
import org.pojoclass.ItJwtToken;
import org.storedatainpropertiesfile.PropertiesLoader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static io.restassured.http.ContentType.JSON;

public class ItLogin {
    @Test()
    public void testItAuthentication()
    {
        AuthRequestForIT authRequestForIT = new AuthRequestForIT();
        authRequestForIT.getUsername();
        authRequestForIT.getPassword();
        Map<String, Object> fixedHeaders = HeaderUtilFixed.createFixedHeaders();
        ItJwtToken itJwtToken = RestAssured.given()
                .headers(fixedHeaders)
                .contentType(JSON)
                .body(authRequestForIT)
                .when()
                .post(EndPointFixed.getAuthUrlsignin())
                .then()
                .log().all() // This line logs the complete request and response details
                .extract().as(ItJwtToken.class);
        String jwtToken = itJwtToken.getJwtToken();
        PropertiesLoader.saveTokenToProperties("itJwtToken", jwtToken);

    }
}
