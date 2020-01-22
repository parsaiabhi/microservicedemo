package com.uob.customer.account.displayblanceservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uob.customer.account.displayblanceservice.config.RibbonConfiguration;


@FeignClient(name = "creation"  ,fallback = CreationServiceFallback.class)
@RibbonClient(name = "creation" ,  configuration = RibbonConfiguration.class)
public interface CreationServiceClient {
	
	
	@PostMapping("/accountcreation/accounts/{accountNo}/balance")
	String getBalance(@PathVariable("accountNo") String accountNo);

}
