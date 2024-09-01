package com.mentes_innovadoras.gift4you.exception.role;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import org.springframework.http.HttpStatus;

public class RoleNotFoundException extends ArchitectureException {
    public RoleNotFoundException() {
        super();
        this.code = ResponseConstant.Code.notFound;
        this.msg = ResponseConstant.Message.roleNotFound;
        this.status = HttpStatus.NOT_FOUND;
    }
}
