package com.hatkhola.authenticationservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AthenticationResponse {
    private String token;

    public AthenticationResponse(String token) {
        this.token = token;
    }
}
