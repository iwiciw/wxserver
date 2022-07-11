package com.wx.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wx.common.entity.TeaBrand;
import com.wx.common.so.teabrand.TeaBrandQuerySo;
import com.wx.common.vo.tearecord.TeaBrandVo;

/**
 * <p>
 * 品牌表 Mapper 接口
 * </p>
 *
 * @author gdd
 * @since 2022-07-07
 */
public interface TeaBrandMapper extends BaseMapper<TeaBrand> {

    List<TeaBrandVo> selectTeaBrandVoByQuerySo(TeaBrandQuerySo so);

}
