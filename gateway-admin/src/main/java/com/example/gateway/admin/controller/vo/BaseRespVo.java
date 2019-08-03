package com.example.gateway.admin.controller.vo;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by JiWen on 2019/7/28 at home.
 */
@Getter
@Setter
public class BaseRespVo implements Serializable {
    private String code;
    private String msg;
    private Object data;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }


    public static BaseRespVo success(){
        BaseRespVo respVo = new BaseRespVo();
        respVo.setCode("success");
        respVo.setMsg("成功");
        return respVo;
    }

    public static BaseRespVo fail(){
        BaseRespVo respVo = new BaseRespVo();
        respVo.setCode("fail");
        respVo.setMsg("失败");
        return respVo;
    }

}
