package com.cognizant.pms.dailyshareprice.model;

import lombok.Data;

@Data
public class AuthResponse {
	private String uid;
	private String name;
	private boolean isValid;
}
