package com.example.gateway.service.exception;


import com.example.gateway.common.exception.SystemException;
import com.example.gateway.common.util.DateUtil;
import com.example.gateway.service.dto.HTTPRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JiWen on 2019/7/27 at home.
 */


@RestControllerAdvice
@Slf4j
public class HTTPExceptionResolver {

    @ExceptionHandler
    public HTTPRespDto resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        log.error("请求网关处理发生异常", e);
        HTTPRespDto httpRespDto = new HTTPRespDto();
        if (e instanceof SystemException) {
            SystemException se = (SystemException) e;
            httpRespDto.setCode(se.getCode());
            httpRespDto.setMessage(se.getDesc());
            httpRespDto.setResponseTime(DateUtil.now());
        } else {
            httpRespDto = HTTPRespDto.unknown();
            httpRespDto.setMessage(e.getMessage());
        }
        log.info("返回: {}", httpRespDto);
        return httpRespDto;
    }
}
