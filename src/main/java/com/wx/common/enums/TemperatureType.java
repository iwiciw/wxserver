package com.wx.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TemperatureType {
    HOT("热"), NORMAL("常温"), ICE("冰"), LITTLE_IC("少冰"), NO_ICE("去冰");

    private String desc;
}
