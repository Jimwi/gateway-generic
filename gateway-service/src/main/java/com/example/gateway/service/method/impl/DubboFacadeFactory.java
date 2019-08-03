package com.example.gateway.service.method.impl;


import com.example.gateway.service.method.Facade;
import com.example.gateway.service.method.FacadeFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by JiWen on 2019/7/23 at home.
 */
@Slf4j
@Component
public class DubboFacadeFactory implements FacadeFactory {

    @Resource
    private ApplicationConfig application;

    @Override
    public Facade createFacade(String name, String group, String version) {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        reference.setApplication(application);
        reference.setInterface(name);
        if (StringUtils.isNotBlank(group)) {
            reference.setGroup(group);
        }
        if (StringUtils.isNotBlank(version)) {
            reference.setVersion(version);
        }
        reference.setRetries(0);
        reference.setCheck(false);
        reference.setGeneric(true);
        ReferenceConfigCache configCache = ReferenceConfigCache.getCache();
        GenericService genericService = configCache.get(reference);
        return new DubboFacade(genericService);
    }
}
