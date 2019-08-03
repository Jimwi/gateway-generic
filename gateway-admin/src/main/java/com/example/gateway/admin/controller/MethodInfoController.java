package com.example.gateway.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.gateway.admin.controller.convert.MethodInfoConvert;
import com.example.gateway.admin.controller.vo.BaseRespVo;
import com.example.gateway.admin.controller.vo.MethodInfoVo;
import com.example.gateway.dao.entity.MethodInfoEntity;
import com.example.gateway.service.core.MethodInfoService;
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
@RequestMapping("admin/methodInfo")
public class MethodInfoController {

    @Resource
    private MethodInfoService methodInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespVo list(@RequestBody MethodInfoVo methodInfoVo) {
        log.info("list 接收到参数: methodInfoVo {}", methodInfoVo);
        QueryWrapper<MethodInfoEntity> queryWrapper = MethodInfoConvert.toCondition(methodInfoVo);
        IPage<MethodInfoEntity> page = MethodInfoConvert.toPage(methodInfoVo);
        ((Page) page).setSearchCount(true);
        IPage<MethodInfoEntity> data = methodInfoService.page(page, queryWrapper);
        BaseRespVo respVo = BaseRespVo.success();
        respVo.setData(data);
        log.info("list 接收到返回条数: {}", data.getRecords().size());
        return respVo;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespVo insert(@RequestBody MethodInfoVo methodInfoVo) {
        log.info("insert 接收到参数: methodInfoVo {}", methodInfoVo);
        MethodInfoEntity entity = MethodInfoConvert.toEntity(methodInfoVo);
        entity.setCreateTime(new Date());
        boolean success = methodInfoService.save(entity);
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
    public BaseRespVo update(@RequestBody MethodInfoVo methodInfoVo) {
        log.info("update 接收到参数: methodInfoVo {}", methodInfoVo);
        MethodInfoEntity entity = MethodInfoConvert.toEntity(methodInfoVo);
        entity.setCreateTime(new Date());
        boolean success = methodInfoService.updateById(entity);
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
    public BaseRespVo delete(@RequestBody MethodInfoVo methodInfoVo) {
        log.info("delete 接收到参数 methodInfoVo: {}", methodInfoVo.getId());
        boolean success = methodInfoService.removeById(methodInfoVo.getId());
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
