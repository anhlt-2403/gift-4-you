package com.mentes_innovadoras.gift4you.controller;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.facade.AccountFacade;
import com.mentes_innovadoras.gift4you.payload.common.ResponseHandler;
import com.mentes_innovadoras.gift4you.payload.reponse.account.AccountResponse;
import com.mentes_innovadoras.gift4you.payload.request.account.CreateAccountRequest;
import com.mentes_innovadoras.gift4you.constant.ApiEndpointConstant;
import com.mentes_innovadoras.gift4you.payload.request.account.UpdateAccountRequest;
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
@Tag(name = "Account")
public class AccountController {
    public final AccountFacade accountFacade;

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
        @GetMapping(value = ApiEndpointConstant.Account.AccountsEndpoint)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = PagedModel.class)))
    })
    public ResponseEntity<Object> getAccounts(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseHandler.response(HttpStatus.OK, accountFacade.getAccounts(pageable), true);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'CUSTOMER')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = AccountResponse.class)))
    })
    @GetMapping(value = ApiEndpointConstant.Account.AccountEndpoint)
    public ResponseEntity<Object> getAccountById(@PathVariable("id") UUID id) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, accountFacade.getAccountById(id), true);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = AccountResponse.class)))
    })
    @PostMapping(value = ApiEndpointConstant.Account.AccountsEndpoint)
    public ResponseEntity<Object> CreateAccount(@Valid @RequestBody CreateAccountRequest accountRequest) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, accountFacade.CreateAccount(accountRequest), true);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'CUSTOMER')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = AccountResponse.class)))
    })
    @PutMapping(value = ApiEndpointConstant.Account.AccountEndpoint)
    public ResponseEntity<Object> UpdateAccount(@PathVariable("id") UUID id, @Valid @RequestBody UpdateAccountRequest accountRequest) throws ArchitectureException
    {
        return ResponseHandler.response(HttpStatus.OK, accountFacade.UpdateAccount(id, accountRequest), true);
    }
}
