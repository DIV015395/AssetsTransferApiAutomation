package org.pojoclass;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ResourceBundle;
public class AuthRequestForDoctor
{
    ResourceBundle resourceBundle = ResourceBundle.getBundle("Doctorlogincredential");
    @JsonProperty("username")
   private String username = resourceBundle.getString("username");
    @JsonProperty("password")
    private String password = resourceBundle.getString("password");
    public String getUsername()
    {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
