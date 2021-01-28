package com.T6Bank.capstoneproject.models;

import javax.persistence.Entity;

@Entity
public class RothIRA extends BankAccount {

	private static double interestRate = 0.0001 ;
	private static int term = 3;
	private static double balance;
	
	RothIRA(){
		super(balance,interestRate,term);
		
	}
	
	RothIRA (double openingBalance){
		super(openingBalance,interestRate,term);
		
	}
}
