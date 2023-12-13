package org.inventorylistingpojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceiverRequest {

    private List<Device> assets;

    // Constructors, getters, and setters

    public static class Device {
        private int id;
        private String code;
        private String serial;
        private String qrCode;
        private String name;
        private String model;
        private String state;
        private String status;
        private String transferType;
        private String transferState;
        private int isVerified;
        private int isIncidence;
        private String type;
        private InitUser initUser;
        private String issuedUser;
        private String issuedDate;
        private String commissionedDate;
        private String createdDate;
        private int categoryId;

        private List<Accessory> accessories;  // Correct field declaration

        public List<Accessory> getAccessories() {
            return accessories;
        }

        // Constructors, getters, and setters

        public static class InitUser {
            private int id;
            private String username;
            private String fname;
            private String mname;
            private String lname;
            private String nickname;
            private int assetUserTypeId;
            private String userType;
            private String uid;

            // Constructors, getters, and setters
        }

        public static class Accessory {
            private int id;
            private String name;
            private String code;
            private String type;
            private int quantity;
            private String status;

            // Constructors, getters, and setters
        }
    }
}
