package com.mentes_innovadoras.gift4you.services.interfaces;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.OrderResponse;
import com.mentes_innovadoras.gift4you.payload.request.OrderRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface OrderService {
    Page<OrderResponse> getOrders(Pageable pageable);
    OrderResponse getOrderById(UUID id) throws ArchitectureException;
    OrderResponse createOrder(OrderRequest orderRequest) throws ArchitectureException;
    OrderResponse updateOrder(UUID id, OrderRequest orderRequest)throws ArchitectureException;
}
