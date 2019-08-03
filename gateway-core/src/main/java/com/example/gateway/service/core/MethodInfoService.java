package com.example.gateway.service.core;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gateway.dao.entity.MethodInfoEntity;

import java.util.List;

/**
 * Created by JiWen on 2019/7/20 at home.
 */

public interface MethodInfoService extends IService<MethodInfoEntity> {

    List<MethodInfoEntity> getAvailableMethods();

    List<MethodInfoEntity> getByMethodCode(String methodCode);
}
