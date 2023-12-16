package org.revokepojo;
public class RevokePayloadBuilder {
    public static RevokePayload buildPayload() {
        return RevokePayload.builder()
                .assetId(8)
                .build();
    }
}
