package com.mentes_innovadoras.gift4you.payload.request.account;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class AccountRequest {

    @Size(max = 100, message = "Full name must be less than or equal to 100 characters")
    private String fullName;

    @Size(max = 100, message = "Email must be less than or equal to 100 characters")
    private String email;

    @Size(max = 10, message = "Gender must be less than or equal to 10 characters")
    private String gender;

    @NotBlank
    @Size(max = 20, message = "phoneNumber must be less than or equal to 20 characters")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number should be valid")
    private String phoneNumber;

    @NotBlank(message = "Username cannot be blank")
    @Size(max = 20, message = "Username must be less than or equal to 20 characters")
    private String userName;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    private String urlImg;

    @NotBlank(message = "Role cannot be blank")
    private String role;
}
