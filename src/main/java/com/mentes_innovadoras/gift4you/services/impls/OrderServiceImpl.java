package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.entity.*;
import com.mentes_innovadoras.gift4you.enums.OrderStatus;
import com.mentes_innovadoras.gift4you.exception.common.NotFoundException;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.mapper.OrderDetailMapper;
import com.mentes_innovadoras.gift4you.mapper.OrderMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.order.OrderResponse;
import com.mentes_innovadoras.gift4you.payload.request.order.OrderRequest;
import com.mentes_innovadoras.gift4you.repository.AccountRepository;
import com.mentes_innovadoras.gift4you.repository.InventoryItemRepository;
import com.mentes_innovadoras.gift4you.repository.OrderRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final AccountRepository accountRepository;
    private final OrderRepository orderRepository;
    private final InventoryItemRepository inventoryItemRepository;
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;


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
    @Transactional
    public OrderResponse createOrder(@Valid OrderRequest orderRequest) throws ArchitectureException {
        Account account = accountRepository.findById(orderRequest.getAccountId())
                .orElseThrow(() -> new NotFoundException(ResponseConstant.Message.userNotFound));

        // Tạo Order mới từ OrderRequest
        Order newOrder = orderMapper.toOrderEntity(orderRequest);
        newOrder.setStatus(OrderStatus.confirmed.name());
        newOrder.setAccount(account);
        newOrder.setCreateAt(OffsetDateTime.now(ZoneOffset.UTC).minusHours(6));
        newOrder.setUpdateAt(OffsetDateTime.now(ZoneOffset.UTC).minusHours(6));

        Set<OrderDetail> orderDetails = new HashSet<>();

        if (orderRequest.getTemplateId() == null) {
            if (orderRequest.getOrderDetailsRequest() == null || orderRequest.getOrderDetailsRequest().isEmpty()) {
                throw new InvalidParamException();
            }

            orderRequest.getOrderDetailsRequest().forEach(orderDetailsRequest -> {
                InventoryItem inventoryItem = inventoryItemRepository.findById(orderDetailsRequest.getInventoryItemId()).orElse(null);
                OrderDetail orderDetail = orderDetailMapper.toOrderDetailEntity(orderDetailsRequest);
                orderDetail.setDescription("New");
                orderDetail.setId(UUID.randomUUID());
                orderDetail.setInventoryItem(inventoryItem);
                orderDetail.setOrder(newOrder);
                orderDetails.add(orderDetail);
            });

            newOrder.setOrderDetails(orderDetails);
        }
        // else {
        //    newOrder.setTemplate(...)
        // }

        Order savedOrder = orderRepository.save(newOrder);

        return orderMapper.toOrderResponse(savedOrder);
    }




    @Override
    public OrderResponse updateOrderStatus(UUID id, String status) throws ArchitectureException {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) throw new NotFoundException(ResponseConstant.Message.orderNotFound);
        order.setStatus(status);
        order.setUpdateAt(OffsetDateTime.now(ZoneOffset.UTC).minusHours(6));
        return orderMapper.toOrderResponse(orderRepository.save(order));
    }
}
