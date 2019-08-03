package com.example.gateway.service.context;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by JiWen on 2019/7/21 at home.
 */
public class SpringContext implements ApplicationContextAware {
    private static ApplicationContext springContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.springContext = applicationContext;
    }
    public static ApplicationContext getSpringContext() {
        return SpringContext.springContext;
    }
}
