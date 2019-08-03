package com.example.gateway.admin.controller.vo;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by JiWen on 2019/7/28 at home.
 */
@Getter
@Setter
public class BizInfoVo extends BaseReqVo {
    private String bizCode;
    private String bizName;
    private String bizStatus;
    private String remark;
}
