package com.mentes_innovadoras.gift4you.payload.request;

import com.mentes_innovadoras.gift4you.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistoryRequest {
    private Instant createAt;
    private Instant updateAt;
    private String status;
    private String description;
    private Order order;
}
