package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.entity.InventoryItem;
import com.mentes_innovadoras.gift4you.entity.OrderDetailItem;
import com.mentes_innovadoras.gift4you.entity.Provider;
import com.mentes_innovadoras.gift4you.exception.common.InventoryItemNotFoundException;
import com.mentes_innovadoras.gift4you.exception.common.NotFoundException;
import com.mentes_innovadoras.gift4you.exception.common.ProviderNotFoundException;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.exception.inventory_item.InsufficientStockException;
import com.mentes_innovadoras.gift4you.mapper.InventoryItemMapper;
import com.mentes_innovadoras.gift4you.mapper.OrderDetailItemMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.inventoryItem.InventoryItemResponse;
import com.mentes_innovadoras.gift4you.payload.request.inventoryItem.InventoryItemRequest;
import com.mentes_innovadoras.gift4you.payload.request.order_detail_item.OrderDetailItemRequest;
import com.mentes_innovadoras.gift4you.repository.InventoryItemRepository;
import com.mentes_innovadoras.gift4you.repository.ProviderRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.InventoryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class InventoryItemServiceImpl implements InventoryItemService {
    private final InventoryItemRepository inventoryItemRepository;
    private final InventoryItemMapper inventoryItemMapper;
    private final ProviderRepository providerRepository;
    private final OrderDetailItemMapper orderDetailItemMapper;

    @Override
    public PagedModel<InventoryItemResponse> getInventoryItems(Pageable pageable) {
        return new PagedModel<>(inventoryItemRepository.findAll(pageable).map(inventoryItemMapper::toInventoryItemResponse));
    }

    @Override
    public InventoryItemResponse getInventoryItemById(UUID id) throws ArchitectureException {
        if (id == null) throw new InvalidParamException();
        InventoryItemResponse inventoryItemResponse = inventoryItemRepository.findById(id).map(inventoryItemMapper::toInventoryItemResponse).orElse(null);
        if (inventoryItemResponse == null) throw new InventoryItemNotFoundException();
        return inventoryItemResponse;
    }

    @Override
    public InventoryItemResponse createInventoryItem(InventoryItemRequest inventoryItemRequest) throws ArchitectureException {
        Provider provider = providerRepository.findById(inventoryItemRequest.getProviderId()).orElse(null);
        if (provider == null) throw new ProviderNotFoundException();
        InventoryItem newInventoryItem = inventoryItemMapper.toInventoryItemEntity(inventoryItemRequest);
        newInventoryItem.setId(UUID.randomUUID());
        newInventoryItem.setPrice(inventoryItemRequest.getPrice());
        newInventoryItem.setStock(inventoryItemRequest.getStock());
        newInventoryItem.setCreateAt(new Date());
        newInventoryItem.setUpdateAt(new Date());
        newInventoryItem.setStatus(inventoryItemRequest.getStatus());
        newInventoryItem.setName(inventoryItemRequest.getName());
        newInventoryItem.setDescription(inventoryItemRequest.getDescription());
        Set<OrderDetailItem> orderDetailItems = new HashSet<>();
        for (OrderDetailItemRequest detailItemRequest : inventoryItemRequest.getItems()) {
            OrderDetailItem detailItem = handleOrderDetailItem(detailItemRequest);
            orderDetailItems.add(detailItem);
        }
        newInventoryItem.setOrderDetailItems(orderDetailItems);
        return inventoryItemMapper.toInventoryItemResponse(inventoryItemRepository.save(newInventoryItem));
    }

    private OrderDetailItem handleOrderDetailItem(OrderDetailItemRequest orderDetailItemRequest) throws ArchitectureException {
        OrderDetailItem orderDetailItem = orderDetailItemMapper.toOrderDetailItemEntity(orderDetailItemRequest);
        orderDetailItem.setId(UUID.randomUUID());
        return orderDetailItem;
    }

    @Override
    public InventoryItemResponse updateInventoryItem(UUID id, InventoryItemRequest inventoryItemRequest) throws ArchitectureException {
        InventoryItem inventoryItem = inventoryItemRepository.findById(id).orElse(null);
        if (inventoryItem == null) throw new InventoryItemNotFoundException();
        inventoryItem.setPrice(inventoryItemRequest.getPrice() == null ? inventoryItem.getPrice() : inventoryItemRequest.getPrice());
        inventoryItem.setStock(inventoryItemRequest.getStock() == null ? inventoryItem.getStock() : inventoryItemRequest.getStock());
        inventoryItem.setCreateAt(new Date());
        inventoryItem.setUpdateAt(new Date());
        inventoryItem.setStatus(inventoryItemRequest.getStatus() == null ? inventoryItem.getStatus() : inventoryItemRequest.getStatus());
        inventoryItem.setName(inventoryItemRequest.getName() == null ? inventoryItem.getName() : inventoryItemRequest.getName());
        inventoryItem.setDescription(inventoryItemRequest.getDescription() == null ? inventoryItem.getDescription() : inventoryItemRequest.getDescription());
        return inventoryItemMapper.toInventoryItemResponse(inventoryItemRepository.save(inventoryItem));
    }
}
