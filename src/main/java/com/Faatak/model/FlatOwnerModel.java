package com.Faatak.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FlatOwnerModel {
	@Id
	private int flatno;
	private String ownerName;

	public FlatOwnerModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlatOwnerModel(int flatno, String ownerName) {
		super();
		this.flatno = flatno;
		this.ownerName = ownerName;
	}

	public int getFlatno() {
		return flatno;
	}

	public void setFlatno(int flatno) {
		this.flatno = flatno;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Override
	public String toString() {
		return "OwnerData [flatno=" + flatno + ", ownerName=" + ownerName + ", getFlatno()=" + getFlatno()
				+ ", getOwnerName()=" + getOwnerName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
