package org.transferedit;
import java.util.List;
public class TransferEditPayloadBuilder {
    public static TransferEditPayload buildPayload() {
        return TransferEditPayload.builder()
                .assetTransId(133)
                .receiverId(13)
                .receiverType("Doctor")
                .status("Working")
                .remark("Edit From Api")
                .accessories(List.of(
                       TransferEditPayload.Accessory.builder()
                                .accessoryId(2)
                                .quantity(5)
                                .type("Essential")
                                .senderQty(9)
                                .build()
                ))
                .images(List.of(
                        TransferEditPayload.Image.builder()
                                .thumbUrl("S3 URL-Updated")
                                .imageUrl("image URL-Updated")
                                .build()
                ))
                .build();
    }
}
