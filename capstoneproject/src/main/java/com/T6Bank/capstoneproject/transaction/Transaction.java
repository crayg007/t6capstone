package com.T6Bank.capstoneproject.transaction;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.DiscriminatorOptions;

import com.T6Bank.capstoneproject.models.BankAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "transaction_type" , discriminatorType = DiscriminatorType.STRING)
@DiscriminatorOptions(force = true)
public abstract class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	@JoinColumn(name = "source_bank_account_id")
	@JsonIgnore
	BankAccount sourceAccount;
	@ManyToOne
	@JoinColumn(name = "target_bank_account_id")
	@JsonIgnore
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
