package com.mentes_innovadoras.gift4you.services.interfaces;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.template.TemplateResponse;
import com.mentes_innovadoras.gift4you.payload.request.template.CreateTemplateRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

import java.util.UUID;

public interface TemplateService {
    PagedModel<TemplateResponse> getTemplates(Pageable pageable);
    TemplateResponse getTemplateById(UUID id) throws ArchitectureException;
    TemplateResponse createTemplate(CreateTemplateRequest createTemplateRequest) throws ArchitectureException;
}
