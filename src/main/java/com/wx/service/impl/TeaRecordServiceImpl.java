package com.wx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.common.entity.TeaRecord;
import com.wx.common.entity.TeaRecordDetail;
import com.wx.common.so.tearecord.TeaRecordCreateSo;
import com.wx.common.so.tearecord.TeaRecordDeleteSo;
import com.wx.common.so.tearecord.TeaRecordQuerySo;
import com.wx.common.so.tearecord.TeaRecordUpdateSo;
import com.wx.common.vo.TeaRecordVo;
import com.wx.mapper.TeaBrandMapper;
import com.wx.mapper.TeaRecordDetailMapper;
import com.wx.mapper.TeaRecordMapper;
import com.wx.service.TeaRecordService;
import com.wx.utils.CosUtil;

import cn.hutool.core.convert.Convert;

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

    @Resource
    private TeaRecordMapper teaRecordMapper;

    @Resource
    private TeaRecordDetailMapper teaRecordDetailMapper;

    @Resource
    private TeaBrandMapper teaBrandMapper;

    @Resource
    private CosUtil cosUtil;

    /**
     * 同一天最多打卡5次
     * @param so
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(TeaRecordCreateSo so) {
        Assert.notNull(teaBrandMapper.selectById(so.getBrandId()), "奶茶品牌不存在");
        int count = teaRecordMapper.selectCount(new QueryWrapper<TeaRecord>().lambda()
            .eq(TeaRecord::getOpenId, so.getOpenId()).eq(TeaRecord::getPurchaseTime, so.getPurchaseTime()));
        Assert.isTrue(count < 8, "同一天最多打卡5次");

        // 插入tea_record
        TeaRecord teaRecord = Convert.convert(TeaRecord.class, so);
        teaRecordMapper.insert(teaRecord);

        // 插入tea_record_detail
        TeaRecordDetail teaRecordDetail = Convert.convert(TeaRecordDetail.class, so);
        teaRecordDetail.setRecordId(teaRecord.getId());
        teaRecordDetailMapper.insert(teaRecordDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(TeaRecordDeleteSo so) {
        // 删除tea_record
        teaRecordMapper.delete(new QueryWrapper<TeaRecord>().lambda().eq(TeaRecord::getOpenId, so.getOpenId())
            .eq(TeaRecord::getId, so.getId()));

        // 删除tea_record_detail
        TeaRecordDetail teaRecordDetail = teaRecordDetailMapper.selectOne(new QueryWrapper<TeaRecordDetail>().lambda()
            .eq(TeaRecordDetail::getOpenId, so.getOpenId()).eq(TeaRecordDetail::getRecordId, so.getId()));

        if (null == teaRecordDetail) {
            return;
        }
        teaRecordDetailMapper.delete(new QueryWrapper<TeaRecordDetail>().lambda()
            .eq(TeaRecordDetail::getOpenId, so.getOpenId()).eq(TeaRecordDetail::getRecordId, so.getId()));

        // cos删除图片
        if (StringUtils.isNotBlank(teaRecordDetail.getPicUrl())) {
            cosUtil.delete(teaRecordDetail.getPicUrl());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TeaRecordUpdateSo so) {
        // 更新tea_record
        TeaRecord dbTeaRecord = teaRecordMapper.selectOne(new QueryWrapper<TeaRecord>().lambda()
            .eq(TeaRecord::getOpenId, so.getOpenId()).eq(TeaRecord::getId, so.getId()));
        Assert.notNull(dbTeaRecord, "奶茶记录不存在");

        Assert.notNull(teaBrandMapper.selectById(so.getBrandId()), "奶茶品牌不存在");

        TeaRecord teaRecord = Convert.convert(TeaRecord.class, so);
        teaRecord.setCreateTime(dbTeaRecord.getCreateTime());
        teaRecord.setLockVersion(dbTeaRecord.getLockVersion());
        teaRecordMapper.updateById(teaRecord);

        // 更新tea_record_detail
        TeaRecordDetail dbTeaRecordDetail = teaRecordDetailMapper.selectOne(new QueryWrapper<TeaRecordDetail>().lambda()
            .eq(TeaRecordDetail::getOpenId, so.getOpenId()).eq(TeaRecordDetail::getRecordId, so.getId()));
        Assert.notNull(dbTeaRecordDetail, "奶茶详情记录不存在");

        TeaRecordDetail teaRecordDetail = Convert.convert(TeaRecordDetail.class, so);
        teaRecordDetail.setRecordId(teaRecord.getId());
        teaRecordDetail.setCreateTime(dbTeaRecordDetail.getCreateTime());
        teaRecordDetail.setLockVersion(dbTeaRecordDetail.getLockVersion());
        teaRecordDetail.setId(dbTeaRecordDetail.getId());
        teaRecordDetailMapper.updateById(teaRecordDetail);
    }

    @Override
    public List<TeaRecordVo> list(TeaRecordQuerySo so) {
        return teaRecordMapper.selectTeaRecordVosByQuerySo(so);
    }
}
