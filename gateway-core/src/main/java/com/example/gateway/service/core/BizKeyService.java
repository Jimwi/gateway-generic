package com.example.gateway.service.core;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gateway.dao.entity.BizKeyEntity;

import java.util.List;

/**
 * Created by JiWen on 2019/7/20 at home.
 */
public interface BizKeyService extends IService<BizKeyEntity> {

    List<BizKeyEntity> queryByBizCode(String bizCode);

    List<BizKeyEntity> queryByBizCodeAndKeyGroup(String bizCode, String keyGroup);
}
