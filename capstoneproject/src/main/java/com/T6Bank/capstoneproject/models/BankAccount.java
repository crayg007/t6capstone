package com.T6Bank.capstoneproject.models;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import org.hibernate.annotations.DiscriminatorOptions;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import com.T6Bank.capstoneproject.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "account_type" , discriminatorType = DiscriminatorType.STRING)
@DiscriminatorOptions(force = true)
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
	private boolean active;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "targetAccount")
	@OrderColumn
	List<Transaction> transactions = new ArrayList<Transaction>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sourceAccount")
	@OrderColumn
	List<Transaction> sourceTransaction = new ArrayList<Transaction>();
	
	public BankAccount() {}
	public BankAccount(@Min(value = 0, message = "Balance must be positive") double balance,
			@DecimalMin(value = "0.0", message = "interestRate > 0.0") @DecimalMax(value = "1.0", message = "interestRate < 1.0") double interestRate,
			int term,boolean active) {
		
		this.balance = balance;
		this.interestRate = interestRate;
		this.term = term;
		this.active = active;
	}
	public BankAccount(long id) {
		
		this.id = id;
	}
	public BankAccount(@Min(value = 0, message = "Balance must be positive") double balance,
			@DecimalMin(value = "0.0", message = "interestRate > 0.0") @DecimalMax(value = "1.0", message = "interestRate < 1.0") double interestRate,
			boolean active) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.active = active;
	}

	public BankAccount(@Min(value = 0, message = "Balance must be positive") double balance,
			@DecimalMin(value = "0.0", message = "interestRate > 0.0") @DecimalMax(value = "1.0", message = "interestRate < 1.0") double interestRate,
			long id, boolean active) {
		
		this.balance = balance;
		this.interestRate = interestRate;
		this.id = id;
		this.active = active;
	}
	
	public BankAccount(double balance2, double interestRate2, int term2) {
		this.balance = balance2;
		this.interestRate = interestRate2;
		this.term = term2;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
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

	
	
	public void addTransaction(Transaction transaction) {
		if(transaction.getTargetAccount().equals(this))
			transactions.add(transaction);
		else 
			sourceTransaction.add(transaction);
	}
	
	public List<Transaction>getTransactions(){
		List<Transaction> combineTransactionList = new ArrayList<>();
		combineTransactionList.addAll(transactions);
		combineTransactionList.addAll(sourceTransaction);
		return combineTransactionList;
	}
	
	
	
}
