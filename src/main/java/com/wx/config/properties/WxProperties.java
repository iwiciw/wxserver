package com.wx.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class WxProperties {
    @Value("${wx.appId}")
    public String appId;
    @Value("${wx.secret}")
    public String secret;
}
