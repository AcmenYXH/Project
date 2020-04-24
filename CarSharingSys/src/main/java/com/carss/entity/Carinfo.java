package com.carss.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class Carinfo {
    private Integer carid;

    private String brand;

    @Past(message = "添加时间不能是未来时间！")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addtime;

    private String status;

    private Double unitprice;

    private String longitude;

    private String latitude;

    private Integer repairnum;

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getAddtime() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return addtime == null ? null : sdf.format(addtime);
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Integer getRepairnum() {
        return repairnum;
    }

    public void setRepairnum(Integer repairnum) {
        this.repairnum = repairnum;
    }
}