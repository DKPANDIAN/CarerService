package com.uniquecaterer.service.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSpringDataWebSupport
@EnableMongoRepositories(basePackages={"com.uniquecaterer.service.rest.repo"})
public class UniqueCatererMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniqueCatererMicroserviceApplication.class, args);
	}

}
