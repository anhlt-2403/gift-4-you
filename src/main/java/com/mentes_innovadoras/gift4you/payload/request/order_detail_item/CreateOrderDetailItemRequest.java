package com.mentes_innovadoras.gift4you.payload.request.order_detail_item;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDetailItemRequest {
    private Integer quantity;
    @NotNull
    private UUID inventoryItemId;
    @NotNull
    private UUID orderDetailId;
}
