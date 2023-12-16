package org.revokepojo;

public class RevokePayloadBuilder {
    public static RevokePayload buildPayload() {
        RevokePayload payload = new RevokePayload();
        payload.setAssetId(8);
        return payload;
    }
}