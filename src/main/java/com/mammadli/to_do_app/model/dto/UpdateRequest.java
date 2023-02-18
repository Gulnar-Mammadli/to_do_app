package com.mammadli.to_do_app.model.dto;

import com.mammadli.to_do_app.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequest {

    private String username;
    private String password;
    private String email;
    private Role role;
}
