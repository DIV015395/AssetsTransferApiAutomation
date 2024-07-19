package org.acceptreject;
import lombok.Builder;
import lombok.Data;
import java.util.List;
@Data
@Builder
public class AcceptRejectPayload
{
        private int assetId;
        private String status;
        private String remark;
        private String action;
        private List<Accessory> accessories;
        private List<Image> images;
        @Data
        @Builder
        public static class Accessory {
            private int accessoryId;
            private String quantity;
            private String type;
            private int receiverQty;
        }
        @Data
        @Builder
        public static class Image
        {
            private String thumbUrl;
            private String imageUrl;
        }
}

