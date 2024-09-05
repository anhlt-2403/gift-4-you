package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.InventoryItem;
import com.mentes_innovadoras.gift4you.payload.reponse.inventoryItem.InventoryItemResponse;
import com.mentes_innovadoras.gift4you.payload.reponse.order.OrderResponse;
import com.mentes_innovadoras.gift4you.payload.request.inventoryItem.InventoryItemRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class InventoryItemMapper {
    private final ModelMapper mapper;
    public InventoryItemMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public InventoryItem toInventoryItemEntity(InventoryItemRequest inventoryItemRequest) {
        return mapper.map(inventoryItemRequest, InventoryItem.class);
    }

    public InventoryItemResponse toInventoryItemResponse(InventoryItem inventoryItem) {
        InventoryItemResponse response = mapper.map(inventoryItem, InventoryItemResponse.class);
        response.setProviderId(inventoryItem.getProvider().getId().toString());
        return response;
    }
}
