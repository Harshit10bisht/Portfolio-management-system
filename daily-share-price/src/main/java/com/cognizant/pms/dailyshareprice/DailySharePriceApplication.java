package com.cognizant.pms.dailyshareprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DailySharePriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailySharePriceApplication.class, args);
	}

}
