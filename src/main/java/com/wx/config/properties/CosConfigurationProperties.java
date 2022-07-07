package com.wx.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "cos")
public class CosConfigurationProperties {
    private String secretId;

    private String secretKey;

    private String region;

    private String bucketName;

    private String path;

    private String url;
}
