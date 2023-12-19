package org.editassettransfer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.revokepojo.RevokePayload;
import org.revokepojo.RevokePayloadBuilder;
import org.testng.annotations.Test;
import org.transferedit.TransferEditPayload;
import org.transferedit.TransferEditPayloadBuilder;
import utils.EndPointFixed;
import utils.HeaderUtilFixed;
import utils.JwtToken;
import java.util.Map;
public class EditAssetTransfer {
    @Test
    public void editTest()
    {
        TransferEditPayload payload = TransferEditPayloadBuilder.buildPayload();
        JwtToken jwtToken = new JwtToken();
        Map<String, Object> fixedHeaders = HeaderUtilFixed.fixedHeaders();
        Response response = RestAssured.given()
                .headers(fixedHeaders)
                .header("x-authorization", jwtToken.getItJwtToken())
                .contentType(ContentType.JSON)
                .body(payload)
                .post(EndPointFixed.getEditAssetTransfer()).then()
                .log().all().extract().response();
    }
}
