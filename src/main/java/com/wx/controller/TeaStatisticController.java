package com.wx.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wx.common.BaseResponse;
import com.wx.common.so.teastatistic.TeaStatisticQuerySo;
import com.wx.common.vo.teastatistic.TeaStatisticVo;

/**
 * 统计
 */
@RestController
@RequestMapping("/api/tea/statistic")
public class TeaStatisticController {

    /**
     * 打卡页面奶茶统计，支持本周，月，年，累计，自定义统计
     * @param so
     * @return
     */
    @PostMapping("query")
    public BaseResponse<TeaStatisticVo> statistic(@RequestBody @Valid TeaStatisticQuerySo so) {
        return BaseResponse.ok();
    }
}
