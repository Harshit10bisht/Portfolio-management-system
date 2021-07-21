package com.cognizant.pms.dailymfnav.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pms.dailymfnav.exceptions.MFNotFoundException;
import com.cognizant.pms.dailymfnav.model.MFDetails;
import com.cognizant.pms.dailymfnav.repository.MFRepository;

@Service
public class MFService {
	@Autowired
	private MFRepository repository;

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

}
