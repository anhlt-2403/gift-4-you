package com.mentes_innovadoras.gift4you.controller;

import com.mentes_innovadoras.gift4you.constant.ApiEndpointConstant;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.facade.InventoryItemFacade;
import com.mentes_innovadoras.gift4you.payload.common.ResponseHandler;
import com.mentes_innovadoras.gift4you.payload.reponse.inventory_item.InventoryItemResponse;
import com.mentes_innovadoras.gift4you.payload.request.inventory_item.CreateInventoryItemRequest;
import com.mentes_innovadoras.gift4you.payload.request.inventory_item.UpdateInventoryItemRequest;
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
@Tag(name = "InventoryItem")
public class InventoryItemController {
    public final InventoryItemFacade inventoryItemFacade;

    @GetMapping(value = ApiEndpointConstant.InventoryItem.InventoryItemsEndpoint)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = PagedModel.class)))
    })
    public ResponseEntity<Object> getInventoryItems(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseHandler.response(HttpStatus.OK, inventoryItemFacade.getInventoryItems(pageable), true);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'CUSTOMER')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = InventoryItemResponse.class)))
    })
    @GetMapping(value = ApiEndpointConstant.InventoryItem.InventoryItemEndpoint)
    public ResponseEntity<Object> getInventoryItemById(@PathVariable("id") UUID id) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, inventoryItemFacade.getInventoryItemById(id), true);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = InventoryItemResponse.class)))
    })
    @PostMapping(value = ApiEndpointConstant.InventoryItem.InventoryItemsEndpoint)
    public ResponseEntity<Object> createInventoryItem(@Valid @RequestBody CreateInventoryItemRequest inventoryItemRequest) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, inventoryItemFacade.createInventoryItem(inventoryItemRequest), true);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = InventoryItemResponse.class)))
    })
    @PutMapping(value = ApiEndpointConstant.InventoryItem.InventoryItemEndpoint)
    public ResponseEntity<Object> updateInventoryItem(@PathVariable("id") UUID id, @Valid @RequestBody UpdateInventoryItemRequest inventoryItemRequest) throws ArchitectureException // Đổi từ UpdateAccountRequest
    {
        return ResponseHandler.response(HttpStatus.OK, inventoryItemFacade.updateInventoryItem(id, inventoryItemRequest), true);
    }
}
