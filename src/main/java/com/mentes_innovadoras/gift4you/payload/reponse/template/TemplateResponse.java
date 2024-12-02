package com.mentes_innovadoras.gift4you.payload.reponse.template;


import com.mentes_innovadoras.gift4you.entity.Review;
import com.mentes_innovadoras.gift4you.entity.TemplateDetail;
import com.mentes_innovadoras.gift4you.payload.reponse.review.ReviewResponse;
import com.mentes_innovadoras.gift4you.payload.reponse.template_detail.TemplateDetailResponse;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class TemplateResponse {

    private UUID id;

    private String description;

    private BigDecimal price;

    private Integer totalSales;

    private String urlImg;

    private Set<TemplateDetailResponse> templateDetails = new LinkedHashSet<>();
}
