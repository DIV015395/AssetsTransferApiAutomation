package org.loginprod;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.doctorloginpojo.DoctorLoginPojo;
import org.doctorloginpojo.DoctorPayLoadBuilder;
import utils.EndPointFixed;
import utils.HeaderUtilFixed;
import org.storedatainpropertiesfile.PropertiesLoader;
import org.testng.annotations.Test;

import java.util.Map;

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
