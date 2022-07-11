package com.wx.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wx.common.entity.UserTeaBrand;
import com.wx.common.so.teabrand.TeaBrandCreateSo;
import com.wx.common.so.userteabrand.UserTeaBrandCreateSo;
import com.wx.common.so.userteabrand.UserTeaBrandDeleteSo;
import com.wx.common.so.userteabrand.UserTeaBrandQuerySo;
import com.wx.common.vo.userteabrand.UserTeaBrandVo;

/**
 * <p>
 * 我的品牌 服务类
 * </p>
 *
 * @author gdd
 * @since 2022-07-07
 */
public interface UserTeaBrandService extends IService<UserTeaBrand> {
    void create(TeaBrandCreateSo so);

    void createFromLibary(UserTeaBrandCreateSo so);

    void delete(UserTeaBrandDeleteSo so);

    List<UserTeaBrandVo> list(UserTeaBrandQuerySo so);

}
