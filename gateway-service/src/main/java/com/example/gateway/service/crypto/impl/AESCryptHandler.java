package com.example.gateway.service.crypto.impl;


import com.example.gateway.common.util.crypto.AESUtil;
import com.example.gateway.service.bizcode.BizKey;
import com.example.gateway.service.crypto.CryptHandler;
import org.springframework.stereotype.Component;

/**
 * Created by JiWen on 2019/7/25 at home.
 */
@Component("aesCryptHandler")
public class AESCryptHandler implements CryptHandler {

    @Override
    public String encrypt(String data, BizKey bizKey) throws Exception {
        return AESUtil.encrypt(data, bizKey.getEncryptKey());
    }

    @Override
    public String decrypt(String data, BizKey bizKey) throws Exception {
        return AESUtil.decrypt(data, bizKey.getEncryptKey());
    }
}
