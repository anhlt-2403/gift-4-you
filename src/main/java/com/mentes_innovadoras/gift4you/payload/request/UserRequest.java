package com.mentes_innovadoras.gift4you.payload.request;
import com.mentes_innovadoras.gift4you.entity.Role;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "Full name cannot be blank")
    @Size(max = 100, message = "Full name must be less than or equal to 100 characters")
    private String fullName;

    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email must be less than or equal to 100 characters")
    private String email;

    @NotBlank(message = "Email cannot be blank")
    @Size(max = 10, message = "Gender must be less than or equal to 10 characters")
    private String gender;

    @Size(max = 20, message = "phoneNumber must be less than or equal to 20 characters")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number should be valid")
    private String phoneNumber;

    @NotBlank(message = "Username cannot be blank")
    @Size(max = 20, message = "Username must be less than or equal to 20 characters")
    private String userName;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    private Role role;
}
