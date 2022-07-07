package com.wx.common.vo.tearecord;

import com.wx.common.AbstractVo;

import lombok.Data;

@Data
public class TeaBrandVo extends AbstractVo {
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

    /**
     * 首字母分组
     */
    private String charGroup;

    /**
     * 组内排序
     */
    private Integer groupSortIndex;
}
