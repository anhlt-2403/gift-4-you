package com.mentes_innovadoras.gift4you.payload.request;

import com.mentes_innovadoras.gift4you.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailRequest {
    private BigDecimal price;
    private Integer quantity;
    private Instant createAt;
    private Instant updateAt;
    private String description;
    private Order order;
}