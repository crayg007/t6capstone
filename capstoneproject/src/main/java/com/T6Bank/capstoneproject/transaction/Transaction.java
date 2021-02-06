package com.T6Bank.capstoneproject.transaction;

import java.util.Date;

import com.T6Bank.capstoneproject.models.BankAccount;



public abstract class Transaction {

	BankAccount sourceAccount;
	BankAccount targetAccount;
	private double amount;
	Date TransactionDate;
	private String reason;
	private boolean isProcessed;
	
	public BankAccount getSourceAccount() {
		return sourceAccount;
	}
	public void setSourceAccount(BankAccount sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	public BankAccount getTargetAccount() {
		return targetAccount;
	}
	public void setTargetAccount(BankAccount targetAccount) {
		this.targetAccount = targetAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getTransactionDate() {
		return TransactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		TransactionDate = transactionDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public boolean isProcessed() {
		return isProcessed;
	}
	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}
	
	public abstract void process();
	
	public boolean isProcessedByFraudTeam() {
		return isProcessed;
	}

	public void setProcessedByFraudTeam(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}

	public String getRejectionReason() {
		return reason;
	}

	public void setRejectionReason(String reason) {
		this.reason = reason;
	}
	
}
