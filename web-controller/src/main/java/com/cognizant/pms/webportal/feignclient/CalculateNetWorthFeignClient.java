package com.cognizant.pms.webportal.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.pms.webportal.model.AssetDetails;
import com.cognizant.pms.webportal.model.SellObjectMap;

@FeignClient(name = "CalculateNetWorthService", url = "http://localhost:8092")
public interface CalculateNetWorthFeignClient {
	@GetMapping("/networth/{id}")
	public double getAsset(@RequestHeader("Authorization") String token, @PathVariable(value = "id") int id);

	@GetMapping("/getallassets/{portfolioId}")
	public List<AssetDetails> getAllAssets(@RequestHeader("Authorization") String token,
			@PathVariable(value = "id") int id);

	@PostMapping("/sellassets")
	public double calculateBalancePostSellPerStock(@RequestHeader("Authorization") String token,
			@RequestBody SellObjectMap sell);
}
