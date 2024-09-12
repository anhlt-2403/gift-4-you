package com.mentes_innovadoras.gift4you.facade;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.order_detail.OrderDetailResponse;
import com.mentes_innovadoras.gift4you.payload.request.order_detail.CreateOrderDetailRequest;
import com.mentes_innovadoras.gift4you.payload.request.order_detail.OrderDetailRequest;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderDetailFacade {
    private final OrderDetailService orderDetailService;

    public PagedModel<OrderDetailResponse> getOrderDetails(Pageable pageable){
        return orderDetailService.getOrderDetails(pageable);
    }

    public Object getOrderDetailById(UUID id) throws ArchitectureException {
        return orderDetailService.getOrderDetailById(id);
    }

    public Object CreateOrderDetail(CreateOrderDetailRequest createOrderDetailRequest) throws ArchitectureException {
        return orderDetailService.createOrderDetail(createOrderDetailRequest);
    }

    public Object UpdateOrderDetailDescription(UUID id, String description) throws ArchitectureException {
        return orderDetailService.updateOrderDetailDescription(id, description);
    }
}
