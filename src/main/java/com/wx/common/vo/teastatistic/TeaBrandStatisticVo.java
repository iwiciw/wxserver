package com.wx.common.vo.teastatistic;

import java.math.BigDecimal;

import com.wx.common.BaseVo;

import lombok.Data;

@Data
public class TeaBrandStatisticVo extends BaseVo {

    private Long brandId;

    /**
     * 品牌名
     */
    private String brandName;

    /**
     * 数量
     */
    private Integer totalCup;

    /**
     * 金额
     */
    private BigDecimal totalPrice;

    /**
     * 糖度
     */
    private Integer totalBrix;
}
