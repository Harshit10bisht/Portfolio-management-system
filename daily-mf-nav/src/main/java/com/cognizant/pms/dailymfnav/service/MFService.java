package com.cognizant.pms.dailymfnav.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pms.dailymfnav.controller.AuthClient;
import com.cognizant.pms.dailymfnav.exceptions.MFNotFoundException;
import com.cognizant.pms.dailymfnav.model.AuthResponse;
import com.cognizant.pms.dailymfnav.model.MFDetails;
import com.cognizant.pms.dailymfnav.repository.MFRepository;

@Service
public class MFService {
	@Autowired
	private MFRepository repository;

	@Autowired
	private AuthClient authClient;
	
	@Transactional
	public List<MFDetails> getAllMutualFund() {
		return repository.findAll();
	}

	@Transactional
	public MFDetails getMutualFundByName(String mutualFundName) throws MFNotFoundException {
		if (repository.findByMutualFundName(mutualFundName) == null)
			throw new MFNotFoundException("Mutual Fund Not Found");
		return repository.findByMutualFundName(mutualFundName);
	}

	public List<Double> getMutualFundByIdList(List<String> mfIdList) {
		List<Double> mfValueList = new ArrayList<>();
		List<MFDetails> mfList = repository.findByMutualFundId(mfIdList);
		for (MFDetails m : mfList) {
			mfValueList.add(m.getMutualFundValue());
		}
		return mfValueList;
	}

	public Boolean isSessionValid(String token) {
		AuthResponse authResponse = authClient.getValidity(token);
		if (authResponse == null)
			throw new RuntimeException("Exception Thrown-Null Auth Response returned");

		return true;
	}

}
