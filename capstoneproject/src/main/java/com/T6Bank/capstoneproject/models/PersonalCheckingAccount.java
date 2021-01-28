package com.T6Bank.capstoneproject.models;

import javax.persistence.Entity;

@Entity
public class PersonalCheckingAccount extends BankAccount {

	private static double interestRate = 0.0001 ;
	private static int term = 3;
	private static double balance;
	
	PersonalCheckingAccount(){
		super(balance,interestRate,term);
		
	}
	
	PersonalCheckingAccount (double openingBalance){
		super(openingBalance,interestRate,term);
		
	}
}
