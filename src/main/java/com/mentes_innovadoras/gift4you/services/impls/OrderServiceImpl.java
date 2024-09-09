package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.entity.*;
import com.mentes_innovadoras.gift4you.enums.OrderStatus;
import com.mentes_innovadoras.gift4you.exception.common.NotFoundException;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.exception.inventory_item.InsufficientStockException;
import com.mentes_innovadoras.gift4you.mapper.OrderDetailItemMapper;
import com.mentes_innovadoras.gift4you.mapper.OrderDetailMapper;
import com.mentes_innovadoras.gift4you.mapper.OrderMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.order.OrderResponse;
import com.mentes_innovadoras.gift4you.payload.request.order.OrderRequest;
import com.mentes_innovadoras.gift4you.payload.request.order_detail.OrderDetailRequest;
import com.mentes_innovadoras.gift4you.payload.request.order_detail_item.OrderDetailItemRequest;
import com.mentes_innovadoras.gift4you.repository.AccountRepository;
import com.mentes_innovadoras.gift4you.repository.InventoryItemRepository;
import com.mentes_innovadoras.gift4you.repository.OrderRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final AccountRepository accountRepository;
    private final OrderRepository orderRepository;
    private final InventoryItemRepository inventoryItemRepository;
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;
    private final OrderDetailItemMapper orderDetailItemMapper;

    @Override
    public PagedModel<OrderResponse> getOrders(Pageable pageable) {
        return new PagedModel<>(orderRepository.findAll(pageable).map(orderMapper::toOrderResponse));
    }

    @Override
    public OrderResponse getOrderById(UUID id) throws ArchitectureException {
        if (id == null) throw new InvalidParamException();
        return orderRepository.findById(id).map(orderMapper::toOrderResponse).orElseThrow(() -> new NotFoundException(ResponseConstant.Message.orderNotFound));
    }

    @Override
    public OrderResponse createOrder(@Valid OrderRequest orderRequest) throws ArchitectureException {
        Account account = accountRepository.findById(orderRequest.getAccountId()).orElseThrow(() -> new NotFoundException(ResponseConstant.Message.userNotFound));
        Order newOrder = orderMapper.toOrderEntity(orderRequest);
        newOrder.setId(UUID.randomUUID());
        newOrder.setStatus(OrderStatus.confirmed.name());
        newOrder.setAccount(account);
        newOrder.setCreateAt(new Date());
        newOrder.setUpdateAt(new Date());

        Map<UUID, Integer> inventoryQuantities = new HashMap<>();
        Set<OrderDetail> orderDetails = new HashSet<>();
        for (OrderDetailRequest detailRequest : orderRequest.getOrderDetails()) {
            OrderDetail detail = handleOrderDetail(detailRequest, inventoryQuantities);
            orderDetails.add(detail);
        }
        newOrder.setOrderDetails(orderDetails);
        return orderMapper.toOrderResponse(orderRepository.save(newOrder));
    }


    private OrderDetail handleOrderDetail(OrderDetailRequest orderDetailRequest, Map<UUID, Integer> inventoryQuantities) throws ArchitectureException {
        OrderDetail orderDetail = orderDetailMapper.toOrderDetailEntity(orderDetailRequest);
        orderDetail.setId(UUID.randomUUID());

        Set<OrderDetailItem> orderDetailItems = new HashSet<>();
        for (OrderDetailItemRequest itemRequest : orderDetailRequest.getItems()) {
            OrderDetailItem item = handleOrderDetailItem(itemRequest, inventoryQuantities);
            orderDetailItems.add(item);
        }
        orderDetail.setOrderDetailItems(orderDetailItems);
        return orderDetail;
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
    public OrderResponse updateOrderStatus(UUID id, String status) throws ArchitectureException {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) throw new NotFoundException(ResponseConstant.Message.orderNotFound);
        order.setStatus(status);
        order.setUpdateAt(new Date());
        return orderMapper.toOrderResponse(orderRepository.save(order));
    }
}
