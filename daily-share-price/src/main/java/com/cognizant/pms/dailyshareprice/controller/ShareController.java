package com.cognizant.pms.dailyshareprice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.pms.dailyshareprice.model.ShareDetails;
import com.cognizant.pms.dailyshareprice.service.ShareService;

@RestController
@RequestMapping("/dailySharePrice")
public class ShareController {
	@Autowired
	ShareService service;

	@GetMapping("/allshares")
	public List<ShareDetails> getAllSharePrice(@RequestHeader("Authorization") String token) {
		if (service.isSessionValid(token)) {
			return service.getallshares();
		}
		return null;
	}

	@GetMapping("/svalue")
	public List<ShareDetails> getByShareValue() {
		return service.getbysharevalue(1500.0);
	}

	@GetMapping("/sname/{shareName}")
	public ShareDetails getShareByName(@RequestHeader("Authorization") String token, @PathVariable String shareName) {
		if (service.isSessionValid(token)) {
			return service.getsharebyname(shareName);
		}
		return null;

	}

	@GetMapping("/{shareIdList}")
	public List<Double> getDailySharePriceByIDList(@RequestHeader("Authorization") String token,
			@PathVariable(value = "shareIdList") List<String> shareIdList) {

		if (service.isSessionValid(token)) {
			return service.getSharebyIdList(shareIdList);
		}
		return null;
	}

}
