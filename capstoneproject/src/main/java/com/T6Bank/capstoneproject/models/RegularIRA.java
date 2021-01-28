package com.T6Bank.capstoneproject.models;

import javax.persistence.Entity;

@Entity
public class RegularIRA extends BankAccount {

	private static double interestRate = 0.0001 ;
	private static int term = 3;
	private static double balance;
	
	RegularIRA(){
		super(balance,interestRate,term);
		
	}
	
	RegularIRA (double openingBalance){
		super(openingBalance,interestRate,term);
		
	}
}
