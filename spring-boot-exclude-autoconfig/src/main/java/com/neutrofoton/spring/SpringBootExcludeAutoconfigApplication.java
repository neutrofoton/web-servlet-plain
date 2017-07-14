package com.neutrofoton.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;

@SpringBootApplication(exclude= {ActiveMQAutoConfiguration.class,DataSourceAutoConfiguration.class})
public class SpringBootExcludeAutoconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExcludeAutoconfigApplication.class, args);
	}
}
