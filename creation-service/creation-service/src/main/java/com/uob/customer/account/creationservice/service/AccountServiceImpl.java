package com.uob.customer.account.creationservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.uob.customer.account.creationservice.entity.Account;
import com.uob.customer.account.creationservice.repository.AccountRepository;



/**
 * @author User1
 *
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	/**
	 * 
	 */
	@Autowired
	private AccountRepository accountRepository;

	/**
	 *
	 */
	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

//	@HystrixCommand(fallbackMethod = "pingFallback")
	@Override
	public Account getBalanceFormAccount(String accountNo) {
		return accountRepository.findByAccountNo(accountNo);
	}

	/*
	 * private ResponseEntity<String> pingFallback(){
	 * 
	 * // String str = new String("fallback----0.00"); return new return new
	 * ResponseEntity<String>("circuit breaker enabled",HttpStatus.
	 * INTERNAL_SERVER_ERROR);
	 * 
	 * }
	 */
	
	
	

}
