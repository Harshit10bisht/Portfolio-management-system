package com.cognizant.pms.dailymfnav.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MFDetailsTest {
	MFDetails mutualFund = new MFDetails();

	@Test
	void testSetMutualFundId() {
		mutualFund.setMutualFundId("101");
		assertEquals("101", mutualFund.getMutualFundId());
	}

	@Test
	void testSetMutualFundName() {
		mutualFund.setMutualFundName("abc");
		assertEquals("abc", mutualFund.getMutualFundName());
	}

	@Test
	void testSetMutualFundValue() {
		mutualFund.setMutualFundValue(10.0);
		assertEquals(10.0, mutualFund.getMutualFundValue());
	}

	@Test
	void testToString() {
		MFDetails mf = new MFDetails("101", "abc", 100.0);
		assertEquals("MutualFund [mutualFundId=101, mutualFundName=abc, mutualFundValue=100.0]", mf.toString());
	}

	@Test
	void testMutualFund() {
		MFDetails mf = new MFDetails();
	}

	@Test
	void testMutualFundStringStringDouble() {
		MFDetails mf = new MFDetails("101", "abc", 100.0);
		assertEquals("101", mf.getMutualFundId());
		assertEquals("abc", mf.getMutualFundName());
		assertEquals(100.0, mf.getMutualFundValue());

	}

}
