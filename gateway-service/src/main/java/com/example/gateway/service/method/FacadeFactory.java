package com.example.gateway.service.method;


/**
 * Created by JiWen on 2019/7/23 at home.
 */
public interface FacadeFactory {

    Facade createFacade(String name, String group, String version);

}
