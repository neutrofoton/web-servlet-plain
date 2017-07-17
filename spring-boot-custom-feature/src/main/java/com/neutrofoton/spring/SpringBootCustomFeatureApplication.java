package com.neutrofoton.spring;

import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.neutrofoton.spring.config.MyConfig;

/*
//Version 1 : default standard model
@SpringBootApplication //This annotation is actually the @ComponentScan, @Configuration, and @EnableAutoConfiguration annotations.
public class SpringBootCustomFeatureApplication {
	
	public static void main(String[] args) {
		//SpringApplication provides the bootstrap for the Spring Boot application that is executed in the main method. 
		//You need to pass the class that will be executed.
		SpringApplication.run(SpringBootCustomFeatureApplication.class, args);
	}
}
*/

/*
//Version 2 : construct SpringApplication with custom features
@SpringBootApplication
public class SpringBootCustomFeatureApplication {
	
	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(SpringBootCustomFeatureApplication.class);
		
		//add more features here
		
		//app.setBanner(new Banner() {
		//			@Override
		//			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
		//				out.print("\n\n\tThis is my own banner!\n\n".toUpperCase());			
		//			}
		//	});
		// 
		//app.setBannerMode(Mode.OFF);
		
		app.run(args);
	}
}
*/

/*
//Version 3 : spring boot with SpringApplicationBuilder and Custom listener handler
@SpringBootApplication
public class SpringBootCustomFeatureApplication {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Logger log = LoggerFactory.getLogger(SpringBootCustomFeatureApplication.class);
		
		new SpringApplicationBuilder()
			.sources(SpringBootCustomFeatureApplication.class)
			//.bannerMode(Mode.OFF)
			//.child(MyConfig.class)
			//.logStartupInfo(false)
			//.web(false)
			.listeners(new ApplicationListener<ApplicationEvent>() {
				
				@Override
				public void onApplicationEvent(ApplicationEvent event) {
					log.info("#### ApplicationEvent >> " + event.getClass().getCanonicalName());
				}
				
			})
			.listeners(new ApplicationListener<ApplicationStartedEvent>() {
				public void onApplicationEvent(ApplicationStartedEvent event) {
					log.info("#### ApplicationStartedEvent >> " + event.getClass().getCanonicalName());
				};
			})
			.listeners(new ApplicationListener<ApplicationEnvironmentPreparedEvent>() {
				public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
					log.info("#### ApplicationEnvironmentPreparedEvent >> " + event.getClass().getCanonicalName());
				};
			})
			.listeners(new ApplicationListener<ApplicationPreparedEvent>() {
				public void onApplicationEvent(ApplicationPreparedEvent event) {
					log.info("#### ApplicationPreparedEvent >> " + event.getClass().getCanonicalName());
				};
			})
			.listeners(new ApplicationListener<ApplicationReadyEvent>() {
				public void onApplicationEvent(ApplicationReadyEvent event) {
					log.info("#### ApplicationReadyEvent >> " + event.getClass().getCanonicalName());
				};
			})
			.listeners(new ApplicationListener<ApplicationFailedEvent>() {
				public void onApplicationEvent(ApplicationFailedEvent event) {
					log.info("#### ApplicationFailedEvent >> " + event.getClass().getCanonicalName());
				};
			})
			.run(args);
		
		
	}
}
*/

//Version 4 : spring boot with ApplicationRunner and CommandLineRunner
@SpringBootApplication
public class SpringBootCustomFeatureApplication implements CommandLineRunner, ApplicationRunner {
	
	private static Logger log = LoggerFactory.getLogger(SpringBootCustomFeatureApplication.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootCustomFeatureApplication.class, args);
	}
	
	@Bean
	String info() {
		return "Just a simple String bean";
	}
	
	@Autowired
	String info;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("## > --- Start ApplicationRunner implementation ...");
		
		args.getNonOptionArgs()
			.forEach(f -> log.info(f));
		
		log.info("## > --- End ApplicationRunner implementation ...");
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info("## > --- Start CommandLineRunner implementation ...");
		
		for(String s : args) {
			log.info(s);
		}
		
		log.info("## > --- End CommandLineRunner implementation ...");
	}
}
