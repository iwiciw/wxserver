package com.wx.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 品牌表
 * </p>
 *
 * @author gdd
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeaBrand extends AbstractEntity {
    /**
     * 名称
     */
    private String brandName;

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
