package com.mentes_innovadoras.gift4you.services.interfaces;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.orderDetailItem.OrderDetailItemResponse;
import com.mentes_innovadoras.gift4you.payload.request.orderDetailItem.OrderDetailItemRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface OrderDetailItemService {
    Page<OrderDetailItemResponse> getOrderDetailItems(Pageable pageable);
    OrderDetailItemResponse getOrderDetailItemById(UUID id) throws ArchitectureException;
    OrderDetailItemResponse createOrderDetailItem(OrderDetailItemRequest orderDetailItemRequest) throws ArchitectureException;
    OrderDetailItemResponse updateOrderDetailItem(UUID id, OrderDetailItemRequest orderDetailItemRequest)throws ArchitectureException;
}
