package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.Order;
import com.mentes_innovadoras.gift4you.entity.OrderDetail;
import com.mentes_innovadoras.gift4you.payload.reponse.order.OrderResponse;
import com.mentes_innovadoras.gift4you.payload.reponse.order_detail.OrderDetailResponse;
import com.mentes_innovadoras.gift4you.payload.request.order.OrderRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Set;
import java.util.UUID;

@Component
public class OrderMapper {
    private final ModelMapper mapper;

    public OrderMapper(ModelMapper mapper) {
        this.mapper = mapper;
        mapper.addMappings(new PropertyMap<OrderRequest, Order>() {
            @Override
            protected void configure() {
                skip(destination.getId());
            }
        });
    }



    public Order toOrderEntity(OrderRequest orderRequest) {
        return mapper.map(orderRequest, Order.class);
    }

    public OrderResponse toOrderResponse(Order order) {
        // Ánh xạ Order sang OrderResponse
        OrderResponse response = mapper.map(order, OrderResponse.class);
        if (order.getTemplate() != null) {
            response.setTemplateId(order.getTemplate().getId());
        }else {
            Type targetListType = new TypeToken<Set<OrderDetailResponse>>() {}.getType();
            Set<OrderDetailResponse> orderDetailResponses = mapper.map(order.getOrderDetails(), targetListType);

            // Duyệt qua các OrderDetail để thêm inventoryItemId vào OrderDetailResponse
            for (OrderDetail orderDetail : order.getOrderDetails()) {
                // Duyệt qua các OrderDetailResponse để tìm OrderDetailResponse tương ứng
                for (OrderDetailResponse detailResponse : orderDetailResponses) {
                    if (detailResponse.getInventoryItemId() == null) {
                        // Nếu chưa có inventoryItemId, thêm vào từ InventoryItem của OrderDetail
                        detailResponse.setInventoryItemId(orderDetail.getInventoryItem().getId());
                    }
                }
            }

            // Thiết lập các thông tin khác vào OrderResponse
            response.setOrderDetailResponses(orderDetailResponses);
        }
        // Ánh xạ OrderDetails sang OrderDetailResponses
        response.setAccountId(order.getAccount().getId());
        response.setCustomerName(order.getAccount().getFullName());

        return response;
    }

}
