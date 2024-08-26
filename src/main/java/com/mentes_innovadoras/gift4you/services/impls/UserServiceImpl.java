package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.entity.User;
import com.mentes_innovadoras.gift4you.mapper.UserMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.UserResponse;
import com.mentes_innovadoras.gift4you.repository.UserRepository;
import com.mentes_innovadoras.gift4you.repository.generic.GenericRepository;
import com.mentes_innovadoras.gift4you.services.base.BaseServiceImpl;
import com.mentes_innovadoras.gift4you.services.interfaces.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    public UserServiceImpl(GenericRepository<User> genericRepository,UserRepository userRepository, UserMapper userMapper) {
        super(genericRepository);
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Page<UserResponse> findAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(userMapper::toUserResponse);
    }

    @Override
    public Page<UserResponse> findByFullName(String fullName, Pageable pageable) {
        Page<User> users = userRepository.findByFullNameContaining(fullName, pageable);
        return users.map(userMapper::toUserResponse);
    }
}
