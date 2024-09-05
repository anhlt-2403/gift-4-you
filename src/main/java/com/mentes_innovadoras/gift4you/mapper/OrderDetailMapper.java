package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.OrderDetail;
import com.mentes_innovadoras.gift4you.payload.reponse.order.OrderResponse;
import com.mentes_innovadoras.gift4you.payload.reponse.orderDetail.OrderDetailResponse;
import com.mentes_innovadoras.gift4you.payload.request.orderDetail.OrderDetailRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {
    private final ModelMapper mapper;
    public OrderDetailMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public OrderDetail toOrderDetailEntity(OrderDetailRequest orderDetailRequest) {
        return mapper.map(orderDetailRequest, OrderDetail.class);
    }

    public OrderDetailResponse toOrderDetailResponse(OrderDetail orderDetail) {
        OrderDetailResponse response = mapper.map(orderDetail, OrderDetailResponse.class);
        response.setOrderId(orderDetail.getOrder().getId().toString());
        return response;    }
}
