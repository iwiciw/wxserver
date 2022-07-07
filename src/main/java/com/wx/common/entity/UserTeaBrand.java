package com.wx.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 我的品牌
 * </p>
 *
 * @author gdd
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserTeaBrand extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    /**
     * openId
     */
    private String openId;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 排序因子
     */
    private Integer sortIndex;
}
