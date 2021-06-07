package com.Faatak.services;

import java.util.ArrayList;

import com.Faatak.model.VisitorModel;

public interface WatchManService {
	
	public ArrayList<String> saveVisistorDetails(VisitorModel visitordata);

	public String updateVisistorDetails(VisitorModel visitordata);

	public boolean checkOwnerDetails(int flatId);

	public boolean getOwnerPermision(VisitorModel visitordata);
}
