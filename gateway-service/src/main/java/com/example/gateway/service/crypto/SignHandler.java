package com.example.gateway.service.crypto;


import com.example.gateway.service.bizcode.BizKey;

/**
 * Created by JiWen on 2019/7/25 at home.
 */
public interface SignHandler {

    String sign(String data, BizKey bizKey) throws Exception;

    boolean verify(String data, String sign, BizKey bizKey) throws Exception;
}
