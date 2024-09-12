package com.mentes_innovadoras.gift4you.payload.request.provider;

import com.mentes_innovadoras.gift4you.payload.request.inventoryItem.InventoryItemRequest;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProviderRequest {
    private Instant createAt;
    private Instant updateAt;
    private String status;
    private String contactInfo;
    private String name;
    private String address;
    @NotEmpty
    private Set<InventoryItemRequest> items;
}
