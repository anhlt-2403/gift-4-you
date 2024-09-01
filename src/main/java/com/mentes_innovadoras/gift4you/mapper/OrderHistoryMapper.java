package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.OrderHistory;
import com.mentes_innovadoras.gift4you.payload.reponse.OrderHistoryResponse;
import com.mentes_innovadoras.gift4you.payload.request.OrderHistoryRequest;
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
        return mapper.map(orderHistory, OrderHistoryResponse.class);
    }
}
