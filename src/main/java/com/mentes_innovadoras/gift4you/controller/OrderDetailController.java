package com.mentes_innovadoras.gift4you.controller;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.facade.OrderDetailFacade;
import com.mentes_innovadoras.gift4you.payload.common.ResponseHandler;
import com.mentes_innovadoras.gift4you.payload.reponse.order_detail.OrderDetailResponse;
import com.mentes_innovadoras.gift4you.payload.request.inventoryItem.InventoryItemRequest;
import com.mentes_innovadoras.gift4you.payload.request.order_detail.CreateOrderDetailRequest;
import com.mentes_innovadoras.gift4you.payload.request.order_detail.OrderDetailRequest;
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
public class OrderDetailController {
    public final OrderDetailFacade orderDetailFacade;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = Page.class)))
    })
    @GetMapping(value = ApiEndpointConstant.OrderDetail.OrderDetailsEndpoint)
    public PagedModel<OrderDetailResponse> getOrderDetails(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return orderDetailFacade.getOrderDetails(pageable);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = OrderDetailResponse.class)))
    })
    @GetMapping(value = ApiEndpointConstant.OrderDetail.OrderDetailEndpoint)
    public ResponseEntity<Object> getOrderDetailById(@PathVariable("id") UUID id) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, orderDetailFacade.getOrderDetailById(id), true);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = OrderDetailResponse.class)))
    })
    @PostMapping(value = ApiEndpointConstant.OrderDetail.OrderDetailsEndpoint)
    public ResponseEntity<Object> CreateOrderDetail(@Valid @RequestBody CreateOrderDetailRequest createOrderDetailRequest) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, orderDetailFacade.CreateOrderDetail(createOrderDetailRequest), true);
    }

    @PutMapping(value = ApiEndpointConstant.OrderDetail.OrderDetailEndpoint)
    public ResponseEntity<Object> UpdateOrderDetailDescription(@PathVariable("id") UUID id, @Valid @RequestBody String description) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, orderDetailFacade.UpdateOrderDetailDescription(id, description), true);
    }
}