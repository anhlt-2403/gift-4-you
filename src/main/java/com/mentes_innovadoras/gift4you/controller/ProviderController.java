package com.mentes_innovadoras.gift4you.controller;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.facade.ProviderFacade;
import com.mentes_innovadoras.gift4you.payload.common.ResponseHandler;
import com.mentes_innovadoras.gift4you.payload.reponse.provider.ProviderResponse;
import com.mentes_innovadoras.gift4you.payload.request.orderDetail.OrderDetailRequest;
import com.mentes_innovadoras.gift4you.payload.request.provider.ProviderRequest;
import com.mentes_innovadoras.gift4you.constant.ApiEndpointConstant;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProviderController {
    public final ProviderFacade providerFacade;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = Page.class)))
    })
    @GetMapping(value = ApiEndpointConstant.Provider.ProvidersEndpoint)
    public Page<ProviderResponse> getProviders(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return providerFacade.getProviders(pageable);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = ProviderResponse.class)))
    })
    @GetMapping(value = ApiEndpointConstant.Provider.ProviderEndpoint)
    public ResponseEntity<Object> getProviderById(@PathVariable("id") UUID id) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, providerFacade.getProviderById(id), true);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = ProviderResponse.class)))
    })
    @PostMapping(value = ApiEndpointConstant.Provider.ProvidersEndpoint)
    public ResponseEntity<Object> CreateProvider(@Valid @RequestBody ProviderRequest providerRequest) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, providerFacade.CreateProvider(providerRequest), true);
    }

    @PutMapping(value = ApiEndpointConstant.Provider.ProviderEndpoint)
    public ResponseEntity<Object> UpdateProvider(@PathVariable("id") UUID id, @Valid @RequestBody ProviderRequest providerRequest) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, providerFacade.UpdateProvider(id, providerRequest), true);
    }
}
