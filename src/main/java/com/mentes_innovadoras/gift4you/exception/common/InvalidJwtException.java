package com.mentes_innovadoras.gift4you.exception.common;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.exception.core.JwtException;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
@Getter
public class InvalidJwtException extends JwtException {

    public InvalidJwtException(String msg) {
        super(msg);
        this.code = ResponseConstant.Code.jwtException;
        this.msg = ResponseConstant.Message.invalidToken;
        this.status = HttpStatus.UNAUTHORIZED;
    }
}
