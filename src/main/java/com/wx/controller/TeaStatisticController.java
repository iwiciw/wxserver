package com.wx.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wx.common.BaseResponse;
import com.wx.common.annotation.DateTimeValidator;
import com.wx.common.enums.StaticType;
import com.wx.common.so.teastatistic.TeaStatisticQuerySo;
import com.wx.common.vo.teastatistic.TeaStatisticVo;
import com.wx.service.TeaStatisticService;
import com.wx.utils.DateUtils;
import com.wx.utils.Validator;

/**
 * 统计
 */
@RestController
@RequestMapping("/api/tea/statistic")
public class TeaStatisticController {

    @Resource
    private TeaStatisticService teaStatisticService;

    /**
     * 打卡页面奶茶统计，支持本周，月，年，累计，自定义统计
     * @param so
     * @return
     */
    @PostMapping("query")
    public BaseResponse<TeaStatisticVo> statistic(@RequestBody @Valid TeaStatisticQuerySo so) {
        if (StaticType.CUSTOM.equals(so.getStaticType())) {
            Validator.checkWithGroup(so, TeaStatisticQuerySo.CustomCheck.class);
        } else if (StaticType.MONTH.equals(so.getStaticType())) {
            Validator.checkWithGroup(so, TeaStatisticQuerySo.MonthCheck.class);
            Assert.isTrue(DateTimeValidator.isValid(so.getPurchaseTime(), "yyyy-MM"), "时间不合法");
        } else if (StaticType.YEAR.equals(so.getStaticType())) {
            Validator.checkWithGroup(so, TeaStatisticQuerySo.YearCheck.class);
            Assert.isTrue(DateTimeValidator.isValid(so.getPurchaseTime(), "yyyy"), "时间不合法");
        } else if (StaticType.THIS_WEEK.equals(so.getStaticType())) {
            Pair<String, String> pair = DateUtils.getCurrentWeek();
            so.setPurchaseTimeBegin(pair.getLeft());
            so.setPurchaseTimeEnd(pair.getRight());
        }
        return BaseResponse.ok(teaStatisticService.statistic(so));
    }
}
