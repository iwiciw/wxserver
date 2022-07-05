package com.wx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wx.config.properties.WxProperties;
import com.wx.service.WxUserService;
import com.wx.utils.RestTemplateUtil;

@Service
public class WxUserServiceImpl implements WxUserService {

    @Resource
    private RestTemplateUtil restTemplateUtil;

    @Resource
    private WxProperties wxProperties;

    @Override
    public String getOpenId(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?" + "appid=" + wxProperties.getAppId() +
                "&secret=" + wxProperties.getSecret() +
                "&js_code=" + code +
                "&grant_type=authorization_code";
        String data = restTemplateUtil.getForObject(url, null, String.class);
        Assert.notNull(data, "openid解析异常");
        JSONObject jsonObject = JSON.parseObject(data);
        Assert.notNull(jsonObject.get("openid"), jsonObject.get("errmsg").toString());
        return jsonObject.get("openid").toString();
    }
}
