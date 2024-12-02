package com.mentes_innovadoras.gift4you.payload.reponse.order_detail;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class OrderDetailResponse {
    private UUID inventoryItemId;

    private Integer quantity;

}
