package com.mentes_innovadoras.gift4you.controller;

import com.mentes_innovadoras.gift4you.payload.common.ResponseHandler;
import com.mentes_innovadoras.gift4you.payload.reponse.AccountResponse;
import com.mentes_innovadoras.gift4you.services.interfaces.AccountService;
import com.mentes_innovadoras.gift4you.utils.ApiEndpointConstant;
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
@RequestMapping(value = ApiEndpointConstant.User.UsersEndpoint)
public class AccountController {
    public final AccountService accountService;

    @GetMapping
    public Page<AccountResponse> getUsers(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return accountService.findAll(pageable);
    }
}
