package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.OrderDetail;
import com.mentes_innovadoras.gift4you.entity.TemplateDetail;
import com.mentes_innovadoras.gift4you.payload.reponse.order_detail.OrderDetailResponse;
import com.mentes_innovadoras.gift4you.payload.reponse.template_detail.TemplateDetailResponse;
import com.mentes_innovadoras.gift4you.payload.request.order_detail.OrderDetailRequest;
import com.mentes_innovadoras.gift4you.payload.request.template_detail.CreateTemplateDetail;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TemplateDetailMapper {
    private final ModelMapper mapper;

    public TemplateDetailMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public TemplateDetail toTemplateDetailEntity(CreateTemplateDetail createTemplateDetail) {
        return mapper.map(createTemplateDetail, TemplateDetail.class);
    }

    public TemplateDetailResponse toTemplateDetailResponse(TemplateDetail templateDetail) {
        return mapper.map(templateDetail, TemplateDetailResponse.class);
    }
}
