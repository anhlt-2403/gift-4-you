package com.mentes_innovadoras.gift4you.services.authentication;

import com.mentes_innovadoras.gift4you.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {
    private final Account account;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Account account) {
        this.account = account;
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + account.getRole().getName().toUpperCase()));
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return "active".equalsIgnoreCase(account.getStatus());
    }
}
