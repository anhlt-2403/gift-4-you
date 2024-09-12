package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.OrderDetail;
import com.mentes_innovadoras.gift4you.payload.reponse.order_detail.OrderDetailResponse;
import com.mentes_innovadoras.gift4you.payload.request.order_detail.CreateOrderDetailRequest;
import com.mentes_innovadoras.gift4you.payload.request.order_detail.OrderDetailRequest;
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
    public OrderDetail toCreateOrderDetailEntity(CreateOrderDetailRequest createOrderDetailRequest) {
        return mapper.map(createOrderDetailRequest, OrderDetail.class);
    }
    public OrderDetailResponse toOrderDetailResponse(OrderDetail orderDetail) {
        return mapper.map(orderDetail, OrderDetailResponse.class);
    }

}
