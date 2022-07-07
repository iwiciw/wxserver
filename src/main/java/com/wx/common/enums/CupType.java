package com.wx.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CupType {
    NORMAL("常规"), BIG("大杯"), MEDIUM("中杯"), SMALL("小杯");

    private String desc;

}
