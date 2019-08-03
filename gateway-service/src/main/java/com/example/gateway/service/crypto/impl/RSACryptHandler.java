package com.example.gateway.service.crypto.impl;


import com.example.gateway.common.util.crypto.RSAUtil;
import com.example.gateway.service.bizcode.BizKey;
import com.example.gateway.service.crypto.CryptHandler;
import org.springframework.stereotype.Component;

/**
 * Created by JiWen on 2019/7/25 at home.
 */
@Component("rsaCryptHandler")
public class RSACryptHandler implements CryptHandler {

    @Override
    public String encrypt(String data, BizKey bizKey) {
        return RSAUtil.encrypt(data, bizKey.getEncryptKey());
    }

    @Override
    public String decrypt(String data, BizKey bizKey) {
        return RSAUtil.decrypt(data, bizKey.getDecryptKey());
    }
}
