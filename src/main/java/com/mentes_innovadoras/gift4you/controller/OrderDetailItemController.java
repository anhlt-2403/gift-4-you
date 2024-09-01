package com.mentes_innovadoras.gift4you.controller;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.facade.OrderDetailItemFacade;
import com.mentes_innovadoras.gift4you.payload.common.ResponseHandler;
import com.mentes_innovadoras.gift4you.payload.reponse.OrderDetailItemResponse;
import com.mentes_innovadoras.gift4you.payload.request.OrderDetailItemRequest;
import com.mentes_innovadoras.gift4you.utils.ApiEndpointConstant;
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
public class OrderDetailItemController {
    public final OrderDetailItemFacade orderDetailItemFacade;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = Page.class)))
    })
    @GetMapping(value = ApiEndpointConstant.OrderDetailItem.OrderDetailItemsEndpoint)
    public Page<OrderDetailItemResponse> getOrderDetailItems(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return orderDetailItemFacade.getOrderDetailItems(pageable);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = OrderDetailItemResponse.class)))
    })
    @GetMapping(value = ApiEndpointConstant.OrderDetailItem.OrderDetailItemEndpoint)
    public ResponseEntity<Object> getOrderDetailItemById(@PathVariable("id") UUID id) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, orderDetailItemFacade.getOrderDetailItemById(id), true);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = OrderDetailItemResponse.class)))
    })
    @PostMapping(value = ApiEndpointConstant.OrderDetailItem.OrderDetailItemsEndpoint)
    public ResponseEntity<Object> CreateOrderDetailItem(@Valid @RequestBody OrderDetailItemRequest orderDetailItemRequest) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, orderDetailItemFacade.CreateOrderDetailItem(orderDetailItemRequest), true);
    }
}
