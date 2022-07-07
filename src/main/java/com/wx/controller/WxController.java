package com.wx.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wx.common.BaseResponse;
import com.wx.service.WxUserService;

/**
 * 获取open_id
 */
@RestController
@RequestMapping("/api/wx")
public class WxController {

    @Resource
    private WxUserService wxUserService;

    /**
     * 认证
     * @param code
     * @return
     */
    @PostMapping(value = "auth")
    public BaseResponse<String> wxAuth(@RequestParam(value = "code") String code) {
        String openId = wxUserService.getOpenId(code);
        return BaseResponse.ok(openId);
    }
}
