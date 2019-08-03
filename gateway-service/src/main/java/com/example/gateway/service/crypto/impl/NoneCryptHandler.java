package com.example.gateway.service.crypto.impl;


import com.example.gateway.service.bizcode.BizKey;
import com.example.gateway.service.crypto.CryptHandler;
import org.springframework.stereotype.Component;

/**
 * Created by JiWen on 2019/7/25 at home.
 */
@Component("noneCryptHandler")
public class NoneCryptHandler implements CryptHandler {

    @Override
    public String encrypt(String data, BizKey bizKey) {
        return data;
    }

    @Override
    public String decrypt(String data, BizKey bizKey) {
        return data;
    }
}
