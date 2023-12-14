package org.doctorloginpojo;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
@Data
@Builder
@AllArgsConstructor
public class DoctorLoginPojo {
    private String username;
    private String password;
}

