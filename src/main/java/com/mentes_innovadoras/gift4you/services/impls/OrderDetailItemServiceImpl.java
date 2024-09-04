package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.entity.InventoryItem;
import com.mentes_innovadoras.gift4you.entity.OrderDetail;
import com.mentes_innovadoras.gift4you.entity.OrderDetailItem;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.exception.account.UserNotFoundException;
import com.mentes_innovadoras.gift4you.mapper.OrderDetailItemMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.OrderDetailItemResponse;
import com.mentes_innovadoras.gift4you.payload.request.OrderDetailItemRequest;
import com.mentes_innovadoras.gift4you.repository.InventoryItemRepository;
import com.mentes_innovadoras.gift4you.repository.OrderDetailItemRepository;
import com.mentes_innovadoras.gift4you.repository.OrderDetailRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderDetailItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class OrderDetailItemServiceImpl implements OrderDetailItemService {
    private final OrderDetailItemRepository orderDetailItemRepository;
    private final OrderDetailItemMapper orderDetailItemMapper;
    private final OrderDetailRepository orderDetailRepository;
    private final InventoryItemRepository inventoryItemRepository;

    @Override
    public Page<OrderDetailItemResponse> getOrderDetailItems(Pageable pageable) {
        return orderDetailItemRepository.findAll(pageable).map(orderDetailItemMapper::toOrderDetailItemResponse);
    }

    @Override
    public OrderDetailItemResponse getOrderDetailItemById(UUID id) throws ArchitectureException {
        if (id == null) throw new InvalidParamException();
        OrderDetailItemResponse orderDetailItemResponse = orderDetailItemRepository.findById(id).map(orderDetailItemMapper::toOrderDetailItemResponse).orElse(null);
        if (orderDetailItemResponse == null) throw new UserNotFoundException();
        return orderDetailItemResponse;
    }

    @Override
    public OrderDetailItemResponse createOrderDetailItem(OrderDetailItemRequest orderDetailItemRequest) throws ArchitectureException {
        OrderDetailItem newOrderDetailItem = orderDetailItemMapper.toOrderDetailItemEntity(orderDetailItemRequest);
        OrderDetail orderDetail = orderDetailRepository.findById(orderDetailItemRequest.getOrderDetail().getId()).orElse(null);
        InventoryItem inventoryItem = inventoryItemRepository.findById(orderDetailItemRequest.getInventoryItem().getId()).orElse(null);
        newOrderDetailItem.setId(UUID.randomUUID());
        newOrderDetailItem.setQuantity(orderDetailItemRequest.getQuantity());
        newOrderDetailItem.setOrderDetail(orderDetail);
        newOrderDetailItem.setInventoryItem(inventoryItem);
        return orderDetailItemMapper.toOrderDetailItemResponse(orderDetailItemRepository.save(newOrderDetailItem));    }

    @Override
    public OrderDetailItemResponse updateOrderDetailItem(UUID id, OrderDetailItemRequest orderDetailItemRequest) throws ArchitectureException {
        OrderDetailItem orderDetailItem = orderDetailItemRepository.findById(id).orElse(null);
        if (orderDetailItem == null) throw new UserNotFoundException();
        orderDetailItem.setQuantity(orderDetailItemRequest.getQuantity());
        return orderDetailItemMapper.toOrderDetailItemResponse(orderDetailItemRepository.save(orderDetailItem));
    }
}
