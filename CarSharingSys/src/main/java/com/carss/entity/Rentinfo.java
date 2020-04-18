package com.carss.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Rentinfo {
    private Integer rentid;

    @NotNull(message = "用户编号不能为空！")
    private Integer userid;

    @NotNull(message = "车辆编号不能为空！")
    private Integer carid;

    @Past(message = "行程开始时间不能是未来时间！")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date rentaltime;

    @Past(message = "行程结束时间不能是未来时间！")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date returntime;

    @PositiveOrZero(message = "租赁金额不能为负数")
    private Double amount;

    private String startlng;

    private String startlat;

    private String endlng;

    private String endlat;

    private String isplay;

    private String tradeNo;

    public Integer getRentid() {
        return rentid;
    }

    public void setRentid(Integer rentid) {
        this.rentid = rentid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getRentaltime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return rentaltime == null ? null : sdf.format(rentaltime);
    }

    public void setRentaltime(Date rentaltime) {
        this.rentaltime = rentaltime;
    }

    public String getReturntime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return returntime == null ? null : sdf.format(returntime);
    }

    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStartlng() {
        return startlng;
    }

    public void setStartlng(String startlng) {
        this.startlng = startlng == null ? null : startlng.trim();
    }

    public String getStartlat() {
        return startlat;
    }

    public void setStartlat(String startlat) {
        this.startlat = startlat == null ? null : startlat.trim();
    }

    public String getEndlng() {
        return endlng;
    }

    public void setEndlng(String endlng) {
        this.endlng = endlng == null ? null : endlng.trim();
    }

    public String getEndlat() {
        return endlat;
    }

    public void setEndlat(String endlat) {
        this.endlat = endlat == null ? null : endlat.trim();
    }

    public String getIsplay() {
        return isplay;
    }

    public void setIsplay(String isplay) {
        this.isplay = isplay == null ? null : isplay.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}