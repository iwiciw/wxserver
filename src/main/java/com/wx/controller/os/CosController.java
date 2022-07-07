package com.wx.controller.os;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wx.common.BaseResponse;
import com.wx.utils.CosUtil;

/**
 * 图片上传腾讯云
 */
@RestController
@RequestMapping("/api/tea/cos")
public class CosController {

    @Resource
    private CosUtil cosUtil;

    /**
     * 上传
     * @param file
     * @return
     */
    @PostMapping(value = "upload")
    public BaseResponse<String> upload(@RequestParam(value = "file") MultipartFile file) {
        return BaseResponse.ok(cosUtil.upload(file));
    }

    /**
     * 删除
     * @param uuid
     * @return
     */
    @PostMapping("delete")
    public BaseResponse delete(@RequestParam(value = "uuid") String uuid) {
        cosUtil.delete(uuid);
        return BaseResponse.ok();
    }
}
