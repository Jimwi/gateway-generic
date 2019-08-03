package com.example.gateway.service.dto;


import com.example.gateway.common.enums.ResponseCode;
import com.example.gateway.common.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by JiWen on 2019/6/30 at home.
 */
@Getter
@Setter
public class HTTPRespDto extends BaseRespDto {
    private String code;
    private String message;
    private String data;
    private String sign;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date responseTime;

    public static HTTPRespDto success(){
        HTTPRespDto responseVo = new HTTPRespDto();
        responseVo.setCode(ResponseCode.SUCCESS.getCode());
        responseVo.setMessage(ResponseCode.SUCCESS.getDesc());
        responseVo.setResponseTime(DateUtil.now());
        return responseVo;
    }

    public static HTTPRespDto unknown(){
        HTTPRespDto responseVo = new HTTPRespDto();
        responseVo.setCode(ResponseCode.UNKNOWN.getCode());
        responseVo.setMessage(ResponseCode.UNKNOWN.getDesc());
        responseVo.setResponseTime(DateUtil.now());
        return responseVo;
    }

}
