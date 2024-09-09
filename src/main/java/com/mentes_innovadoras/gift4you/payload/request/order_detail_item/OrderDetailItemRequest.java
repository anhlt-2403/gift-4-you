package com.mentes_innovadoras.gift4you.payload.request.order_detail_item;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailItemRequest {

    @NotNull
    private UUID itemId;

    @NotNull
    @Positive
    private Integer quantity;
}
