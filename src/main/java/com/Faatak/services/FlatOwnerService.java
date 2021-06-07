package com.Faatak.services;

import com.Faatak.model.VisitorModel;

public interface FlatOwnerService {
	public boolean getAcknowledgement(VisitorModel  visitordata);
	public void reviewVisitorData(String Name , String Mobile , String Address);

}
