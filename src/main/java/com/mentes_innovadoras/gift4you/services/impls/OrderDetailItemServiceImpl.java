package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.entity.*;
import com.mentes_innovadoras.gift4you.exception.common.*;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.mapper.OrderDetailItemMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.orderDetailItem.OrderDetailItemResponse;
import com.mentes_innovadoras.gift4you.payload.request.order_detail_item.CreateOrderDetailItemRequest;
import com.mentes_innovadoras.gift4you.payload.request.order_detail_item.OrderDetailItemRequest;
import com.mentes_innovadoras.gift4you.repository.InventoryItemRepository;
import com.mentes_innovadoras.gift4you.repository.OrderDetailItemRepository;
import com.mentes_innovadoras.gift4you.repository.OrderDetailRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderDetailItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class OrderDetailItemServiceImpl implements OrderDetailItemService {
    private final OrderDetailItemRepository orderDetailItemRepository;
    private final OrderDetailItemMapper orderDetailItemMapper;
    private final OrderDetailRepository orderDetailRepository;
    private final InventoryItemRepository inventoryItemRepository;

    @Override
    public PagedModel<OrderDetailItemResponse> getOrderDetailItems(Pageable pageable) {
        return new PagedModel<>(orderDetailItemRepository.findAll(pageable).map(orderDetailItemMapper::toOrderDetailItemResponse));
    }

    @Override
    public OrderDetailItemResponse getOrderDetailItemById(UUID id) throws ArchitectureException {
        if (id == null) throw new InvalidParamException();
        OrderDetailItemResponse orderDetailItemResponse = orderDetailItemRepository.findById(id).map(orderDetailItemMapper::toOrderDetailItemResponse).orElse(null);
        if (orderDetailItemResponse == null) throw new OrderDetailItemNotFoundException();
        return orderDetailItemResponse;
    }

    @Override
    public OrderDetailItemResponse createOrderDetailItem(CreateOrderDetailItemRequest createOrderDetailItemRequest) throws ArchitectureException {
        OrderDetail orderDetail = orderDetailRepository.findById(createOrderDetailItemRequest.getOrderDetailId()).orElseThrow(() -> new NotFoundException(ResponseConstant.Message.orderDetailNotFound));
        InventoryItem inventoryItem = inventoryItemRepository.findById(createOrderDetailItemRequest.getInventoryItemId()).orElseThrow(() -> new NotFoundException(ResponseConstant.Message.inventoryItemNotFound));
        OrderDetailItem newOrderDetailItem = orderDetailItemMapper.toCreateOrderDetailItem(createOrderDetailItemRequest);
        newOrderDetailItem.setId(UUID.randomUUID());
        newOrderDetailItem.setOrderDetail(orderDetail);
        newOrderDetailItem.setInventoryItem(inventoryItem);
        return orderDetailItemMapper.toOrderDetailItemResponse(orderDetailItemRepository.save(newOrderDetailItem));
    }

    @Override
    public OrderDetailItemResponse updateOrderDetailItem(UUID id, OrderDetailItemRequest orderDetailItemRequest) throws ArchitectureException {
        OrderDetailItem orderDetailItem = orderDetailItemRepository.findById(id).orElse(null);
        if (orderDetailItem == null) throw new NotFoundException(ResponseConstant.Message.itemNotFound);
        orderDetailItem.setQuantity(orderDetailItemRequest.getQuantity());
        return orderDetailItemMapper.toOrderDetailItemResponse(orderDetailItemRepository.save(orderDetailItem));
    }

}
