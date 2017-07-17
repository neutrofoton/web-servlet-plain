package com.neutrofoton.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
	
	@Bean
	String text() {
		return "Hi there!";
	}
}
