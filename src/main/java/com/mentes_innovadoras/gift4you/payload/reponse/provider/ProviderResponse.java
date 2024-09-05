package com.mentes_innovadoras.gift4you.payload.reponse.provider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProviderResponse {
    private UUID id;
    private Instant createAt;
    private Instant updateAt;
    private String status;
    private String contactInfo;
    private String name;
    private String address;
}
