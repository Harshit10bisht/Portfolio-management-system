package com.cognizant.pms.calculatenetworth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MFDetails {
	private String mutualFundId;
	private String mutualFundName;
	private double mutualFundValue;

}
