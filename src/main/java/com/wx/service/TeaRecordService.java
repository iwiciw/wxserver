package com.wx.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wx.common.entity.TeaRecord;
import com.wx.common.so.tearecord.TeaRecordCreateSo;
import com.wx.common.so.tearecord.TeaRecordDeleteSo;
import com.wx.common.so.tearecord.TeaRecordQuerySo;
import com.wx.common.so.tearecord.TeaRecordUpdateSo;
import com.wx.common.vo.TeaRecordVo;

/**
 * <p>
 * 奶茶记录表 服务类
 * </p>
 *
 * @author gdd
 * @since 2022-07-07
 */
public interface TeaRecordService extends IService<TeaRecord> {
    void create(TeaRecordCreateSo so);

    void delete(TeaRecordDeleteSo so);

    void update(TeaRecordUpdateSo so);

    List<TeaRecordVo> list(TeaRecordQuerySo so);
}
