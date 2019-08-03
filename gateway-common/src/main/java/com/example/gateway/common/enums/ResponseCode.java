package com.example.gateway.common.enums;


/**
 * Created by JiWen on 2019/6/30 at home.
 */
//TODO 返回码统一下，做一个调研。
public enum ResponseCode {

    SUCCESS("SUCCESS", "成功"),
    FAIL("FAIL", "失败"),
    UNKNOWN("UNKNOWN", "系统开小差了"),
    ;

    ResponseCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
