package com.example.gateway.service.core.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.gateway.common.enums.StatusEnum;
import com.example.gateway.service.core.BizKeyService;
import com.example.gateway.dao.entity.BizKeyEntity;
import com.example.gateway.dao.mapper.BizKeyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by JiWen on 2019/7/20 at home.
 */
@Service
public class BizKeyServiceImpl extends ServiceImpl<BizKeyMapper, BizKeyEntity> implements BizKeyService {
    @Resource
    private BizKeyMapper bizKeyMapper;


    @Override
    public List<BizKeyEntity> queryByBizCode(String bizCode) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("biz_code", bizCode);
        condition.put("key_status", StatusEnum.ENABLE.getStatus());
        return bizKeyMapper.selectByMap(condition);
    }

    @Override
    public List<BizKeyEntity> queryByBizCodeAndKeyGroup(String bizCode, String keyGroup) {
        Map<String, Object> condition = new HashMap<>();
        if (!Objects.isNull(bizCode)) {
            condition.put("biz_code", bizCode);
        }
        if (!Objects.isNull(keyGroup)) {
            condition.put("key_group", keyGroup);
        }
        condition.put("key_status", StatusEnum.ENABLE.getStatus());
        return bizKeyMapper.selectByMap(condition);
    }
}
