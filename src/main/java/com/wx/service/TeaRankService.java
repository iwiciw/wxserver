package com.wx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wx.common.entity.TeaRecord;
import com.wx.common.so.tearank.TeaRankSo;
import com.wx.common.so.tearecord.TeaRecordCreateSo;
import com.wx.common.so.tearecord.TeaRecordDeleteSo;
import com.wx.common.so.tearecord.TeaRecordQuerySo;
import com.wx.common.so.tearecord.TeaRecordUpdateSo;
import com.wx.common.vo.TeaRecordVo;
import com.wx.common.vo.tearank.TeaRankVo;

import java.util.List;

/**
 * <p>
 * 奶茶排行榜 服务类
 * </p>
 *
 * @author dp
 * @since 2022-07-07
 */
public interface TeaRankService {

    TeaRankVo list(TeaRankSo so);
}
