package com.cognizant.pms.dailymfnav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.pms.dailymfnav.exceptions.MFNotFoundException;
import com.cognizant.pms.dailymfnav.model.MFDetails;
import com.cognizant.pms.dailymfnav.service.MFService;

@RestController
@RequestMapping("/dailyMFNAV")
public class MFController {
	@Autowired
	private MFService service;

	@GetMapping("/allMFs")
	public List<MFDetails> getAllMutualFund() {
		return service.getAllMutualFund();
	}

	@GetMapping("/name/{mutualFundName}")
	public MFDetails getDailyMutualFundNav(@PathVariable String mutualFundName) throws MFNotFoundException {
		return service.getMutualFundByName(mutualFundName);
	}
}