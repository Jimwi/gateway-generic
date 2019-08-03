package com.example.gateway.service.crypto.impl;


import com.example.gateway.service.bizcode.BizKey;
import com.example.gateway.service.crypto.SignHandler;
import org.springframework.stereotype.Component;

/**
 * Created by JiWen on 2019/7/25 at home.
 */
@Component("noneSignHandler")
public class NoneSignHandler implements SignHandler {
    @Override
    public String sign(String data, BizKey bizKey) {
        return "";
    }

    @Override
    public boolean verify(String data, String sign, BizKey bizKey) {
        return true;
    }
}
