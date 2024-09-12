package com.mentes_innovadoras.gift4you.services.interfaces;


import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.inventoryItem.InventoryItemResponse;
import com.mentes_innovadoras.gift4you.payload.request.inventoryItem.InventoryItemRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

import java.util.UUID;

public interface InventoryItemService {
    PagedModel<InventoryItemResponse> getInventoryItems(Pageable pageable);
    InventoryItemResponse getInventoryItemById(UUID id) throws ArchitectureException;
    InventoryItemResponse createInventoryItem(InventoryItemRequest inventoryItemRequest) throws ArchitectureException;
    InventoryItemResponse updateInventoryItem(UUID id, InventoryItemRequest inventoryItemRequest)throws ArchitectureException;

}
