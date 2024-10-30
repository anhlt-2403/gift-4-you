package com.mentes_innovadoras.gift4you.payload.request.order;

import com.mentes_innovadoras.gift4you.payload.request.order_detail.OrderDetailRequest;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
public class OrderRequest {
    @NotBlank
    @Size(max = 255, message = "Address must be less than or equal to 255 characters")
    private String address;

    @Size(max = 255, message = "Description must be less than or equal to 255 characters")
    private String description;

    @NotBlank
    @Size(max = 20, message = "phoneNumber must be less than or equal to 20 characters")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number should be valid")
    private String phoneNumber;

    @NotNull
    @Positive
    private BigDecimal totalPrice;

    @NotNull
    private UUID accountId;

    private UUID templateId;

    private Set<OrderDetailRequest> orderDetailsRequest;
}
