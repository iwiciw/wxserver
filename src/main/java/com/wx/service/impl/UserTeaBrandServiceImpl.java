package com.wx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.common.entity.TeaBrand;
import com.wx.common.entity.UserTeaBrand;
import com.wx.common.so.teabrand.TeaBrandCreateSo;
import com.wx.common.so.userteabrand.UserTeaBrandCreateSo;
import com.wx.common.so.userteabrand.UserTeaBrandDeleteSo;
import com.wx.common.so.userteabrand.UserTeaBrandQuerySo;
import com.wx.common.vo.userteabrand.UserTeaBrandVo;
import com.wx.mapper.TeaBrandMapper;
import com.wx.mapper.UserTeaBrandMapper;
import com.wx.service.UserTeaBrandService;

import cn.hutool.core.convert.Convert;

/**
 * <p>
 * 我的品牌 服务实现类
 * </p>
 *
 * @author gdd
 * @since 2022-07-07
 */
@Service
public class UserTeaBrandServiceImpl extends ServiceImpl<UserTeaBrandMapper, UserTeaBrand>
    implements UserTeaBrandService {

    @Resource
    private UserTeaBrandMapper userTeaBrandMapper;

    @Resource
    private TeaBrandMapper teaBrandMapper;

    @Override
    public void create(TeaBrandCreateSo so) {
        Assert.isNull(
            teaBrandMapper
                .selectOne(new QueryWrapper<TeaBrand>().lambda().eq(TeaBrand::getBrandName, so.getBrandName())),
            "奶茶品牌已存在，请从品牌库添加");
        TeaBrand teaBrand = new TeaBrand();
        teaBrand.setBrandName(so.getBrandName());
        teaBrand.setOpenId(so.getOpenId());
        teaBrand.setPicUrl(so.getBrandPicUrl());

        teaBrandMapper.insert(teaBrand);

        UserTeaBrand userTeaBrand = new UserTeaBrand();
        userTeaBrand.setBrandId(teaBrand.getId());
        userTeaBrand.setOpenId(teaBrand.getOpenId());
        userTeaBrandMapper.insert(userTeaBrand);
    }

    @Override
    public void createFromLibary(UserTeaBrandCreateSo so) {
        Assert.notNull(teaBrandMapper.selectById(so.getBrandId()), "品牌库中该奶茶品牌不存在");

        int count = userTeaBrandMapper.selectCount(new QueryWrapper<UserTeaBrand>().lambda()
            .eq(UserTeaBrand::getOpenId, so.getOpenId()).eq(UserTeaBrand::getBrandId, so.getBrandId()));
        Assert.isTrue(count < 1, "用户已添加此品牌");

        UserTeaBrand userTeaBrand = Convert.convert(UserTeaBrand.class, so);
        userTeaBrandMapper.insert(userTeaBrand);
    }

    @Override
    public void delete(UserTeaBrandDeleteSo so) {
        userTeaBrandMapper.delete(new QueryWrapper<UserTeaBrand>().lambda()
            .eq(UserTeaBrand::getOpenId, so.getOpenId()).eq(UserTeaBrand::getBrandId, so.getBrandId()));
    }

    @Override
    public List<UserTeaBrandVo> list(UserTeaBrandQuerySo so) {
        return userTeaBrandMapper.selectUserTeaBrandVoByQuerySo(so);
    }
}
