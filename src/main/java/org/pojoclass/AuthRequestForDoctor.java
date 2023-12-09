package org.pojoclass;
import com.fasterxml.jackson.annotation.JsonProperty;
public class AuthRequest {
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("username")
    private String username;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    private String password;

    // Getters and setters
}
