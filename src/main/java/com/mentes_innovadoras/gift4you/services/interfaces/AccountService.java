package com.mentes_innovadoras.gift4you.services.interfaces;

import com.mentes_innovadoras.gift4you.entity.Account;
import com.mentes_innovadoras.gift4you.payload.reponse.AccountResponse;
import com.mentes_innovadoras.gift4you.services.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService extends BaseService<Account> {
    Page<AccountResponse> findAll(Pageable pageable);
    Page<AccountResponse> findByFullName(String fullName, Pageable pageable);
}
