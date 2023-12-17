package org.acceptreject;
import java.util.List;
public class AcceptRejectPayloadBuilder {
    public static AcceptRejectPayload buildPayload()
    {
        return AcceptRejectPayload.builder()
                .assetId(8)
                .status("Working")
                .remark("aacept by aatem")
                .action("Accepted")
                .accessories(List.of(
                        AcceptRejectPayload.Accessory.builder()
                                .accessoryId(6)
                                .quantity("5")
                                .type("Essential")
                                .receiverQty(4)
                                .build()
                ))
                .images(List.of(
                        AcceptRejectPayload.Image.builder()
                                .thumbUrl("S3 URL R")
                                .imageUrl("image URL R")
                                .build(),
                        AcceptRejectPayload.Image.builder()
                                .thumbUrl("S3 URL2 R")
                                .imageUrl("image URL2 R")
                                .build()
                ))
                .build();
    }
}
