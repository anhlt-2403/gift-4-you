package com.mentes_innovadoras.gift4you.util;

public class ApiEndpointConstant {
    public static final String ApiVersion = "/v1";
    public static final String ApiEndpoint = "/api" + ApiVersion;

    public static final class Authentication {
        public static final String AuthenticationEndpoint = ApiEndpoint + "/auth";
        public static final String Login = AuthenticationEndpoint + "/login";
    }
    public static final class User {
        public static final String UsersEndpoint = ApiEndpoint + "/users";
        public static final String UserEndpoint = UsersEndpoint + "/{id}";
    }


}
