package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.OrderDetail;
import com.mentes_innovadoras.gift4you.entity.OrderDetailItem;
import com.mentes_innovadoras.gift4you.payload.reponse.order_detail.OrderDetailResponse;
import com.mentes_innovadoras.gift4you.payload.request.order_detail_item.OrderDetailItemRequest;
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

    public OrderDetailResponse toOrderDetailResponse(OrderDetail orderDetail) {
        return mapper.map(orderDetail, OrderDetailResponse.class);
    }
}
