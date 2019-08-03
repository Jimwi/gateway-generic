package com.example.gateway.common.enums;


/**
 * Created by JiWen on 2019/7/2 at home.
 */
public enum SignType {
    MD5("MD5", "MD5加签"),
    RSA("RSA", "RSA加签")
    ;

    SignType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    private String type;
    private String description;

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
