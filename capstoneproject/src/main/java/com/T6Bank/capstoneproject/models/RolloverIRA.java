package com.T6Bank.capstoneproject.models;

import javax.persistence.Entity;

@Entity
public class RolloverIRA extends BankAccount {

	private static double interestRate = 0.0001 ;
	private static int term = 3;
	private static double balance;
	
	RolloverIRA(){
		super(balance,interestRate,term,active);
		
	}
	
	RolloverIRA (double openingBalance,boolean active){
		super(openingBalance,interestRate,term,active);
		
	}
}
