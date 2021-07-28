package com.cognizant.pms.dailyshareprice;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.pms.dailyshareprice.controller.ShareController;

@AutoConfigureMockMvc
@SpringBootTest
class DailySharePriceApplicationTests {
	@Autowired
	private ShareController shareController;

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
		assertNotNull(shareController);
	}

	@Test
	public void testGetShareByName() throws Exception {
		ResultActions actions = mvc.perform(get("/dailySharePrice/sname/Amazon"));
		actions.andExpect(status().isForbidden());
		actions.andExpect(jsonPath("$.shareId").exists());
		actions.andExpect(jsonPath("$.shareId").value("AMZ"));

		actions.andExpect(jsonPath("$.shareName").exists());
		actions.andExpect(jsonPath("$.shareName").value("Amazon"));

		actions.andExpect(jsonPath("$.shareValue").exists());
		actions.andExpect(jsonPath("$.shareValue").value("2500.0"));
	}

	@Test
	public void testGetAllSharePrice() throws Exception {
		mvc.perform(get("/dailySharePrice/allshares")).andExpect(status().isOk());
	}

	@Test
	public void testGetDailySharePriceByIDList() throws Exception {
		mvc.perform(get("/dailySharePrice/AMZ")).andExpect(status().isOk());
	}

}
