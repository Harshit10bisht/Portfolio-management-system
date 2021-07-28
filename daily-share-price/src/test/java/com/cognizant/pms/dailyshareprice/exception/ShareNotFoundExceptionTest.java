package com.cognizant.pms.dailyshareprice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ShareNotFoundExceptionTest {
	@Test
	void testShareNotFoundException() {
		ShareNotFoundException shareNotFoundException=new ShareNotFoundException("Error occured");
		assertEquals("Error occured",shareNotFoundException.getMessage());
	}

}
