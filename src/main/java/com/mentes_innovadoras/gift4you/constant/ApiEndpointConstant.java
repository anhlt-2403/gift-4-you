package com.mentes_innovadoras.gift4you.constant;

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
    public static final class Order {
        public static final String OrdersEndpoint = ApiEndpoint + "/orders";
        public static final String OrderEndpoint = OrdersEndpoint + "/{id}";
    }
    public static final class OrderDetail {
        public static final String OrderDetailsEndpoint = ApiEndpoint + "/orderDetails";
        public static final String OrderDetailEndpoint = OrderDetailsEndpoint + "/{id}";
    }
    public static final class OrderDetailItem {
        public static final String OrderDetailItemsEndpoint = ApiEndpoint + "/orderDetailItems";
        public static final String OrderDetailItemEndpoint = OrderDetailItemsEndpoint + "/{id}";
    }
    public static final class OrderHistory {
        public static final String OrderHistoriesEndpoint = ApiEndpoint + "/orderHistories";
        public static final String OrderHistoryEndpoint = OrderHistoriesEndpoint + "/{id}";
    }
    public static final class Provider {
        public static final String ProvidersEndpoint = ApiEndpoint + "/providers";
        public static final String ProviderEndpoint = ProvidersEndpoint + "/{id}";
    }
}
