package com.technocrat.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.technocrat")
public class SpringKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}

}
