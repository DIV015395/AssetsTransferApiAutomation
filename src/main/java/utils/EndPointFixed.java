package utils;

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
    public static String getInitiateTransfer() {
        return initiateTransfer;
    }
    private static String initiateTransfer = baseUrl + "/asset/v1/transfer/init-transfer";

    public static String getDoctorListing() {
        return doctorListing;
    }

    private static String doctorListing = baseUrl + "/asset/v1/assets/doctor-assets";

    public static String getRevokeAssets() {
        return revokeAssets;
    }

    private static String revokeAssets = baseUrl + "/asset/v1/transfer/revoke-initiated-asset";


    public static String getAcceptReject() {
        return acceptReject;
    }

    private static String acceptReject = baseUrl + "/asset/v1/transfer/accept-reject";

    public static String getEditAssetTransfer() {
        return editAssetTransfer;
    }

    private static String editAssetTransfer  = baseUrl + "/asset/v1/transfer/edit-initiated-asset";




}
