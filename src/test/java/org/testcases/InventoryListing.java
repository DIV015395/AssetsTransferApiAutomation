package org.testcases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.example.EndPointFixed;
import org.example.HeaderUtilFixed;
import org.inventorypojoclass.ReceiverRequest;
import org.pojoclass.ItJwtToken;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static io.restassured.http.ContentType.JSON;
public class InventoryListing {
    @Test
    public void inventoryListing() throws IOException {
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

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(receiverRequest);
        System.out.println(jsonString);

        // Write JSON string to a file
        File file = new File("C:\\Users\\ManjeetSharma\\Downloads\\AssetsTransferApiAutomation\\jsonschema\\inventoryschema.json");
        objectMapper.writeValue(file, jsonString);
    }
}
