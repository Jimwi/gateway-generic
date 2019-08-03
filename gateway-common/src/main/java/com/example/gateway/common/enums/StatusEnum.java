package com.example.gateway.common.enums;


/**
 * Created by JiWen on 2019/7/25 at home.
 */
public enum StatusEnum {

    DISABLE("0", "不可用"),
    ENABLE("1", "可用"),
    ;

    private String status;
    private String desc;

    StatusEnum(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
