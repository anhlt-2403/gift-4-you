package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.OrderHistory;
import com.mentes_innovadoras.gift4you.payload.reponse.order.OrderResponse;
import com.mentes_innovadoras.gift4you.payload.reponse.orderHistory.OrderHistoryResponse;
import com.mentes_innovadoras.gift4you.payload.request.orderHistory.OrderHistoryRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderHistoryMapper {
    private final ModelMapper mapper;
    public OrderHistoryMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public OrderHistory toOrderHistoryEntity(OrderHistoryRequest orderHistoryRequest) {
        return mapper.map(orderHistoryRequest, OrderHistory.class);
    }

    public OrderHistoryResponse toOrderHistoryResponse(OrderHistory orderHistory) {
        OrderHistoryResponse response = mapper.map(orderHistory, OrderHistoryResponse.class);
        response.setOrderId(orderHistory.getOrder().getId().toString());
        return response;
    }
}
