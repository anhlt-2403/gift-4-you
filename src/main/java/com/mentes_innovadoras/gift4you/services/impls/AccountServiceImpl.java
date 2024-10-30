package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.entity.Account;
import com.mentes_innovadoras.gift4you.entity.Role;
import com.mentes_innovadoras.gift4you.enums.AccountStatus;
import com.mentes_innovadoras.gift4you.enums.RoleEnum;
import com.mentes_innovadoras.gift4you.exception.common.AlreadyExistException;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.common.NotFoundException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.mapper.AccountMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.account.AccountResponse;
import com.mentes_innovadoras.gift4you.payload.request.account.CreateAccountRequest;
import com.mentes_innovadoras.gift4you.payload.request.account.UpdateAccountRequest;
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

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
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
    public AccountResponse createAccount(@Valid CreateAccountRequest accountRequest) throws ArchitectureException{
        if (accountRepository.existsByPhoneNumber(accountRequest.getPhoneNumber())) throw new AlreadyExistException(ResponseConstant.Message.phoneNumberAlreadyExist);
        if (accountRepository.existsByEmail(accountRequest.getEmail())) throw new AlreadyExistException(ResponseConstant.Message.emailAlreadyExist);
        Role role = roleRepository.findByName(accountRequest.getRole());
        if (role == null || accountRequest.getRole().equalsIgnoreCase(RoleEnum.admin.name())) {
            role = roleRepository.findByName(RoleEnum.customer.name());
        }
        Account newAccount = accountMapper.toAccountEntity(accountRequest);
        newAccount.setId(UUID.randomUUID());
        newAccount.setCreateAt(OffsetDateTime.now(ZoneOffset.UTC).minusHours(6));
        newAccount.setUpdateAt(OffsetDateTime.now(ZoneOffset.UTC).minusHours(6));
        newAccount.setPassword(passwordEncoder.encode(newAccount.getPassword()));
        newAccount.setRole(role);
        newAccount.setStatus(AccountStatus.active.name());
        return accountMapper.toAccountResponse(accountRepository.save(newAccount));
    }

    @Transactional
    @Override
    public AccountResponse updateAccount(UUID id, @Valid UpdateAccountRequest accountRequest) throws ArchitectureException {
        Account account = accountRepository.findById(id).orElseThrow(() ->new NotFoundException(ResponseConstant.Message.userNotFound));
        account.setFullName(accountRequest.getFullName() == null ? account.getFullName() : accountRequest.getFullName());
        account.setEmail(accountRequest.getEmail() == null ? account.getEmail() : accountRequest.getEmail());
        account.setGender(accountRequest.getGender() == null ? account.getGender() : accountRequest.getGender());
        account.setUpdateAt(OffsetDateTime.ofInstant(new Date().toInstant(), ZoneOffset.UTC).minusHours(6));
        return accountMapper.toAccountResponse(accountRepository.save(account));
    }


    @Override
    public PagedModel<AccountResponse> getAccounts(Pageable pageable) {
        return new PagedModel<>(accountRepository.findAll(pageable).map(accountMapper::toAccountResponse));
    }

    @Override
    public AccountResponse getAccountById(UUID id) throws ArchitectureException {
        if (id == null) throw new InvalidParamException();
        return accountRepository.findById(id).map(accountMapper::toAccountResponse)
                .orElseThrow(() -> new NotFoundException(ResponseConstant.Message.userNotFound));
    }

}
