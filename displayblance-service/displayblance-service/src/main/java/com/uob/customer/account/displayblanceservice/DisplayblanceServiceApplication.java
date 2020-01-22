package com.uob.customer.account.displayblanceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.uob.customer.account.displayblanceservice.service"})
public class DisplayblanceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayblanceServiceApplication.class, args);
	}
	
	@Bean 
    public ServletRegistrationBean getServlet () { 
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet (); 
        ServletRegistrationBean registrationBean = new ServletRegistrationBean (streamServlet); 
        registrationBean.setLoadOnStartup ( 1 ); 
        registrationBean.addUrlMappings ( "/hystrix.stream" ); 
        registrationBean.setName ( "HystrixMetricsStreamServlet" ); 
        return registrationBean; 
    }

}
