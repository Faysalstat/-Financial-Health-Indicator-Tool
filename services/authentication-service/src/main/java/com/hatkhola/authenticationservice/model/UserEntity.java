package com.hatkhola.authenticationservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    private String userName;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserEntity(String userName, String password, List<GrantedAuthority> authorities) {
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }

}
