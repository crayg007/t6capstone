package com.T6Bank.capstoneproject.models;

import javax.persistence.Entity;

@Entity
public class SavingsAccount extends BankAccount {
	
	private static double interestRate = 0.01 ;
	private static int term = 3;
	private static double balance;
	
	SavingsAccount(){
		super(balance,interestRate,term);
		
	}
	
	SavingsAccount (double openingBalance){
		super(openingBalance,interestRate,term);
		
	}
	
	
}
