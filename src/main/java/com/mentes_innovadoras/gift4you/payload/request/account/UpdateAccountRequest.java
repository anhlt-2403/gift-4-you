package com.mentes_innovadoras.gift4you.payload.request.account;

import lombok.Getter;
import jakarta.validation.constraints.Size;
@Getter
public class UpdateAccountRequest {
    @Size(max = 100, message = "Full name must be less than or equal to 100 characters")
    private String fullName;

    @Size(max = 100, message = "Email must be less than or equal to 100 characters")
    private String email;

    @Size(max = 10, message = "Gender must be less than or equal to 10 characters")
    private String gender;
}
