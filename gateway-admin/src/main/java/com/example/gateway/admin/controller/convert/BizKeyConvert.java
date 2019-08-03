package com.example.gateway.admin.controller.convert;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.gateway.admin.controller.vo.BizKeyVo;
import com.example.gateway.dao.entity.BizKeyEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JiWen on 2019/7/28 at home.
 */
public class BizKeyConvert {

    public static QueryWrapper<BizKeyEntity> toCondition(BizKeyVo bizKeyVo) {
        Map<String, Object> condition = new HashMap<>();
        if (bizKeyVo.getBizCode() != null) {
            condition.put("biz_key", bizKeyVo.getBizCode());
        }
        if (bizKeyVo.getKeyGroup() != null) {
            condition.put("key_group", bizKeyVo.getKeyGroup());
        }
        if (bizKeyVo.getEncryptType() != null) {
            condition.put("encrypt_type", bizKeyVo.getEncryptType());
        }
        if (bizKeyVo.getSignType() != null) {
            condition.put("sign_key", bizKeyVo.getSignType());
        }
        if (bizKeyVo.getKeyStatus() != null) {
            condition.put("key_status", bizKeyVo.getKeyStatus());
        }
        QueryWrapper<BizKeyEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(condition);
        return queryWrapper;
    }

    public static IPage<BizKeyEntity> toPage(BizKeyVo bizKeyVo) {
        Page<BizKeyEntity> page = new Page<>(bizKeyVo.getPageIndex(), bizKeyVo.getPageSize());
        return page;
    }

    public static BizKeyEntity toEntity(BizKeyVo bizKeyVo) {
        BizKeyEntity bizKeyEntity = new BizKeyEntity();
        bizKeyEntity.setBizCode(bizKeyVo.getBizCode());
        bizKeyEntity.setKeyGroup(bizKeyVo.getKeyGroup());
        bizKeyEntity.setEncryptType(bizKeyVo.getEncryptType());
        bizKeyEntity.setEncryptKey(bizKeyVo.getEncryptKey());
        bizKeyEntity.setDecryptKey(bizKeyVo.getDecryptKey());
        bizKeyEntity.setSignType(bizKeyVo.getSignType());
        bizKeyEntity.setSignKey(bizKeyVo.getSignKey());
        bizKeyEntity.setKeyStatus(bizKeyVo.getKeyStatus());
        bizKeyEntity.setRemark(bizKeyVo.getRemark());
        bizKeyEntity.setId(bizKeyVo.getId());
        bizKeyEntity.setUpdateTime(new Date());
        return bizKeyEntity;
    }


}
