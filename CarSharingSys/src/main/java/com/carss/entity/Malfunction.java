package com.carss.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Malfunction {
    private Integer malid;

    @NotNull(message="用户编号不能为空！")
    private Integer userid;

    @NotNull(message="车辆编号不能为空！")
    private Integer carid;

    private String describe;

    @Past(message = "上报时间不能是未来时间！")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date reporttime;

    private String repairstatus;

    @Past(message = "受理时间不能是未来时间！")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date processtime;

    public Integer getMalid() {
        return malid;
    }

    public void setMalid(Integer malid) {
        this.malid = malid;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public Date getReporttime() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return reporttime == null ? null : sdf.format(reporttime);
    	return reporttime;
    }

    public void setReporttime(Date reporttime) {
        this.reporttime = reporttime;
    }

    public String getRepairstatus() {
        return repairstatus;
    }

    public void setRepairstatus(String repairstatus) {
        this.repairstatus = repairstatus == null ? null : repairstatus.trim();
    }

    public Date getProcesstime() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return processtime == null ? null : sdf.format(processtime);
    	return processtime;
    }

    public void setProcesstime(Date processtime) {
        this.processtime = processtime;
    }

	@Override
	public String toString() {
		return "Malfunction [malid=" + malid + ", userid=" + userid + ", carid=" + carid + ", describe=" + describe
				+ ", reporttime=" + reporttime + ", repairstatus=" + repairstatus + ", processtime=" + processtime
				+ "]";
	}
    
    
}