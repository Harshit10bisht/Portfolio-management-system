package com.cognizant.pms.webportal.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellObjectMap {
	int pid;
	Map<String, Integer> stockIdList;
	Map<String, Integer> mfAssetList;

}
