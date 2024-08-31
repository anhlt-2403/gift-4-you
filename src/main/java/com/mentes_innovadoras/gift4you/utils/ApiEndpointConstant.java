package com.mentes_innovadoras.gift4you.utils;

public class ApiEndpointConstant {
        public static final String ApiVersion = "/v1";
    public static final String ApiEndpoint = "/api" + ApiVersion;

    public static final class Authentication {
        public static final String AuthenticationEndpoint = ApiEndpoint + "/auth";
        public static final String Login = AuthenticationEndpoint + "/login";
    }
    public static final class Account {
        public static final String AccountsEndpoint = ApiEndpoint + "/accounts";
        public static final String AccountEndpoint = AccountsEndpoint + "/{id}";
    }
    public static final class InventoryItem {
        public static final String InventoryItemsEndpoint = ApiEndpoint + "/inventoryItems";
        public static final String InventoryItemEndpoint = InventoryItemsEndpoint + "/{id}";
    }

}
