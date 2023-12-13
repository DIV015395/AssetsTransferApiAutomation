package org.initiatetransfertest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.utils.EndPointFixed;
import org.utils.HeaderUtilFixed;
import org.initiatedtransferpojo.InitiateTransferPojo;
import org.initiatedtransferpojo.PayloadBuilder;
import org.testng.annotations.Test;
import org.utils.JwtToken;

import java.util.Map;
public class InitiateTransferApiTest
{
    @Test
    public void test()
    {
        InitiateTransferPojo payload = PayloadBuilder.buildMyPayload();
        JwtToken jwtToken = new JwtToken();
        Map<String, Object> fixedHeaders = HeaderUtilFixed.fixedHeaders();
        Response response = RestAssured.given()
                .headers(fixedHeaders)
                .header("x-authorization", jwtToken.getItJwtToken())
                .contentType(ContentType.JSON)
                .body(payload)
                .post(EndPointFixed.getInitiateTransfer()).then()
                .log().all().extract().response();
         System.out.println(response.time());
    }
}
