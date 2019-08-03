package com.example.gateway.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.gateway.admin.controller.convert.BizKeyConvert;
import com.example.gateway.admin.controller.vo.BaseRespVo;
import com.example.gateway.admin.controller.vo.BizKeyVo;
import com.example.gateway.dao.entity.BizKeyEntity;
import com.example.gateway.service.core.BizKeyService;
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
@RequestMapping("admin/bizKey")
public class BizKeyController {

    @Resource
    private BizKeyService bizKeyService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespVo list(@RequestBody BizKeyVo bizKeyVo) {
        log.info("list 接收到参数: bizInfoVo {}", bizKeyVo);
        QueryWrapper<BizKeyEntity> queryWrapper = BizKeyConvert.toCondition(bizKeyVo);
        IPage<BizKeyEntity> page = BizKeyConvert.toPage(bizKeyVo);
        IPage<BizKeyEntity> data = bizKeyService.page(page, queryWrapper);
        BaseRespVo respVo = BaseRespVo.success();
        respVo.setData(data);
        log.info("list 接收到返回条数: {}", data.getRecords().size());
        return respVo;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespVo insert(@RequestBody BizKeyVo bizKeyVo) {
        log.info("insert 接收到参数: bizKeyVo {}", bizKeyVo);
        BizKeyEntity entity = BizKeyConvert.toEntity(bizKeyVo);
        entity.setCreateTime(new Date());
        boolean success = bizKeyService.save(entity);
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
    public BaseRespVo update(@RequestBody BizKeyVo bizKeyVo) {
        log.info("update 接收到参数: bizKeyVo {}", bizKeyVo);
        BizKeyEntity entity = BizKeyConvert.toEntity(bizKeyVo);
        boolean success = bizKeyService.updateById(entity);
        BaseRespVo respVo;
        if (success) {
            respVo = BaseRespVo.success();
        } else {
            respVo = BaseRespVo.fail();
        }
        log.info("insert 返回: {}", respVo);
        return respVo;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespVo delete(@RequestBody BizKeyVo bizKeyVo) {
        log.info("delete 接收到参数 bizKeyVo: {}", bizKeyVo.getId());
        boolean success = bizKeyService.removeById(bizKeyVo.getId());
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
