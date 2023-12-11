package org.initiatedtransferpojo;
import java.util.List;

public class PayloadBuilder
{
    public static InitiateTransferPojo buildMyPayload() {
        return InitiateTransferPojo.builder()
                .receiverId("13")
                .receiverType("Doctor")
                .assets(List.of(
                        InitiateTransferPojo.Asset.builder()
                                .assetId("8")
                                .status("Working")
                                .remark("This for asset 25 remark by sender! from QA server response time check")
                                .accessories(List.of(
                                        InitiateTransferPojo.Asset.Accessory.builder()
                                                .accessoryId(6)
                                                .quantity(5)
                                                .type("Essential")
                                                .senderQty(6)
                                                .build()
                                ))
                                .images(List.of(
                                        InitiateTransferPojo.Asset.Image.builder()
                                                .thumbUrl("S3 URL")
                                                .imageUrl("image URL")
                                                .build(),
                                        InitiateTransferPojo.Asset.Image.builder()
                                                .thumbUrl("S3 URL2")
                                                .imageUrl("image URL2")
                                                .build()
                                ))
                                .build()
                ))
                .build();
    }
}
