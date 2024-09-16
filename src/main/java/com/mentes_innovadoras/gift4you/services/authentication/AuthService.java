package com.mentes_innovadoras.gift4you.services.authentication;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.entity.Account;
import com.mentes_innovadoras.gift4you.exception.common.NotFoundException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.LoginResponse;
import com.mentes_innovadoras.gift4you.payload.request.LoginRequest;
import com.mentes_innovadoras.gift4you.repository.AccountRepository;
import com.mentes_innovadoras.gift4you.utils.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    @Value("${expiration.hours}")
    private long expirationHours;

    public LoginResponse login(@Valid LoginRequest loginRequest) throws ArchitectureException {
        Account account = accountRepository.findByPhoneNumber(loginRequest.getPhoneNumber()).orElse(null);
        if (account == null) throw new NotFoundException(ResponseConstant.Message.userNotFound);
        if (!passwordEncoder.matches(loginRequest.getPassword(), account.getPassword())) {
            throw new BadCredentialsException(ResponseConstant.Message.invalidPassword);
        }
        UserDetailsImpl userDetails = new UserDetailsImpl(account);
        String accessToken = jwtUtil.generateToken(userDetails);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(account.getId());
        loginResponse.setFullName(account.getFullName());
        loginResponse.setStatus(account.getStatus());
        loginResponse.setExpiresIn(expirationHours * 60 * 60);
        loginResponse.setAccessToken(accessToken);
        return loginResponse;
    }
}
