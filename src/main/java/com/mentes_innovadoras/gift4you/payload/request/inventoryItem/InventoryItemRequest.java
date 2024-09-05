package com.mentes_innovadoras.gift4you.payload.request.inventoryItem;

import com.mentes_innovadoras.gift4you.entity.Provider;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItemRequest {
    private BigDecimal price;
    private Integer stock;
    private Instant createAt;
    private Instant updateAt;
    private String status;
    private String name;
    private String description;
    @NotBlank
    private UUID providerId;
}
