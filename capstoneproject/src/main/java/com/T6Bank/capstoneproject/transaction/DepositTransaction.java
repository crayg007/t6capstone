package com.T6Bank.capstoneproject.transaction;

import com.T6Bank.capstoneproject.models.BankAccount;

public class DepositTransaction extends Transaction {
	
	public DepositTransaction() {}
	public DepositTransaction(BankAccount targetAccount, double amount){
		
		setTargetAccount(targetAccount);
		setAmount(amount);
	}
	
	public void process() {
		
		if (targetAccount.deposit(getAmount()) == true) {
			String reason = "Deposit: $" + getAmount();
			setReason(reason);
		} else {
			String reason = "Failed to deposit this: $" +getAmount();
			setRejectionReason(reason);
		}
		
	}
}
