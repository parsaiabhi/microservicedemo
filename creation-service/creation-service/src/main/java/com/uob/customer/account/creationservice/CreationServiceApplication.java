package com.uob.customer.account.creationservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableCircuitBreaker
public class CreationServiceApplication{

	

	public static void main(String[] args) {
		SpringApplication.run(CreationServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}

}
