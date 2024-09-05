package com.mentes_innovadoras.gift4you.payload.request.orderHistory;

import com.mentes_innovadoras.gift4you.entity.Order;
import jakarta.validation.constraints.NotBlank;
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
public class OrderHistoryRequest {
    private Instant createAt;
    private Instant updateAt;
    private String status;
    private String description;
    @NotBlank
    private UUID orderId;
}
