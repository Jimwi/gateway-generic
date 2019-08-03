package com.example.gateway.service.method.impl;


import com.alibaba.fastjson.JSONObject;
import com.example.gateway.service.method.Facade;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * Created by JiWen on 2019/7/23 at home.
 */

@Slf4j
public class DubboFacade implements Facade {

    private GenericService genericService;

    public DubboFacade(GenericService genericService) {
        this.genericService = genericService;
    }

    @Override
    public Object invoke(String method, String parameterType, String jsonArg) {
        JSONObject arg = JSONObject.parseObject(jsonArg);
        return genericService.$invoke(method, new String[]{parameterType}, new Object[]{arg});
    }

    @Override
    public String getRpcType() {
        return "dubbo";
    }

}
