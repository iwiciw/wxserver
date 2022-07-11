package com.wx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.common.entity.TeaBrand;
import com.wx.common.so.teabrand.TeaBrandQuerySo;
import com.wx.common.vo.tearecord.TeaBrandVo;
import com.wx.mapper.TeaBrandMapper;
import com.wx.service.TeaBrandService;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author gdd
 * @since 2022-07-07
 */
@Service
public class TeaBrandServiceImpl extends ServiceImpl<TeaBrandMapper, TeaBrand> implements TeaBrandService {


    @Resource
    private TeaBrandMapper teaBrandMapper;

    @Override
    public List<TeaBrandVo> list(TeaBrandQuerySo so) {
        return teaBrandMapper.selectTeaBrandVoByQuerySo(so);
    }
}
