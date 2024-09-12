package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.entity.*;
import com.mentes_innovadoras.gift4you.exception.common.NotFoundException;
import com.mentes_innovadoras.gift4you.exception.common.OrderDetailNotFoundException;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.exception.inventory_item.InsufficientStockException;
import com.mentes_innovadoras.gift4you.mapper.OrderDetailItemMapper;
import com.mentes_innovadoras.gift4you.mapper.OrderDetailMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.order_detail.OrderDetailResponse;
import com.mentes_innovadoras.gift4you.payload.request.order_detail.CreateOrderDetailRequest;
import com.mentes_innovadoras.gift4you.payload.request.order_detail_item.OrderDetailItemRequest;
import com.mentes_innovadoras.gift4you.repository.InventoryItemRepository;
import com.mentes_innovadoras.gift4you.repository.OrderDetailRepository;
import com.mentes_innovadoras.gift4you.repository.OrderRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailMapper orderDetailMapper;
    private final OrderRepository orderRepository;
    private final InventoryItemRepository inventoryItemRepository;
    private final OrderDetailItemMapper orderDetailItemMapper;

    @Override
    public PagedModel<OrderDetailResponse> getOrderDetails(Pageable pageable) {
        return new PagedModel<>(orderDetailRepository.findAll(pageable).map(orderDetailMapper::toOrderDetailResponse));
    }

    @Override
    public OrderDetailResponse getOrderDetailById(UUID id) throws ArchitectureException {
        if (id == null) throw new InvalidParamException();
        return orderDetailRepository.findById(id).map(orderDetailMapper::toOrderDetailResponse).orElseThrow(() -> new NotFoundException(ResponseConstant.Message.orderDetailNotFound));
    }

    @Override
    public OrderDetailResponse createOrderDetail(CreateOrderDetailRequest createOrderDetailRequest) throws ArchitectureException {
        Order order = orderRepository.findById(createOrderDetailRequest.getOrderId()).orElseThrow(() -> new NotFoundException(ResponseConstant.Message.orderNotFound));
        OrderDetail newOrderDetail = orderDetailMapper.toCreateOrderDetailEntity(createOrderDetailRequest);
        newOrderDetail.setId(UUID.randomUUID());
        newOrderDetail.setOrder(order);

        Map<UUID, Integer> inventoryQuantities = new HashMap<>();
        Set<OrderDetailItem> orderDetailItems = new HashSet<>();
        for (OrderDetailItemRequest detailItemRequest : createOrderDetailRequest.getItems()) {
            OrderDetailItem detailItem = handleOrderDetailItem(detailItemRequest, inventoryQuantities);
            orderDetailItems.add(detailItem);
        }
        newOrderDetail.setOrderDetailItems(orderDetailItems);
        return orderDetailMapper.toOrderDetailResponse(orderDetailRepository.save(newOrderDetail));
    }

    private OrderDetailItem handleOrderDetailItem(OrderDetailItemRequest orderDetailItemRequest, Map<UUID, Integer> inventoryQuantities) throws ArchitectureException {
        UUID inventoryItemId = orderDetailItemRequest.getItemId();
        int requestedQuantity = orderDetailItemRequest.getQuantity();

        InventoryItem inventoryItem = inventoryItemRepository.findById(inventoryItemId)
                .orElseThrow(() -> new NotFoundException(ResponseConstant.Message.itemNotFound));

        int availableQuantity = inventoryItem.getStock();

        int currentOrderedQuantity = inventoryQuantities.getOrDefault(inventoryItemId, 0);

        if (currentOrderedQuantity + requestedQuantity > availableQuantity) {
            throw new InsufficientStockException(inventoryItem.getName(), availableQuantity, currentOrderedQuantity + requestedQuantity);
        }

        inventoryQuantities.put(inventoryItemId, currentOrderedQuantity + requestedQuantity);

        OrderDetailItem orderDetailItem = orderDetailItemMapper.toOrderDetailItemEntity(orderDetailItemRequest);
        orderDetailItem.setId(UUID.randomUUID());
        return orderDetailItem;
    }


    @Override
    public OrderDetailResponse updateOrderDetailDescription(UUID id, String description) throws ArchitectureException {
        OrderDetail orderDetail = orderDetailRepository.findById(id).orElse(null);
        if (orderDetail == null) throw new NotFoundException(ResponseConstant.Message.orderDetailNotFound);
        orderDetail.setDescription(description);
        return orderDetailMapper.toOrderDetailResponse(orderDetailRepository.save(orderDetail));
    }

}
