package org.testcases;

import io.restassured.RestAssured;
import org.example.EndPointFixed;
import org.example.HeaderUtilFixed;
import org.inventorypojoclass.ReceiverRequest;
import org.pojoclass.ItJwtToken;

import java.util.Map;

import static io.restassured.http.ContentType.JSON;

public class InventoryListings
{
    public void inventory()
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
