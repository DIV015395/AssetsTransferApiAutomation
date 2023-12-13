package org.itloginpojo;

import org.doctorloginpojo.DoctorLoginPojo;

import java.util.ResourceBundle;

public class ItPayLoadBuilder
{
    public static ItLoginPojo buildMyPayload() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Itlogincredential");
        String username = resourceBundle.getString("username");
        String password = resourceBundle.getString("password");
        return ItLoginPojo.builder()
                .username(username)
                .password(password)
                .build();
    }
}
