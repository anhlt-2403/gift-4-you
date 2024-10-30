package com.mentes_innovadoras.gift4you.controller;

import com.mentes_innovadoras.gift4you.constant.ApiEndpointConstant;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.facade.ProviderFacade;
import com.mentes_innovadoras.gift4you.payload.common.ResponseHandler;
import com.mentes_innovadoras.gift4you.payload.reponse.provider.ProviderResponse;
import com.mentes_innovadoras.gift4you.payload.request.provider.CreateProviderRequest;
import com.mentes_innovadoras.gift4you.payload.request.provider.UpdateProviderRequest;
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
@Tag(name = "Provider")
public class ProviderController {
    public final ProviderFacade providerFacade;

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @GetMapping(value = ApiEndpointConstant.Provider.ProvidersEndpoint)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = PagedModel.class)))
    })
    public ResponseEntity<Object> getProviders(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseHandler.response(HttpStatus.OK, providerFacade.getProviders(pageable), true); // Đổi từ getInventoryItems
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = ProviderResponse.class)))
    })
    @GetMapping(value = ApiEndpointConstant.Provider.ProviderEndpoint)
    public ResponseEntity<Object> getProviderById(@PathVariable("id") UUID id) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, providerFacade.getProviderById(id), true);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = ProviderResponse.class)))
    })
    @PostMapping(value = ApiEndpointConstant.Provider.ProvidersEndpoint)
    public ResponseEntity<Object> createProvider(@Valid @RequestBody CreateProviderRequest providerRequest) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, providerFacade.createProvider(providerRequest), true);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = ProviderResponse.class)))
    })
    @PutMapping(value = ApiEndpointConstant.Provider.ProviderEndpoint)
    public ResponseEntity<Object> updateProvider(@PathVariable("id") UUID id, @Valid @RequestBody UpdateProviderRequest providerRequest) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, providerFacade.updateProvider(id, providerRequest), true);
    }
}
