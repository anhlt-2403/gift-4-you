package com.mentes_innovadoras.gift4you.payload.request.inventory_item;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    private BigDecimal price;

    @NotNull
    private Integer stock;

    @NotNull
    private UUID providerId;
}
