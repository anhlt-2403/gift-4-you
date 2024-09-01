package com.mentes_innovadoras.gift4you.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class LoginRequest {

    @NotBlank(message = "Username cannot be blank")
    @Size(max = 20, message = "Username must be less than or equal to 20 characters")
    private String userName;

    @NotBlank(message = "Password cannot be blank")
    private String password;
}
