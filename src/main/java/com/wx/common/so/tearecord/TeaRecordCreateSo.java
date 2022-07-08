package com.wx.common.so.tearecord;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.wx.common.BaseSo;
import com.wx.common.enums.CupType;
import com.wx.common.enums.MoodType;
import com.wx.common.enums.TemperatureType;

import lombok.Data;

@Data
public class TeaRecordCreateSo extends BaseSo {
    /**
     * openId
     */
    @NotBlank(message = "openId不能为空")
    @Length(max = 100, message = "openId长度不能超过{max}")
    private String openId;

    /**
     * 奶茶品牌id
     */
    @NotNull(message = "品牌id不能为空")
    @Min(value = 1, message = "品牌id不合法")
    private Long brandId;

    /**
     * 奶茶名称
     */
    @NotBlank(message = "奶茶名称不能为空")
    @Length(max = 30, message = "openId长度不能超过{max}")
    private String teaName;

    /**
     * 奶茶价格
     */
    @NotNull(message = "价格不能为空")
    @DecimalMin(value = "0.0", message = "奶茶价格不小于{value}")
    @DecimalMax(value = "999.0", message = "奶茶价格大于{value}")
    @Digits(integer = 3, fraction = 2, message = "费用整数位不能大于{integer}，小数位不能大于{fraction}")
    private BigDecimal price;

    /**
     * 温度(枚举)
     */
    @NotNull(message = "温度不能为空")
    private TemperatureType temperature;

    /**
     * 糖度(枚举)
     */
    @NotNull(message = "糖度不能为空")
    @Size(min = 0, max = 10, message = "糖度在{min}和{max}之间")
    private Integer brix;

    /**
     * 评分
     */
    @NotNull(message = "评分不能为空")
    @Size(min = 1, max = 5, message = "评分在{min}和{max}之间")
    private Integer score;

    /**
     * 此刻心情(枚举)
     */
    private MoodType mood;

    /**
     * 份量
     */
    @NotNull(message = "份量不能为空")
    private CupType cup;

    /**
     * 购买时间
     */
    @NotBlank(message = "购买时间不能为空")
    private String purchaseTime;

    /**
     * 小料
     */
    @Length(max = 50, message = "小料长度不能超过{max}")
    private String toppings;

    /**
     * 评价
     */
    @Length(max = 200, message = "评价长度不能超过{max}")
    private String remark;

    /**
     * 图片
     */
    @Length(max = 200, message = "图片长度不能超过{max}")
    private String picUrl;
}
