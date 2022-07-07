package com.wx.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wx.common.BaseResponse;
import com.wx.common.so.teabrand.TeaBrandQuerySo;
import com.wx.common.vo.tearecord.TeaBrandVo;
import com.wx.service.TeaBrandService;

/**
 * 品牌库
 */
@RestController
@RequestMapping("/api/tea/brand")
public class TeaBrandController {

    @Resource
    private TeaBrandService TeaBrandService;

    /**
     * 品牌列表
     * @param so
     * @return
     */
    @PostMapping("list")
    public BaseResponse<TeaBrandVo> list(@RequestBody TeaBrandQuerySo so) {
        return BaseResponse.ok();
    }
}
