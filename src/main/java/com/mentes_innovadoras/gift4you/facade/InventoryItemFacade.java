package com.mentes_innovadoras.gift4you.facade;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.request.inventory_item.CreateInventoryItemRequest;
import com.mentes_innovadoras.gift4you.payload.request.inventory_item.UpdateInventoryItemRequest;
import com.mentes_innovadoras.gift4you.services.interfaces.InventoryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InventoryItemFacade {
    private final InventoryItemService inventoryItemService;

    public Object getInventoryItems(Pageable pageable) {
        return inventoryItemService.getInventoryItems(pageable);
    }

    public Object getInventoryItemById(UUID id) throws ArchitectureException {
        return inventoryItemService.getInventoryItemById(id);
    }

    public Object createInventoryItem(CreateInventoryItemRequest createInventoryItemRequest) throws ArchitectureException {
        return inventoryItemService.createInventoryItem(createInventoryItemRequest);
    }

    public Object updateInventoryItem(UUID id, UpdateInventoryItemRequest updateInventoryItemRequest) throws ArchitectureException {
        return inventoryItemService.updateInventoryItem(id, updateInventoryItemRequest);
    }

}
