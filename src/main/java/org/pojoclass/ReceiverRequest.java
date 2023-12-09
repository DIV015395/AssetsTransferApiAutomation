package org.pojoclass;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReceiverRequest {
    @JsonProperty("receiverId")
    private String receiverId;

    @JsonProperty("receiverType")
    private String receiverType;

    @JsonProperty("assets")
    private List<Assets> assets;

    // Getters and setters
}
