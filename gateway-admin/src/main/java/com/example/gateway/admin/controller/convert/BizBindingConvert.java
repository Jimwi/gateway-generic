package com.example.gateway.admin.controller.convert;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.gateway.admin.controller.vo.BizBindingVo;
import com.example.gateway.dao.entity.BizBindingEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JiWen on 2019/7/28 at home.
 */
public class BizBindingConvert {

    public static QueryWrapper<BizBindingEntity> toCondition(BizBindingVo bizBindingVo) {
        Map<String, Object> condition = new HashMap<>();
        if (bizBindingVo.getBizCode() != null) {
            condition.put("biz_code", bizBindingVo.getBizCode());
        }
        if (bizBindingVo.getMethodCode() != null) {
            condition.put("method_code", bizBindingVo.getMethodCode());
        }
        if (bizBindingVo.getBindingStatus() != null) {
            condition.put("binding_status", bizBindingVo.getMethodCode());
        }
        QueryWrapper<BizBindingEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(condition);
        return queryWrapper;
    }

    public static IPage<BizBindingEntity> toPage(BizBindingVo bizBindingVo) {
        Page<BizBindingEntity> page = new Page<>(bizBindingVo.getPageIndex(), bizBindingVo.getPageSize());
        return page;
    }

    public static BizBindingEntity toEntity(BizBindingVo bizBindingVo) {
        BizBindingEntity bizBindingEntity = new BizBindingEntity();
        bizBindingEntity.setBizCode(bizBindingVo.getBizCode());
        bizBindingEntity.setMethodCode(bizBindingVo.getMethodCode());
        bizBindingEntity.setBindingStatus(bizBindingVo.getBindingStatus());
        bizBindingEntity.setId(bizBindingVo.getId());
        bizBindingEntity.setUpdateTime(new Date());
        return bizBindingEntity;
    }

}
