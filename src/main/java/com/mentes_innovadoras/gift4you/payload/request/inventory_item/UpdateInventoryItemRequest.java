package com.mentes_innovadoras.gift4you.payload.request.inventory_item;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;
@Getter

public class UpdateInventoryItemRequest {
    private String description;

    private String name;

    @Positive
    private BigDecimal price;

    @Min(0)
    private Integer stock;

    private UUID providerId;
}
