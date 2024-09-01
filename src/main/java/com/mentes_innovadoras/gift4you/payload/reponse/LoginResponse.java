package com.mentes_innovadoras.gift4you.payload.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginResponse {
    private UUID id;
    private String fullName;
    private String status;
    private String accessToken;
    private long expiresIn;
}
