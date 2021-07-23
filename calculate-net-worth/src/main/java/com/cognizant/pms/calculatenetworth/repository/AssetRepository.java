package com.cognizant.pms.calculatenetworth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.pms.calculatenetworth.model.AssetDetails;

@Repository
public interface AssetRepository extends JpaRepository<AssetDetails, Integer> {
	
	public List<AssetDetails> findByPortfolioidOrderByAssetid(int id);
	public AssetDetails findByPortfolioidAndAssetidAndType(int portfolioId,String assetId,String type);

}
