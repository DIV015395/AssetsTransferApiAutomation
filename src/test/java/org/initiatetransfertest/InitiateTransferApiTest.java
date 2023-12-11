package org.initiatetransfertest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.EndPointFixed;
import org.example.HeaderUtilFixed;
import org.initiatedtransferpojo.InitiateTransferPojo;
import org.initiatedtransferpojo.PayloadBuilder;
import org.pojoclass.ItJwtToken;
import org.testng.annotations.Test;
import java.util.Map;
public class InitiateTransferApiTest
{
    @Test
    public void test()
    {
        InitiateTransferPojo payload = PayloadBuilder.buildMyPayload();
        ItJwtToken itJwtToken = new ItJwtToken();
        Map<String, Object> fixedHeaders = HeaderUtilFixed.createFixedHeaders();
        Response response = RestAssured.given()
                .headers(fixedHeaders)
                .header("x-authorization", itJwtToken.getJwtToken())
                .contentType(ContentType.JSON)
                .body(payload)
                .post(EndPointFixed.getInitiateTransfer()).then()
                .log().all().extract().response();
         System.out.println(response.time());
    }
}
