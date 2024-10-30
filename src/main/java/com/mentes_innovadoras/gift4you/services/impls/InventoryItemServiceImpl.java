package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.entity.InventoryItem;
import com.mentes_innovadoras.gift4you.entity.Provider;
import com.mentes_innovadoras.gift4you.enums.InventoryItemStatus;
import com.mentes_innovadoras.gift4you.enums.ProviderStatus;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.common.NotFoundException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.mapper.InventoryItemMapper;
import com.mentes_innovadoras.gift4you.mapper.ProviderMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.inventory_item.InventoryItemResponse;
import com.mentes_innovadoras.gift4you.payload.reponse.provider.ProviderResponse;
import com.mentes_innovadoras.gift4you.payload.request.inventory_item.CreateInventoryItemRequest;
import com.mentes_innovadoras.gift4you.payload.request.inventory_item.UpdateInventoryItemRequest;
import com.mentes_innovadoras.gift4you.repository.InventoryItemRepository;
import com.mentes_innovadoras.gift4you.repository.ProviderRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.InventoryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class InventoryItemServiceImpl implements InventoryItemService {

    private final InventoryItemRepository inventoryItemRepository;
    private final InventoryItemMapper inventoryItemMapper;
    private final ProviderRepository providerRepository;
    @Override
    public PagedModel<InventoryItemResponse> getInventoryItems(Pageable pageable) {
        return new PagedModel<>(inventoryItemRepository.findAll(pageable).map(inventoryItemMapper::inventoryItemResponse));
    }

    @Override
    public InventoryItemResponse getInventoryItemById(UUID id) throws ArchitectureException {
        if (id == null) throw new InvalidParamException();
        return inventoryItemRepository.findById(id).map(inventoryItemMapper::inventoryItemResponse).orElseThrow(() -> new NotFoundException(ResponseConstant.Message.itemNotFound));
    }

    @Override
    public InventoryItemResponse createInventoryItem(CreateInventoryItemRequest createInventoryItemRequest) throws ArchitectureException {
        Provider provider = providerRepository.findById(createInventoryItemRequest.getProviderId()).orElseThrow(() -> new NotFoundException(ResponseConstant.Message.providerNotFound));
        InventoryItem newInventoryItem = inventoryItemMapper.toInventoryItemEntity(createInventoryItemRequest);
        newInventoryItem.setId(UUID.randomUUID());
        newInventoryItem.setCreateAt(OffsetDateTime.now(ZoneOffset.UTC).minusHours(6));
        newInventoryItem.setUpdateAt(OffsetDateTime.now(ZoneOffset.UTC).minusHours(6));
        newInventoryItem.setStatus(InventoryItemStatus.available.name());
        newInventoryItem.setProvider(provider);
        return inventoryItemMapper.inventoryItemResponse(inventoryItemRepository.save(newInventoryItem));
    }

    @Override
    public InventoryItemResponse updateInventoryItem(UUID id, UpdateInventoryItemRequest updateInventoryItemRequest) throws ArchitectureException {
        InventoryItem inventoryItem = inventoryItemRepository.findById(id).orElseThrow(() ->new NotFoundException(ResponseConstant.Message.itemNotFound));
        Provider provider = providerRepository.findById(updateInventoryItemRequest.getProviderId()).orElseThrow(() -> new NotFoundException(ResponseConstant.Message.providerNotFound));
        inventoryItem.setProvider(provider);
        inventoryItem.setName(updateInventoryItemRequest.getName() == null ? inventoryItem.getName() : updateInventoryItemRequest.getName());
        inventoryItem.setDescription(updateInventoryItemRequest.getDescription() == null ? inventoryItem.getDescription() : updateInventoryItemRequest.getDescription());
        inventoryItem.setPrice(updateInventoryItemRequest.getPrice() == null ? inventoryItem.getPrice() : updateInventoryItemRequest.getPrice());
        inventoryItem.setStock(updateInventoryItemRequest.getStock() == null ? inventoryItem.getStock() : updateInventoryItemRequest.getStock());
        inventoryItem.setUpdateAt(OffsetDateTime.now(ZoneOffset.UTC).minusHours(6));
        return inventoryItemMapper.inventoryItemResponse(inventoryItemRepository.save(inventoryItem));
    }
}
