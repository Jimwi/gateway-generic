package com.example.gateway.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.gateway.admin.controller.convert.BizBindingConvert;
import com.example.gateway.admin.controller.vo.BaseRespVo;
import com.example.gateway.admin.controller.vo.BizBindingVo;
import com.example.gateway.dao.entity.BizBindingEntity;
import com.example.gateway.service.core.BizBindingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by JiWen on 2019/7/28 at home.
 */
@Controller
@Slf4j
@RequestMapping("admin/bizBinding")
public class BizBindingController {

    @Resource
    private BizBindingService bizBindingService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespVo list(@RequestBody BizBindingVo bizBindingVo) {
        log.info("list 接收到参数: bizBindingVo {}", bizBindingVo);
        QueryWrapper<BizBindingEntity> queryWrapper = BizBindingConvert.toCondition(bizBindingVo);
        IPage<BizBindingEntity> page = BizBindingConvert.toPage(bizBindingVo);
        IPage<BizBindingEntity> data = bizBindingService.page(page, queryWrapper);
        BaseRespVo respVo = BaseRespVo.success();
        respVo.setData(data);
        log.info("list 接收到返回条数: {}", data.getRecords().size());
        return respVo;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespVo insert(@RequestBody BizBindingVo bizBindingVo) {
        log.info("insert 接收到参数: bizBindingVo {}", bizBindingVo);
        BizBindingEntity entity = BizBindingConvert.toEntity(bizBindingVo);
        entity.setCreateTime(new Date());
        boolean success = bizBindingService.save(entity);
        BaseRespVo respVo;
        if (success) {
            respVo = BaseRespVo.success();
        } else {
            respVo = BaseRespVo.fail();
        }
        log.info("insert 返回: {}", respVo);
        return respVo;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespVo update(@RequestBody BizBindingVo bizBindingVo) {
        log.info("update 接收到参数: bizBindingVo {}", bizBindingVo);
        BizBindingEntity entity = BizBindingConvert.toEntity(bizBindingVo);
        boolean success = bizBindingService.updateById(entity);
        BaseRespVo respVo;
        if (success) {
            respVo = BaseRespVo.success();
        } else {
            respVo = BaseRespVo.fail();
        }
        log.info("update 返回: {}", respVo);
        return respVo;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespVo delete(@RequestBody BizBindingVo bizBindingVo) {
        log.info("delete 接收到参数 bizBindingVo : {}", bizBindingVo.getId());
        boolean success = bizBindingService.removeById(bizBindingVo.getId());
        BaseRespVo respVo;
        if (success) {
            respVo = BaseRespVo.success();
        } else {
            respVo = BaseRespVo.fail();
        }
        log.info("delete 返回: {}", respVo);
        return respVo;
    }


}
