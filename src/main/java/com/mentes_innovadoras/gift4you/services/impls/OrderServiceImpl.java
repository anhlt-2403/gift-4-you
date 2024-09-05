package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.entity.Account;
import com.mentes_innovadoras.gift4you.entity.Order;
import com.mentes_innovadoras.gift4you.enums.OrderStatus;
import com.mentes_innovadoras.gift4you.exception.account.OrderNotFoundException;
import com.mentes_innovadoras.gift4you.exception.account.UserNotFoundException;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.mapper.OrderMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.order.OrderResponse;
import com.mentes_innovadoras.gift4you.payload.request.order.OrderRequest;
import com.mentes_innovadoras.gift4you.repository.AccountRepository;
import com.mentes_innovadoras.gift4you.repository.OrderRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final AccountRepository accountRepository;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public PagedModel<OrderResponse> getOrders(Pageable pageable) {
        return new PagedModel<>(orderRepository.findAll(pageable).map(orderMapper::toOrderResponse));
    }

    @Override
    public OrderResponse getOrderById(UUID id) throws ArchitectureException {
        if (id == null) throw new InvalidParamException();
        OrderResponse orderResponse = orderRepository.findById(id).map(orderMapper::toOrderResponse).orElse(null);
        if (orderResponse == null) throw new UserNotFoundException();
        return orderResponse;
    }

    @Override
    public OrderResponse createOrder(@Valid OrderRequest orderRequest) throws ArchitectureException {
        Account account = accountRepository.findById(orderRequest.getAccountId()).orElse(null);
        if (account == null) throw new UserNotFoundException();
        Order newOrder = orderMapper.toOrderEntity(orderRequest);
        newOrder.setId(UUID.randomUUID());
        newOrder.setStatus(OrderStatus.confirmed.name());
        newOrder.setAccount(account);
        newOrder.setCreateAt(new Date());
        newOrder.setUpdateAt(new Date());
        return orderMapper.toOrderResponse(orderRepository.save(newOrder));
    }

    @Override
    public OrderResponse updateOrderStatus(UUID id, String status) throws ArchitectureException {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) throw new OrderNotFoundException();
        order.setStatus(status);
        order.setUpdateAt(new Date());
        return orderMapper.toOrderResponse(orderRepository.save(order));
    }
}
