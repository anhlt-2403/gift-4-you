package com.mentes_innovadoras.gift4you.mapper;

import com.mentes_innovadoras.gift4you.entity.Order;
import com.mentes_innovadoras.gift4you.entity.Template;
import com.mentes_innovadoras.gift4you.entity.TemplateDetail;
import com.mentes_innovadoras.gift4you.payload.reponse.order.OrderResponse;
import com.mentes_innovadoras.gift4you.payload.reponse.order_detail.OrderDetailResponse;
import com.mentes_innovadoras.gift4you.payload.reponse.template.TemplateResponse;
import com.mentes_innovadoras.gift4you.payload.reponse.template_detail.TemplateDetailResponse;
import com.mentes_innovadoras.gift4you.payload.request.order.OrderRequest;
import com.mentes_innovadoras.gift4you.payload.request.template.CreateTemplateRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Set;

@Component
public class TemplateMapper {
    private final ModelMapper mapper;

    public TemplateMapper(ModelMapper mapper) {
        this.mapper = mapper;
        mapper.addMappings(new PropertyMap<CreateTemplateRequest, Template>() {
            @Override
            protected void configure() {
                skip(destination.getId());
            }
        });
    }

    public Template toTemplateEntity(CreateTemplateRequest createTemplateRequest) {
        return mapper.map(createTemplateRequest, Template.class);
    }

    public TemplateResponse toTemplateResponse(Template template) {
        // Ánh xạ Template sang TemplateResponse
        TemplateResponse templateResponse = mapper.map(template, TemplateResponse.class);

        // Ánh xạ TemplateDetails sang TemplateDetailResponses
        Type targetListType = new TypeToken<Set<TemplateDetailResponse>>() {}.getType();
        Set<TemplateDetailResponse> templateDetailResponses = mapper.map(template.getTemplateDetails(), targetListType);

        // Nếu bạn cần ánh xạ inventoryItemId từ TemplateDetail sang TemplateDetailResponse
        for (TemplateDetail templateDetail : template.getTemplateDetails()) {
            for (TemplateDetailResponse detailResponse : templateDetailResponses) {
                // Nếu chưa có inventoryItemId, set giá trị
                if (detailResponse.getInventoryItemId() == null) {
                    detailResponse.setInventoryItemId(templateDetail.getInventoryItem().getId());
                }
            }
        }

        templateResponse.setTemplateDetails(templateDetailResponses);
        return templateResponse;
    }

}
