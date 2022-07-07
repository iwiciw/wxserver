package com.wx.common.so.tearecord;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.wx.common.BaseSo;

import lombok.Data;

@Data
public class TeaRecordDeleteSo extends BaseSo {

    @NotNull(message = "id不能为空")
    @Min(value = 1, message = "id非法")
    private Long id;

    @NotNull(message = "openId不能为空")
    @Length(max = 100, message = "openId长度不能超过{max}")
    private String openId;
}
