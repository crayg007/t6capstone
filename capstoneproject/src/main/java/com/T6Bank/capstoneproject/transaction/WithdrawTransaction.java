package com.T6Bank.capstoneproject.transaction;

import java.util.Optional;


import com.T6Bank.capstoneproject.models.BankAccount;
import com.T6Bank.capstoneproject.models.CheckingAccount;


public class WithdrawTransaction extends Transaction {

	public WithdrawTransaction() {}
	public WithdrawTransaction(BankAccount targetAccount, double amount){
		setTargetAccount(targetAccount);
		setAmount(amount);
	}
	
	
	public void process() {
		
		if (targetAccount.withdraw(getAmount()) == true) {
			String reason = "Withdraw: $" + getAmount();
			setReason(reason);
		} else {
			String reason = "Failed to withdraw this: $" +getAmount();
			setRejectionReason(reason);
		}
	}

}
