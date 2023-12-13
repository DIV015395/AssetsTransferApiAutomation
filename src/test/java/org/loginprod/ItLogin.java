package org.loginprod;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.itloginpojo.ItLoginPojo;
import org.itloginpojo.ItPayLoadBuilder;
import org.utils.EndPointFixed;
import org.utils.HeaderUtilFixed;
import org.storedatainpropertiesfile.PropertiesLoader;
import org.testng.annotations.Test;
import java.util.Map;

public class ItLogin {
    @Test()
    public void testDoctorLogin()
    {
        ItLoginPojo payload = ItPayLoadBuilder.buildMyPayload();
        Map<String, Object> fixedHeaders = HeaderUtilFixed.fixedHeaders();
        Response response = RestAssured.given()
                .headers(fixedHeaders)
                .contentType(ContentType.JSON)
                .body(payload)
                .post(EndPointFixed.getAuthUrlsignin()).then()
                .log().all().extract().response();
        PropertiesLoader.saveTokenToProperties("itJwtToken", response.jsonPath().getString("jwtToken"));
    }
}
