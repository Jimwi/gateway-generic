package com.example.gateway.service.validate;


import com.example.gateway.service.dto.BaseReqDto;

/**
 * Created by JiWen on 2019/7/21 at home.
 */
public interface Validate<REQ extends BaseReqDto> {
    void validate(REQ req);
}
