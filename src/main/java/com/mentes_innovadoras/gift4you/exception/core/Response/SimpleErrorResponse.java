package com.mentes_innovadoras.gift4you.exception.core.Response;
import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.exception.core.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;

public class SimpleErrorResponse extends Response{
    public SimpleErrorResponse(ArchitectureException exception) {
        this.result = false;
        this.status = exception.getStatus().value();
        this.code = exception.getCode();
        this.msg = exception.getMsg();
    }

    public SimpleErrorResponse(JwtException exception) {
        this.result = false;
        this.status = exception.getStatus().value();
        this.code = exception.getCode();
        this.msg = exception.getMsg();
    }

    public SimpleErrorResponse(AccessDeniedException exception) {
        this.result = false;
        this.status = HttpStatus.FORBIDDEN.value();
        this.code = ResponseConstant.Code.accessDenied;
        this.msg = ResponseConstant.Message.accessDenied;
    }
    public SimpleErrorResponse(BadCredentialsException exception) {
        this.result = false;
        this.status = HttpStatus.UNAUTHORIZED.value();
        this.code = ResponseConstant.Code.badCredentials;
        this.msg = ResponseConstant.Message.invalidPassword;
    }
}
