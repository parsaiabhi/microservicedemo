package com.uob.customer.account.creationservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author User1
 *
 */
@Setter
@Getter
@NoArgsConstructor
/**
 * @param name
 * @param email
 * @param address
 * @param gender
 * @param amount
 */
@AllArgsConstructor
public class AccountRequestDto {

	private String name;
	private String email;
	private String address;
	private String gender;
	private int balance;
}
