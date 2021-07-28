package com.cognizant.pms.dailyshareprice;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableEurekaClient
public class SwaggerConfig {
	@Bean
    public Docket docket()
    {
        return new Docket(DocumentationType.SWAGGER_2).select().build();
    }

}
