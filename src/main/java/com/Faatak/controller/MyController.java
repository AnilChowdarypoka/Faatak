package com.Faatak.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Faatak.model.VisitorModel;
import com.Faatak.services.WatchManService;

@RestController
public class MyController {
	@Autowired
	private WatchManService watchman;

	/*
	 * getAcknowledged() is used to get Acknowledgement with Out saving Tenent
	 * Details.
	 * 
	 */
	@GetMapping("/ownerAcknowledgement")
	public ArrayList<String> getAcknowledged(@RequestBody VisitorModel visitordata) {
		ArrayList<String> arr = new ArrayList<String>();
		boolean checkOwnerDetails = this.watchman.checkOwnerDetails(visitordata.getOwnerFlatId());
		if (checkOwnerDetails) {
			arr.add("Owner Details Matched");
			boolean acknowledgement = this.watchman.getOwnerPermision(visitordata);
			if (!acknowledgement) {
				arr.add("Owner Refused");
			} else {
				arr.add("Owner Acknowledged");
			}
			return arr;
		} else {
			arr.add("Owner Details were Incorrect");
			return arr;
		}
	}

	/*
	 * saveVisitorDetails() is used to get Acknowledgement by saving Tenent Details.
	 */

	@PostMapping(path = "/VisitorDetails", consumes = "application/json")
	public ArrayList<String> saveVisitorDetails(@RequestBody VisitorModel visitordata) {
		return this.watchman.saveVisistorDetails(visitordata);
	}

	/*
	 * updateVisitorDetails() is used to get Acknowledgement by Updating Tenent
	 * Details.
	 */

	@PutMapping(path = "/VisitorDetails", consumes = "application/json")
	public ArrayList<String> updateVisitorDetails(@RequestBody VisitorModel visitordata) {
		ArrayList<String> arr = new ArrayList<String>();
		String updateStatus = this.watchman.updateVisistorDetails(visitordata);
		arr = (getAcknowledged(visitordata));
		arr.add(updateStatus);
		return arr;
	}

}
