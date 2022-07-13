package com.wx.mapper;

import com.wx.common.vo.tearank.TeaRankBrandVo;
import com.wx.common.vo.tearank.TeaRankProductVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 奶茶排行榜 Mapper 接口
 * </p>
 *
 * @author dp
 * @since 2022-07-07
 */
public interface TeaRankMapper {
    /**
     * 品牌榜
     * @param monday
     * @return
     */
    List<TeaRankBrandVo> selectBrandRankList(@Param("monday") String monday);

    /**
     * 产品榜
     * @param monday
     * @return
     */
    List<TeaRankProductVo> selectProductRankList(@Param("monday") String monday);

}
