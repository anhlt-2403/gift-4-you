package com.mentes_innovadoras.gift4you.facade;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.request.order.OrderRequest;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderFacade {
    private final OrderService orderService;

    public Object getOrders(Pageable pageable) {
        return orderService.getOrders(pageable);
    }

    public Object getOrderById(UUID id) throws ArchitectureException {
        return orderService.getOrderById(id);
    }

    public Object createOrder(OrderRequest orderRequest) throws ArchitectureException {
        return orderService.createOrder(orderRequest);
    }

    public Object updateOrderStatus(UUID id, String status) throws ArchitectureException {
        return orderService.updateOrderStatus(id, status);
    }

    public Object getOrdersByAccountId(UUID id, Pageable pageable) throws ArchitectureException {
        return  orderService.getOrdersByUserId(id, pageable);
    }
}
