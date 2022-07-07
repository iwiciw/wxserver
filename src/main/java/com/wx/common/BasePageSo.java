package com.wx.common;

import java.io.Serializable;

import lombok.Data;

@Data
public class BasePageSo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页面数
     */
    private Integer pageNumber = 1;

    /**
     * 页面数
     */
    private Integer pageSize = 50;
}
