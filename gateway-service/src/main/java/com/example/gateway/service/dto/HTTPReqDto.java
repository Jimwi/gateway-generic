package com.example.gateway.service.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by JiWen on 2019/6/30 at home.
 */
@Getter
@Setter
public class HTTPReqDto extends BaseReqDto {
    private String bizCode;
    private String keyGroup;
    private String methodCode;
    private String data;
    private String sign;
    private Date requestTime;
}
