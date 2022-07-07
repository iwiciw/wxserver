package com.wx.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wx.common.BaseResponse;
import com.wx.common.so.teabrand.TeaBrandCreateSo;
import com.wx.common.so.userteabrand.UserTeaBrandCreateSo;
import com.wx.common.so.userteabrand.UserTeaBrandDeleteSo;
import com.wx.common.so.userteabrand.UserTeaBrandQuerySo;
import com.wx.common.vo.userteabrand.UserTeaBrandVo;
import com.wx.service.UserTeaBrandService;

/**
 * 我的品牌
 */
@RestController
@RequestMapping("/api/user/tea/brand")
public class UserTeaBrandController {

    @Resource
    private UserTeaBrandService userTeaBrandService;

    /**
     * 自定义添加-内置图标-后续开发根据品牌名称进行修正
     * @param so
     * @return
     */
    @PostMapping("create")
    public BaseResponse create(@RequestBody @Valid UserTeaBrandCreateSo so) {
        return BaseResponse.ok();
    }

    /**
     * 从品牌库添加
     * @param so
     * @return
     */
    @PostMapping("createFromLibary")
    public BaseResponse createFromLibary(@RequestBody @Valid TeaBrandCreateSo so) {
        return BaseResponse.ok();
    }

    /**
     * 删除
     * @param so
     * @return
     */
    @PostMapping("delete")
    public BaseResponse delete(@RequestBody @Valid UserTeaBrandDeleteSo so) {
        return BaseResponse.ok();
    }

    /**
     * 列表查询
     * @param so
     * @return
     */
    @PostMapping("list")
    public BaseResponse<UserTeaBrandVo> list(@RequestBody @Valid UserTeaBrandQuerySo so) {
        return BaseResponse.ok();
    }

}
