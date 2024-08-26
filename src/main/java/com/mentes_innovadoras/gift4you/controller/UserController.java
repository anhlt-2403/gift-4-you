package com.mentes_innovadoras.gift4you.controller;

import com.mentes_innovadoras.gift4you.payload.reponse.UserResponse;
import com.mentes_innovadoras.gift4you.services.interfaces.UserService;
import com.mentes_innovadoras.gift4you.utils.ApiEndpointConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = ApiEndpointConstant.User.UsersEndpoint)
public class UserController {
    public final UserService userService;

    @GetMapping
    public Page<UserResponse> getUsers(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return userService.findAll(pageable);
    }

}
