package com.example.gateway.common.enums;


/**
 * Created by JiWen on 2019/7/2 at home.
 */
public enum EncryptType {

    AES("AES", "AES加密"),
    RSA("RSA", "加密"),
    ;

    EncryptType(String type, String description) {
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
