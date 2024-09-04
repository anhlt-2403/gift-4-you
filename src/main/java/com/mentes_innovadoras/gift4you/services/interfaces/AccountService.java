package com.mentes_innovadoras.gift4you.services.interfaces;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.reponse.account.AccountResponse;

import com.mentes_innovadoras.gift4you.payload.request.account.CreateAccountRequest;
import com.mentes_innovadoras.gift4you.payload.request.account.UpdateAccountRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

import java.util.UUID;

public interface AccountService {
    PagedModel<AccountResponse> getAccounts(Pageable pageable);
    AccountResponse getAccountById(UUID id) throws ArchitectureException;
    AccountResponse createAccount(CreateAccountRequest accountRequest) throws ArchitectureException;
    AccountResponse updateAccount(UUID id, UpdateAccountRequest updateAccountRequest)throws ArchitectureException;
}
