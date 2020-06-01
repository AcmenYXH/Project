package com.carss.entity;

/**
 * @Author: yangxh8
 * @Date: 2020-05-26 10:55:34
 * @Description:
 */
public class LoginRequest {
    private String account;
    private String password;
    private String verifyCode;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public LoginRequest() {
    }

    public LoginRequest(String account, String password, String verifyCode) {
        this.account = account;
        this.password = password;
        this.verifyCode = verifyCode;
    }
}
