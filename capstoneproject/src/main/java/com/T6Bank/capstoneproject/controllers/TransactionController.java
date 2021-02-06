package com.T6Bank.capstoneproject.controllers;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.T6Bank.capstoneproject.models.AccountHolder;
import com.T6Bank.capstoneproject.models.BankAccount;
import com.T6Bank.capstoneproject.models.CheckingAccount;
import com.T6Bank.capstoneproject.payload.CurrentUser;
import com.T6Bank.capstoneproject.payload.UserPrincipal;
import com.T6Bank.capstoneproject.repository.AccountRepository;
import com.T6Bank.capstoneproject.repository.CheckingRepository;
import com.T6Bank.capstoneproject.service.AccountService;
import com.T6Bank.capstoneproject.service.TransactionService;
import com.T6Bank.capstoneproject.service.UserService;
import com.T6Bank.capstoneproject.transaction.DepositTransaction;
import com.T6Bank.capstoneproject.transaction.Transaction;
import com.T6Bank.capstoneproject.transaction.WithdrawTransaction;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping(value = "/User/CheckingAccounts/Withdraw/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount withdrawChecking(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody WithdrawTransaction account) {
		
	return transactionService.getWithdrawChecking(currentUser, account.getAmount(), id);
	}
	
	@PostMapping(value = "/User/CheckingAccounts/Deposit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount depositChecking(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody DepositTransaction account) {
		
	return transactionService.getDepositChecking(currentUser, account.getAmount(), id);
	}
	
	@PostMapping(value = "/User/SavingsAccounts/Withdraw/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount withdrawSavings(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody WithdrawTransaction account) {
		
	return transactionService.getWithdrawSavings(currentUser, account.getAmount(), id);
	}
	
	@PostMapping(value = "/User/SavingsAccounts/Deposit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount depositSavings(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody DepositTransaction account) {
		
	return transactionService.getDepositSavings(currentUser, account.getAmount(), id);
	}
	
	@PostMapping(value = "/User/CDAccounts/Withdraw/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount withdrawCD(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody WithdrawTransaction account) {
		
	return transactionService.getWithdrawCD(currentUser, account.getAmount(), id);
	}
	
	@PostMapping(value = "/User/CDAccounts/Deposit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount depositCD(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody DepositTransaction account) {
		
	return transactionService.getDepositCD(currentUser, account.getAmount(), id);
	}
	
	@PostMapping(value = "/User/DBAAccounts/Withdraw/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount withdrawDBA(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody WithdrawTransaction account) {
		
	return transactionService.getWithdrawDBA(currentUser, account.getAmount(), id);
	}
	
	@PostMapping(value = "/User/DBAAccounts/Deposit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount depositDBA(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody DepositTransaction account) {
		
	return transactionService.getDepositDBA(currentUser, account.getAmount(), id);
	}
	
	@PostMapping(value = "/User/Personal/Withdraw/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount withdrawPersonal(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody WithdrawTransaction account) {
		
	return transactionService.getWithdrawPersonal(currentUser, account.getAmount(), id);
	}
	
	@PostMapping(value = "/User/Personal/Deposit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount depositPersonal(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody DepositTransaction account) {
		
	return transactionService.getDepositPersonal(currentUser, account.getAmount(), id);
	}
	
	@PostMapping(value = "/User/Regular/Withdraw/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount withdrawRegular(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody WithdrawTransaction account) {
		
	return transactionService.getWithdrawRegular(currentUser, account.getAmount(), id);
	}
	
	@PostMapping(value = "/User/Regular/Deposit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount depositRegular(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody DepositTransaction account) {
		
	return transactionService.getDepositRegular(currentUser, account.getAmount(), id);
	}
	
	@PostMapping(value = "/User/Rollover/Withdraw/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount withdrawRollover(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody WithdrawTransaction account) {
		
	return transactionService.getWithdrawRollover(currentUser, account.getAmount(), id);
	}
	
	@PostMapping(value = "/User/Rollover/Deposit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount depositRollover(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody DepositTransaction account) {
		
	return transactionService.getDepositRollover(currentUser, account.getAmount(), id);
	}
	
	@PostMapping(value = "/User/Roth/Withdraw/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount withdrawRoth(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody WithdrawTransaction account) {
		
	return transactionService.getWithdrawRoth(currentUser, account.getAmount(), id);
	}
	
	@PostMapping(value = "/User/Roth/Deposit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount depositRoth(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody DepositTransaction account) {
		
	return transactionService.getDepositRoth(currentUser, account.getAmount(), id);
	}
}
