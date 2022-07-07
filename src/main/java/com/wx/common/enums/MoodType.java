package com.wx.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MoodType {
    NORMAL("平常"), RELAX("放松"), HAPPY("高兴"), SAD("难过"), ANXIETY("焦虑"), OTHER("其他");

    private String desc;
}
