package com.mentes_innovadoras.gift4you.services.interfaces;


import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.order_detail.OrderDetailResponse;
import com.mentes_innovadoras.gift4you.payload.request.order_detail.CreateOrderDetailRequest;
import com.mentes_innovadoras.gift4you.payload.request.order_detail.OrderDetailRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

import java.util.UUID;

public interface OrderDetailService {
    PagedModel<OrderDetailResponse> getOrderDetails(Pageable pageable);
    OrderDetailResponse getOrderDetailById(UUID id) throws ArchitectureException;
    OrderDetailResponse createOrderDetail(CreateOrderDetailRequest createOrderDetailRequest) throws ArchitectureException;
    OrderDetailResponse updateOrderDetailDescription(UUID id, String description)throws ArchitectureException;

}
