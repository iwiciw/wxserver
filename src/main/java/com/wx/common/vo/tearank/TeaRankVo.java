package com.wx.common.vo.tearank;

import java.util.List;

import com.wx.common.BaseVo;

import lombok.Data;

@Data
public class TeaRankVo extends BaseVo {

    /**
     * 品牌周榜 默认前20
     */
    private List<TeaRankBrandVo> brandWeekVos;

    /**
     * 品牌总榜 默认前20
     */
    private List<TeaRankBrandVo> brandAllVos;

    /**
     * 单品周榜 默认前20
     */
    private List<TeaRankProductVo> productWeekVos;

    /**
     * 单品总榜 默认前20
     */
    private List<TeaRankProductVo> productAllVos;
}
