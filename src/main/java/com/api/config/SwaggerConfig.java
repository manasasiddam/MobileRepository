package com.api.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SwaggerConfig {
	@Bean
	public GroupedOpenApi controllerApi() {
		return GroupedOpenApi.builder()
				.group("mobile-api")
				.packagesToScan("com.api.controller")
				.build();


	

	    }

}