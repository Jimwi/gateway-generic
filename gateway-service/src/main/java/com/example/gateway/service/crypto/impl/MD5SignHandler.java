package com.example.gateway.service.crypto.impl;


import com.example.gateway.common.util.crypto.MD5Util;
import com.example.gateway.service.bizcode.BizKey;
import com.example.gateway.service.crypto.SignHandler;
import org.springframework.stereotype.Component;

/**
 * Created by JiWen on 2019/7/25 at home.
 */
@Component("md5SignHandler")
public class MD5SignHandler implements SignHandler {

    @Override
    public String sign(String data, BizKey bizKey) {
        return MD5Util.sign(data, bizKey.getSignKey());
    }

    @Override
    public boolean verify(String data, String sign, BizKey bizKey) {
        return MD5Util.verify(data, sign, bizKey.getSignKey());
    }
}
