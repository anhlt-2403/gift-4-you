package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.entity.Account;
import com.mentes_innovadoras.gift4you.mapper.AccountMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.AccountResponse;
import com.mentes_innovadoras.gift4you.repository.UserRepository;
import com.mentes_innovadoras.gift4you.repository.generic.GenericRepository;
import com.mentes_innovadoras.gift4you.services.base.BaseServiceImpl;
import com.mentes_innovadoras.gift4you.services.interfaces.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {
    private final AccountMapper userMapper;
    private final UserRepository userRepository;
    public AccountServiceImpl(GenericRepository<Account> genericRepository, UserRepository userRepository, AccountMapper userMapper) {
        super(genericRepository);
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Page<Account> findByFullName(String fullName, Pageable pageable) {
        return userRepository.findByFullNameContaining(fullName, pageable);
    }
}
