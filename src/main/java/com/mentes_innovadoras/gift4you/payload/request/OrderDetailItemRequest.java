package com.mentes_innovadoras.gift4you.payload.request;

import com.mentes_innovadoras.gift4you.entity.InventoryItem;
import com.mentes_innovadoras.gift4you.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailItemRequest {
    private Integer quantity;
    private InventoryItem inventoryItem;
    private OrderDetail orderDetail;
}
