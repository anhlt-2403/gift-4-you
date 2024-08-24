package com.mentes_innovadoras.gift4you.controller;

import com.mentes_innovadoras.gift4you.util.ApiEndpointConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = ApiEndpointConstant.User.UsersEndpoint)
public class UserController {
}
