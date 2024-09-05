package com.mentes_innovadoras.gift4you.facade;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.orderDetailItem.OrderDetailItemResponse;
import com.mentes_innovadoras.gift4you.payload.request.orderDetail.OrderDetailRequest;
import com.mentes_innovadoras.gift4you.payload.request.orderDetailItem.OrderDetailItemRequest;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderDetailItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderDetailItemFacade {
    private final OrderDetailItemService orderDetailItemService;

    public Page<OrderDetailItemResponse> getOrderDetailItems(Pageable pageable){
        return orderDetailItemService.getOrderDetailItems(pageable);
    }

    public Object getOrderDetailItemById(UUID id) throws ArchitectureException {
        return orderDetailItemService.getOrderDetailItemById(id);
    }

    public Object CreateOrderDetailItem(OrderDetailItemRequest orderDetailItemRequest) throws ArchitectureException {
        return orderDetailItemService.createOrderDetailItem(orderDetailItemRequest);
    }
    public Object UpdateOrderDetailItem(UUID id, OrderDetailItemRequest orderDetailItemRequest) throws ArchitectureException {
        return orderDetailItemService.updateOrderDetailItem(id, orderDetailItemRequest);
    }
}
