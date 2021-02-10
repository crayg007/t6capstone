package com.T6Bank.capstoneproject.transaction;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.T6Bank.capstoneproject.models.BankAccount;

@Entity
@DiscriminatorValue("transfer")
public class TransferTransaction extends Transaction {

	public TransferTransaction() {}
	public TransferTransaction(BankAccount sourceAccount, BankAccount targetAccount, double amount){
		
		setTargetAccount(targetAccount);
		setSourceAccount(sourceAccount);
		setAmount(amount);
	}
	
	public void process() {
		
		if (sourceAccount.withdraw(getAmount()) && targetAccount.deposit(getAmount()) == true) {
			String reason = "Transfer: $" + getAmount();
			setReason(reason);
		} else {
			String reason = "Failed to transfer this: $" +getAmount();
			setRejectionReason(reason);
		}
		
	}
}
