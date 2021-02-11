package com.T6Bank.capstoneproject.controllers;



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

import com.T6Bank.capstoneproject.payload.CurrentUser;
import com.T6Bank.capstoneproject.payload.UserPrincipal;
import com.T6Bank.capstoneproject.repository.AccountRepository;
import com.T6Bank.capstoneproject.service.DeleteService;
import com.T6Bank.capstoneproject.service.DepositService;
import com.T6Bank.capstoneproject.service.TransferService;
import com.T6Bank.capstoneproject.service.UserService;
import com.T6Bank.capstoneproject.service.WithdrawService;
import com.T6Bank.capstoneproject.transaction.DepositTransaction;
import com.T6Bank.capstoneproject.transaction.TransferTransaction;
import com.T6Bank.capstoneproject.transaction.WithdrawTransaction;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TransactionController {
	
	@Autowired
	WithdrawService withdrawService;
	@Autowired
	DepositService depositService;
	@Autowired
	TransferService transferService;
	@Autowired
	DeleteService deleteService;
	@Autowired
	UserService userService;
	@Autowired
	AccountRepository accounts;
	
	@PostMapping(value = "/User/Withdraw/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount withdraw(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody WithdrawTransaction account) {
		
	return withdrawService.getWithdraw(currentUser,id,account.getAmount());
	}
	
	@PostMapping(value = "/User/Deposit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount deposit(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@RequestBody DepositTransaction account) {
		
	return depositService.getDeposit(currentUser,id,account.getAmount());
	}
	
	@PostMapping(value = "/User/Transfer/{id}/Source/{sourceId}")
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount transfer(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@PathVariable Long sourceId,
			@RequestBody TransferTransaction account) {
		
		return transferService.getTransfer(currentUser, id, 
				sourceId,account.getAmount());
		
	}
	
	@PostMapping(value = "/User/Delete/{id}/Source/{sourceId}")
	@ResponseStatus(HttpStatus.CREATED)
	public String Delete(@CurrentUser UserPrincipal currentUser
			,@PathVariable Long id,
			@PathVariable Long sourceId) {
		return deleteService.deleteAccount(currentUser, id, sourceId);
	}
	
	@PostMapping(value = "/User/Delete")
	@ResponseStatus(HttpStatus.CREATED)
	public String DeleteAccountHolder(@CurrentUser UserPrincipal currentUser) {
		AccountHolder account = userService.getAccountHolderByUserId(currentUser);
		account.setActive(false);
		account.getUser().setActive(false);
		accounts.save(account);
		return "Account is now deleted";
	}
	
	
}
