package com.uob.customer.account.creationservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author User1
 *
 */
@Entity
@Table(name = "account")
@NoArgsConstructor
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
	private long balance;

}
