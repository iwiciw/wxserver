package com.wx.common.vo.tearank;

import com.wx.common.BaseVo;

import lombok.Data;

@Data
public class TeaRankBrandVo extends BaseVo {

    /**
     * 品牌名
     */
    private String brandName;

    /**
     * 打卡次数
     */
    private Integer cupNums;

    /**
     * 打卡用户数量
     */
    private Integer userNums;

    /**
     * 评价分
     */
    private Integer score;
}
