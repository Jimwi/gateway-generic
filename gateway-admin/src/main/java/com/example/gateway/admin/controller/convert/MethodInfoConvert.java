package com.example.gateway.admin.controller.convert;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.gateway.admin.controller.vo.MethodInfoVo;
import com.example.gateway.dao.entity.MethodInfoEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JiWen on 2019/7/28 at home.
 */
public class MethodInfoConvert {

    public static QueryWrapper<MethodInfoEntity> toCondition(MethodInfoVo methodInfoVo) {
        Map<String, Object> condition = new HashMap<>();
        if (methodInfoVo.getMethodCode() != null) {
            condition.put("biz_code", methodInfoVo.getMethodCode());
        }
        if (methodInfoVo.getMethodStatus() != null) {
            condition.put("biz_status", methodInfoVo.getMethodStatus());
        }
        QueryWrapper<MethodInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(condition);
        return queryWrapper;
    }

    public static IPage<MethodInfoEntity> toPage(MethodInfoVo methodInfoVo) {
        Page<MethodInfoEntity> page = new Page<>(methodInfoVo.getPageIndex(), methodInfoVo.getPageSize());
        return page;
    }

    public static MethodInfoEntity toEntity(MethodInfoVo methodInfoVo) {
        MethodInfoEntity methodInfoEntity = new MethodInfoEntity();
        methodInfoEntity.setMethodCode(methodInfoVo.getMethodCode());
        methodInfoEntity.setMethodName(methodInfoVo.getMethodName());
        methodInfoEntity.setRpcType(methodInfoVo.getRpcType());
        methodInfoEntity.setParamType(methodInfoVo.getParamType());
        methodInfoEntity.setReturnType(methodInfoVo.getReturnType());
        methodInfoEntity.setMethodGroup(methodInfoVo.getMethodGroup());
        methodInfoEntity.setMethodVersion(methodInfoVo.getMethodVersion());
        methodInfoEntity.setMethodStatus(methodInfoVo.getMethodStatus());
        methodInfoEntity.setRemark(methodInfoVo.getRemark());
        methodInfoEntity.setId(methodInfoVo.getId());
        methodInfoEntity.setUpdateTime(new Date());
        return methodInfoEntity;

    }


}
