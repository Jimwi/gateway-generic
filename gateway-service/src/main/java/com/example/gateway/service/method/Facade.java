package com.example.gateway.service.method;


/**
 * Created by JiWen on 2019/7/23 at home.
 */
public interface Facade {

    String getRpcType();

    Object invoke(String method, String parameterType, String jsonArg);
}
