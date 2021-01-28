package com.T6Bank.capstoneproject.models;

import javax.persistence.Entity;

@Entity
public class CheckingAccount extends BankAccount{
	
	private static double interestRate = 0.0001 ;
	private static int term = 3;
	private static double balance;
	
	CheckingAccount(){
		super(balance,interestRate,term);
		
	}
	
	CheckingAccount (double openingBalance){
		super(openingBalance,interestRate,term);
		
	}

}
