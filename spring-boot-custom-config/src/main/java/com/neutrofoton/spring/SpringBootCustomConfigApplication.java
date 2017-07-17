package com.neutrofoton.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.neutrofoton.spring.properties.MyAppProperties;

@SpringBootApplication
public class SpringBootCustomConfigApplication {

	private static Logger log = LoggerFactory.getLogger(SpringBootCustomConfigApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCustomConfigApplication.class, args);
		
		
	}
	
	@Value("${server.ip}")
	private String serverIp;
	
	@Autowired
	private MyAppProperties props;
	
	@Bean
	CommandLineRunner values() {
		return args->{
			log.info(">> The server ip is : " + this.serverIp);
			
			log.info("## >> app server ip : "+ props.getServerIp());
			log.info("## >> app name : "+ props.getName());
			log.info("## >> app desc : "+ props.getDescription());
		};
	}
}
