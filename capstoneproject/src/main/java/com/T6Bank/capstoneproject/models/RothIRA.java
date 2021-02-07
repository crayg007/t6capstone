package com.T6Bank.capstoneproject.models;

import javax.persistence.Entity;

@Entity
public class RothIRA extends BankAccount {

	private static double interestRate = 0.0001 ;
	private static int term = 3;
	private static double balance;
	
	RothIRA(){
		super(balance,interestRate,term,active);
		
	}
	
	RothIRA (double openingBalance,boolean active){
		super(openingBalance,interestRate,term,active);
		
	}
}
