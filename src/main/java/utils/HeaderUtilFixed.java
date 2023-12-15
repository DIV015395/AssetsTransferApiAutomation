package utils;
import java.util.Map;
public class HeaderUtilFixed
{
    public static Map<String, Object> fixedHeaders() {
        return Map.of(
                "X-HMAC-FROM", "MOBILE-APP",
                "X-APP-DEVICE-ID", "1",
                "X-APP-OS", "IOS",
                "X-APP-VERSION", "11"
        );
    }
    public static Map<String, Object> blankValuesHeaders() {
        return Map.of(
                "X-HMAC-FROM", "",
                "X-APP-DEVICE-ID", "",
                "X-APP-OS", "",
                "X-APP-VERSION", ""
        );
    }
    public static Map<String, Object> withoutInXhmacHeaders() {
        return Map.of(
                "X-APP-DEVICE-ID", "1",
                "X-APP-OS", "IOS",
                "X-APP-VERSION", "11"
        );
    }
    public static Map<String, Object> withoutInDeviceIdHeaders() {
        return Map.of(
                "X-HMAC-FROM", "App",
                "X-APP-OS", "IOS",
                "X-APP-VERSION", "11"
        );
    }
    public static Map<String, Object> withoutInOsVersionHeaders() {
        return Map.of(
                "X-HMAC-FROM", "App",
                "X-APP-DEVICE-ID", "1",
                "X-APP-VERSION", "11"
        );
    }
    public static Map<String, Object> withoutInOsVersionIdHeaders() {
        return Map.of(
                "X-HMAC-FROM", "App",
                "X-APP-DEVICE-ID", "1",
                "X-APP-OS", "IOS"
        );
    }
}