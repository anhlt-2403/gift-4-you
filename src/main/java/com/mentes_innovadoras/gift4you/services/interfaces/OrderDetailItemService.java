package com.mentes_innovadoras.gift4you.services.interfaces;


import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.orderDetailItem.OrderDetailItemResponse;
import com.mentes_innovadoras.gift4you.payload.request.order_detail_item.CreateOrderDetailItemRequest;
import com.mentes_innovadoras.gift4you.payload.request.order_detail_item.OrderDetailItemRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

import java.util.UUID;

public interface OrderDetailItemService {
    PagedModel<OrderDetailItemResponse> getOrderDetailItems(Pageable pageable);
    OrderDetailItemResponse getOrderDetailItemById(UUID id) throws ArchitectureException;
    OrderDetailItemResponse createOrderDetailItem(CreateOrderDetailItemRequest createOrderDetailItemRequest) throws ArchitectureException;
    OrderDetailItemResponse updateOrderDetailItem(UUID id, OrderDetailItemRequest orderDetailItemRequest)throws ArchitectureException;

}
