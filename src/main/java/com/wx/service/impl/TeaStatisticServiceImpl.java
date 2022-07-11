package com.wx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wx.common.so.teastatistic.TeaStatisticQuerySo;
import com.wx.common.vo.teastatistic.TeaStatisticVo;
import com.wx.mapper.TeaRecordMapper;
import com.wx.service.TeaStatisticService;

@Service
public class TeaStatisticServiceImpl implements TeaStatisticService {

    @Resource
    private TeaRecordMapper teaRecordMapper;

    @Override
    public TeaStatisticVo statistic(TeaStatisticQuerySo so) {
        TeaStatisticVo teaStatisticVo = teaRecordMapper.statistic(so);
        if (null == teaStatisticVo) {
            return teaStatisticVo;
        }
        teaStatisticVo.setTeaBrandStatisticVos(teaRecordMapper.brandStatistic(so));
        return teaStatisticVo;
    }
}
