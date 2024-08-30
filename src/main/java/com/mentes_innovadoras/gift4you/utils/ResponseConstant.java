package com.mentes_innovadoras.gift4you.utils;

public class ResponseConstant {
    public static class Code{
        public static final String invalidParam = "0";
        public static final String invalidArgument = "10";
        public static final String AlreadyExist= "11";
        public static final String NotFound= "99";
        public static final String constraintViolation= "-1";
    }

    public static class Message{
        public static final String invalidParam = "Invalid Parameter";
        public static final String phoneNumberAlreadyExist = "Phone Number Already Exist";
        public static final String userNotFound= "User Not Found";
        public static final String roleNotFound = "Role Not Found";
        public static final String invalidArgument = "-Invalid Argument";

    }
}
