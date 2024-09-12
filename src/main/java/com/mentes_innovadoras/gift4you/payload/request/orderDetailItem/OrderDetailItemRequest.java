package com.mentes_innovadoras.gift4you.payload.request.orderDetailItem;

import com.mentes_innovadoras.gift4you.entity.InventoryItem;
import com.mentes_innovadoras.gift4you.entity.OrderDetail;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailItemRequest {
    private Integer quantity;
    @NotBlank
    private UUID inventoryItemId;
    @NotBlank
    private UUID orderDetailId;
}
