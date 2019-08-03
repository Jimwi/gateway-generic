package com.example.gateway.service.method;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by JiWen on 2019/7/19 at home.
 */
@Getter
@Setter
public class FacadeMethod {

    private String methodCode;
    private String methodName;
    private String facadeName;
    private String shortMethodName;
    private String paramType;
    private String returnType;
    private String rpcType;
    private Facade facade;

    public Object invoke(String param) {
        return facade.invoke(shortMethodName, paramType, param);
    }
}
