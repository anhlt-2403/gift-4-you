package com.mentes_innovadoras.gift4you.services.authentication;

import com.mentes_innovadoras.gift4you.entity.Account;
import com.mentes_innovadoras.gift4you.repository.AccountRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AccountRepository accountRepository;

    public UserDetailsServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetailsImpl loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        Account account = accountRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with phone number: " + phoneNumber));
        return new UserDetailsImpl(account);
    }

}
