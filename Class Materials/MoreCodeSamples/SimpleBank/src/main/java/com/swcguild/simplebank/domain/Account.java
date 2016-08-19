package com.swcguild.simplebank.domain;

public class Account {
	private int id;
	private int accountHolderId;
	private double balance;

	public int getAccountHolderId() {
		return accountHolderId;
	}

	public void setAccountHolderId(int accountHolderId) {
		this.accountHolderId = accountHolderId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	

}
