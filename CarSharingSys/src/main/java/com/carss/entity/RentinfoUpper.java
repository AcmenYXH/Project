package com.carss.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RentinfoUpper {
    private Integer RENTID;

    private String USERACCOUNT;
    
    private Integer USERID;

    private Integer CARID;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mi:ss")
    private Date RENTALTIME;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mi:ss")
    private Date RETURNTIME;

    private Double AMOUNT;

    private String STARTLNG;

    private String STARTLAT;

    private String ENDLNG;

    private String ENDLAT;

    private String ISPLAY;

    private String TRADENO;

	public Integer getRENTID() {
		return RENTID;
	}

	public void setRENTID(Integer rENTID) {
		RENTID = rENTID;
	}

	public String getUSERACCOUNT() {
		return USERACCOUNT;
	}

	public void setUSERACCOUNT(String uSERACCOUNT) {
		USERACCOUNT = uSERACCOUNT;
	}

	public Integer getUSERID() {
		return USERID;
	}

	public void setUSERID(Integer uSERID) {
		USERID = uSERID;
	}

	public Integer getCARID() {
		return CARID;
	}

	public void setCARID(Integer cARID) {
		CARID = cARID;
	}

	public String getRENTALTIME() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return RENTALTIME == null ? null : sdf.format(RENTALTIME);
	}

	public void setRENTALTIME(Date rENTALTIME) {
		RENTALTIME = rENTALTIME;
	}

	public String getRETURNTIME() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return RETURNTIME == null ? null : sdf.format(RETURNTIME);
	}

	public void setRETURNTIME(Date rETURNTIME) {
		RETURNTIME = rETURNTIME;
	}

	public Double getAMOUNT() {
		return AMOUNT;
	}

	public void setAMOUNT(Double aMOUNT) {
		AMOUNT = aMOUNT;
	}

	public String getSTARTLNG() {
		return STARTLNG;
	}

	public void setSTARTLNG(String sTARTLNG) {
		STARTLNG = sTARTLNG;
	}

	public String getSTARTLAT() {
		return STARTLAT;
	}

	public void setSTARTLAT(String sTARTLAT) {
		STARTLAT = sTARTLAT;
	}

	public String getENDLNG() {
		return ENDLNG;
	}

	public void setENDLNG(String eNDLNG) {
		ENDLNG = eNDLNG;
	}

	public String getENDLAT() {
		return ENDLAT;
	}

	public void setENDLAT(String eNDLAT) {
		ENDLAT = eNDLAT;
	}

	public String getISPLAY() {
		return ISPLAY;
	}

	public void setISPLAY(String iSPLAY) {
		ISPLAY = iSPLAY;
	}

	public String getTRADENO() {
		return TRADENO;
	}

	public void setTRADENO(String TRADENO) {
		this.TRADENO = TRADENO;
	}
}