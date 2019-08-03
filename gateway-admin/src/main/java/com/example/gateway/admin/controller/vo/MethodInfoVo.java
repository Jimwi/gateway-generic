package com.example.gateway.admin.controller.vo;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by JiWen on 2019/7/28 at home.
 */
@Getter
@Setter
public class MethodInfoVo extends BaseReqVo {
    private String methodCode;
    private String methodName;
    private String rpcType;
    private String paramType;
    private String returnType;
    private String methodGroup;
    private String methodVersion;
    private String methodStatus;
    private String remark;
}
