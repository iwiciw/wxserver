package com.wx.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StaticType {
    THIS_WEEK("本周"), MONTH("月"), YEAR("年"), CUSTOM("自定义"), ALL("累计所有");

    private String desc;
}
