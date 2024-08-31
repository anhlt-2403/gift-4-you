package com.mentes_innovadoras.gift4you.payload.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InventoryItemResponse {
    private UUID id;
    private BigDecimal price;
    private Integer stock;
    private Instant createAt;
    private Instant updateAt;
    private String status;
    private String name;
    private String description;
}
