package com.uob.customer.account.creationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
