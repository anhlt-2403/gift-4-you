package com.mentes_innovadoras.gift4you.payload.reponse.provider;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
public class ProviderResponse {
    private UUID id;

    private Date createAt;

    private Date updateAt;

    private String status;

    private String contactInfo;

    private String name;

    private String address;
}
