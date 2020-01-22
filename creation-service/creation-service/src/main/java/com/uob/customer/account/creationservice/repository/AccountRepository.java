package com.uob.customer.account.creationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uob.customer.account.creationservice.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Integer>{
	
	Account findByAccountNo(String accountNo);

}
