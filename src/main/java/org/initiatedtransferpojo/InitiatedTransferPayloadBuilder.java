package org.initiatedtransferpojo;

import java.util.List;

public class InitiatedTransferPayloadBuilder
{
    public static InitiateTransferPayload buildMyPayload() {
        return InitiateTransferPayload.builder()
                .receiverId("13")
                .receiverType("Doctor")
                .assets(List.of(
                        InitiateTransferPayload.Asset.builder()
                                .assetId("8")
                                .status("Working")
                                .remark("Remarks mention here")
                                .accessories(List.of(
                                        InitiateTransferPayload.Asset.Accessory.builder()
                                                .accessoryId(2)
                                                .quantity(5)
                                                .type("Essential")
                                                .senderQty(1)
                                                .build()
                                ))
                                .images(List.of(
                                        InitiateTransferPayload.Asset.Image.builder()
                                                .thumbUrl("ggggggggg")
                                                .imageUrl("uuuuuuu")
                                                .build()
                                ))
                                .build()
                ))
                .build();
    }
    public static class PayloadReceiverIdIsDoctorAndTypeIsIt {
        public static InitiateTransferPayload buildMyPayload() {
            return InitiateTransferPayload.builder()
                    .receiverId("13")
                    .receiverType("IT")
                    .assets(List.of(
                            InitiateTransferPayload.Asset.builder()
                                    .assetId("8")
                                    .status("Working")
                                    .remark("This for asset 25 remark by sender! from QA server response time check")
                                    .accessories(List.of(
                                            InitiateTransferPayload.Asset.Accessory.builder()
                                                    .accessoryId(2)
                                                    .quantity(1)
                                                    .type("Essential")
                                                    .senderQty(4)
                                                    .build()
                                    ))
                                    .images(List.of(
                                            InitiateTransferPayload.Asset.Image.builder()
                                                    .thumbUrl("S3 URL")
                                                    .imageUrl("image URL")
                                                    .build()
                                    ))
                                    .build()
                    ))
                    .build();
        }
    }
    public static class PayloadAssetIdIsEmpty{
        public static InitiateTransferPayload buildMyPayload() {
            return InitiateTransferPayload.builder()
                    .receiverId("13")
                    .receiverType("Doctor")
                    .assets(List.of(
                            InitiateTransferPayload.Asset.builder()
                                    .assetId("")
                                    .status("Working")
                                    .remark("This for asset 25 remark by sender! from QA server response time check")
                                    .accessories(List.of(
                                            InitiateTransferPayload.Asset.Accessory.builder()
                                                    .accessoryId(6)
                                                    .quantity(5)
                                                    .type("Essential")
                                                    .senderQty(4)
                                                    .build()
                                    ))
                                    .images(List.of(
                                            InitiateTransferPayload.Asset.Image.builder()
                                                    .thumbUrl("S3 URL")
                                                    .imageUrl("image URL")
                                                    .build()
                                    ))
                                    .build()
                    ))
                    .build();
        }
    }
    public static class PayloadStatusIsEmpty{
        public static InitiateTransferPayload buildMyPayload() {
            return InitiateTransferPayload.builder()
                    .receiverId("13")
                    .receiverType("Doctor")
                    .assets(List.of(
                            InitiateTransferPayload.Asset.builder()
                                    .assetId("8")
                                    .status("")
                                    .remark("This for asset 25 remark by sender! from QA server response time check")
                                    .accessories(List.of(
                                            InitiateTransferPayload.Asset.Accessory.builder()
                                                    .accessoryId(6)
                                                    .quantity(5)
                                                    .type("Essential")
                                                    .senderQty(4)
                                                    .build()
                                    ))
                                    .images(List.of(
                                            InitiateTransferPayload.Asset.Image.builder()
                                                    .thumbUrl("S3 URL")
                                                    .imageUrl("image URL")
                                                    .build()
                                    ))
                                    .build()
                    ))
                    .build();
        }
    }


    public static class PayloadStatusIsWrong{
        public static InitiateTransferPayload buildMyPayload() {
            return InitiateTransferPayload.builder()
                    .receiverId("13")
                    .receiverType("Doctor")
                    .assets(List.of(
                            InitiateTransferPayload.Asset.builder()
                                    .assetId("8")
                                    .status("wor")
                                    .remark("This for asset 25 remark by sender! from QA server response time check")
                                    .accessories(List.of(
                                            InitiateTransferPayload.Asset.Accessory.builder()
                                                    .accessoryId(6)
                                                    .quantity(5)
                                                    .type("Essential")
                                                    .senderQty(4)
                                                    .build()
                                    ))
                                    .images(List.of(
                                            InitiateTransferPayload.Asset.Image.builder()
                                                    .thumbUrl("S3 URL")
                                                    .imageUrl("image URL")
                                                    .build()
                                    ))
                                    .build()
                    ))
                    .build();
        }
    }

