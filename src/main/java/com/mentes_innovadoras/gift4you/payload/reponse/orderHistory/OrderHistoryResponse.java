package com.mentes_innovadoras.gift4you.payload.reponse.orderHistory;

import com.mentes_innovadoras.gift4you.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistoryResponse {
    private UUID id;
    private Instant createAt;
    private Instant updateAt;
    private String status;
    private String description;
    private String orderId;
}
