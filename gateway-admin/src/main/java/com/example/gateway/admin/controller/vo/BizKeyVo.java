package com.example.gateway.admin.controller.vo;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by JiWen on 2019/7/28 at home.
 */
@Getter
@Setter
public class BizKeyVo extends BaseReqVo {
    private String bizCode;
    private String keyGroup;
    private String encryptType;
    private String encryptKey;
    private String decryptKey;
    private String signType;
    private String signKey;
    private String keyStatus;
    private String remark;
}
