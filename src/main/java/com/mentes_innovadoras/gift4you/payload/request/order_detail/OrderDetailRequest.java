package com.mentes_innovadoras.gift4you.payload.request.order_detail;

import com.mentes_innovadoras.gift4you.payload.request.order_detail_item.OrderDetailItemRequest;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailRequest {
    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @Positive
    private Integer quantity;

    @Size(max = 255, message = "Description must be less than or equal to 255 characters" )
    private String description;

    @NotEmpty
    private Set<OrderDetailItemRequest> items;
}
