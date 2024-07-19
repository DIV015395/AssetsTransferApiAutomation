package org.initiatetransfertest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.EndPointFixed;
import utils.HeaderUtilFixed;
import org.initiatedtransferpojo.InitiateTransferPayload;
import org.initiatedtransferpojo.InitiatedTransferPayloadBuilder;
import org.testng.annotations.Test;
import utils.JwtToken;
import java.util.Map;
public class InitiateTransferApiTest
{
    @Test
    public void test()
    {
        InitiateTransferPayload payload = InitiatedTransferPayloadBuilder.buildMyPayload();
        JwtToken jwtToken = new JwtToken();
        Map<String, Object> fixedHeaders = HeaderUtilFixed.fixedHeaders();
        Response response = RestAssured.given()
                .headers(fixedHeaders)
                .header("x-authorization", jwtToken.getItJwtToken())
                .contentType(ContentType.JSON)
                .body(payload)
                .post(EndPointFixed.getInitiateTransfer()).then()
                .log().all().extract().response();
    }
    @Test
    public void test2()
    {
        InitiateTransferPayload payload = InitiatedTransferPayloadBuilder.PayloadReceiverIdIsDoctorAndTypeIsIt.buildMyPayload();
        JwtToken jwtToken = new JwtToken();
        Map<String, Object> fixedHeaders = HeaderUtilFixed.fixedHeaders();
        Response response = RestAssured.given()
                .headers(fixedHeaders)
                .header("x-authorization", jwtToken.getItJwtToken())
                .contentType(ContentType.JSON)
                .body(payload)
                .post(EndPointFixed.getInitiateTransfer()).then()
                .log().all().extract().response();
    }
}
