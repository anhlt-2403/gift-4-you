package com.mentes_innovadoras.gift4you.services.interfaces;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.orderHistory.OrderHistoryResponse;
import com.mentes_innovadoras.gift4you.payload.request.orderHistory.OrderHistoryRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface OrderHistoryService {
    Page<OrderHistoryResponse> getOrderHistories(Pageable pageable);
    OrderHistoryResponse getOrderHistoryById(UUID id) throws ArchitectureException;
    OrderHistoryResponse createOrderHistory(OrderHistoryRequest orderHistoryRequest) throws ArchitectureException;
    OrderHistoryResponse updateOrderHistory(UUID id, OrderHistoryRequest orderHistoryRequest)throws ArchitectureException;
}
