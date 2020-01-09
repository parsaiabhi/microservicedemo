package com.uob.customer.account.creationservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CreationServiceApplication{

	

	public static void main(String[] args) {
		SpringApplication.run(CreationServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}

}
