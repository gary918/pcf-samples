package com.gary.search;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Account")
public class Account {

	private Integer id;
	private String name;
	private Double balance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
