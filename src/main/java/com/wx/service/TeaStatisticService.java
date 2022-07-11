package com.wx.service;

import com.wx.common.so.teastatistic.TeaStatisticQuerySo;
import com.wx.common.vo.teastatistic.TeaStatisticVo;

public interface TeaStatisticService {

    TeaStatisticVo statistic(TeaStatisticQuerySo so);
}
