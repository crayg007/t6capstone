package com.T6Bank.capstoneproject.models;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;



@Entity
@DiscriminatorValue("cdAccount")
public class CDAccount extends BankAccount {
	
	private static double balance;
	private static int term;
	private static double interestRate;
	
//	@ManyToOne()
//	@JoinColumn(name = "cd_Offering_id")
//	private CDOffering cdOffering;
	
	public CDAccount() {
		//super(balance, interestRate, term,active);
		super(balance,interestRate,term);
	}
	
	public CDAccount(@Min(value = 0, message = "Balance must be positive") double balance,
			@DecimalMin(value = "0.0", message = "interestRate > 0.0") @DecimalMax(value = "1.0", message = "interestRate < 1.0") double interestRate,
			int term, double balance2, int term2, double interestRate2,boolean active) {
		super(balance, interestRate, term,active);
		this.balance = balance2;
		term = term2;
		interestRate = interestRate2;
	}

	public CDAccount(CDOffering cdOffering, double balance,boolean active) {
		super(balance, interestRate, term,active);
		//this.cdOffering = cdOffering;
		this.balance = balance;
		term = cdOffering.getTerm();
		interestRate = cdOffering.getInterestRate();
		
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

//	public CDOffering getCdOffering() {
//		return cdOffering;
//	}
//
//	public void setCdOffering(CDOffering cdOffering) {
//		this.cdOffering = cdOffering;
//	}
	
	

}
