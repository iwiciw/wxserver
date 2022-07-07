package com.wx.common.so.tearank;

import com.wx.common.BaseSo;
import com.wx.common.enums.RankType;

import lombok.Data;

@Data
public class TeaRankSo extends BaseSo {
    /**
     * 排行榜维度
     */
    public RankType rankType;
}
