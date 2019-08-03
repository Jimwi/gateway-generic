package com.example.gateway.service.validate.impl;


import com.example.gateway.common.enums.ExceptionEnum;
import com.example.gateway.common.exception.SystemException;
import com.example.gateway.service.validate.Validate;
import com.example.gateway.service.dto.HTTPReqDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by JiWen on 2019/7/23 at home.
 */
@Component("httpValidate")
public class HTTPValidate implements Validate<HTTPReqDto> {
    @Override
    public void validate(HTTPReqDto reqVo) {
        if (Objects.isNull(reqVo)) {
            throw new SystemException(ExceptionEnum.GV0001, "请求参数不能为空");
        }
        if (StringUtils.isBlank(reqVo.getBizCode())) {
            throw new SystemException(ExceptionEnum.GV0001, "请求参数bizCode不能为空");
        }
        if (StringUtils.isBlank(reqVo.getMethodCode())) {
            throw new SystemException(ExceptionEnum.GV0001, "请求参数methodCode不能为空");
        }
        if (StringUtils.isBlank(reqVo.getData())) {
            throw new SystemException(ExceptionEnum.GV0001, "请求参数data不能为空");
        }
        if (StringUtils.isBlank(reqVo.getData())) {
            throw new SystemException(ExceptionEnum.GV0001, "请求参数data不能为空");
        }
        if (Objects.isNull(reqVo.getRequestTime())) {
            throw new SystemException(ExceptionEnum.GV0001, "请求参数requestTime不能为空");
        }
    }
}
