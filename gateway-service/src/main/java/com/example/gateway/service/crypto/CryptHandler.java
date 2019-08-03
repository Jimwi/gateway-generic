package com.example.gateway.service.crypto;


import com.example.gateway.service.bizcode.BizKey;

/**
 * Created by JiWen on 2019/7/25 at home.
 */
public interface CryptHandler {
    String encrypt(String data, BizKey bizKey) throws Exception;

    String decrypt(String data, BizKey bizKey) throws Exception;
}
