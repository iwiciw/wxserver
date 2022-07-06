package com.wx.common.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
@EqualsAndHashCode(callSuper = false)
public class TeaRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    private Integer lockVersion;


}
