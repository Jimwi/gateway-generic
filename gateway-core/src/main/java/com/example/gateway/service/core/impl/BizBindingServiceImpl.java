package com.example.gateway.service.core.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.gateway.common.enums.StatusEnum;
import com.example.gateway.service.core.BizBindingService;
import com.example.gateway.dao.entity.BizBindingEntity;
import com.example.gateway.dao.mapper.BizBindingMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JiWen on 2019/7/20 at home.
 */
@Service
public class BizBindingServiceImpl extends ServiceImpl<BizBindingMapper, BizBindingEntity> implements BizBindingService {
    @Resource
    private BizBindingMapper bizBindingMapper;

    @Override
    public List<BizBindingEntity> queryByBizCode(String bizCode) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("biz_code", bizCode);
        condition.put("biz_status", StatusEnum.ENABLE.getStatus());
        return bizBindingMapper.selectByMap(condition);
    }

    @Override
    public List<BizBindingEntity> queryByBizCodeAndMethodCode(String bizCode, String methodCode) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("biz_code", bizCode);
        condition.put("method_code", methodCode);
        condition.put("binding_status", StatusEnum.ENABLE.getStatus());
        return bizBindingMapper.selectByMap(condition);
    }
}
