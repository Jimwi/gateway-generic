package com.example.gateway.admin.controller.vo;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by JiWen on 2019/7/28 at home.
 */
@Getter
@Setter
public class BaseReqVo implements Serializable {
    private Long id;
    private Date createTimeStart;
    private Date createTimeEnd;
    private Long pageSize = 20L;
    private Long pageIndex = 0L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
