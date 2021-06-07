package com.Faatak.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VisitorModel {
	@Id
	private int vid;

	private String visitorName;

	private String address;

	private int ownerFlatId;

	private String mobileNo;

	public VisitorModel(int vid, String visitorName, String address, int ownerFlatId, String mobileNo) {
		super();
		this.vid = vid;
		this.visitorName = visitorName;
		this.address = address;
		this.ownerFlatId = ownerFlatId;
		this.mobileNo = mobileNo;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getOwnerFlatId() {
		return ownerFlatId;
	}

	public void setOwnerFlatId(int ownerFlatId) {
		this.ownerFlatId = ownerFlatId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public VisitorModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "visitorData [vid=" + vid + ", visitorName=" + visitorName + ", address=" + address + ", ownerFlatId="
				+ ownerFlatId + ", mobileNo=" + mobileNo + "]";
	}

}