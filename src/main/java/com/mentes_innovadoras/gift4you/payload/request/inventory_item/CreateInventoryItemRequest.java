package com.mentes_innovadoras.gift4you.payload.request.inventory_item;


import jakarta.validation.constraints.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;
@Getter

public class CreateInventoryItemRequest {
    @Size(max = 255)
    private String description;

    @Size(max = 50)
    @NotNull
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @Min(0)
    private Integer stock;

    @NotNull
    private UUID providerId;
}
