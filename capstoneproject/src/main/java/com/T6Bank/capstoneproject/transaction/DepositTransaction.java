package com.T6Bank.capstoneproject.transaction;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.T6Bank.capstoneproject.models.BankAccount;

@Entity
@DiscriminatorValue("deposit")
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
