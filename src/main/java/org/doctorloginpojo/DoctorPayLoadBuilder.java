package org.doctorloginpojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ResourceBundle;

public class DoctorPayLoadBuilder
{
    public static DoctorLoginPojo buildMyPayload() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Doctorlogincredential");
        String username = resourceBundle.getString("username");
        String password = resourceBundle.getString("password");
        return DoctorLoginPojo.builder()
                .username(username)
                .password(password)
                .build();
    }
}

