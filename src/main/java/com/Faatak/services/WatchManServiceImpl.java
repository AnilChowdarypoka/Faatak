package com.Faatak.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Faatak.dao.FlatOwnerDao;
import com.Faatak.dao.VisitorDataDao;
import com.Faatak.model.FlatOwnerModel;
import com.Faatak.model.VisitorModel;

@Service
public class WatchManServiceImpl implements WatchManService {
	@Autowired
	private VisitorDataDao dao;
	@Autowired
	private FlatOwnerDao OwnerDao;

	@Override
	public ArrayList<String> saveVisistorDetails(VisitorModel visitordata) {
		ArrayList<String> arr = new ArrayList<String>();
		String errMsg = null;
		try {
			dao.save(visitordata);
			boolean isvaliduser = checkOwnerDetails(visitordata.getOwnerFlatId());
			if (isvaliduser) {
				errMsg = "User Details Saved Sucessfully and Owner details has been Confirmed ";
				arr.add(errMsg);
				boolean ownerResponse = getOwnerPermision(visitordata);
				if (ownerResponse) {
					errMsg = "Owner Acknowledged";
					arr.add(errMsg);
				} else {
					errMsg = "Owner refused";
					arr.add(errMsg);
				}
				return arr;
			} else {
				errMsg = "User Details Saved Sucessfully and Owner details was not matched";
				arr.add(errMsg);
			}
		} catch (Exception e) {
		}
		return arr;
	}

	@Override
	public String updateVisistorDetails(VisitorModel visitordata) {
		try {
			dao.save(visitordata);
		} catch (Exception e) {
		}
		return "Details Updated Sucessfully";
	}

	@Override
	public boolean checkOwnerDetails(int flatId) {
		boolean flag = false;

		Optional<FlatOwnerModel> ownerObj = OwnerDao.findById(flatId);
		if (ownerObj.isPresent()) {
			System.out.println("True");
			return true;
		}
		return flag;
	}

	@Override
	public boolean getOwnerPermision(VisitorModel visitordata) {
		FlatOwnerServiceImpl implObj = new FlatOwnerServiceImpl();
		return implObj.getAcknowledgement(visitordata);
	}
}
