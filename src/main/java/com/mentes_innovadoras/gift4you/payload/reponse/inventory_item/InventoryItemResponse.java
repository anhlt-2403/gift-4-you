package com.mentes_innovadoras.gift4you.payload.reponse.inventory_item;

import com.mentes_innovadoras.gift4you.payload.reponse.provider.ProviderResponse;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Setter
@Getter
public class InventoryItemResponse {

    private UUID id;

    private OffsetDateTime createAt;

    private String description;

    private String name;

    private BigDecimal price;

    private String status;

    private Integer stock;

    private OffsetDateTime updateAt;

    private ProviderResponse providerResponse;
}
