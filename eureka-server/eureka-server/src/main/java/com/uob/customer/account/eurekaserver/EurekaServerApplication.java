package com.uob.customer.account.eurekaserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
@PropertySource(value = { "classpath:application.properties" })

public class EurekaServerApplication implements CommandLineRunner {

	@Value("${spring.application.name}")
	private String appName;

	@Override
	public void run(String... args) throws Exception {
		log.info("app name :{}", appName);
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

	
	/*
	 * @Bean public PropertySourcesPlaceholderConfigurer placeholder() { return new
	 * PropertySourcesPlaceholderConfigurer(); }
	 */
	
}
