package com.Faatak.services;

import java.util.Random;

import com.Faatak.model.VisitorModel;

public class FlatOwnerServiceImpl implements FlatOwnerService {

	@Override
	public boolean getAcknowledgement(VisitorModel visitordata) {
		Random rd = new Random(); // for Random response
		reviewVisitorData(visitordata.getVisitorName(), visitordata.getMobileNo(), visitordata.getAddress());
		boolean OwnerResponse = rd.nextBoolean();
		System.out.println("Owner Acknowledge is : " + OwnerResponse);
		return OwnerResponse;
	}

	@Override
	public void reviewVisitorData(String Name, String Mobile, String Address) {
		System.out.println("Owner reviewing Visitor Data  : ");
		System.out.println("Name : " + Name);
		System.out.println("Mobile No : " + Mobile);
		System.out.println("Address : " + Address);
	}

}