    public static class AccessoriesTypeIsEmpty
    {
        public static InitiateTransferPayload buildMyPayload() {
            return InitiateTransferPayload.builder()
                    .receiverId("13")
                    .receiverType("Doctor")
                    .assets(List.of(
                            InitiateTransferPayload.Asset.builder()
                                    .assetId("8")
                                    .status("Working")
                                    .remark("This for asset 25 remark by sender! from QA server response time check")
                                    .accessories(List.of(
                                            InitiateTransferPayload.Asset.Accessory.builder()
                                                    .accessoryId(6)
                                                    .quantity(5)
                                                    .type("")
                                                    .senderQty(4)
                                                    .build()
                                    ))
                                    .images(List.of(
                                            InitiateTransferPayload.Asset.Image.builder()
                                                    .thumbUrl("S3 URL")
                                                    .imageUrl("image URL")
                                                    .build()
                                    ))
                                    .build()
                    ))
                    .build();
        }

    }

    public static class AccessoriesTypeIsWrong
    {
        public static InitiateTransferPayload buildMyPayload() {
            return InitiateTransferPayload.builder()
                    .receiverId("13")
                    .receiverType("Doctor")
                    .assets(List.of(
                            InitiateTransferPayload.Asset.builder()
                                    .assetId("8")
                                    .status("Working")
                                    .remark("This for asset 25 remark by sender! from QA server response time check")
                                    .accessories(List.of(
                                            InitiateTransferPayload.Asset.Accessory.builder()
                                                    .accessoryId(6)
                                                    .quantity(5)
                                                    .type("Ess")
                                                    .senderQty(4)
                                                    .build()
                                    ))
                                    .images(List.of(
                                            InitiateTransferPayload.Asset.Image.builder()
                                                    .thumbUrl("S3 URL")
                                                    .imageUrl("image URL")
                                                    .build()
                                    ))
                                    .build()
                    ))
                    .build();
        }

    }

    public static class AssetsImageEmpty
    {
        public static InitiateTransferPayload buildMyPayload() {
            return InitiateTransferPayload.builder()
                    .receiverId("13")
                    .receiverType("Doctor")
                    .assets(List.of(
                            InitiateTransferPayload.Asset.builder()
                                    .assetId("8")
                                    .status("Working")
                                    .remark("This for asset 25 remark by sender! from QA server response time check")
                                    .accessories(List.of(
                                            InitiateTransferPayload.Asset.Accessory.builder()
                                                    .accessoryId(6)
                                                    .quantity(5)
                                                    .type("Ess")
                                                    .senderQty(4)
                                                    .build()
                                    ))
                                    .images(List.of(
                                            InitiateTransferPayload.Asset.Image.builder()
                                                    .thumbUrl("")
                                                    .imageUrl("")
                                                    .build()
                                    ))
                                    .build()
                    ))
                    .build();
        }

    }
    public static class RemarksIsEmpty
    {
        public static InitiateTransferPayload buildMyPayload() {
            return InitiateTransferPayload.builder()
                    .receiverId("13")
                    .receiverType("Doctor")
                    .assets(List.of(
                            InitiateTransferPayload.Asset.builder()
                                    .assetId("8")
                                    .status("Working")
                                    .remark("")
                                    .accessories(List.of(
                                            InitiateTransferPayload.Asset.Accessory.builder()
                                                    .accessoryId(6)
                                                    .quantity(5)
                                                    .type("Essential")
                                                    .senderQty(4)
                                                    .build()
                                    ))
                                    .images(List.of(
                                            InitiateTransferPayload.Asset.Image.builder()
                                                    .thumbUrl("S3 URL")
                                                    .imageUrl("image URL")
                                                    .build()
                                    ))
                                    .build()
                    ))
                    .build();
        }
    }

    public static class AssetIdOutOfDatabase
    {
        public static InitiateTransferPayload buildMyPayload() {
            return InitiateTransferPayload.builder()
                    .receiverId("13")
                    .receiverType("Doctor")
                    .assets(List.of(
                            InitiateTransferPayload.Asset.builder()
                                    .assetId("8")
                                    .status("Working")
                                    .remark("Enter Remarks")
                                    .accessories(List.of(
                                            InitiateTransferPayload.Asset.Accessory.builder()
                                                    .accessoryId(2)
                                                    .quantity(5)
                                                    .type("Essential")
                                                    .senderQty(4)
                                                    .build()
                                    ))
                                    .images(List.of(
                                            InitiateTransferPayload.Asset.Image.builder()
                                                    .thumbUrl("S3 URL")
                                                    .imageUrl("image URL")
                                                    .build()
                                    ))
                                    .build()
                    ))
                    .build();
        }
    }
}
