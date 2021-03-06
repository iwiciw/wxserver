package com.wx.common.so.tearecord;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.wx.common.BaseSo;

import lombok.Data;

@Data
public class TeaRecordQuerySo extends BaseSo {

    @NotNull(message = "openId不能为空")
    @Length(max = 100, message = "openId长度不能超过{max}")
    private String openId;

    /**
     * 前缀匹配，比如2022-09就是查2022年9月的，2022-09-01就是查9月1号的
     */
    private String purchaseTime;

}
