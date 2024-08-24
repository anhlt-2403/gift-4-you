package com.mentes_innovadoras.gift4you.facade;

import com.mentes_innovadoras.gift4you.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {
        private final UserService userService;
}
