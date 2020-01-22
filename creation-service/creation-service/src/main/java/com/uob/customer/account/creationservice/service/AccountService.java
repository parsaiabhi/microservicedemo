package com.uob.customer.account.creationservice.service;

import com.uob.customer.account.creationservice.entity.Account;
import com.uob.customer.account.creationservice.projection.BalanceProjection;

public interface AccountService {

	Account createAccount(Account account);

	Account getBalanceFormAccount(String accountNo);

}
