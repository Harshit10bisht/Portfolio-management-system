package com.cognizant.pms.calculatenetworth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShareDetails {
	private String shareId;
	private String shareName;
	private double shareValue;

}
