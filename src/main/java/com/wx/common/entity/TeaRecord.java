package com.wx.common.entity;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 奶茶记录表
 * </p>
 *
 * @author gdd
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeaRecord extends AbstractEntity {

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
    private String name;

    /**
     * 奶茶价格
     */
    private BigDecimal price;

    /**
     * 温度(枚举)
     */
    private Integer temperature;

    /**
     * 糖度(枚举)
     */
    private String brix;

    /**
     * 评分
     */
    private Integer score;

    /**
     * 此刻心情(枚举)
     */
    private String mood;

    /**
     * 购买时间
     */
    private String purchaseTime;
}
