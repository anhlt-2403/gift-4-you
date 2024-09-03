package com.mentes_innovadoras.gift4you.facade;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.payload.request.account.CreateAccountRequest;
import com.mentes_innovadoras.gift4you.payload.request.account.UpdateAccountRequest;
import com.mentes_innovadoras.gift4you.services.interfaces.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountFacade {
    private final AccountService accountService;

    public Object getAccounts(Pageable pageable){
        return accountService.getAccounts(pageable);
    }

    public Object getAccountById(UUID id) throws ArchitectureException {
        return accountService.getAccountById(id);
    }

    public Object CreateAccount(CreateAccountRequest accountRequest) throws ArchitectureException {
        return accountService.createAccount(accountRequest);
    }

    public Object UpdateAccount(UUID id, UpdateAccountRequest accountRequest) throws ArchitectureException {
        return accountService.updateAccount(id, accountRequest);
    }
}
