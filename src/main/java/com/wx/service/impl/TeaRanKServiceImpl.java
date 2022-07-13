package com.wx.service.impl;

import com.wx.common.enums.RankType;
import com.wx.common.so.tearank.TeaRankSo;
import com.wx.common.vo.tearank.TeaRankBrandVo;
import com.wx.common.vo.tearank.TeaRankProductVo;
import com.wx.common.vo.tearank.TeaRankVo;
import com.wx.mapper.TeaRankMapper;
import com.wx.service.TeaRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TeaRanKServiceImpl implements TeaRankService {

    @Resource
    private TeaRankMapper teaRankMapper;

    @Override
    public TeaRankVo list(TeaRankSo so) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Calendar cld = Calendar.getInstance(Locale.CHINA);
        cld.setFirstDayOfWeek(Calendar.MONDAY);
        cld.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String monday = df.format(cld.getTime());
        String today = df.format(new Date());
        TeaRankVo teaRankVo = new TeaRankVo();
        if (RankType.BRAND_WEEK.equals(so.getRankType())) {
            List<TeaRankBrandVo> teaRankBrandVoList = teaRankMapper.selectBrandRankList(monday);
            teaRankVo.setBrandWeekVos(teaRankBrandVoList);
        } else if (RankType.BRAND_ALL.equals(so.getRankType())) {
            List<TeaRankBrandVo> teaRankBrandVoList = teaRankMapper.selectBrandRankList(null);
            teaRankVo.setBrandAllVos(teaRankBrandVoList);
        } else if (RankType.PRODUCT_WEEK.equals(so.getRankType())) {
            List<TeaRankProductVo> teaRankProductVoList = teaRankMapper.selectProductRankList(monday);
            teaRankVo.setProductWeekVos(teaRankProductVoList);
        } else if (RankType.PRODUCT_ALL.equals(so.getRankType())) {
            List<TeaRankProductVo> teaRankProductVoList = teaRankMapper.selectProductRankList(null);
            teaRankVo.setProductAllVos(teaRankProductVoList);
        }
        return teaRankVo;
    }

    public static void main(String[] args){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Calendar cld = Calendar.getInstance(Locale.CHINA);
        cld.setFirstDayOfWeek(Calendar.MONDAY);
        cld.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String monDate = df.format(cld.getTime());
        String today = df.format(new Date());
        String str="123";
    }
}
