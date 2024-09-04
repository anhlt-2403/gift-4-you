package com.mentes_innovadoras.gift4you.payload.request.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
public class OrderRequest {

    @Size(max = 255, message = "Address must be less than or equal to 255 characters")
    @NotBlank
    private String address;

    private Date createAt;

    @Size(max = 255, message = "Description must be less than or equal to 255 characters")
    private String description;

    @NotBlank
    @Size(max = 20, message = "phoneNumber must be less than or equal to 20 characters")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number should be valid")
    private String phoneNumber;

    @NotBlank
    @Positive
    private BigDecimal totalPrice;

    private Date updateAt;

    @NotBlank
    private UUID accountId;
}
