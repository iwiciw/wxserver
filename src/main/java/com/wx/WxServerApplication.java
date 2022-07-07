package com.wx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wx.mapper")
public class WxServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxServerApplication.class, args);
    }
}
