package com.mentes_innovadoras.gift4you.payload.request.orderDetail;

import com.mentes_innovadoras.gift4you.entity.Order;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

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
    @NotBlank
    private UUID orderId;
}
