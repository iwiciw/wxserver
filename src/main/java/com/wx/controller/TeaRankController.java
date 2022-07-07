package com.wx.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wx.common.BaseResponse;
import com.wx.common.so.tearank.TeaRankSo;
import com.wx.common.vo.tearank.TeaRankVo;

/**
 * 排行榜
 */
@RestController
@RequestMapping("/api/tea/rank")
public class TeaRankController {

    /**
     * 列表
     * @param so
     * @return
     */
    @PostMapping
    public BaseResponse<TeaRankVo> list(@RequestBody TeaRankSo so) {
        return BaseResponse.ok();
    }
}
