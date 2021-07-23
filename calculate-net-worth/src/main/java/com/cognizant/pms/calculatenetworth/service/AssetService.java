package com.cognizant.pms.calculatenetworth.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pms.calculatenetworth.model.AssetDetails;
import com.cognizant.pms.calculatenetworth.repository.AssetRepository;

@Service
public class AssetService {
	@Autowired
	private AssetRepository repository;

	@Transactional
	public List<AssetDetails> getAllAssetForPortfolio(int id) {
		return repository.findByPortfolioidOrderByAssetid(id);
	}

}
