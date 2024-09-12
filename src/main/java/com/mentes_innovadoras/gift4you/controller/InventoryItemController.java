package com.mentes_innovadoras.gift4you.controller;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.facade.InventoryItemFacade;
import com.mentes_innovadoras.gift4you.payload.common.ResponseHandler;
import com.mentes_innovadoras.gift4you.payload.reponse.inventoryItem.InventoryItemResponse;
import com.mentes_innovadoras.gift4you.payload.request.inventoryItem.InventoryItemRequest;
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
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class InventoryItemController {
    public final InventoryItemFacade inventoryItemFacade;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = Page.class)))
    })
    @GetMapping(value = ApiEndpointConstant.InventoryItem.InventoryItemsEndpoint)
    public PagedModel<InventoryItemResponse> getInventoryItems(@RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return inventoryItemFacade.getInventoryItems(pageable);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = InventoryItemResponse.class)))
    })
    @GetMapping(value = ApiEndpointConstant.InventoryItem.InventoryItemEndpoint)
    public ResponseEntity<Object> getInventoryItemById(@PathVariable("id") UUID id) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, inventoryItemFacade.getInventoryItemById(id), true);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = InventoryItemResponse.class)))
    })
    @PostMapping(value = ApiEndpointConstant.InventoryItem.InventoryItemsEndpoint)
    public ResponseEntity<Object> CreateInventoryItem(@Valid @RequestBody InventoryItemRequest inventoryItemRequest) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, inventoryItemFacade.CreateInventoryItem(inventoryItemRequest), true);
    }

    @PutMapping(value = ApiEndpointConstant.InventoryItem.InventoryItemEndpoint)
    public ResponseEntity<Object> UpdateInventoryItem(@PathVariable("id") UUID id, @Valid @RequestBody InventoryItemRequest inventoryItemRequest) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, inventoryItemFacade.UpdateInventoryItem(id, inventoryItemRequest), true);
    }
}
