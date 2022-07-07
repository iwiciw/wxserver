package com.wx.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RankType {
    BRAND_WEEK("品牌周榜"), BRAND_ALL("品牌总榜"), PRODUCT_WEEK("单品周榜"), PRODUCT_ALL("单品总榜");

    private String desc;
}
