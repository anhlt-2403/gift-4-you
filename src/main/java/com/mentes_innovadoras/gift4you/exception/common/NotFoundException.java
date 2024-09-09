package com.mentes_innovadoras.gift4you.exception.common;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends ArchitectureException {
    public NotFoundException(String msg) {
        super();
        this.code = ResponseConstant.Code.notFound;
        this.msg = msg;
        this.status = HttpStatus.NOT_FOUND;
    }
}
