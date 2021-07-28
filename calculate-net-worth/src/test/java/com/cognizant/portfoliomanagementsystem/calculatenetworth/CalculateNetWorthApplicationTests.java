package com.cognizant.portfoliomanagementsystem.calculatenetworth;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.pms.calculatenetworth.controller.StocksController;

@AutoConfigureMockMvc
@SpringBootTest
class CalculateNetWorthApplicationTests {
	@Autowired
	private StocksController controller;

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
		assertNotNull(controller);
	}

	@Test
	public void testGetAllMutualFunds() throws Exception {
		ResultActions actions = mvc.perform(get("/NetWorth/mutualfunds"));
		actions.andExpect(status().isOk());

	}

	@Test
	public void testGetStockName() throws Exception {
		ResultActions actions = mvc.perform(get("/NetWorth//pershare/Amazon"));
		actions.andExpect(status().isOk());

	}

	@Test
	public void testGetAllStocks() throws Exception {
		ResultActions actions = mvc.perform(get("/NetWorth/shares"));
		actions.andExpect(status().isOk());

	}

}
