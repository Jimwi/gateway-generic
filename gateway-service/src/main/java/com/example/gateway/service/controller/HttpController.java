package com.example.gateway.service.controller;


import com.example.gateway.service.validate.impl.HTTPValidate;
import com.example.gateway.service.dto.HTTPReqDto;
import com.example.gateway.service.dto.HTTPRespDto;
import com.example.gateway.service.handler.Impl.HTTPHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by JiWen on 2019/6/30 at home.
 */
@Controller
@Slf4j
public class HttpController {

    @Resource
    private HTTPHandler httpHandler;
    @Resource
    private HTTPValidate httpValidate;

    @RequestMapping(value = "gateway", method = RequestMethod.POST)
    @ResponseBody
    public HTTPRespDto gateway(@RequestBody HTTPReqDto reqDto) {
        Long startTime = System.currentTimeMillis();
        log.info("收到请求: {}", reqDto);
        httpValidate.validate(reqDto);
        HTTPRespDto respDto = httpHandler.handle(reqDto);
        Long endTime = System.currentTimeMillis();
        log.info("返回: {}, 耗时: {} ms", respDto, endTime - startTime);
        return respDto;
    }
}
