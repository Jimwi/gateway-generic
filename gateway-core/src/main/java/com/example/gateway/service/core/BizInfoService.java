package com.example.gateway.service.core;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gateway.dao.entity.BizInfoEntity;

import java.util.List;

/**
 * Created by JiWen on 2019/7/20 at home.
 */
public interface BizInfoService extends IService<BizInfoEntity> {

    List<BizInfoEntity> queryAvailableBizInfos();

    List<BizInfoEntity> queryByBizCode(String bizCode);

}
