package com.mentes_innovadoras.gift4you.payload.reponse.template_detail;

import com.mentes_innovadoras.gift4you.entity.InventoryItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TemplateDetailResponse {

    private UUID inventoryItemId;

    private Integer quantity;
}
