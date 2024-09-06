package com.mentes_innovadoras.gift4you.payload.request.order_detail_item;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import java.util.UUID;

@Getter
public class OrderDetailItemRequest {

    @NotNull
    private UUID itemId;

    @NotNull
    @Positive
    private Integer quantity;
}
