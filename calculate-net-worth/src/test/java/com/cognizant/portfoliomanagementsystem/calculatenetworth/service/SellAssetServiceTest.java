package com.cognizant.portfoliomanagementsystem.calculatenetworth.service;

import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cognizant.pms.calculatenetworth.controller.AuthClient;
import com.cognizant.pms.calculatenetworth.model.AssetDetails;
import com.cognizant.pms.calculatenetworth.repository.AssetRepository;
import com.cognizant.pms.calculatenetworth.service.SellAssetService;

@RunWith(MockitoJUnitRunner.class)
public class SellAssetServiceTest {
	@Mock
	AssetRepository repository;

	@Mock
	AuthClient authClient;

	@InjectMocks
	SellAssetService sellAssetService;

	@Test
	void testDeleteStockAssetWithUnits() {
		Map<String, Integer> idList = new HashMap<>();
		idList.put("ABC", 5);
		when(repository.findByPortfolioidAndAssetidAndType(0, "ABC", "Share")).thenReturn(new AssetDetails());
		sellAssetService.deleteStockAssetWithUnits(0, idList);
	}

}
