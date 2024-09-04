package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.entity.Account;
import com.mentes_innovadoras.gift4you.entity.Order;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.exception.account.UserNotFoundException;
import com.mentes_innovadoras.gift4you.mapper.OrderMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.OrderResponse;
import com.mentes_innovadoras.gift4you.payload.request.OrderRequest;
import com.mentes_innovadoras.gift4you.repository.AccountRepository;
import com.mentes_innovadoras.gift4you.repository.OrderRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderService;
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
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final AccountRepository accountRepository;
    @Override
    public Page<OrderResponse> getOrders(Pageable pageable) {
        return orderRepository.findAll(pageable).map(orderMapper::toOrderResponse);
    }

    @Override
    public OrderResponse getOrderById(UUID id) throws ArchitectureException {
        if (id == null) throw new InvalidParamException();
        OrderResponse orderResponse = orderRepository.findById(id).map(orderMapper::toOrderResponse).orElse(null);
        if (orderResponse == null) throw new UserNotFoundException();
        return orderResponse;
    }

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) throws ArchitectureException {
        Order newOrder = orderMapper.toOrderEntity(orderRequest);
        Account account = accountRepository.findById(orderRequest.getAccount().getId()).orElse(null);
        newOrder.setId(UUID.randomUUID());
        newOrder.setCreateAt(new Date());
        newOrder.setUpdateAt(new Date());
        newOrder.setDescription(orderRequest.getDescription());
        newOrder.setPhoneNumber(orderRequest.getPhoneNumber());
        newOrder.setStatus(orderRequest.getStatus());
        newOrder.setAddress(orderRequest.getAddress());
        newOrder.setTotalPrice(orderRequest.getTotalPrice());
        newOrder.setAccount(account);
        return orderMapper.toOrderResponse(orderRepository.save(newOrder));
    }

    @Override
    public OrderResponse updateOrder(UUID id, OrderRequest orderRequest) throws ArchitectureException {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) throw new UserNotFoundException();
        order.setCreateAt(new Date());
        order.setUpdateAt(new Date());
        order.setDescription(orderRequest.getDescription());
        order.setPhoneNumber(orderRequest.getPhoneNumber());
        order.setStatus(orderRequest.getStatus());
        order.setAddress(orderRequest.getAddress());
        order.setTotalPrice(orderRequest.getTotalPrice());
        return orderMapper.toOrderResponse(orderRepository.save(order));
    }
}
