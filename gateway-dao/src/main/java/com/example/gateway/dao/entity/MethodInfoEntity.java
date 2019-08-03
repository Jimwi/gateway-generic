package com.example.gateway.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("method_info")
public class MethodInfoEntity extends BaseEntity {

    private String methodCode;

    private String methodName;

    private String rpcType;

    private String paramType;

    private String returnType;

    private String methodGroup;

    private String methodVersion;

    private String methodStatus;

    private String remark;

    public String getMethodCode() {
        return methodCode;
    }

    public void setMethodCode(String methodCode) {
        this.methodCode = methodCode == null ? null : methodCode.trim();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getRpcType() {
        return rpcType;
    }

    public void setRpcType(String rpcType) {
        this.rpcType = rpcType == null ? null : rpcType.trim();
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType == null ? null : paramType.trim();
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType == null ? null : returnType.trim();
    }

    public String getMethodGroup() {
        return methodGroup;
    }

    public void setMethodGroup(String methodGroup) {
        this.methodGroup = methodGroup == null ? null : methodGroup.trim();
    }

    public String getMethodVersion() {
        return methodVersion;
    }

    public void setMethodVersion(String methodVersion) {
        this.methodVersion = methodVersion == null ? null : methodVersion.trim();
    }

    public String getMethodStatus() {
        return methodStatus;
    }

    public void setMethodStatus(String methodStatus) {
        this.methodStatus = methodStatus == null ? null : methodStatus.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}