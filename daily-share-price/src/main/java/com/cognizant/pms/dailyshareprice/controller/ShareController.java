package com.cognizant.pms.dailyshareprice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<ShareDetails> getAllSharePrice() {
		return service.getallshares();
	}
	
	@GetMapping("/svalue")
	public List<ShareDetails> getByShareValue() {
		return service.getbysharevalue(1500.0);
	}
	
	@GetMapping("/sname/{shareName}")
	public ShareDetails getShareByName(@PathVariable String shareName) {
		return service.getsharebyname(shareName);
	}
}