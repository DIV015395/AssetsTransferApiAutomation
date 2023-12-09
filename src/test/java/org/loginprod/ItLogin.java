package org.testingpojo;

import io.restassured.RestAssured;
import org.example.EndPointFixed;
import org.example.HeaderUtil;
import org.pojoclass.AuthRequestForDoctor;
import org.pojoclass.AuthRequestForIT;
import org.pojoclass.DoctorJwtToken;
import org.pojoclass.ItJwtToken;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.http.ContentType.JSON;

public class ItLogin
{
    private String baseUrl;
    @Test()
    public void testAuthentication()
    {
        System.out.println(EndPointFixed.getAuthUrlsignin());
        AuthRequestForIT authRequestForIT = new AuthRequestForIT();
        authRequestForIT.getUsername();
        authRequestForIT.getPassword();
        Map<String, Object> fixedHeaders = HeaderUtil.createFixedHeaders();
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
        System.out.println(jwtToken);
    }
}
