package com.backend.healthserviceasservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HealthServiceAsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthServiceAsServiceApplication.class, args);
	}

}
