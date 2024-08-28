package com.mentes_innovadoras.gift4you.exception.user;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;

public class UserNotFoundException extends ArchitectureException {
    public UserNotFoundException() {
        super();
        this.code = USER_NOT_FOUND_CODE;
        this.msg = USER_NOT_FOUND;
        this.status = HttpStatus.NOT_FOUND;
    }
}
