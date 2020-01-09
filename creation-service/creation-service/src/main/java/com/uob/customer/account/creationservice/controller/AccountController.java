package com.uob.customer.account.creationservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uob.customer.account.creationservice.dto.AccountRequestDto;
import com.uob.customer.account.creationservice.entity.Account;
import com.uob.customer.account.creationservice.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/accounts/create")
	public ResponseEntity<String> enrollAccount(@RequestBody AccountRequestDto AccountRequestDto) {

		ModelMapper mapper = new ModelMapper();
		Account account = mapper.map(AccountRequestDto, Account.class);
		account = accountService.createAccount(account);
		return new ResponseEntity<String>(account.getAccountNo(), HttpStatus.OK);

	}

}
