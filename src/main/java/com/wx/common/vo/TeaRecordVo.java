package com.wx.common.vo;

import java.math.BigDecimal;

import com.wx.common.AbstractVo;

public class TeaRecordVo extends AbstractVo {

    /**
     * 详情id
     */
    private Long recordDetailId;
    /**
     * openId
     */
    private String openId;

    /**
     * 奶茶品牌id
     */
    private Long brandId;

    /**
     * 奶茶名称
     */
    private String teaName;

    /**
     * 奶茶价格
     */
    private BigDecimal price;

    /**
     * 温度(枚举)
     */
    private String temperature;

    /**
     * 糖度
     */
    private Integer brix;

    /**
     * 评分
     */
    private Integer score;

    /**
     * 此刻心情(枚举)
     */
    private String mood;

    /**
     * 份量
     */
    private String cup;

    /**
     * 购买时间
     */
    private String purchaseTime;

    /**
     * 小料
     */
    private String toppings;

    /**
     * 评价
     */
    private String remark;

    /**
     * 图片
     */
    private String picUrl;
}
