package com.cognizant.pms.dailyshareprice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class ShareDetails {
	@Id
	@Column(name = "share_id")
	private String shareId;
	@Column(name = "share_name")
	private String shareName;
	@Column(name = "share_value")
	private double shareValue;

}
