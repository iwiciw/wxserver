package com.wx.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.common.entity.TeaBrand;
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

}
