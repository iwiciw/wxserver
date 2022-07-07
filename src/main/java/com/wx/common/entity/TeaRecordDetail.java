package com.wx.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 记录详情表
 * </p>
 *
 * @author gdd
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeaRecordDetail extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    /**
     * openId
     */
    private String openId;

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
