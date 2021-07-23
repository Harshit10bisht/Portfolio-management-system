package com.cognizant.pms.calculatenetworth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.pms.calculatenetworth.model.PortfolioDetails;

@Repository
public interface PortfolioRepository extends JpaRepository<PortfolioDetails, Integer> {

}
