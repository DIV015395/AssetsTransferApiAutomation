package org.pojoclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ResourceBundle;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItJwtToken
{

    ResourceBundle resourceBundle = ResourceBundle.getBundle("jwt");
    // Accessing values
    @JsonProperty("jwtToken")
    private String jwtToken = resourceBundle.getString("itJwtToken");
    public String getJwtToken() {
        return jwtToken;
    }
}
