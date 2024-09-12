package com.mentes_innovadoras.gift4you.payload.request.inventoryItem;

import com.mentes_innovadoras.gift4you.entity.Provider;
import com.mentes_innovadoras.gift4you.payload.request.order_detail_item.OrderDetailItemRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;
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
    @NotNull
    private UUID providerId;
    @NotEmpty
    private Set<OrderDetailItemRequest> items;
}
