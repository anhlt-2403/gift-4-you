package com.mentes_innovadoras.gift4you.exception.core;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@Getter
@Setter
public class JwtException extends AuthenticationException {
    protected String code;
    protected String msg;
    protected HttpStatus status;

    public JwtException(String msg) {
        super(msg);
    }
}
