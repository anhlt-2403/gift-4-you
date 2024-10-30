package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.Order;
import com.mentes_innovadoras.gift4you.payload.reponse.order.OrderResponse;
import com.mentes_innovadoras.gift4you.payload.request.order.OrderRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderMapper {
    private final ModelMapper mapper;

    public OrderMapper(ModelMapper mapper) {
        this.mapper = mapper;
        mapper.addMappings(new PropertyMap<OrderRequest, Order>() {
            @Override
            protected void configure() {
                // Exclude ID mapping to prevent conflicts
                skip(destination.getId());
            }
        });
    }



    public Order toOrderEntity(OrderRequest orderRequest) {
        return mapper.map(orderRequest, Order.class);
    }

    public OrderResponse toOrderResponse(Order order) {
        OrderResponse response = mapper.map(order, OrderResponse.class);
        response.setCustomerName(order.getAccount().getFullName());
        return response;
    }
}
