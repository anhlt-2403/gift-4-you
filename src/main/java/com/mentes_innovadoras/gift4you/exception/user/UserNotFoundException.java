package com.mentes_innovadoras.gift4you.exception.user;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.utils.ResponseConstant;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ArchitectureException {
    public UserNotFoundException() {
        super();
        this.code = ResponseConstant.Code.userNotFound;
        this.msg = ResponseConstant.Message.userNotFound;
        this.status = HttpStatus.NOT_FOUND;
    }
}
