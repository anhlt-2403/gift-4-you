package com.mentes_innovadoras.gift4you.facade;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.inventoryItem.InventoryItemResponse;
import com.mentes_innovadoras.gift4you.payload.request.inventoryItem.InventoryItemRequest;
import com.mentes_innovadoras.gift4you.services.interfaces.InventoryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InventoryItemFacade {
    private final InventoryItemService inventoryItemService;

    public Page<InventoryItemResponse> getInventoryItems(Pageable pageable){
        return inventoryItemService.getInventoryItems(pageable);
    }

    public Object getInventoryItemById(UUID id) throws ArchitectureException {
        return inventoryItemService.getInventoryItemById(id);
    }

    public Object CreateInventoryItem(InventoryItemRequest inventoryItemRequest) throws ArchitectureException {
        return inventoryItemService.createInventoryItem(inventoryItemRequest);
    }

    public Object UpdateInventoryItem(UUID id, InventoryItemRequest inventoryItemRequest) throws ArchitectureException {
        return inventoryItemService.updateInventoryItem(id, inventoryItemRequest);
    }
}
