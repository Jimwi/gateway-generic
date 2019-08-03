package com.example.gateway.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("biz_binding")
public class BizBindingEntity extends BaseEntity {

    private String bizCode;

    private String methodCode;

    private String bindingStatus;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode == null ? null : bizCode.trim();
    }

    public String getMethodCode() {
        return methodCode;
    }

    public void setMethodCode(String methodCode) {
        this.methodCode = methodCode == null ? null : methodCode.trim();
    }

    public String getBindingStatus() {
        return bindingStatus;
    }

    public void setBindingStatus(String bindingStatus) {
        this.bindingStatus = bindingStatus == null ? null : bindingStatus.trim();
    }
}