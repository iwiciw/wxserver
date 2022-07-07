package com.wx.common;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;

@Data
public class BaseResponse<T extends Serializable> implements Serializable {

    private Boolean success = Boolean.TRUE;

    private List<String> messages;

    private T vo;

    private List<T> voList;

    private Integer count;

    public static <T extends Serializable> BaseResponse<T> ok(List<T> voList, Integer count) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setVoList(voList);
        baseResponse.setCount(count);
        return baseResponse;
    }

    public static <T extends Serializable> BaseResponse<T> ok() {
        return new BaseResponse<>();
    }

    public static <T extends Serializable> BaseResponse<T> error(String message) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(false);
        baseResponse.setMessages(Lists.newArrayList(message));
        return baseResponse;
    }

    public static <T extends Serializable> BaseResponse<T> ok(List<T> voList) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setVoList(voList);
        return baseResponse;
    }

    public static <T extends Serializable> BaseResponse<T> ok(T vo) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setVo(vo);
        return baseResponse;
    }

}
