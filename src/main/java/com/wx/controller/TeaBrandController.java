package com.wx.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wx.common.BaseResponse;
import com.wx.common.entity.TeaBrand;
import com.wx.common.so.TeaBrandCreateSo;
import com.wx.service.TeaBrandService;

import cn.hutool.core.convert.Convert;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author gdd
 * @since 2022-07-07
 */
@RestController
@RequestMapping("/api/tea/brand")
public class TeaBrandController {

    @Resource
    private TeaBrandService teaBrandService;

    @PostMapping("create")
    public BaseResponse create(@RequestBody TeaBrandCreateSo so) {
        TeaBrand teaBrand = Convert.convert(TeaBrand.class, so);
        teaBrandService.save(teaBrand);
        return BaseResponse.ok();
    }
}
