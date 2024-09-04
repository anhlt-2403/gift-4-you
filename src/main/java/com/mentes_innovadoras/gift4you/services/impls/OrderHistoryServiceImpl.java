package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.entity.Order;
import com.mentes_innovadoras.gift4you.entity.OrderHistory;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.exception.account.UserNotFoundException;
import com.mentes_innovadoras.gift4you.mapper.OrderHistoryMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.OrderHistoryResponse;
import com.mentes_innovadoras.gift4you.payload.request.OrderHistoryRequest;
import com.mentes_innovadoras.gift4you.repository.OrderHistoryRepository;
import com.mentes_innovadoras.gift4you.repository.OrderRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
    private final OrderHistoryRepository orderHistoryRepository;
    private final OrderHistoryMapper orderHistoryMapper;
    private final OrderRepository orderRepository;
    @Override
    public Page<OrderHistoryResponse> getOrderHistories(Pageable pageable) {
        return orderHistoryRepository.findAll(pageable).map(orderHistoryMapper::toOrderHistoryResponse);
    }

    @Override
    public OrderHistoryResponse getOrderHistoryById(UUID id) throws ArchitectureException {
        if (id == null) throw new InvalidParamException();
        OrderHistoryResponse orderHistoryResponse = orderHistoryRepository.findById(id).map(orderHistoryMapper::toOrderHistoryResponse).orElse(null);
        if (orderHistoryResponse == null) throw new UserNotFoundException();
        return orderHistoryResponse;
    }

    @Override
    public OrderHistoryResponse createOrderHistory(OrderHistoryRequest orderHistoryRequest) throws ArchitectureException {
        OrderHistory newOrderHistory = orderHistoryMapper.toOrderHistoryEntity(orderHistoryRequest);
        Order order = orderRepository.findById(orderHistoryRequest.getOrder().getId()).orElse(null);
        newOrderHistory.setId(UUID.randomUUID());
        newOrderHistory.setCreateAt(new Date());
        newOrderHistory.setUpdateAt(new Date());
        newOrderHistory.setDescription(orderHistoryRequest.getDescription());
        newOrderHistory.setStatus(orderHistoryRequest.getStatus());
        newOrderHistory.setOrder(order);
        return orderHistoryMapper.toOrderHistoryResponse(orderHistoryRepository.save(newOrderHistory));
    }

    @Override
    public OrderHistoryResponse updateOrderHistory(UUID id, OrderHistoryRequest orderHistoryRequest) throws ArchitectureException {
        OrderHistory orderHistory = orderHistoryRepository.findById(id).orElse(null);
        if (orderHistory == null) throw new UserNotFoundException();
        orderHistory.setId(UUID.randomUUID());
        orderHistory.setCreateAt(new Date());
        orderHistory.setUpdateAt(new Date());
        orderHistory.setDescription(orderHistoryRequest.getDescription());
        orderHistory.setStatus(orderHistoryRequest.getStatus());
        return orderHistoryMapper.toOrderHistoryResponse(orderHistoryRepository.save(orderHistory));
    }
}