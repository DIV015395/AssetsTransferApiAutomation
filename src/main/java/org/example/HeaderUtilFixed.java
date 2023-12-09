package org.example;
import java.util.Map;
public class HeaderUtil {

    public static Map<String, Object> createFixedHeaders() {
        return Map.of(
                "X-HMAC-FROM", "App",
                "X-APP-DEVICE-ID", "1",
                "X-APP-OS", "IOS",
                "X-APP-VERSION", "11"
        );
    }
}