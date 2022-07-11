package com.wx.common.so.userteabrand;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.wx.common.BaseSo;

import lombok.Data;

@Data
public class UserTeaBrandDeleteSo extends BaseSo {

    /**
     * openId
     */
    @NotBlank(message = "openId不能为空")
    @Length(max = 100, message = "openId长度不能超过{max}")
    private String openId;

    /**
     * 用户品牌id
     */
    @NotNull(message = "品牌id不能为空")
    @Min(value = 1, message = "品牌id不合法")
    private Long brandId;
}
