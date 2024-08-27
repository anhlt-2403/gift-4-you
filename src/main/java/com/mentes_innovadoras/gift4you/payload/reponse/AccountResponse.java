package com.mentes_innovadoras.gift4you.payload.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountResponse {
    private UUID id;
    private String fullName;
    private String email;
    private String status;
    private String gender;
    private Instant createAt;
    private Instant updateAt;
    private String urlImg;
    private String phoneNumber;
    private String userName;
}
