package com.example.gateway.admin.controller.convert;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.gateway.admin.controller.vo.BizInfoVo;
import com.example.gateway.dao.entity.BizInfoEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JiWen on 2019/7/28 at home.
 */
public class BizInfoConvert {

    public static QueryWrapper<BizInfoEntity> toCondition(BizInfoVo bizInfoVo) {
        Map<String, Object> condition = new HashMap<>();
        if (bizInfoVo.getBizCode() != null) {
            condition.put("biz_code", bizInfoVo.getBizCode());
        }
        if (bizInfoVo.getBizStatus() != null) {
            condition.put("biz_status", bizInfoVo.getBizStatus());
        }
        QueryWrapper<BizInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(condition);
        return queryWrapper;
    }

    public static IPage<BizInfoEntity> toPage(BizInfoVo bizInfoVo) {
        Page<BizInfoEntity> page = new Page<>(bizInfoVo.getPageIndex(), bizInfoVo.getPageSize());
        return page;
    }

    public static BizInfoEntity toEntity(BizInfoVo bizInfoVo) {
        BizInfoEntity bizInfoEntity = new BizInfoEntity();
        bizInfoEntity.setBizCode(bizInfoVo.getBizCode());
        bizInfoEntity.setBizName(bizInfoVo.getBizName());
        bizInfoEntity.setBizStatus(bizInfoVo.getBizStatus());
        bizInfoEntity.setRemark(bizInfoVo.getRemark());
        bizInfoEntity.setId(bizInfoVo.getId());
        bizInfoEntity.setUpdateTime(new Date());
        return bizInfoEntity;
    }

}
