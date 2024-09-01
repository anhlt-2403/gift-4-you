package com.mentes_innovadoras.gift4you.payload.reponse;


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
public class OrderResponse {
    private UUID id;
    private String address;
    private Instant createAt;
    private String description;
    private String phoneNumber;
    private String status;
    private BigDecimal totalPrice;
    private Instant updateAt;
}
