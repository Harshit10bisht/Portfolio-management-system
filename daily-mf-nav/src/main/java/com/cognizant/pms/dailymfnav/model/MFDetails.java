package com.cognizant.pms.dailymfnav.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mf_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MFDetails {
	@Id
	@Column(name = "mf_id")
	private String mutualFundId;
	@Column(name = "mf_name")
	private String mutualFundName;
	@Column(name = "mf_value")
	private double mutualFundValue;

}
