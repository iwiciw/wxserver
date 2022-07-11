package com.wx.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wx.common.entity.TeaRecord;
import com.wx.common.so.tearecord.TeaRecordQuerySo;
import com.wx.common.so.teastatistic.TeaStatisticQuerySo;
import com.wx.common.vo.TeaRecordVo;
import com.wx.common.vo.teastatistic.TeaBrandStatisticVo;
import com.wx.common.vo.teastatistic.TeaStatisticVo;

/**
 * <p>
 * 奶茶记录表 Mapper 接口
 * </p>
 *
 * @author gdd
 * @since 2022-07-07
 */
public interface TeaRecordMapper extends BaseMapper<TeaRecord> {

    List<TeaRecordVo> selectTeaRecordVosByQuerySo(TeaRecordQuerySo so);

    /**
     * 首页统计分析
     * @param so
     * @return
     */
    TeaStatisticVo statistic(TeaStatisticQuerySo so);

    /**
     * 首页统计分析
     * @param so
     * @return
     */
    List<TeaBrandStatisticVo> brandStatistic(TeaStatisticQuerySo so);

}
