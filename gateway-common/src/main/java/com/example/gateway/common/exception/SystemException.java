package com.example.gateway.common.exception;


import com.example.gateway.common.enums.ExceptionEnum;

/**
 * Created by JiWen on 2019/7/21 at home.
 */

public class SystemException extends RuntimeException{
    private ExceptionEnum exceptionEnum;
    private String desc;

    public SystemException(ExceptionEnum exceptionEnum, String desc) {
        this.exceptionEnum = exceptionEnum;
        this.desc = desc;
    }

    public SystemException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public String getCode(){
        return exceptionEnum.name();
    }

    public String getDesc() {
        if (exceptionEnum.getDesc() != null){
            return exceptionEnum.getDesc();
        }
        return desc;
    }
}
