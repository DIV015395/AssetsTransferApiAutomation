package org.example;

import java.util.ResourceBundle;

public class EndPointFixed
{
    static ResourceBundle resourceBundle = ResourceBundle.getBundle("baseurl");
    private static String baseUrl = resourceBundle.getString("baseUrl");
    // For Login
    private static String endpoint = "/auth/signin";
    private static String authUrlsignin = baseUrl+endpoint;
    public static String getAuthUrlsignin() {
        return authUrlsignin;
    }
    //
    private static String inventoryListing = baseUrl + "/asset/v1/assets/inventory";
    public static String getInventoryListing() {
        return inventoryListing;
    }


}
