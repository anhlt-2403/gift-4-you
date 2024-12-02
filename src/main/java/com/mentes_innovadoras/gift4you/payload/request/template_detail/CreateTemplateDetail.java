package com.mentes_innovadoras.gift4you.payload.request.template_detail;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateTemplateDetail {

    @NotNull
    private UUID inventoryItemId;

    @NotNull
    @Positive
    private Integer quantity;
}
