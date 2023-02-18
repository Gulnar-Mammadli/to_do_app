package com.mammadli.to_do_app.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mammadli.to_do_app.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id_user", nullable = false)
    @JsonProperty("id_user")
    private String idUser;

    @Column(name = "user_name", nullable = false, unique = true)
    @JsonProperty("user_name")
    private String username;

    @Column(unique = true, nullable = false)
    @Size(min=6)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

}
