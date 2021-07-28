package com.cognizant.pms.dailymfnav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
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
	public ResponseEntity<List<MFDetails>> getAllMutualFund(@RequestHeader("Authorization") String token) {
		try {
			if (service.isSessionValid(token)) {
				// return service.getAllMutualFund();
				return ResponseEntity.ok(service.getAllMutualFund());
			}
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		} catch (Throwable e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("/name/{mutualFundName}")
	public MFDetails getDailyMutualFundNav(@RequestHeader("Authorization") String token,
			@PathVariable String mutualFundName) throws MFNotFoundException {
		if (service.isSessionValid(token)) {
			return service.getMutualFundByName(mutualFundName);
		}
		return null;
	}

	@GetMapping("/{mfIdList}")
	public List<Double> getDailyMutualFundNavById(@RequestHeader("Authorization") String token,
			@PathVariable(value = "mfIdList") List<String> mfIdList) throws MFNotFoundException {
		if (service.isSessionValid(token)) {
			return service.getMutualFundByIdList(mfIdList);
		}
		return null;
	}

}
