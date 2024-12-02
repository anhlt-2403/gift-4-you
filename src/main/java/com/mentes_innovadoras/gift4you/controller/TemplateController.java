package com.mentes_innovadoras.gift4you.controller;

import com.mentes_innovadoras.gift4you.constant.ApiEndpointConstant;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.facade.TemplateFacade;
import com.mentes_innovadoras.gift4you.payload.common.ResponseHandler;
import com.mentes_innovadoras.gift4you.payload.reponse.order.OrderResponse;
import com.mentes_innovadoras.gift4you.payload.reponse.template.TemplateResponse;
import com.mentes_innovadoras.gift4you.payload.request.order.OrderRequest;
import com.mentes_innovadoras.gift4you.payload.request.template.CreateTemplateRequest;
import com.mentes_innovadoras.gift4you.services.interfaces.TemplateService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = "Template")
public class TemplateController {
    private final TemplateFacade templateFacade;

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'CUSTOMER')")
    @GetMapping(value = ApiEndpointConstant.Template.TemplatesEndpoint)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = PagedModel.class)))
    })
    public ResponseEntity<Object> getTemplates(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseHandler.response(HttpStatus.OK, templateFacade.getTemplates(pageable), true);
    }


    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'CUSTOMER')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = TemplateResponse.class)))
    })
    @GetMapping(value = ApiEndpointConstant.Template.TemplateEndpoint)
    public ResponseEntity<Object> getTemplateById(@PathVariable("id") UUID id) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, templateFacade.getTemplateById(id), true);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'CUSTOMER')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = TemplateResponse.class)))
    })
    @PostMapping(value = ApiEndpointConstant.Template.TemplatesEndpoint)
    public ResponseEntity<Object> CreateOrder(@Valid @RequestBody CreateTemplateRequest createTemplateRequest) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, templateFacade.createTemplate(createTemplateRequest), true);
    }
}
