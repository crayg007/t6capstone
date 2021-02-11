package com.T6Bank.capstoneproject.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("saving")
public class SavingsAccount extends BankAccount {
	
	private static double interestRate = 0.01 ;
	private static int term = 3;
	private static double balance;
	
	SavingsAccount(){
		//super(balance,interestRate,term,active);
		super(balance,interestRate,term);
	}
	
	SavingsAccount (double openingBalance,boolean active){
		super(openingBalance,interestRate,term,active);
		
	}
	
	
}
