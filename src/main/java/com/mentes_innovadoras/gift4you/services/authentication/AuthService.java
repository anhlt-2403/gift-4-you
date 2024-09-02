package com.mentes_innovadoras.gift4you.services.authentication;

import com.mentes_innovadoras.gift4you.entity.Account;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.exception.account.UserNotFoundException;
import com.mentes_innovadoras.gift4you.payload.reponse.LoginResponse;
import com.mentes_innovadoras.gift4you.payload.request.LoginRequest;
import com.mentes_innovadoras.gift4you.repository.AccountRepository;
import com.mentes_innovadoras.gift4you.utils.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
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
        Account account = accountRepository.findByUserName(loginRequest.getUserName())
                .orElseThrow(UserNotFoundException::new);
        if (!passwordEncoder.matches(loginRequest.getPassword(), account.getPassword())) {
            throw new UserNotFoundException();
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
