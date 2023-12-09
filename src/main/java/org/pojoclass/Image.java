package org.pojoclass;

import com.fasterxml.jackson.annotation.JsonProperty;

class Image {
    @JsonProperty("thumbUrl")
    private String thumbUrl;

    @JsonProperty("imageUrl")
    private String imageUrl;

    // Getters and setters
}
