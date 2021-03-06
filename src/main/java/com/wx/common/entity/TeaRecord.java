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
}
