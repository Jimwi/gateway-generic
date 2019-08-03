package com.example.gateway.service.crypto;


import com.example.gateway.common.enums.ExceptionEnum;
import com.example.gateway.common.exception.SystemException;
import com.example.gateway.service.bizcode.BizKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by JiWen on 2019/7/25 at home.
 */
@Component
@Slf4j
public class CryptSignMap {
    @Resource
    private Map<String, CryptHandler> cryptHandlerMap;
    @Resource
    private Map<String, SignHandler> signHandlerMap;

    public String encrypt(String data, BizKey bizKey) {
        String encryptType = bizKey.getEncryptType().toLowerCase() + "CryptHandler";
        try {
            return cryptHandlerMap.get(encryptType).encrypt(data, bizKey);
        } catch (Exception e) {
            log.error("", e);
            throw new SystemException(ExceptionEnum.GV0007);
        }
    }

    public String decrypt(String data, BizKey bizKey) {
        String encryptType = bizKey.getEncryptType().toLowerCase() + "CryptHandler";
        try {
            return cryptHandlerMap.get(encryptType).decrypt(data, bizKey);
        } catch (Exception e) {
            log.error("", e);
            throw new SystemException(ExceptionEnum.GV0008);
        }
    }

    public String sign(String data, BizKey bizKey) {
        String signType = bizKey.getSignType().toLowerCase() + "SignHandler";
        try {
            return signHandlerMap.get(signType).sign(data, bizKey);
        } catch (Exception e) {
            log.error("", e);
            throw new SystemException(ExceptionEnum.GV0005);
        }
    }

    public boolean verify(String data, String sign, BizKey bizKey) {
        String signType = bizKey.getSignType().toLowerCase() + "SignHandler";
        try {
            return signHandlerMap.get(signType).verify(data, sign, bizKey);
        } catch (Exception e) {
            log.error("", e);
            throw new SystemException(ExceptionEnum.GV0006);
        }
    }
}
