package com.cognizant.pms.calculatenetworth.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.pms.calculatenetworth.model.ShareDetails;

@FeignClient(name = "ShareService", url = "http://localhost:8090")
public interface ShareDetailsFeignProxy {

	@GetMapping("/dailySharePrice/allshares")
	public List<ShareDetails> findAll();

	@GetMapping("/dailySharePrice/{shareIdList}")
	public List<Double> finddailyShareById(@PathVariable(value = "shareIdList") List<String> shareIdList);

}
