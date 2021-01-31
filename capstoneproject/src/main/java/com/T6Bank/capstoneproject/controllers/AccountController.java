package com.T6Bank.capstoneproject.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.T6Bank.capstoneproject.exception.NoSuchResourceFoundException;
import com.T6Bank.capstoneproject.models.AccountHolder;
import com.T6Bank.capstoneproject.models.CDAccount;
import com.T6Bank.capstoneproject.models.CheckingAccount;
import com.T6Bank.capstoneproject.models.DBAAccount;
import com.T6Bank.capstoneproject.models.PersonalCheckingAccount;
import com.T6Bank.capstoneproject.models.RegularIRA;
import com.T6Bank.capstoneproject.models.RolloverIRA;
import com.T6Bank.capstoneproject.models.RothIRA;
import com.T6Bank.capstoneproject.models.SavingsAccount;
import com.T6Bank.capstoneproject.payload.CurrentUser;
import com.T6Bank.capstoneproject.payload.UserPrincipal;
import com.T6Bank.capstoneproject.service.AccountService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@CurrentUser UserPrincipal currentUser,@RequestBody @Valid AccountHolder account) {
		account.setUser(currentUser.getId());
		accountService.addAccount(account);
		return account;
	}
	
	@GetMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.OK)
	public List<AccountHolder> getAccountHolder(){
		return accountService.getAccount();
	}
	
	@GetMapping(value = "/AccountHolders/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<AccountHolder> getAccountHolderById(@PathVariable Long id) throws NoSuchResourceFoundException {
		return accountService.getAccountById(id);
	}
	
	@PostMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addByIdSavingsAccount(@PathVariable Long id, 
			@RequestBody SavingsAccount  balance)throws NoSuchResourceFoundException{
		return accountService.addSavingsAccountById(balance, id);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<SavingsAccount> getPostByIdSavingsAccount(@PathVariable Long id) throws NoSuchResourceFoundException {
		return accountService.getSavingsAccounts();
	}
	
	@PostMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addByIdCheckingAccount(@PathVariable Long id, 
			@RequestBody CheckingAccount  balance)throws NoSuchResourceFoundException{
		return accountService.addCheckingAccountById(balance, id);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CheckingAccount> getPostByIdCheckingAccount(@PathVariable Long id) throws NoSuchResourceFoundException {
		return accountService.getCheckingAccounts();
	}
	
	@PostMapping(value = "/AccountHolders/{id}/PersonalChecking")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonalCheckingAccount addByIdPersonalCheckingAccount(@PathVariable Long id, 
			@RequestBody PersonalCheckingAccount  balance)throws NoSuchResourceFoundException{
		return accountService.addPersonalCheckingAccountById(balance, id);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/PersonalChecking")
	@ResponseStatus(HttpStatus.OK)
	public List<PersonalCheckingAccount> getPostByIdPersonalCheckingAccount(@PathVariable Long id) throws NoSuchResourceFoundException {
		return accountService.getPersonalCheckingAccounts();
	}
	
	@PostMapping(value = "/AccountHolders/{id}/DBA")
	@ResponseStatus(HttpStatus.CREATED)
	public DBAAccount addByIdDBAAccount(@PathVariable Long id, 
			@RequestBody DBAAccount  balance)throws NoSuchResourceFoundException{
		return accountService.addDBAAccountById(balance, id);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/DBA")
	@ResponseStatus(HttpStatus.OK)
	public List<DBAAccount> getPostByIdDBAAccount(@PathVariable Long id) throws NoSuchResourceFoundException {
		return accountService.getDBAAccounts();
	}
	
	@PostMapping(value = "/AccountHolders/{id}/Rollover")
	@ResponseStatus(HttpStatus.CREATED)
	public RolloverIRA addByIdRolloverIRA(@PathVariable Long id, 
			@RequestBody RolloverIRA  balance)throws NoSuchResourceFoundException{
		return accountService.addRolloverIRAById(balance, id);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/Rollover")
	@ResponseStatus(HttpStatus.OK)
	public List<RolloverIRA> getPostByIdRolloverIRA(@PathVariable Long id) throws NoSuchResourceFoundException {
		return accountService.getRolloverIRA();
	}
	
	@PostMapping(value = "/AccountHolders/{id}/Roth")
	@ResponseStatus(HttpStatus.CREATED)
	public RothIRA addByIdRothIRA(@PathVariable Long id, 
			@RequestBody RothIRA  balance)throws NoSuchResourceFoundException{
		return accountService.addRothIRAById(balance, id);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/Roth")
	@ResponseStatus(HttpStatus.OK)
	public List<RothIRA> getPostByIdRothIRA(@PathVariable Long id) throws NoSuchResourceFoundException {
		return accountService.getRothIRA();
	}
	
	@PostMapping(value = "/AccountHolders/{id}/Regular")
	@ResponseStatus(HttpStatus.CREATED)
	public RegularIRA addByIdRegularIRA(@PathVariable Long id, 
			@RequestBody RegularIRA  balance)throws NoSuchResourceFoundException{
		return accountService.addRegularIRAById(balance, id);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/Regular")
	@ResponseStatus(HttpStatus.OK)
	public List<RegularIRA> getPostByIdRegularIRA(@PathVariable Long id) throws NoSuchResourceFoundException {
		return accountService.getRegularIRA();
	}
	
	@PostMapping(value = "/AccountHolders/{id}/CDAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addByIdCDAccount(@PathVariable Long id, 
			@RequestBody CDAccount  balance)throws NoSuchResourceFoundException{
		return accountService.addCDAccountById(balance, id);
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CDAccount")
	@ResponseStatus(HttpStatus.OK)
	public List<CDAccount> getPostByIdCDAccount(@PathVariable Long id) throws NoSuchResourceFoundException {
		return accountService.getCDAccount();
	}

}
