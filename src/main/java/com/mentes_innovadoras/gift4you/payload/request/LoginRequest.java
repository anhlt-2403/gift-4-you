package com.mentes_innovadoras.gift4you.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class LoginRequest {

    @NotBlank(message = "Phone number cannot be blank")
    @Size(max = 20, message = "Phone number must be less than or equal to 20 characters")
    private String phoneNumber;

    @NotBlank(message = "Password cannot be blank")
    private String password;
}
