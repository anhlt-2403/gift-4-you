package com.mentes_innovadoras.gift4you.controller;

import com.mentes_innovadoras.gift4you.constant.ApiEndpointConstant;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.facade.AuthFacade;
import com.mentes_innovadoras.gift4you.payload.common.ResponseHandler;
import com.mentes_innovadoras.gift4you.payload.reponse.LoginResponse;
import com.mentes_innovadoras.gift4you.payload.request.LoginRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthController {
    public final AuthFacade authFacade;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = LoginResponse.class)))
    })
    @PostMapping(value = ApiEndpointConstant.Authentication.Login)
    public ResponseEntity<Object> Login(@Valid @RequestBody LoginRequest loginRequest) throws ArchitectureException {
        return ResponseHandler.response(HttpStatus.OK, authFacade.Login(loginRequest), true);
    }
}
