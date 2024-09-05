package com.mentes_innovadoras.gift4you.facade;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.orderHistory.OrderHistoryResponse;
import com.mentes_innovadoras.gift4you.payload.request.orderDetailItem.OrderDetailItemRequest;
import com.mentes_innovadoras.gift4you.payload.request.orderHistory.OrderHistoryRequest;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderHistoryFacade {
    private final OrderHistoryService orderHistoryService;

    public Page<OrderHistoryResponse> getOrderHistories(Pageable pageable){
        return orderHistoryService.getOrderHistories(pageable);
    }

    public Object getOrderHistoryById(UUID id) throws ArchitectureException {
        return orderHistoryService.getOrderHistoryById(id);
    }

    public Object CreateOrderHistory(OrderHistoryRequest orderHistoryRequest) throws ArchitectureException {
        return orderHistoryService.createOrderHistory(orderHistoryRequest);
    }

    public Object UpdateOrderHistory(UUID id, OrderHistoryRequest orderHistoryRequest) throws ArchitectureException {
        return orderHistoryService.updateOrderHistory(id, orderHistoryRequest);
    }
}
