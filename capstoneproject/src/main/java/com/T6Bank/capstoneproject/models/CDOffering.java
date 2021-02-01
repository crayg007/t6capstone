package com.T6Bank.capstoneproject.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class CDOffering {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int term;
	private double interestRate;
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cdOffering")
//	@OrderColumn
//	private CDAccount cdAccount;
	
	public CDOffering() {
		
	}

	public CDOffering(int term, double interestRate) {
		
		this.term = term;
		this.interestRate = interestRate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

//	public CDAccount getCdAccount() {
//		return cdAccount;
//	}
//
//	public void setCdAccount(CDAccount cdAccount) {
//		this.cdAccount = cdAccount;
//	}
	
	

}
