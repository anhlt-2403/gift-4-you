package com.mentes_innovadoras.gift4you.facade;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.request.order.OrderRequest;
import com.mentes_innovadoras.gift4you.payload.request.template.CreateTemplateRequest;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderService;
import com.mentes_innovadoras.gift4you.services.interfaces.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TemplateFacade {
    private final TemplateService templateService;

    public Object getTemplates(Pageable pageable) {
        return templateService.getTemplates(pageable);
    }

    public Object getTemplateById(UUID id) throws ArchitectureException {
        return templateService.getTemplateById(id);
    }

    public Object createTemplate(CreateTemplateRequest createTemplateRequest) throws ArchitectureException {
        return templateService.createTemplate(createTemplateRequest);
    }
}
