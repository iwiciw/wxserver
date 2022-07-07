package com.wx.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.common.entity.TeaRecord;
import com.wx.mapper.TeaRecordMapper;
import com.wx.service.TeaRecordService;

/**
 * <p>
 * 奶茶记录表 服务实现类
 * </p>
 *
 * @author gdd
 * @since 2022-07-07
 */
@Service
public class TeaRecordServiceImpl extends ServiceImpl<TeaRecordMapper, TeaRecord> implements TeaRecordService {

}
