package com.mentes_innovadoras.gift4you.services.interfaces;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.LoginResponse;
import com.mentes_innovadoras.gift4you.payload.reponse.account.AccountResponse;
import com.mentes_innovadoras.gift4you.payload.request.LoginRequest;
import com.mentes_innovadoras.gift4you.payload.request.account.AccountRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AccountService {
    Page<AccountResponse> getAccounts(Pageable pageable);
    AccountResponse getAccountById(UUID id) throws ArchitectureException;
    AccountResponse findByUserName(String username) throws ArchitectureException;
    AccountResponse findByPhoneNumber(String phoneNumber) throws ArchitectureException;
    AccountResponse createAccount(AccountRequest accountRequest) throws ArchitectureException;
    AccountResponse updateAccount(UUID id, AccountRequest accountRequest)throws ArchitectureException;
}
