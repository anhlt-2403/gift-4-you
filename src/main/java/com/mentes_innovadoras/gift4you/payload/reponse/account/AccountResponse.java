package com.mentes_innovadoras.gift4you.payload.reponse.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
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
    private Date createAt;
    private Date updateAt;
    private String urlImg;
    private String phoneNumber;
    private String userName;
}
