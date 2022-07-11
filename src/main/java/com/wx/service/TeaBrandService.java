package com.wx.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wx.common.entity.TeaBrand;
import com.wx.common.so.teabrand.TeaBrandQuerySo;
import com.wx.common.vo.tearecord.TeaBrandVo;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author gdd
 * @since 2022-07-07
 */
public interface TeaBrandService extends IService<TeaBrand> {

    List<TeaBrandVo> list(TeaBrandQuerySo so);
}
