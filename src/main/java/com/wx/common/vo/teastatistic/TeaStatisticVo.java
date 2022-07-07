package com.wx.common.vo.teastatistic;

import java.math.BigDecimal;
import java.util.List;

import com.wx.common.BaseVo;

import lombok.Data;

@Data
public class TeaStatisticVo extends BaseVo {

    /**
     * 累计杯数
     */
    private Integer totalCup;

    /**
     * 累计消费
     */
    private BigDecimal totalPrice;

    /**
     * 累计糖度
     */
    private Integer totalBrix;

    /**
     * 品牌统计列表
     */
    private List<TeaBrandStatisticVo> teaBrandStatisticVos;
}
