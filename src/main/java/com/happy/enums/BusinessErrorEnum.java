package com.happy.enums;

/**
 * @author wangjun
 * @Title: BusinessErrorEnum
 * @ProjectName newHappy
 * @Description: TODO
 * @date 2018/10/12 11:13
 */
public enum BusinessErrorEnum {

    NO_COMMUNITY_ERROR("3005", "小区不存在"),
    OWNER_ERROR("3006", "房间与房主不匹配");



    private BusinessErrorEnum(String code, String msg) {
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
