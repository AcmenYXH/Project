package com.carss.entity;

public class Admininfo {
    private Integer adminid;

    private String adminname;

    private String adminpsd;

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    public String getAdminpsd() {
        return adminpsd;
    }

    public void setAdminpsd(String adminpsd) {
        this.adminpsd = adminpsd == null ? null : adminpsd.trim();
    }
}