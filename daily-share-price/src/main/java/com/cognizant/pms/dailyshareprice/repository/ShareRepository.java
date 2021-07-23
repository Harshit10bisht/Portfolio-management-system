package com.cognizant.pms.dailyshareprice.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.pms.dailyshareprice.model.ShareDetails;

@Repository
public interface ShareRepository extends JpaRepository<ShareDetails, String> {
	public List<ShareDetails> findAll();

	public ShareDetails findByShareName(String shareName);
	
	@Query(value = "SELECT * FROM share_details s WHERE s.share_id IN ?1 order by s.share_id", nativeQuery = true)
	public List<ShareDetails> findByShareId(List<String> shareIdList);

	@Query(value = "SELECT * FROM share_details s WHERE s.share_value > :shareValue", nativeQuery = true)
	public List<ShareDetails> findByShareValue(Double shareValue);

}
