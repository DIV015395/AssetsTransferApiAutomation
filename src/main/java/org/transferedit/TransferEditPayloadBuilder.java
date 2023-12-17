package org.transferedit;
import java.util.List;
public class TransferEditPayloadBuilder {
    public static TransferEditPayload buildPayload() {
        return TransferEditPayload.builder()
                .assetTransId(14)
                .receiverId(2)
                .receiverType("IT")
                .status("Damaged")
                .remark("Updated remark.2345000")
                .accessories(List.of(
                       TransferEditPayload.Accessory.builder()
                                .accessoryId(1)
                                .quantity("1")
                                .type("Essential")
                                .senderQty(1)
                                .build()
                ))
                .images(List.of(
                        TransferEditPayload.Image.builder()
                                .thumbUrl("S3 URL-Updated")
                                .imageUrl("image URL-Updated")
                                .build(),
                       TransferEditPayload.Image.builder()
                                .thumbUrl("S3 URL2-Updated")
                                .imageUrl("image URL2-Updated")
                                .build()
                ))
                .build();
    }
}
