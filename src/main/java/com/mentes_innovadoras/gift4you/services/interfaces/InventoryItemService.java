package com.mentes_innovadoras.gift4you.services.interfaces;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.InventoryItemResponse;
import com.mentes_innovadoras.gift4you.payload.request.InventoryItemRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface InventoryItemService {
    Page<InventoryItemResponse> getInventoryItems(Pageable pageable);
    InventoryItemResponse getInventoryItemById(UUID id) throws ArchitectureException;
    InventoryItemResponse createInventoryItem(InventoryItemRequest inventoryItemRequest) throws ArchitectureException;
    InventoryItemResponse updateInventoryItem(UUID id, InventoryItemRequest inventoryItemRequest)throws ArchitectureException;
}
