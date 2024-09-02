package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.entity.Account;
import com.mentes_innovadoras.gift4you.entity.Role;
import com.mentes_innovadoras.gift4you.enums.AccountStatus;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.exception.role.RoleNotFoundException;
import com.mentes_innovadoras.gift4you.exception.account.PhoneNumberAlreadyExistException;
import com.mentes_innovadoras.gift4you.exception.account.UserNotFoundException;
import com.mentes_innovadoras.gift4you.mapper.AccountMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.account.AccountResponse;
import com.mentes_innovadoras.gift4you.payload.request.account.AccountRequest;
import com.mentes_innovadoras.gift4you.repository.AccountRepository;
import com.mentes_innovadoras.gift4you.repository.RoleRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public AccountResponse createAccount(@Valid AccountRequest accountRequest) throws ArchitectureException{
        Account account = accountRepository.findByPhoneNumber(accountRequest.getPhoneNumber()).orElse(null);
        if (account != null) throw new PhoneNumberAlreadyExistException();
        Role role = roleRepository.findByName(accountRequest.getRole());
        if (role == null) throw new RoleNotFoundException();
        Account newAccount = accountMapper.toAccountEntity(accountRequest);
        newAccount.setId(UUID.randomUUID());
        newAccount.setCreateAt(new Date());
        newAccount.setUpdateAt(new Date());
        newAccount.setPassword(passwordEncoder.encode(newAccount.getPassword()));
        newAccount.setRole(role);
        newAccount.setStatus(AccountStatus.active.toString());
        return accountMapper.toAccountResponse(accountRepository.save(newAccount));
    }

    @Transactional
    @Override
    public AccountResponse updateAccount(UUID id, AccountRequest accountRequest) throws ArchitectureException {
        return null;
    }


    @Override
    public PagedModel<AccountResponse> getAccounts(Pageable pageable) {
        return new PagedModel<>(accountRepository.findAll(pageable).map(accountMapper::toAccountResponse));
    }

    @Override
    public AccountResponse getAccountById(UUID id) throws ArchitectureException {
        if (id == null) throw new InvalidParamException();
        AccountResponse accountResponse = accountRepository.findById(id).map(accountMapper::toAccountResponse).orElse(null);
        if (accountResponse == null) throw new UserNotFoundException();
        return accountResponse;
    }

    @Override
    public AccountResponse findByUserName(String username) {
        return accountRepository.findByUserName(username).map(accountMapper::toAccountResponse).orElse(null);
    }

    @Override
    public AccountResponse findByPhoneNumber(String phoneNumber) {
        return accountRepository.findByPhoneNumber(phoneNumber).map(accountMapper::toAccountResponse).orElse(null);
    }

}
