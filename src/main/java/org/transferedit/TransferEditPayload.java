package org.transferedit;
import lombok.Builder;
import lombok.Data;
import java.util.List;
@Data
@Builder
public class TransferEditPayload {
    private int assetTransId;
    private int receiverId;
    private String receiverType;
    private String status;
    private String remark;
    private List<Accessory> accessories;
    private List<Image> images;

    @Data
    @Builder
    public static class Accessory {
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

