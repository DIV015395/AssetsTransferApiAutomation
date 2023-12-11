package org.example;
import java.util.Map;
public class HeaderUtilFixed
{
    public static Map<String, Object> createFixedHeaders() {
        return Map.of(
                "X-HMAC-FROM", "App",
                "X-APP-DEVICE-ID", "1",
                "X-APP-OS", "IOS",
                "X-APP-VERSION", "11"
        );
    }
}