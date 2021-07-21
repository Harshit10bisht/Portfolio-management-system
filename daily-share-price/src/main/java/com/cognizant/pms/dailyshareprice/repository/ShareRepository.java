package com.cognizant.pms.dailyshareprice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.pms.dailyshareprice.model.ShareDetails;

public interface ShareRepository extends JpaRepository<ShareDetails, String> {
	public List<ShareDetails> findAll();

	public ShareDetails findByShareName(String shareName);

	@Query(value = "SELECT * FROM share_details s WHERE s.share_value > :shareValue", nativeQuery = true)
	public List<ShareDetails> findByShareValue(Double shareValue);

}
