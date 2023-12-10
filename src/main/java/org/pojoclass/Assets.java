package org.pojoclass;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Assets {
    @JsonProperty("assetId")
    private String assetId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("remark")
    private String remark;

    @JsonProperty("accessories")
    private List<Accessory> accessories;

    @JsonProperty("images")
    private List<Image> images;

    // Getters and setters
}

