package com.mentes_innovadoras.gift4you.exception.common;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import org.springframework.http.HttpStatus;

public class InvalidParamException extends ArchitectureException {
    public InvalidParamException() {
        super();
        this.code = ResponseConstant.Code.invalidParam;
        this.msg = ResponseConstant.Message.invalidParam;
        this.status = HttpStatus.BAD_REQUEST;
    }
}
