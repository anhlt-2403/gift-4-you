package com.mentes_innovadoras.gift4you.constant;

public class ApiEndpointConstant {
    private static final String ApiVersion = "/v1";
    private static final String ApiEndpoint = "/api" + ApiVersion;

    public static final class Authentication {
        public static final String AuthenticationEndpoint = ApiEndpoint + "/auth";
        public static final String Login = AuthenticationEndpoint + "/login";
    }
    public static final class Account {
        public static final String AccountsEndpoint = ApiEndpoint + "/accounts";
        public static final String AccountEndpoint = AccountsEndpoint + "/{id}";
    }


}
