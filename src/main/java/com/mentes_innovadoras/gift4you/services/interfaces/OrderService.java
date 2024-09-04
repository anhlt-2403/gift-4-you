package com.mentes_innovadoras.gift4you.services.interfaces;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.order.OrderResponse;
import com.mentes_innovadoras.gift4you.payload.request.order.OrderRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

import java.util.UUID;

public interface OrderService {
    PagedModel<OrderResponse> getOrders(Pageable pageable);
    OrderResponse getOrderById(UUID id) throws ArchitectureException;
    OrderResponse createOrder(OrderRequest OrderRequest) throws ArchitectureException;
    OrderResponse updateOrderStatus(UUID id, String status)throws ArchitectureException;
}
