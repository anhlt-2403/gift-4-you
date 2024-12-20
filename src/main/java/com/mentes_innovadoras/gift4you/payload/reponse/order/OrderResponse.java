package com.mentes_innovadoras.gift4you.payload.reponse.order;

import com.mentes_innovadoras.gift4you.payload.reponse.order_detail.OrderDetailResponse;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
public class OrderResponse {

    private UUID id;

    private String address;

    private Date createAt;

    private String description;

    private String phoneNumber;

    private String status;

    private BigDecimal totalPrice;

    private Date updateAt;

    private UUID accountId;

    private String customerName;

    private UUID templateId;

    private Set<OrderDetailResponse> orderDetailResponses;
}
