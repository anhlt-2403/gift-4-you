package com.mentes_innovadoras.gift4you.exception.common;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import org.springframework.http.HttpStatus;

public class AlreadyExistException extends ArchitectureException {
    public AlreadyExistException(String msg) {
        super();
        this.code = ResponseConstant.Code.alreadyExist;
        this.msg = msg;
        this.status = HttpStatus.BAD_REQUEST;
    }
}
