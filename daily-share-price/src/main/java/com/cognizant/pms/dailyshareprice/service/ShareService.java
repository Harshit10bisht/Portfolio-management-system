package com.cognizant.pms.dailyshareprice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pms.dailyshareprice.model.ShareDetails;
import com.cognizant.pms.dailyshareprice.repository.ShareRepository;

@Service
public class ShareService {
	@Autowired
	private ShareRepository repository;

	@Transactional
	public List<ShareDetails> getallshares() {
		return repository.findAll();
	}

	@Transactional
	public ShareDetails getsharebyname(String shareName) {
		return repository.findByShareName(shareName);
	}

	public List<ShareDetails> getbysharevalue(Double shareValue) {
		return repository.findByShareValue(shareValue);
	}

	public List<Double> getSharebyIdList(List<String> shareIdList) {
		List<Double> shareValueList = new ArrayList<>();
		List<ShareDetails> shareList = repository.findByShareId(shareIdList);
		for (ShareDetails s : shareList) {
			shareValueList.add(s.getShareValue());
		}
		return shareValueList;
	}

}
