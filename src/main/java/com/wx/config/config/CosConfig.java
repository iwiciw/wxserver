package com.wx.config.config;

import javax.annotation.Resource;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import com.wx.config.properties.CosConfigurationProperties;

@Configuration
@EnableConfigurationProperties({CosConfigurationProperties.class})
public class CosConfig {

    @Resource
    private CosConfigurationProperties cosConfigurationProperties;

    @Bean
    public COSClient getCosClient() {
        // 1 初始化用户身份信息(secretId, secretKey)。
        COSCredentials cred = new BasicCOSCredentials(cosConfigurationProperties.getSecretId(),
            cosConfigurationProperties.getSecretKey());
        // 2 设置 bucket 区域。
        ClientConfig clientConfig = new ClientConfig(new Region(cosConfigurationProperties.getRegion()));
        // 3 生成 cos 客户端。
        return new COSClient(cred, clientConfig);
    }
}
