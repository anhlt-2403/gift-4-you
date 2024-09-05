package com.mentes_innovadoras.gift4you.exception.account;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import org.springframework.http.HttpStatus;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;

public class ProviderNotFoundException extends ArchitectureException {
    public ProviderNotFoundException() {
        super();
        this.code = ResponseConstant.Code.notFound;
        this.msg = ResponseConstant.Message.userNotFound;
        this.status = HttpStatus.NOT_FOUND;
    }
}
