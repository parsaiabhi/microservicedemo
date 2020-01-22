package com.uob.customer.account.creationservice.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import com.uob.customer.account.creationservice.util.AccountNumberGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author User1
 *
 */
@Entity
@Table(name = "account")
/**
 * @param id
 * @param name
 * @param email
 * @param address
 * @param gender
 * @param accountNo
 * @param balance
 */
@AllArgsConstructor
@Getter
@Setter
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String address;
	private String gender;
	private String accountNo;
	private double balance;

	public Account() {
		accountNo = AccountNumberGenerator.generateAccountNumber();
	}

}
