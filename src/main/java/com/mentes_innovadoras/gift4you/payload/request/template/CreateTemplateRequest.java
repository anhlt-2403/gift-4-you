package com.mentes_innovadoras.gift4you.payload.request.template;


import com.mentes_innovadoras.gift4you.payload.request.template_detail.CreateTemplateDetail;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Set;


@Getter
public class CreateTemplateRequest {

    @Size(max = 255)
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    private String urlImg;

    private Set<CreateTemplateDetail> createTemplateDetails;
}


