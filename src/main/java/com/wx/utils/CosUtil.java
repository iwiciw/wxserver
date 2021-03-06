package com.wx.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.model.COSObject;
import com.qcloud.cos.model.ObjectMetadata;
import com.wx.common.exception.BizException;
import com.wx.config.properties.CosConfigurationProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CosUtil {

    @Resource
    private COSClient cosClient;

    @Resource
    private CosConfigurationProperties cosConfigurationProperties;

    public String upload(MultipartFile file) {
        String fileUrl = getUrl(UUID.randomUUID().toString());
        try {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            Map<String, String> userMetadata = new HashMap<>();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getBytes().length);
            objectMetadata.setUserMetadata(userMetadata);
            cosClient.putObject(cosConfigurationProperties.getBucketName(), fileUrl, file.getInputStream(),
                objectMetadata);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return cosConfigurationProperties.getUrl() + fileUrl;
    }

    public Pair<String, InputStream> download(String uuid) {
        if (!cosClient.doesObjectExist(cosConfigurationProperties.getBucketName(), getUrl(uuid))) {
            return null;
        }
        COSObject CosObject = cosClient.getObject(cosConfigurationProperties.getBucketName(), getUrl(uuid));
        return Pair.of(CosObject.getObjectMetadata().getUserMetadata().get("fileName"), CosObject.getObjectContent());
    }

    public Boolean delete(String uuid) {
        // ??????BucketName,objectName????????????
        cosClient.deleteObject(cosConfigurationProperties.getBucketName(), getUrl(uuid));
        return Boolean.TRUE;
    }

    /**
     * ?????????????????????????????????????????????base64????????????????????????????????????data:image/png;base64,????????????????????????png????????????
     * ????????????????????????????????????????????????????????????base64?????????????????????
     * @param base64Str
     * @return
     */
    public String upload(String base64Str) {
        String[] d = base64Str.split("base64,");
        String dataPrefix;
        String data;
        if (d.length == 2) {
            dataPrefix = d[0];
            data = d[1];
        } else {
            log.error("??????????????????????????????,base64Str:" + base64Str);
            throw new BizException("??????????????????????????????");
        }

        String fileName = getFileName(dataPrefix);
        byte[] fileOut = base64ToBytes(data);
        // ???????????????(dev/2020/9/12/UUID.png)
        String fileKey = cosConfigurationProperties.getPath() + "/" + calculatePath() + fileName;
        // ??????????????????
        this.uploadFile2Tx(fileKey, fileOut);
        return cosConfigurationProperties.getUrl() + fileKey;
    }

    public void uploadFile2Tx(String fileName, byte[] fileBytes) {
        ByteArrayInputStream input = null;
        try {
            input = new ByteArrayInputStream(fileBytes);
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(input.available());
            cosClient.putObject(cosConfigurationProperties.getBucketName(), fileName, input, objectMetadata);
        } catch (CosClientException serviceExp) {
            log.error("??????????????????", serviceExp);
            throw new BizException("??????????????????", serviceExp);
        }
    }

    /**
     * ?????????base64???????????????
     *
     * @param base64Str base64????????????
     * @return ????????????
     */
    public byte[] base64ToBytes(String base64Str) {
        Assert.notNull(base64Str, "base64Str empty");
        return Base64.decodeBase64(base64Str);
    }

    /**
     * ??????????????????????????????
     *
     * @return ?????????
     */
    public String calculatePath() {
        Calendar calendar = Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String date = String.valueOf(calendar.get(Calendar.DATE));
        return year + "/" + month + "/" + date + "/";
    }

    /**
     * ??????????????????UUID+.??????
     */
    public String getFileName(String dataPrix) {
        String suffix;
        if ("data:image/jpg;".equalsIgnoreCase(dataPrix)) {
            suffix = ".jpg";
        } else if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {
            suffix = ".jpg";
        } else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {
            suffix = ".ico";
        } else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {
            suffix = ".gif";
        } else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {
            suffix = ".png";
        } else {
            throw new BizException("???????????????????????????");
        }
        return UUID.randomUUID() + suffix;
    }

    private String getUrl(String uuid) {
        String fileDir = cosConfigurationProperties.getPath();
        if (!fileDir.endsWith("/")) {
            fileDir = fileDir.concat("/");
        }
        return fileDir + uuid;
    }
}
