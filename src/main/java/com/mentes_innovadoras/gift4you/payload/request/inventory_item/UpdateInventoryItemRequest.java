package com.mentes_innovadoras.gift4you.payload.request.inventory_item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;
@Getter

public class UpdateInventoryItemRequest {
    private String description;

    private String name;

    private BigDecimal price;

    private Integer stock;

    private UUID providerId;
}
