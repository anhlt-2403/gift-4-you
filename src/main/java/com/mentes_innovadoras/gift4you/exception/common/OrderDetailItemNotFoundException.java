package com.mentes_innovadoras.gift4you.exception.common;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import org.springframework.http.HttpStatus;

public class OrderDetailItemNotFoundException extends ArchitectureException {
    public OrderDetailItemNotFoundException() {
        super();
        this.code = ResponseConstant.Code.notFound;
        this.msg = ResponseConstant.Message.userNotFound;
        this.status = HttpStatus.NOT_FOUND;
    }
}
