package com.example.gateway.service.method.impl;


import com.example.gateway.service.method.Facade;

/**
 * Created by JiWen on 2019/7/23 at home.
 */
public class HessianFacade implements Facade {

    @Override
    public Object invoke(String method, String parameterType, String jsonArg) {
        throw new RuntimeException("还未实现,hessian的好难写，干脆以后都用dubbo的吧");
    }

    @Override
    public String getRpcType() {
        return "hessian";
    }
}
