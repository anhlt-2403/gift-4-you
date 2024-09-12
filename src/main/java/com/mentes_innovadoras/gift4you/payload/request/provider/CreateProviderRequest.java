package com.mentes_innovadoras.gift4you.payload.request.provider;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateProviderRequest {
    @Size(max = 50)
    @NotBlank
    private String contactInfo;

    @Size(max = 50)
    @NotBlank
    private String name;

    @Size(max = 255)
    @NotBlank
    private String address;
}
