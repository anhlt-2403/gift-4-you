package com.mentes_innovadoras.gift4you.controller;

import com.mentes_innovadoras.gift4you.constant.ApiEndpointConstant;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.facade.OrderFacade;
import com.mentes_innovadoras.gift4you.payload.common.ResponseHandler;
import com.mentes_innovadoras.gift4you.payload.reponse.order.OrderResponse;
import com.mentes_innovadoras.gift4you.payload.request.order.OrderRequest;
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
@Tag(name = "Order")
public class OrderController {
    private final OrderFacade orderFacade;

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @GetMapping(value = ApiEndpointConstant.Order.OrdersEndpoint)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = PagedModel.class)))
    })
    public ResponseEntity<Object> getOrders(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseHandler.response(HttpStatus.OK, orderFacade.getOrders(pageable), true);
    }


    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'CUSTOMER')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = OrderResponse.class)))
    })
    @GetMapping(value = ApiEndpointConstant.Order.OrderEndpoint)
    public ResponseEntity<Object> getOrderById(@PathVariable("id") UUID id) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, orderFacade.getOrderById(id), true);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = OrderResponse.class)))
    })
    @PostMapping(value = ApiEndpointConstant.Order.OrdersEndpoint)
    public ResponseEntity<Object> CreateOrder(@Valid @RequestBody OrderRequest orderRequest) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, orderFacade.createOrder(orderRequest), true);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'CUSTOMER')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = OrderResponse.class)))
    })
    @PutMapping(value = ApiEndpointConstant.Order.OrderEndpoint)
    public ResponseEntity<Object> UpdateOrder(@PathVariable("id") UUID id,@RequestParam String status) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, orderFacade.updateOrderStatus(id, status), true);
    }
}
