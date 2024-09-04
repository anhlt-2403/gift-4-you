package com.mentes_innovadoras.gift4you.exception.common;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.exception.core.JwtException;
import org.springframework.http.HttpStatus;

public class ExpiredJwtException extends JwtException {
    public ExpiredJwtException(String msg) {
        super(msg);
        this.code = ResponseConstant.Code.jwtException;
        this.msg = ResponseConstant.Message.expiredToken;
        this.status = HttpStatus.UNAUTHORIZED;
    }
}
