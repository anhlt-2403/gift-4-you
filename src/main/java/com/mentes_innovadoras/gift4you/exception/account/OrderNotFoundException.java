package com.mentes_innovadoras.gift4you.exception.account;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import org.springframework.http.HttpStatus;

public class OrderNotFoundException extends ArchitectureException {
    public OrderNotFoundException() {
        super();
        this.code = ResponseConstant.Code.notFound;
        this.msg = ResponseConstant.Message.orderNotFound;
        this.status = HttpStatus.NOT_FOUND;
    }
}
