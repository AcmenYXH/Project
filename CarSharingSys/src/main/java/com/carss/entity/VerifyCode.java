package com.carss.entity;

import java.util.Arrays;

/**
 * @Author: yangxh8
 * @Date: 2020-04-01 11:35:26
 * @Description:验证码类
 */
public class VerifyCode {

    /**
     * 验证码
     */
    private String code;

    /**
     * 验证码图片数组
     */
    private byte[] imgBytes;

    /**
     * 失效时间
     */
    private long expireTime;

    public VerifyCode() {
    }

    public VerifyCode(String code, byte[] imgBytes, long expireTime) {
        this.code = code;
        this.imgBytes = imgBytes;
        this.expireTime = expireTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte[] getImgBytes() {
        return imgBytes;
    }

    public void setImgBytes(byte[] imgBytes) {
        this.imgBytes = imgBytes;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "VerifyCode{" +
                "code='" + code + '\'' +
                ", imgBytes=" + Arrays.toString(imgBytes) +
                ", expireTime=" + expireTime +
                '}';
    }
}
