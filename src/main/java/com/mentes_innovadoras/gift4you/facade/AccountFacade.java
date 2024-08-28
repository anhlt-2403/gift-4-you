package com.mentes_innovadoras.gift4you.facade;

import com.mentes_innovadoras.gift4you.entity.Account;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.exception.user.UserNotFoundException;
import com.mentes_innovadoras.gift4you.mapper.AccountMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.AccountResponse;
import com.mentes_innovadoras.gift4you.services.interfaces.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountFacade {
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    public Page<Object> getAccounts(Pageable pageable) throws ArchitectureException{
        Page<Account> accounts = accountService.findAll(pageable);
        return accounts.map(accountMapper::toAccountResponse);
    }

    public Object getAccountById(UUID id) throws ArchitectureException {
            if (id == null)
                throw new InvalidParamException();
            AccountResponse accountResponse = accountService.findById(id).map(accountMapper::toAccountResponse).orElse(null);
            if (accountResponse == null)
                throw new UserNotFoundException();
            return accountResponse;
    }
}
