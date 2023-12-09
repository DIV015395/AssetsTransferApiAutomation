package org.testingpojo;


import io.restassured.RestAssured;
import org.example.EndPointFixed;
import org.example.HeaderUtil;
import org.pojoclass.AuthRequestForDoctor;
import org.pojoclass.DoctorJwtToken;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.http.ContentType.JSON;

public class DoctorLogin {

    private String baseUrl;
    @Test()
    public void testAuthentication()
    {

        AuthRequestForDoctor authRequestForDoctor = new AuthRequestForDoctor();
        authRequestForDoctor.getUsername();
        authRequestForDoctor.getPassword();
        Map<String, Object> fixedHeaders = HeaderUtil.createFixedHeaders();
        DoctorJwtToken doctorJwtToken = RestAssured.given()
                .headers(fixedHeaders)
                .contentType(JSON)
                .body(authRequestForDoctor)
                .when()
                .post(EndPointFixed.getAuthUrlsignin())
                .then()
                .log().all() // This line logs the complete request and response details
                .extract().as(DoctorJwtToken.class);
        String jwtToken = doctorJwtToken.getJwtToken();
        System.out.println(jwtToken);
    }
}
