package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.OrderDetailItem;
import com.mentes_innovadoras.gift4you.payload.reponse.order.OrderResponse;
import com.mentes_innovadoras.gift4you.payload.reponse.orderDetailItem.OrderDetailItemResponse;
import com.mentes_innovadoras.gift4you.payload.request.orderDetailItem.OrderDetailItemRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailItemMapper {
    private final ModelMapper mapper;
    public OrderDetailItemMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public OrderDetailItem toOrderDetailItemEntity(OrderDetailItemRequest orderDetailItemRequest) {
        return mapper.map(orderDetailItemRequest, OrderDetailItem.class);
    }

    public OrderDetailItemResponse toOrderDetailItemResponse(OrderDetailItem orderDetailItem) {
        OrderDetailItemResponse response = mapper.map(orderDetailItem, OrderDetailItemResponse.class);
        response.setOrderDetailId(orderDetailItem.getOrderDetail().getId().toString());
        response.setInventoryItemId(orderDetailItem.getInventoryItem().getId().toString());
        return response;
    }
}
