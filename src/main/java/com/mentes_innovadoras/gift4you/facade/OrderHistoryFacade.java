package com.mentes_innovadoras.gift4you.facade;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.orderHistory.OrderHistoryResponse;
import com.mentes_innovadoras.gift4you.payload.request.orderDetailItem.OrderDetailItemRequest;
import com.mentes_innovadoras.gift4you.payload.request.orderHistory.OrderHistoryRequest;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderHistoryFacade {
    private final OrderHistoryService orderHistoryService;

    public PagedModel<OrderHistoryResponse> getOrderHistories(Pageable pageable){
        return orderHistoryService.getOrderHistories(pageable);
    }

    public Object getOrderHistoryById(UUID id) throws ArchitectureException {
        return orderHistoryService.getOrderHistoryById(id);
    }

    public Object CreateOrderHistory(OrderHistoryRequest orderHistoryRequest) throws ArchitectureException {
        return orderHistoryService.createOrderHistory(orderHistoryRequest);
    }

    public Object UpdateOrderHistoryStatusDescription(UUID id, String status, String description) throws ArchitectureException {
        return orderHistoryService.updateOrderHistoryStatusDescription(id, status, description);
    }
}
