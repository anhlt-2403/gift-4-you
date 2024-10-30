package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.InventoryItem;
import com.mentes_innovadoras.gift4you.payload.reponse.inventory_item.InventoryItemResponse;
import com.mentes_innovadoras.gift4you.payload.request.inventory_item.CreateInventoryItemRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class InventoryItemMapper {
    private final ModelMapper mapper;

    public InventoryItemMapper(ModelMapper mapper) {
        this.mapper = mapper;
        mapper.addMappings(new PropertyMap<CreateInventoryItemRequest, InventoryItem>() {
            @Override
            protected void configure() {
                skip(destination.getId());
            }
        });
    }




    public InventoryItem toInventoryItemEntity(CreateInventoryItemRequest inventoryItemRequest) {
        return mapper.map(inventoryItemRequest, InventoryItem.class);
    }

    public InventoryItemResponse inventoryItemResponse(InventoryItem inventoryItem) {
        return mapper.map(inventoryItem, InventoryItemResponse.class);
    }
}
