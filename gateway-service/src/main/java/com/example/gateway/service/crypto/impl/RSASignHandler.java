package com.example.gateway.service.crypto.impl;


import com.example.gateway.common.util.crypto.RSAUtil;
import com.example.gateway.service.bizcode.BizKey;
import com.example.gateway.service.crypto.SignHandler;
import org.springframework.stereotype.Component;

/**
 * Created by JiWen on 2019/7/25 at home.
 * 需要两对密钥
 */
@Component("rsaSignHandler")
public class RSASignHandler implements SignHandler {

    @Override
    public String sign(String data, BizKey bizKey) {
        return RSAUtil.sign(data, bizKey.getEncryptKey());
    }

    @Override
    public boolean verify(String data, String sign, BizKey bizKey) {
        return RSAUtil.verify(data, sign, bizKey.getDecryptKey());
    }
}
