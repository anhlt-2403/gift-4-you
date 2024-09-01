package com.mentes_innovadoras.gift4you.services.interfaces;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.OrderDetailResponse;
import com.mentes_innovadoras.gift4you.payload.request.OrderDetailRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface OrderDetailService {
    Page<OrderDetailResponse> getOrderDetails(Pageable pageable);
    OrderDetailResponse getOrderDetailById(UUID id) throws ArchitectureException;
    OrderDetailResponse createOrderDetail(OrderDetailRequest orderDetailRequest) throws ArchitectureException;
    OrderDetailResponse updateOrderDetail(UUID id, OrderDetailRequest orderDetailRequest)throws ArchitectureException;
}
