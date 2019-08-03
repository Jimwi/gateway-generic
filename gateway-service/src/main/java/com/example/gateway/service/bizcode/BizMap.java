package com.example.gateway.service.bizcode;


import com.example.gateway.dao.entity.BizBindingEntity;
import com.example.gateway.dao.entity.BizInfoEntity;
import com.example.gateway.dao.entity.BizKeyEntity;
import com.example.gateway.service.cache.ServiceCache;
import com.example.gateway.service.core.BizBindingService;
import com.example.gateway.service.core.BizInfoService;
import com.example.gateway.service.core.BizKeyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JiWen on 2019/7/24 at home.
 */
@Component
@Slf4j
public class BizMap {

    @Resource
    private BizInfoService bizInfoService;
    @Resource
    private BizKeyService bizKeyService;
    @Resource
    private BizBindingService bizBindingService;

    @ServiceCache
    public BizInfo getBizInfo(String bizCode) {
        List<BizInfoEntity> entities = bizInfoService.queryByBizCode(bizCode);
        if (entities.size() == 1) {
            BizInfoEntity entity = entities.get(0);
            BizInfo bizInfo = new BizInfo();
            bizInfo.setBizCode(entity.getBizCode());
            bizInfo.setBizName(entity.getBizName());
            bizInfo.setEnable("1".equals(entity.getBizStatus()));
            return bizInfo;
        }
        return null;
    }

    @ServiceCache
    public BizKey getBizKey(String bizCode, String keyGroup) {
        List<BizKeyEntity> entities = bizKeyService.queryByBizCodeAndKeyGroup(bizCode, keyGroup);
        if (entities.size() == 1) {
            BizKeyEntity entity = entities.get(0);
            BizKey bizKey = new BizKey();
            bizKey.setBizCode(entity.getBizCode());
            bizKey.setKeyGroup(entity.getKeyGroup());
            bizKey.setEncryptType(entity.getEncryptType());
            bizKey.setEncryptKey(entity.getEncryptKey());
            bizKey.setDecryptKey(entity.getDecryptKey());
            bizKey.setSignType(entity.getSignType());
            bizKey.setSignKey(entity.getSignKey());
            bizKey.setEnable("1".equals(entity.getKeyStatus()));
            return bizKey;
        }
        return null;
    }

    @ServiceCache
    public List<BizKey> getBizKey(String bizCode) {
        List<BizKeyEntity> entities = bizKeyService.queryByBizCode(bizCode);
        List<BizKey> bizKeys = new ArrayList<>();
        for (BizKeyEntity entity : entities) {
            BizKey bizKey = new BizKey();
            bizKey.setBizCode(entity.getBizCode());
            bizKey.setKeyGroup(entity.getKeyGroup());
            bizKey.setEncryptType(entity.getEncryptType());
            bizKey.setEncryptKey(entity.getEncryptKey());
            bizKey.setDecryptKey(entity.getDecryptKey());
            bizKey.setSignType(entity.getSignType());
            bizKey.setSignKey(entity.getSignKey());
            bizKey.setEnable("1".equals(entity.getKeyStatus()));
            bizKeys.add(bizKey);
        }
        return bizKeys;
    }


    @ServiceCache
    public boolean isBinding(String bizCode, String methodCode) {
        List<BizBindingEntity> bindingEntities = bizBindingService.queryByBizCodeAndMethodCode(bizCode, methodCode);
        if (bindingEntities.size() == 1) {
            BizBindingEntity bizBindingEntity = bindingEntities.get(0);
            return "1".equals(bizBindingEntity.getBindingStatus());
        }
        return false;

    }
}
