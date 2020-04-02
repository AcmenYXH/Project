package com.carss.entity;

import java.util.Arrays;

public class UserinfoWithBLOBs extends Userinfo {
//    private Object icon;
//
//    private Object licence;
//
//    public Object getIcon() {
//        return icon;
//    }
//
//    public void setIcon(Object icon) {
//        this.icon = icon;
//    }
//
//    public Object getLicence() {
//        return licence;
//    }
//
//    public void setLicence(Object licence) {
//        this.licence = licence;
//    }
	private byte[] icon;

    private byte[] licence;

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}

	public byte[] getLicence() {
		return licence;
	}

	public void setLicence(byte[] licence) {
		this.licence = licence;
	}

	@Override
	public String toString() {
		return "UserinfoWithBLOBs [icon=" + Arrays.toString(icon) + ", licence=" + Arrays.toString(licence) + "]";
	}
	
	

}