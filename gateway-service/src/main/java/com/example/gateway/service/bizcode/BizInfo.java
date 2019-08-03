package com.example.gateway.service.bizcode;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by JiWen on 2019/7/24 at home.
 */
@Getter
@Setter
public class BizInfo {
    private String bizCode;
    private String bizName;
    private boolean enable;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
