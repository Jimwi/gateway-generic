package com.example.gateway.service.core.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.gateway.common.enums.StatusEnum;
import com.example.gateway.dao.entity.MethodInfoEntity;
import com.example.gateway.dao.mapper.MethodInfoMapper;
import com.example.gateway.service.core.MethodInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JiWen on 2019/7/23 at home.
 */
@Service
public class MethodInfoServiceImpl extends ServiceImpl<MethodInfoMapper, MethodInfoEntity> implements MethodInfoService {

    @Resource
    private MethodInfoMapper methodInfoMapper;

    @Override
    public List<MethodInfoEntity> getAvailableMethods() {
        Map<String, Object> condition = new HashMap<>();
        condition.put("method_status", StatusEnum.ENABLE.getStatus());
        return methodInfoMapper.selectByMap(condition);
    }

    @Override
    public List<MethodInfoEntity> getByMethodCode(final String methodCode) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("method_code", methodCode);
        condition.put("method_status", StatusEnum.ENABLE.getStatus());
        return methodInfoMapper.selectByMap(condition);
    }
}
