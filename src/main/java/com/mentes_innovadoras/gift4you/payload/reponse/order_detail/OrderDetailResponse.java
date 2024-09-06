package com.mentes_innovadoras.gift4you.payload.reponse.order_detail;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderDetailResponse {
    private UUID id;

    private BigDecimal price;

    private Integer quantity;

    private String description;
}
