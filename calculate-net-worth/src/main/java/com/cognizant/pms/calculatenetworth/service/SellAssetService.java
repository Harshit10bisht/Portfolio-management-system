package com.cognizant.pms.calculatenetworth.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pms.calculatenetworth.controller.AuthClient;
import com.cognizant.pms.calculatenetworth.model.AssetDetails;
import com.cognizant.pms.calculatenetworth.model.AuthResponse;
import com.cognizant.pms.calculatenetworth.repository.AssetRepository;

@Service
public class SellAssetService {
	@Autowired
	private AssetRepository repository;

	@Autowired
	private AuthClient authClient;

	public void deleteStockAssetWithUnits(int portfolioId, Map<String, Integer> stockIdList) {
		for (String id : stockIdList.keySet()) {
			AssetDetails a = repository.findByPortfolioidAndAssetidAndType(portfolioId, id, "Share");
			int units = a.getUnits() - stockIdList.get(id);
			if (units > 0) {
				a.setUnits(units);
				repository.save(a);
			} else {
				repository.delete(a);
			}
		}
	}

	public void deleteMutualFundAssetWithUnits(int portfolioId, Map<String, Integer> mfIdList) {
		for (String id : mfIdList.keySet()) {
			AssetDetails a = repository.findByPortfolioidAndAssetidAndType(portfolioId, id, "MF");
			int units = a.getUnits() - mfIdList.get(id);
			if (units > 0) {
				a.setUnits(units);
				repository.save(a);
			} else {
				repository.delete(a);
			}
		}
	}

	public Boolean isSessionValid(String token) {
		try {
			AuthResponse authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
