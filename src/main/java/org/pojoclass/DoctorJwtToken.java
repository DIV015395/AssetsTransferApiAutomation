package org.pojoclass;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorJwtToken {
    public String getJwtToken() {
        return jwtToken;
    }
    @JsonProperty("jwtToken")
    private String jwtToken;
}
