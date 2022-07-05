package com.wx.service;

public interface WxUserService {
    /***
     * 获取微信用户openId
     * @param code
     * @return
     */
    String getOpenId(String code);
}
