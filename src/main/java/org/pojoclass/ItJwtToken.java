package org.pojoclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItJwtToken {
    public String getJwtToken() {
        return jwtToken;
    }
    @JsonProperty("jwtToken")
    private String jwtToken;
}
