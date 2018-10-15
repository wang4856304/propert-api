package com.happy.enums;

public enum ErrorEnum {
    PARAM_VALID_ERROR("2001", "参数校验错误"),
    TOKEN_EMPTY_ERROR("1002", "token为空"),
    TOKEN_INVALID_ERROR("1003", "token无效"),
    TOKEN_NOT_FOUND_ERROR("1004", "不存在token");



    private ErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
