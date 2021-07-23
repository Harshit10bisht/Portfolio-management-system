package com.cognizant.pms.calculatenetworth.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellObjectMap {
	int pid;
	Map<String,Integer> stockIdList;
	Map<String,Integer> mfAssetList;

}
