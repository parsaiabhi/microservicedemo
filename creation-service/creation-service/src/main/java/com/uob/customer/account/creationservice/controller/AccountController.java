package com.uob.customer.account.creationservice.controller;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.uob.customer.account.creationservice.dto.AccountRequestDto;
import com.uob.customer.account.creationservice.entity.Account;
import com.uob.customer.account.creationservice.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private Environment environment;

	@PostMapping("/accounts/create")
	public ResponseEntity<String> enrollAccount(@RequestBody AccountRequestDto AccountRequestDto) {

		ModelMapper mapper = new ModelMapper();
		Account account = mapper.map(AccountRequestDto, Account.class);
		account = accountService.createAccount(account);
		return new ResponseEntity<String>(account.getAccountNo(), HttpStatus.OK);

	}

	@PostMapping("/accounts/{accountNo}/balance")
	@HystrixCommand(fallbackMethod = "pingFallback")
	public ResponseEntity<String> getBalance(@PathVariable("accountNo") String accountNo) {
		Double balance = accountService.getBalanceFormAccount(accountNo).getBalance();
		String bal  = balance.toString()+ " from port: "+environment.getProperty("local.server.port");
		return new ResponseEntity<String>(bal, HttpStatus.OK);

	}
	
	
	
	  private ResponseEntity<String> pingFallback(String accountNo){
		  accountNo = "circuit breaker enabled";
	  // String str = new String("fallback----0.00"); return new
	  return new ResponseEntity<String>(accountNo,HttpStatus.INTERNAL_SERVER_ERROR);
	  
	  }
	 
	
	
	
	
	

}
