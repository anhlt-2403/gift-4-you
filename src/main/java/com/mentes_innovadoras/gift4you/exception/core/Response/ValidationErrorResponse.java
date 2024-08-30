package com.mentes_innovadoras.gift4you.exception.core.Response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;
@Getter
@Setter
public class ValidationErrorResponse extends Response {
  private final Map<String, String> fieldErrors;
    public ValidationErrorResponse(String code, String msg, Map<String, String> fieldErrors) {
      this.result = false;
      this.status = HttpStatus.BAD_REQUEST.value();
      this.code = code;
      this.msg = msg;
      this.fieldErrors = fieldErrors;
    }
  }
