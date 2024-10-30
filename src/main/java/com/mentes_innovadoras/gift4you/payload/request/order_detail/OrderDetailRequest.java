package com.mentes_innovadoras.gift4you.payload.request.order_detail;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


import java.util.UUID;

@Getter
@Setter
public class OrderDetailRequest {
    @NotNull
    @Positive
    private Integer quantity;

    @NotEmpty
    private UUID inventoryItemId;
}
