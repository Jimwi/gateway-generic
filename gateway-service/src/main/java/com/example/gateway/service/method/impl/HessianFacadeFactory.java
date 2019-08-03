package com.example.gateway.service.method.impl;


import com.example.gateway.service.method.Facade;
import com.example.gateway.service.method.FacadeFactory;
import org.springframework.stereotype.Component;

/**
 * Created by JiWen on 2019/7/23 at home.
 */
@Component
public class HessianFacadeFactory implements FacadeFactory {
    @Override
    public Facade createFacade(String name, String group, String version) {
        return new HessianFacade();
    }
}
