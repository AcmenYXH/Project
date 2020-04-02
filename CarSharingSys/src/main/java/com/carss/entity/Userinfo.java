package com.carss.entity;

import javax.validation.constraints.*;

public class Userinfo {
    private Integer userid;

    @NotNull(message = "账号不能为空！")
    private String useraccount;

    @NotBlank(message = "密码去掉首尾空格后长度不能为 0！")
    @Size(min = 6,max = 15,message = "密码长度为6-15位字符！")
    private String password;

    private String username;

    private String idcard;

    @Size(min=11,max=11,message = "手机号不足11位！")
    private String phone;

    private String isdeposit;

    @Positive(message = "余额不能为负数！")
    private Double purse;

    @Positive(message = "积分不能为负数！")
    private Integer integral;

    @Positive(message = "信用积分不能为负数！")
    private Integer credit;

    
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount == null ? null : useraccount.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIsdeposit() {
        return isdeposit;
    }

    public void setIsdeposit(String isdeposit) {
        this.isdeposit = isdeposit == null ? null : isdeposit.trim();
    }

    public Double getPurse() {
        return purse;
    }

    public void setPurse(Double purse) {
        this.purse = purse;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}