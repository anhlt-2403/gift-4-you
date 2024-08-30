package com.mentes_innovadoras.gift4you.exception.core.Response;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;

public class SimpleErrorResponse extends Response{
    public SimpleErrorResponse(ArchitectureException exception) {
        this.result = false;
        this.status = exception.getStatus().value();
        this.code = exception.getCode();
        this.msg = exception.getMsg();
    }
}
