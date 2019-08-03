package com.example.gateway.service.method;


import com.example.gateway.dao.entity.MethodInfoEntity;
import com.example.gateway.service.core.MethodInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by JiWen on 2019/7/21 at home.
 */
@Component
@Slf4j
public class MethodMap {

    /**
     * methodCode  -->  method Proxy
     */
    private final static Map<String, FacadeMethod> methodMap = new ConcurrentHashMap<>();

    /**
     * facadeName  -->  Facade proxy
     */
    private final static Map<String, Facade> facadeMap = new ConcurrentHashMap<>();


    private final static String methodSeparator = "#";

    @Resource
    private MethodInfoService methodInfoService;

    @Resource
    private Map<String, FacadeFactory> facadeFactoryMap;

    public FacadeMethod getMethod(String methodCode) {
        FacadeMethod method = MethodMap.methodMap.get(methodCode);
        if (method == null) {
            synchronized (this) {
                try {
                    method = MethodMap.methodMap.get(methodCode);
                    if (method == null) {
                        method = createMethod(methodCode);
                        if (method != null) {
                            MethodMap.methodMap.put(methodCode, method);
                            log.info("load {} method {} ", method.getRpcType(), methodCode);
                        }
                    }
                } catch (Exception e) {
                    log.error("cannot create method {}", methodCode, e);
                }
            }
        }
        return method;
    }


    @PostConstruct
    private void init() {
        List<MethodInfoEntity> allServices = methodInfoService.getAvailableMethods();
        for (MethodInfoEntity methodInfoEntity : allServices) {
            if (MethodMap.methodMap.get(methodInfoEntity.getMethodCode()) == null) {
                FacadeMethod method = doCreateMethod(methodInfoEntity);
                if (method != null) {
                    MethodMap.methodMap.put(methodInfoEntity.getMethodCode(), method);
                    log.info("loading {} method {} ", methodInfoEntity.getRpcType(), methodInfoEntity.getMethodCode());
                }
            }
        }
    }

    private FacadeMethod createMethod(String methodCode) {
        List<MethodInfoEntity> services = methodInfoService.getByMethodCode(methodCode);
        if (services.size() == 1) {
            MethodInfoEntity methodInfoEntity = services.get(0);
            return doCreateMethod(methodInfoEntity);
        } else {
            throw new RuntimeException("find more than 1 method configurations, method code " + methodCode);
        }
    }

    private FacadeMethod doCreateMethod(MethodInfoEntity methodInfoEntity) {
        String rpcType = methodInfoEntity.getRpcType();
        String methodCode = methodInfoEntity.getMethodCode();
        if (StringUtils.isBlank(rpcType)) {
            log.warn("{} rpcType {} is not supported", methodCode, rpcType);
            return null;
        }
        int index = methodInfoEntity.getMethodName().lastIndexOf(methodSeparator);
        String facadeName = methodInfoEntity.getMethodName().substring(0, index);
        String shortMethodName = methodInfoEntity.getMethodName().substring(index + 1);
        Facade facade = getFacade(facadeName, methodInfoEntity.getMethodGroup(), methodInfoEntity.getMethodVersion(), rpcType);

        FacadeMethod method = new FacadeMethod();
        method.setMethodCode(methodInfoEntity.getMethodCode());
        method.setMethodName(methodInfoEntity.getMethodName());
        method.setRpcType(methodInfoEntity.getRpcType());
        method.setShortMethodName(shortMethodName);
        method.setParamType(methodInfoEntity.getParamType());
        method.setReturnType(methodInfoEntity.getReturnType());
        method.setFacade(facade);
        return method;
    }

    private Facade getFacade(String facadeName, String group, String version, String rpcType) {
        Facade facade = MethodMap.facadeMap.get(facadeName);
        if (facade == null) {
            facade = facadeFactoryMap.get(rpcType + "FacadeFactory").createFacade(facadeName, group, version);
            MethodMap.facadeMap.put(facadeName, facade);
        }
        return facade;
    }

}
