package org.testcases;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.example.EndPointFixed;
import org.example.HeaderUtilFixed;
import org.inventorypojoclass.ReceiverRequest;
import org.pojoclass.ItJwtToken;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Map;
import static io.restassured.http.ContentType.JSON;
public class InventoryListing {
    @Test
    public void inventoryListing()
    {
        ItJwtToken itJwtToken = new ItJwtToken();
        Map<String, Object> fixedHeaders = HeaderUtilFixed.createFixedHeaders();
        ReceiverRequest receiverRequest = RestAssured.given()
                .headers(fixedHeaders)
                .header("x-authorization",itJwtToken.getJwtToken())
                .contentType(JSON)
                .get(EndPointFixed.getInventoryListing())
                .then()
                .log().all()
                .extract().as(ReceiverRequest.class);
    }
}
