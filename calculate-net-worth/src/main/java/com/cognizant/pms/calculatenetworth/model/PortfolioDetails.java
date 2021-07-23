package com.cognizant.pms.calculatenetworth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "portfolio_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioDetails {
	@Id
	@Column(name = "portfolio_id")
	private int portfolioId;

}
