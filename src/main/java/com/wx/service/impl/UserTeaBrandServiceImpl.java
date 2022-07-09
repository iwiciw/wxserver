package com.wx.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.common.entity.UserTeaBrand;
import com.wx.common.so.teabrand.TeaBrandCreateSo;
import com.wx.common.so.userteabrand.UserTeaBrandCreateSo;
import com.wx.common.so.userteabrand.UserTeaBrandDeleteSo;
import com.wx.common.so.userteabrand.UserTeaBrandQuerySo;
import com.wx.common.vo.userteabrand.UserTeaBrandVo;
import com.wx.mapper.UserTeaBrandMapper;
import com.wx.service.UserTeaBrandService;

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

    @Override
    public void create(UserTeaBrandCreateSo so) {

    }

    @Override
    public void createFromLibary(TeaBrandCreateSo so) {

    }

    @Override
    public void delete(UserTeaBrandDeleteSo so) {

    }

    @Override
    public List<UserTeaBrandVo> list(UserTeaBrandQuerySo so) {
        return null;
    }
}
