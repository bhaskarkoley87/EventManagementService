package com.hackfse.giveaway.EventManagementService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.hackfse.giveaway"})
@EnableJpaRepositories("com.hackfse.giveaway.dao")
@EntityScan("com.hackfse.giveaway.dto") 
public class EventManagementServiceApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "8090");
		SpringApplication.run(EventManagementServiceApplication.class, args);
	}

}

