package com.wx.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wx.common.BaseResponse;
import com.wx.common.so.tearecord.TeaRecordCreateSo;
import com.wx.common.so.tearecord.TeaRecordDeleteSo;
import com.wx.common.so.tearecord.TeaRecordQuerySo;
import com.wx.common.so.tearecord.TeaRecordUpdateSo;
import com.wx.common.vo.TeaRecordVo;
import com.wx.service.TeaRecordService;

/**
 * 奶茶记录
 */
@RestController
@RequestMapping("/api/tea/record")
public class TeaRecordController {

    @Resource
    private TeaRecordService teaRecordService;

    /**
     * 创建奶茶消费记录
     * @param so
     * @return
     */
    @PostMapping("create")
    public BaseResponse create(@RequestBody @Valid TeaRecordCreateSo so) {
        teaRecordService.create(so);
        return BaseResponse.ok();
    }

    /**
     * 删除奶茶消费记录
     * @param so
     * @return
     */
    @PostMapping("delete")
    public BaseResponse delete(@RequestBody @Valid TeaRecordDeleteSo so) {
        teaRecordService.delete(so);
        return BaseResponse.ok();
    }

    /**
     * 更新奶茶消费记录
     * @param so
     * @return
     */
    @PostMapping("update")
    public BaseResponse update(@RequestBody @Valid TeaRecordUpdateSo so) {
        teaRecordService.update(so);
        return BaseResponse.ok();
    }

    /**
     * 消费记录查询
     * @param so
     * @return
     */
    @PostMapping("list")
    public BaseResponse<TeaRecordVo> list(@RequestBody @Valid TeaRecordQuerySo so) {
        return BaseResponse.ok(teaRecordService.list(so));
    }
}
