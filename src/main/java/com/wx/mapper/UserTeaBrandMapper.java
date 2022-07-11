package com.wx.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wx.common.entity.UserTeaBrand;
import com.wx.common.so.userteabrand.UserTeaBrandQuerySo;
import com.wx.common.vo.userteabrand.UserTeaBrandVo;

/**
 * <p>
 * 我的品牌 Mapper 接口
 * </p>
 *
 * @author gdd
 * @since 2022-07-07
 */
public interface UserTeaBrandMapper extends BaseMapper<UserTeaBrand> {

    List<UserTeaBrandVo> selectUserTeaBrandVoByQuerySo(UserTeaBrandQuerySo so);

}
