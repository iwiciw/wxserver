package com.wx.common.so.teabrand;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.wx.common.BaseSo;

import lombok.Data;

@Data
public class TeaBrandCreateSo extends BaseSo {

    @NotBlank(message = "openId不能为空")
    @Length(max = 100, message = "openId长度不能超过{max}")
    private String openId;

    /**
     * 奶茶品牌
     */
    @NotBlank(message = "品牌名称不能为空")
    @Length(max = 20, message = "品牌名称长度不能超过{max}")
    private String brandName;


    /**
     * 图标
     */
    @Length(max = 100, message = "图标长度不能超过{max}")
    private String brandPicUrl;
}
