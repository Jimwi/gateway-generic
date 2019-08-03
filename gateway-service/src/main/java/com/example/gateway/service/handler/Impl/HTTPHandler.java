package com.example.gateway.service.handler.Impl;


import com.alibaba.fastjson.JSONObject;
import com.example.gateway.common.enums.ExceptionEnum;
import com.example.gateway.common.exception.SystemException;
import com.example.gateway.service.bizcode.BizInfo;
import com.example.gateway.service.bizcode.BizKey;
import com.example.gateway.service.bizcode.BizMap;
import com.example.gateway.service.dto.HTTPReqDto;
import com.example.gateway.service.dto.HTTPRespDto;
import com.example.gateway.service.crypto.CryptSignMap;
import com.example.gateway.service.handler.ServiceHandler;
import com.example.gateway.service.method.FacadeMethod;
import com.example.gateway.service.method.MethodMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by JiWen on 2019/7/21 at home.
 */
@Component("httpHandler")
@Slf4j
public class HTTPHandler extends ServiceHandler<HTTPReqDto, HTTPRespDto> {

    @Resource
    private MethodMap methodMap;
    @Resource
    private BizMap bizMap;
    @Resource
    CryptSignMap cryptSignMap;

    @Override
    public void beforeHandler(HTTPReqDto reqVo, HandlerContext context) {
        //验签 解密
        BizInfo bizInfo = bizMap.getBizInfo(reqVo.getBizCode());
        if (bizInfo == null) {
            throw new SystemException(ExceptionEnum.GV0002);
        }
        context.put("bizInfo", bizInfo);
        boolean binding = bizMap.isBinding(reqVo.getBizCode(), reqVo.getMethodCode());
        if (!binding) {
            throw new SystemException(ExceptionEnum.GV0003);
        }

        BizKey bizKey = bizMap.getBizKey(bizInfo.getBizCode(), reqVo.getKeyGroup());
        if (bizKey == null) {
            throw new SystemException(ExceptionEnum.GV0004);
        }
        context.put("bizKey", bizKey);
        boolean verify = cryptSignMap.verify(reqVo.getData(), reqVo.getSign(), bizKey);
        if (!verify) {
            throw new SystemException(ExceptionEnum.GV0006);
        }
        String decryptData = cryptSignMap.decrypt(reqVo.getData(), bizKey);
        log.info("收到请求明文: {}", decryptData);
        reqVo.setData(decryptData);

    }

    @Override
    public HTTPRespDto doHandler(HTTPReqDto reqVo, HandlerContext context) {
        try {
            FacadeMethod method = methodMap.getMethod(reqVo.getMethodCode());
            Object result = method.invoke(reqVo.getData());
            String data = JSONObject.toJSONString(result);
            log.info("返回明文: {}", data);
            HTTPRespDto respVo = HTTPRespDto.success();
            respVo.setData(data);
            return respVo;
        } catch (Exception e) {
            log.error("接口调用失败 bizCode: {},methodCode: {}", reqVo.getBizCode(), reqVo.getMethodCode(), e);
            throw new SystemException(ExceptionEnum.GV0009);
        }
    }

    @Override
    public void afterHandler(HTTPRespDto respVo, HTTPReqDto reqVo, HandlerContext context) {
        //加密 加签
        BizKey bizKey = (BizKey) context.get("bizKey");
        String encryptData = cryptSignMap.encrypt(respVo.getData(), bizKey);
        respVo.setData(encryptData);
        String sign = cryptSignMap.sign(encryptData, bizKey);
        respVo.setSign(sign);
    }
}
