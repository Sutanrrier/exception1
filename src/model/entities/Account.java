package model.entities;

import model.exceptions.BalanceException;
import model.exceptions.WithdrawException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	//Construtores
	public Account() {
		
	}
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	//Getters e Setters
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public Double getBalance() {
		return balance;
	}
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	public void withdraw(Double amount) throws BalanceException, WithdrawException {
		if(amount > withdrawLimit) {
			throw new WithdrawException("Quantidade desejada excede seu limite de saque!");
		}
		else if(amount > balance) {
			throw new BalanceException("Saldo insuficiente para saque!");
		}
		else {
			balance -= amount;
		}
	}
	
}
