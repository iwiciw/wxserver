package com.wx.common.so;

import com.wx.common.BaseSo;

import lombok.Data;

@Data
public class TeaBrandCreateSo extends BaseSo {
    /**
     * 名称
     */
    private String name;

    /**
     * 图标
     */
    private String picUrl;

    /**
     * openId(系统自建0)
     */
    private String openId;
}
