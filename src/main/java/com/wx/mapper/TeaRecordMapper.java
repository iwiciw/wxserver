package com.wx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wx.common.entity.TeaRecord;
import com.wx.common.so.tearecord.TeaRecordQuerySo;
import com.wx.common.vo.TeaRecordVo;

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
}
