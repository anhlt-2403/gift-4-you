package com.mentes_innovadoras.gift4you.facade;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.OrderDetailResponse;
import com.mentes_innovadoras.gift4you.payload.request.OrderDetailRequest;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderDetailFacade {
    private final OrderDetailService orderDetailService;

    public Page<OrderDetailResponse> getOrderDetails(Pageable pageable){
        return orderDetailService.getOrderDetails(pageable);
    }

    public Object getOrderDetailById(UUID id) throws ArchitectureException {
        return orderDetailService.getOrderDetailById(id);
    }

    public Object CreateOrderDetail(OrderDetailRequest orderDetailRequest) throws ArchitectureException {
        return orderDetailService.createOrderDetail(orderDetailRequest);
    }
}
