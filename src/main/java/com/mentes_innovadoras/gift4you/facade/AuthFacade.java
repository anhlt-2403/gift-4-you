package com.mentes_innovadoras.gift4you.facade;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.request.LoginRequest;
import com.mentes_innovadoras.gift4you.services.authentication.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthFacade {
    private final AuthService authService;
    public Object Login(LoginRequest loginRequest)throws ArchitectureException {
        return authService.login(loginRequest);
    }
}
