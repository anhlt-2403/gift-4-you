package com.mentes_innovadoras.gift4you.services.interfaces;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.inventory_item.InventoryItemResponse;
import com.mentes_innovadoras.gift4you.payload.reponse.provider.ProviderResponse;
import com.mentes_innovadoras.gift4you.payload.request.inventory_item.CreateInventoryItemRequest;
import com.mentes_innovadoras.gift4you.payload.request.inventory_item.UpdateInventoryItemRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

import java.util.UUID;

public interface InventoryItemService {
    PagedModel<InventoryItemResponse> getInventoryItems(Pageable pageable);
    InventoryItemResponse getInventoryItemById(UUID id) throws ArchitectureException;
    InventoryItemResponse createInventoryItem(CreateInventoryItemRequest createInventoryItemRequest) throws ArchitectureException;
    InventoryItemResponse updateInventoryItem(UUID id, UpdateInventoryItemRequest updateInventoryItemRequest)throws ArchitectureException;
}
