package com.cognizant.pms.calculatenetworth.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.pms.calculatenetworth.model.MFDetails;

@FeignClient(name = "MutualFundService", url = "http://localhost:8091")
public interface MutualFundDetailsFeignProxy {
	
	@GetMapping("/dailyMFNAV/allMFs")
	public List<MFDetails> findAllmf();
	
	@GetMapping("/dailyMFNAV/{mfIdList}")
	public List<Double> findMutualDetailsById(@PathVariable(value="mfIdList") List<String> mfIdList);
}
