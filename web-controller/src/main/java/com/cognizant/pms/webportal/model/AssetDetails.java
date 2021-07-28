package com.cognizant.pms.webportal.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetDetails {
	private int tid;
	private String assetid;
	private int portfolioid;
	private String type;
	private int units;

}
