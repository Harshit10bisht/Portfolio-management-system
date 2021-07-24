package com.cognizant.pms.calculatenetworth.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.pms.calculatenetworth.model.AssetDetails;
import com.cognizant.pms.calculatenetworth.model.MFDetails;
import com.cognizant.pms.calculatenetworth.model.SellObjectMap;
import com.cognizant.pms.calculatenetworth.model.ShareDetails;
import com.cognizant.pms.calculatenetworth.service.AssetService;
import com.cognizant.pms.calculatenetworth.service.SellAssetService;

@RestController
public class StocksController {
	@Autowired
	private AssetService service;

	@Autowired
	private ShareDetailsFeignProxy proxy;

	@Autowired
	private MutualFundDetailsFeignProxy mutualFundProxy;

	@Autowired
	private SellAssetService sellService;

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
		List<String> stockAssetList = new ArrayList<>();
		List<String> mutualFundAssetList = new ArrayList<>();
		List<Double> stockValueList = new ArrayList<>();
		List<Double> mutualFundValueList = new ArrayList<>();
		List<AssetDetails> assets = service.getAllAssetForPortfolio(id);
		for (AssetDetails a : assets) {
			if (a.getType().equals("Share")) {
				stockAssetList.add(a.getAssetid());
			} else {
				mutualFundAssetList.add(a.getAssetid());
			}
		}
		if (!stockAssetList.isEmpty()) {
			stockValueList = proxy.finddailyShareById(stockAssetList);
		}

		if (!mutualFundAssetList.isEmpty()) {
			mutualFundValueList = mutualFundProxy.findMutualDetailsById(mutualFundAssetList);
		}
		int stockCounter = 0, mfCounter = 0;
		for (AssetDetails a : assets) {
			if (a.getType().equals("Share")) {
				netWorth += a.getUnits() * stockValueList.get(stockCounter);
				stockCounter++;
			} else {
				netWorth += a.getUnits() * mutualFundValueList.get(mfCounter);
				mfCounter++;
			}
		}
		return netWorth;
	}

	@PostMapping("/sellassets")
	public double calculateBalancePostSellPerStock(@RequestBody SellObjectMap sell) {
		Map<String, Integer> stockIdList = sell.getStockIdList();
		Map<String, Integer> mfIdList = sell.getMfIdList();
		if (!stockIdList.isEmpty()) {
			sellService.deleteStockAssetWithUnits(sell.getPid(), stockIdList);
		}
		if (!mfIdList.isEmpty()) {
			sellService.deleteMutualFundAssetWithUnits(sell.getPid(), mfIdList);
		}
		return getAsset(sell.getPid());
	}

	@GetMapping("/getallassets/{portfolioId}")
	public List<AssetDetails> getAllAssets(@RequestHeader @PathVariable(value = "portfolioId") int portfolioId) {
		return service.getAllAssetForPortfolio(portfolioId);
	}

}
