package com.example.gateway.common.enums;


/**
 * Created by JiWen on 2019/7/21 at home.
 */
public enum  ExceptionEnum {

    GS0000("成功"),

    GV0001("参数校验未通过"),
    GV0002("合作方不存在"),
    GV0003("合作方秘钥异常"),
    GV0004("接口未注册"),
    GV0005("加签失败"),
    GV0006("验签失败"),
    GV0007("加密失败"),
    GV0008("解密失败"),
    GV0009("接口调用失败"),

    GE00001("系统开小差了"),
    ;

    ExceptionEnum(String desc) {
        this.desc = desc;
    }
    private String desc;
    public String getDesc() {
        return desc;
    }
}
