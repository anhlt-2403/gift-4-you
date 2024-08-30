package com.mentes_innovadoras.gift4you.exception.user;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.utils.ResponseConstant;
import org.springframework.http.HttpStatus;

public class PhoneNumberAlreadyExistException extends ArchitectureException {
    public PhoneNumberAlreadyExistException() {
        super();
        this.code = ResponseConstant.Code.AlreadyExist;
        this.msg = ResponseConstant.Message.phoneNumberAlreadyExist;
        this.status = HttpStatus.BAD_REQUEST;
    }
}
