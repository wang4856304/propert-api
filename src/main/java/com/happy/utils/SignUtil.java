package com.happy.utils;

public class SignUtil {

    public static String getMD5Sign(String value) {
        return MD5Util.getMd5(value);
    }
}
