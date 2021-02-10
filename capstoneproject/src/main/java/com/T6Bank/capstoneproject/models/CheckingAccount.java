package com.T6Bank.capstoneproject.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("checking")
public class CheckingAccount extends BankAccount{
	
	private static double interestRate = 0.0001 ;
	private static int term = 3;
	private static double balance;
	
	CheckingAccount(){
		//super(balance,interestRate,term,active);
		super(balance,interestRate,term);
	}
	
	CheckingAccount (double openingBalance,boolean active){
		super(openingBalance,interestRate,term,active);
		
	}

}
