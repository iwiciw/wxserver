package com.wx.common.so.userteabrand;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.wx.common.BaseSo;

import lombok.Data;

@Data
public class UserTeaBrandQuerySo extends BaseSo {

    /**
     * openId
     */
    @NotBlank(message = "openId不能为空")
    @Length(max = 100, message = "openId长度不能超过{max}")
    private String openId;
}
