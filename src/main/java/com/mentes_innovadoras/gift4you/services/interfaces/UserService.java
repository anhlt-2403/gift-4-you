package com.mentes_innovadoras.gift4you.services.interfaces;

import com.mentes_innovadoras.gift4you.entity.User;
import com.mentes_innovadoras.gift4you.payload.reponse.UserResponse;
import com.mentes_innovadoras.gift4you.services.base.BaseService;
import com.mentes_innovadoras.gift4you.services.base.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends BaseService<User> {
    Page<UserResponse> findAll(Pageable pageable);
    Page<UserResponse> findByFullName(String fullName, Pageable pageable);
}
