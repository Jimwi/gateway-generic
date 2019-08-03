package com.example.gateway.service.handler;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by JiWen on 2019/7/2 at home.
 */
public abstract class ServiceHandler<REQ, RESP> {

    /**
     * 解密验签
     *
     * @param req
     */
    public abstract void beforeHandler(REQ req, HandlerContext context);

    /**
     * 调用相应的服务
     *
     * @param req
     * @return
     */
    public abstract RESP doHandler(REQ req, HandlerContext context);

    /**
     * 加密返回
     *
     * @param resp
     * @param req
     */
    public abstract void afterHandler(RESP resp, REQ req, HandlerContext context);

    public RESP handle(REQ req) {
        HandlerContext context = new HandlerContext();
        beforeHandler(req, context);
        RESP resp = doHandler(req, context);
        afterHandler(resp, req, context);
        return resp;
    }

    public static class HandlerContext {
        private Map<String, Object> contextMap = new HashMap<>();
        public void put(String key, Object value) {
            contextMap.put(key, value);
        }
        public Object get(String key) {
            return contextMap.get(key);
        }
    }
}
