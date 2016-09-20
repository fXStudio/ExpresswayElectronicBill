package com.expressway.electronicbill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ImportResource("classpath*:spring-*.xml")
public class Application {
	/**
	 * Application Enter Point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
