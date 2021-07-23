package com.cognizant.pms.dailymfnav.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.pms.dailymfnav.model.MFDetails;

@Repository
public interface MFRepository extends JpaRepository<MFDetails, String> {
	public List<MFDetails> findAll();

	public MFDetails findByMutualFundName(String mutualFundName);

	@Query(value = "SELECT * FROM mf_details m WHERE m.mf_id IN ?1 order by m.mf_id", nativeQuery = true)
	public List<MFDetails> findByMutualFundId(List<String> mfIdList);
}
