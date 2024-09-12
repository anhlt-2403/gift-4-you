package com.mentes_innovadoras.gift4you.controller;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.facade.OrderHistoryFacade;
import com.mentes_innovadoras.gift4you.payload.common.ResponseHandler;
import com.mentes_innovadoras.gift4you.payload.reponse.orderHistory.OrderHistoryResponse;
import com.mentes_innovadoras.gift4you.payload.request.orderDetailItem.OrderDetailItemRequest;
import com.mentes_innovadoras.gift4you.payload.request.orderHistory.OrderHistoryRequest;
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
public class OrderHistoryController {
    public final OrderHistoryFacade orderHistoryFacade;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = Page.class)))
    })
    @GetMapping(value = ApiEndpointConstant.OrderHistory.OrderHistoriesEndpoint)
    public PagedModel<OrderHistoryResponse> getOrderHistories(@RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return orderHistoryFacade.getOrderHistories(pageable);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = OrderHistoryResponse.class)))
    })
    @GetMapping(value = ApiEndpointConstant.OrderHistory.OrderHistoryEndpoint)
    public ResponseEntity<Object> getOrderHistoryById(@PathVariable("id") UUID id) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, orderHistoryFacade.getOrderHistoryById(id), true);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = OrderHistoryResponse.class)))
    })
    @PostMapping(value = ApiEndpointConstant.OrderHistory.OrderHistoriesEndpoint)
    public ResponseEntity<Object> CreateOrderHistory(@Valid @RequestBody OrderHistoryRequest orderHistoryRequest) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, orderHistoryFacade.CreateOrderHistory(orderHistoryRequest), true);
    }

    @PutMapping(value = ApiEndpointConstant.OrderHistory.OrderHistoryEndpoint)
    public ResponseEntity<Object> UpdateOrderHistoryStatusDescription(@PathVariable("id") UUID id, @Valid @RequestBody String status, String description) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, orderHistoryFacade.UpdateOrderHistoryStatusDescription(id, status, description), true);
    }
}
