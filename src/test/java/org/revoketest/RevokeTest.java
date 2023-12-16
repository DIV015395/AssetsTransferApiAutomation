package org.revoketest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.revokepojo.RevokePayload;
import org.revokepojo.RevokePayloadBuilder;
import org.testng.annotations.Test;
import utils.EndPointFixed;
import utils.HeaderUtilFixed;
import utils.JwtToken;

import java.util.Map;

public class RevokeTest {
    @Test
    public void revokeTest()
    {
        RevokePayload payload = RevokePayloadBuilder.buildPayload();
        JwtToken jwtToken = new JwtToken();
        Map<String, Object> fixedHeaders = HeaderUtilFixed.fixedHeaders();
        Response response = RestAssured.given()
                .headers(fixedHeaders)
                .header("x-authorization", jwtToken.getItJwtToken())
                .contentType(ContentType.JSON)
                .body(payload)
                .post(EndPointFixed.getRevokeAssets()).then()
                .log().all().extract().response();

    }
}
