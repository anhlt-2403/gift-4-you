package com.mentes_innovadoras.gift4you.payload.request;

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
public class OrderRequest {
    private String address;
    private Instant createAt;
    private String description;
    private String phoneNumber;
    private String status;
    private BigDecimal totalPrice;
    private Instant updateAt;
}
