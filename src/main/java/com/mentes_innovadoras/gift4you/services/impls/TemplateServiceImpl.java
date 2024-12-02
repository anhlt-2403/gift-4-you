package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.entity.*;
import com.mentes_innovadoras.gift4you.enums.OrderStatus;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.common.NotFoundException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.mapper.TemplateDetailMapper;
import com.mentes_innovadoras.gift4you.mapper.TemplateMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.template.TemplateResponse;
import com.mentes_innovadoras.gift4you.payload.request.template.CreateTemplateRequest;
import com.mentes_innovadoras.gift4you.repository.InventoryItemRepository;
import com.mentes_innovadoras.gift4you.repository.OrderRepository;
import com.mentes_innovadoras.gift4you.repository.TemplateRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TemplateServiceImpl implements TemplateService {
    private final TemplateRepository templateRepository;
    private final InventoryItemRepository inventoryItemRepository;
    private final TemplateMapper templateMapper;
    private final TemplateDetailMapper templateDetailMapper;
    @Override
    public PagedModel<TemplateResponse> getTemplates(Pageable pageable) {
        return new PagedModel<>(templateRepository.findAll(pageable).map(templateMapper::toTemplateResponse));
    }

    @Override
    public TemplateResponse getTemplateById(UUID id) throws ArchitectureException {
        if (id == null) throw new InvalidParamException();
        return templateRepository.findById(id).map(templateMapper::toTemplateResponse).orElseThrow(() -> new NotFoundException(ResponseConstant.Message.templateNotFound));    }

    @Override
    public TemplateResponse createTemplate(CreateTemplateRequest createTemplateRequest) throws ArchitectureException {
        Template newTemplate = templateMapper.toTemplateEntity(createTemplateRequest);
        newTemplate.setId(UUID.randomUUID());
        newTemplate.setTotalSales(0);

        Set<TemplateDetail> templateDetails = new HashSet<>();



            createTemplateRequest.getCreateTemplateDetails().forEach(createTemplateDetail -> {
                InventoryItem inventoryItem = inventoryItemRepository.findById(createTemplateDetail.getInventoryItemId()).orElse(null);
                TemplateDetail templateDetail = templateDetailMapper.toTemplateDetailEntity(createTemplateDetail);
                templateDetail.setId(UUID.randomUUID());
                templateDetail.setInventoryItem(inventoryItem);
                templateDetail.setTemplate(newTemplate);
                templateDetails.add(templateDetail);
            });

            newTemplate.setTemplateDetails(templateDetails);


        Template saveTemplate = templateRepository.save(newTemplate);

        return templateMapper.toTemplateResponse(saveTemplate);
    }
}
