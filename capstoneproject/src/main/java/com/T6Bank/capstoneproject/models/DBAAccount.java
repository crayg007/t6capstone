package com.T6Bank.capstoneproject.models;

import javax.persistence.Entity;

@Entity
public class DBAAccount extends BankAccount {

	private static double interestRate = 0.0001 ;
	private static int term = 3;
	private static double balance;
	
	DBAAccount(){
		super(balance,interestRate,term);
		
	}
	
	DBAAccount (double openingBalance){
		super(openingBalance,interestRate,term);
		
	}
}
