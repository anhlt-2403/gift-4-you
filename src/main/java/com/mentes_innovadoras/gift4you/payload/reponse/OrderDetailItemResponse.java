package com.mentes_innovadoras.gift4you.payload.reponse;

import com.mentes_innovadoras.gift4you.entity.InventoryItem;
import com.mentes_innovadoras.gift4you.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailItemResponse {
    private UUID id;
    private Integer quantity;
    private InventoryItem inventoryItem;
    private OrderDetail orderDetail;
}
