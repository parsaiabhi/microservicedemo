
package com.uob.customer.account.displayblanceservice.service;

import org.springframework.stereotype.Component;

@Component
public class CreationServiceFallback implements CreationServiceClient {

	@Override
	public String getBalance(String accountNo) {
		return "from fallback";
	}

}
