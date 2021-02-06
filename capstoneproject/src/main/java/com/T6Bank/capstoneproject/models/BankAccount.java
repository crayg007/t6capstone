package com.T6Bank.capstoneproject.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import com.T6Bank.capstoneproject.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "account_holder_id")
	@JsonIgnore
	protected AccountHolder accountHolder;
	
	@Min(value = 0, message="Balance must be positive")
	private double  balance ;
	
	@DecimalMin (value = "0.0", message = "interestRate > 0.0")
	@DecimalMax (value = "1.0", message = "interestRate < 1.0")
	private double interestRate;
	
	private int term;
	
//	List<Transaction> transactions = new ArrayList<Transaction>();
	public BankAccount() {}
	public BankAccount(@Min(value = 0, message = "Balance must be positive") double balance,
			@DecimalMin(value = "0.0", message = "interestRate > 0.0") @DecimalMax(value = "1.0", message = "interestRate < 1.0") double interestRate,
			int term) {
		
		this.balance = balance;
		this.interestRate = interestRate;
		this.term = term;
		
	}
	public BankAccount(long id) {
		super();
		this.id = id;
	}
	public BankAccount(@Min(value = 0, message = "Balance must be positive") double balance,
			@DecimalMin(value = "0.0", message = "interestRate > 0.0") @DecimalMax(value = "1.0", message = "interestRate < 1.0") double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		
	}

	public BankAccount(@Min(value = 0, message = "Balance must be positive") double balance,
			@DecimalMin(value = "0.0", message = "interestRate > 0.0") @DecimalMax(value = "1.0", message = "interestRate < 1.0") double interestRate,
			long id) {
		
		this.balance = balance;
		this.interestRate = interestRate;
		this.id = id;
		
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	
	public boolean withdraw(double amount)
	{
		if((balance - amount) >= 0) 
		{
			balance = balance - amount;
			return true;
		} else
			{
			
			return false;
			}	
	}
	
	public boolean deposit(double amount) 
	{
		if(amount > 0)
		{
			balance = balance + amount;
			return true;
		} else 
			return false;	
	}
	
	
	public double getFutureValue(int term) 
	{
		return (balance * Math.pow((1+ getInterestRate() ), term));
	}

	
	
//	public void addTransaction(Transaction transaction) {
//		transactions.add(transaction);
//	}
//	
//	public List<Transaction>getTransactions(){
//		return transactions;
//	}
	
}
