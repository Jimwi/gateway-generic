package com.example.gateway.service.core.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.gateway.common.enums.StatusEnum;
import com.example.gateway.service.core.BizInfoService;
import com.example.gateway.dao.entity.BizInfoEntity;
import com.example.gateway.dao.mapper.BizInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JiWen on 2019/7/20 at home.
 */
@Service
public class BizInfoServiceImpl extends ServiceImpl<BizInfoMapper, BizInfoEntity> implements BizInfoService {
    @Resource
    private BizInfoMapper bizInfoMapper;

    @Override
    public List<BizInfoEntity> queryAvailableBizInfos() {
        Map<String, Object> condition = new HashMap<>();
        condition.put("biz_status", StatusEnum.ENABLE.getStatus());
        return bizInfoMapper.selectByMap(condition);
    }

    @Override
    public List<BizInfoEntity> queryByBizCode(String bizCode) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("biz_code", bizCode);
        condition.put("biz_status", StatusEnum.ENABLE.getStatus());
        return bizInfoMapper.selectByMap(condition);
    }
}
