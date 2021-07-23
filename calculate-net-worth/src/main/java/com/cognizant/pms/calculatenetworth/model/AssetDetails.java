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
@Table(name = "asset_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetDetails {
	@Id
	@Column(name = "tid")
	private int tid;

	@Column(name = "asset_id")
	private String assetid;
	@Column(name = "portfolio_id")
	private int portfolioid;
	@Column(name = "type")
	private String type;
	@Column(name = "units")
	private int units;

}
