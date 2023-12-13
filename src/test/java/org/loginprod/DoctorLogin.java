package org.loginprod;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.doctorloginpojo.DoctorLoginPojo;
import org.doctorloginpojo.DoctorPayLoadBuilder;
import org.utils.EndPointFixed;
import org.utils.HeaderUtilFixed;
import org.storedatainpropertiesfile.PropertiesLoader;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.http.ContentType.JSON;

public class DoctorLogin {

    @Test()
    public void testDoctorLogin()
    {
        DoctorLoginPojo payload = DoctorPayLoadBuilder.buildMyPayload();
        Map<String, Object> fixedHeaders = HeaderUtilFixed.fixedHeaders();
        Response response = RestAssured.given()
                .headers(fixedHeaders)
                .contentType(ContentType.JSON)
                .body(payload)
                .post(EndPointFixed.getAuthUrlsignin()).then()
                .log().all().extract().response();
        PropertiesLoader.saveTokenToProperties("doctorJwtToken", response.jsonPath().getString("jwtToken"));
    }
}
