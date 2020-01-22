
package com.uob.customer.account.displayblanceservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.WeightedResponseTimeRule;

public class RibbonConfiguration {

	@Autowired
	IClientConfig config;

	@Bean
	public IPing ribbonPing(IClientConfig config) {
		return new PingUrl();
	}

	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new WeightedResponseTimeRule();
//		return new AvailabilityFilteringRule();
	}

	/*
	 * @Bean public Decoder feignDecoder() { HttpMessageConverter jacksonConverter =
	 * new MappingJackson2HttpMessageConverter(customObjectMapper());
	 * ObjectFactory<HttpMessageConverters> objectFactory = () -> new
	 * HttpMessageConverters(jacksonConverter); return new ResponseEntityDecoder(new
	 * SpringDecoder(objectFactory)); }
	 * 
	 * public ObjectMapper customObjectMapper() { return new ObjectMapper(); //
	 * Customize as much as you want return objectMapper; }
	 */

}
