package com.cognizant.pms.calculatenetworth.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.pms.calculatenetworth.model.AssetDetails;
import com.cognizant.pms.calculatenetworth.model.MFDetails;
import com.cognizant.pms.calculatenetworth.model.ShareDetails;
import com.cognizant.pms.calculatenetworth.service.AssetService;

@RestController
public class StocksController {
	@Autowired
	private AssetService service;

	@Autowired
	private ShareDetailsFeignProxy proxy;

	@Autowired
	private MutualFundDetailsFeignProxy mutualFundProxy;

	@GetMapping("/shares")
	public List<ShareDetails> getAllStocks() {
		List<ShareDetails> shareslist = proxy.findAll();
		return shareslist;
	}

	@GetMapping("/mf")
	public List<MFDetails> getAllMF() {
		List<MFDetails> mflist = mutualFundProxy.findAllmf();
		return mflist;
	}

	@GetMapping("/networth/{id}")
	public double getAsset(@PathVariable(value = "id") int id) {
		double netWorth = 0.0;
		System.out.println("Milestone 1");
		List<String> stockAssetList = new ArrayList<>();
		List<String> mutualFundAssetList = new ArrayList<>();
		List<Double> stockValueList = new ArrayList<>();
		List<Double> mutualFundValueList = new ArrayList<>();
		List<AssetDetails> assets = service.getAllAssetForPortfolio(id);
		for (AssetDetails a : assets) {
			if (a.getType().equals("Share")) {
				stockAssetList.add(a.getAssetid());
			} 
			else {
				mutualFundAssetList.add(a.getAssetid());
			}
		}
		System.out.println("Milestone 2");
		if (!stockAssetList.isEmpty()) {
			stockValueList = proxy.finddailyShareById(stockAssetList);
		}
		
		if (!mutualFundAssetList.isEmpty()) {
			mutualFundValueList = mutualFundProxy.findMutualDetailsById(mutualFundAssetList);
		}
		System.out.println("Milestone 3");
		int stockCounter = 0, mfCounter = 0;
		for (AssetDetails a : assets) {
			System.out.println("Milestone 0" +a);
			if (a.getType().equals("Share")) {
				System.out.println("Milestone a");
				netWorth += a.getUnits() * stockValueList.get(stockCounter);
				stockCounter++;
			} else {
				System.out.println("Milestone b");
				netWorth += a.getUnits() * mutualFundValueList.get(mfCounter);
				mfCounter++;
			}
		}
		System.out.println("Milestone 4");
		return netWorth;

	}

}
