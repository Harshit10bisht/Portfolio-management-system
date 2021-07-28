package com.cognizant.pms.dailyshareprice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ShareNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShareNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
