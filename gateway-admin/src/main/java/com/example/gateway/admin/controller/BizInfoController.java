package com.example.gateway.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.gateway.admin.controller.convert.BizInfoConvert;
import com.example.gateway.admin.controller.vo.BaseRespVo;
import com.example.gateway.admin.controller.vo.BizInfoVo;
import com.example.gateway.dao.entity.BizInfoEntity;
import com.example.gateway.service.core.BizInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * Created by JiWen on 2019/7/28 at home.
 */
@Controller
@Slf4j
@RequestMapping("admin/bizInfo")
public class BizInfoController {

    @Resource
    private BizInfoService bizInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespVo list(@RequestBody BizInfoVo bizInfoVo) {
        log.info("list 接收到参数: bizInfoVo {}", bizInfoVo);
        QueryWrapper<BizInfoEntity> queryWrapper = BizInfoConvert.toCondition(bizInfoVo);
        IPage<BizInfoEntity> page = BizInfoConvert.toPage(bizInfoVo);
        IPage<BizInfoEntity> data = bizInfoService.page(page, queryWrapper);
        BaseRespVo respVo = BaseRespVo.success();
        respVo.setData(data);
        log.info("list 接收到返回条数: {}", data.getRecords().size());
        return respVo;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespVo insert(@RequestBody BizInfoVo bizInfoVo) {
        log.info("insert 接收到参数: bizInfoVo {}", bizInfoVo);
        BizInfoEntity bizInfoEntity = BizInfoConvert.toEntity(bizInfoVo);
        boolean success = bizInfoService.save(bizInfoEntity);
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
    public BaseRespVo update(@RequestBody BizInfoVo bizInfoVo) {
        log.info("update 接收到参数: bizInfoVo {}", bizInfoVo);
        BizInfoEntity bizInfoEntity = BizInfoConvert.toEntity(bizInfoVo);
        boolean success = bizInfoService.updateById(bizInfoEntity);
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
    public BaseRespVo delete(@RequestBody BizInfoVo bizInfoVo) {
        log.info("delete 接收到参数 bizInfoVo: {}", bizInfoVo.getId());
        boolean success = bizInfoService.removeById(bizInfoVo.getId());
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
