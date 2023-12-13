package org.itloginpojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class ItLoginPojo {
    private String username;
    private String password;
}
