package com.wx.common.vo.userteabrand;

import com.wx.common.AbstractVo;

import lombok.Data;

@Data
public class UserTeaBrandVo extends AbstractVo {

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 排序因子
     */
    private Integer sortIndex;

    /**
     * 图标
     */
    private String brandPicUrl;
}
