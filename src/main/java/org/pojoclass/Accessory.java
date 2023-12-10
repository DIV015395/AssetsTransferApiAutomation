package org.pojoclass;

import com.fasterxml.jackson.annotation.JsonProperty;

class Accessory {
    @JsonProperty("accessoryId")
    private int accessoryId;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("type")
    private String type;

    @JsonProperty("senderQty")
    private int senderQty;

    // Getters and setters
}