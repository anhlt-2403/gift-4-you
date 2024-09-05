package com.mentes_innovadoras.gift4you.exception.account;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import org.springframework.http.HttpStatus;

public class OrderHistoryNotFoundException extends ArchitectureException {
    public OrderHistoryNotFoundException() {
        super();
        this.code = ResponseConstant.Code.notFound;
        this.msg = ResponseConstant.Message.userNotFound;
        this.status = HttpStatus.NOT_FOUND;
    }
}
