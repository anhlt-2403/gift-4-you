package com.mentes_innovadoras.gift4you.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

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
}
