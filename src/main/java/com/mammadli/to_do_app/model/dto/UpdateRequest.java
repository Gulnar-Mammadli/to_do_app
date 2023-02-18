package com.mammadli.to_do_app.model.dto;

import com.mammadli.to_do_app.enums.Role;
import lombok.Data;

@Data
public class UpdateRequest {

    private String username;
    private String password;
    private String email;
    private Role role;
}
