package com.example.gateway.admin.controller.vo;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by JiWen on 2019/7/28 at home.
 */
@Getter
@Setter
public class BizBindingVo extends BaseReqVo {
    private String bizCode;
    private String methodCode;
    private String bindingStatus;
}
