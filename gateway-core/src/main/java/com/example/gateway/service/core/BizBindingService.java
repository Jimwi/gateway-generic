package com.example.gateway.service.core;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gateway.dao.entity.BizBindingEntity;

import java.util.List;

/**
 * Created by JiWen on 2019/7/20 at home.
 */
public interface BizBindingService extends IService<BizBindingEntity> {

   List<BizBindingEntity> queryByBizCode(String bizCode);

   List<BizBindingEntity> queryByBizCodeAndMethodCode(String bizCode,String methodCode);

}
