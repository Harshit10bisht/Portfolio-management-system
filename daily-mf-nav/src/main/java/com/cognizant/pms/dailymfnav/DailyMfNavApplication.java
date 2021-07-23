package com.cognizant.pms.dailymfnav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DailyMfNavApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyMfNavApplication.class, args);
	}

}
