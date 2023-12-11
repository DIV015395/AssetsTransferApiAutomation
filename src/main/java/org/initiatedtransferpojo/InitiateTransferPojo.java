package org.initiatedtransferpojo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public  class  InitiateTransferPojo
{
    private String receiverId;
    private String receiverType;
    private List<Asset> assets;
    @Data
    @Builder
    public static class Asset {
        private String assetId;
        private String status;
        private String remark;
        private List<Accessory> accessories;
        private List<Image> images;

        @Data
        @Builder
        public static class Accessory
        {
            private int accessoryId;
            private int quantity;
            private String type;
            private int senderQty;
        }

        @Data
        @Builder
        public static class Image {
            private String thumbUrl;
            private String imageUrl;
        }
    }
}

