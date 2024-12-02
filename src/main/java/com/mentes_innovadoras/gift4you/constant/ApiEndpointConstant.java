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
        public static final String OrdersOfAccountEndpoint = AccountEndpoint + "/orders";
    }
    public static final class Order {
        public static final String OrdersEndpoint = ApiEndpoint + "/orders";
        public static final String OrderEndpoint = OrdersEndpoint + "/{id}";
    }

    public static final class Template {
        public static final String TemplatesEndpoint = ApiEndpoint + "/template";
        public static final String TemplateEndpoint = TemplatesEndpoint + "/{id}";
    }

    public static final class Provider {
        public static final String ProvidersEndpoint = ApiEndpoint + "/providers";
        public static final String ProviderEndpoint = ProvidersEndpoint + "/{id}";
    }

    public static final class InventoryItem {
        public static final String InventoryItemsEndpoint = ApiEndpoint + "/inventory-items";
        public static final String InventoryItemEndpoint = InventoryItemsEndpoint + "/{id}";
    }
}
