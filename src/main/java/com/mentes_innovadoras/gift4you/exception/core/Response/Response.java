package com.mentes_innovadoras.gift4you.exception.core.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response {
    protected boolean result;
    protected int status;
    protected String code;
    protected String msg;
}
