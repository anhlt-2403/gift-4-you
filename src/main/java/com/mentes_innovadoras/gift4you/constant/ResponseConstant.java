package com.mentes_innovadoras.gift4you.constant;

public class ResponseConstant {
    public static class Code{
        public static final String invalidParam = "0";
        public static final String invalidArgument = "10";
        public static final String alreadyExist= "11";
        public static final String notFound= "99";
        public static final String constraintViolation= "-1";
        public static final String jwtException = "401";
        public static final String accessDenied = "403";
    }

    public static class Message{
        public static final String invalidParam = "Invalid Parameter";
        public static final String phoneNumberAlreadyExist = "Phone Number Already Exist";
        public static final String userNotFound= "User Not Found";
        public static final String roleNotFound = "Role Not Found";
        public static final String invalidArgument = "-Invalid Argument";
        public static final String invalidToken = "Invalid Token";
        public static final String expiredToken = "Expired Token";
        public static final String accessDenied = "Access Denied: You don't have permission to access this resource";
    }
}
