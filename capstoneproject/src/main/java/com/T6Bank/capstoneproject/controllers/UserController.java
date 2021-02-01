package com.T6Bank.capstoneproject.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
import com.T6Bank.capstoneproject.service.UserService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;
	
	@GetMapping(value = "/User")
	@ResponseStatus(HttpStatus.OK)
	public  AccountHolder getAccount(@CurrentUser UserPrincipal currentUser){
		
		return userService.getAccountHolderByUserId(currentUser);
	}
	
	@PostMapping(value = "/User/CheckingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingAccount(@CurrentUser UserPrincipal currentUser
			,@RequestBody @Valid CheckingAccount  balance)throws NoSuchResourceFoundException{
		
		 userService.addCheckingAccountByUser(currentUser, balance);
		return balance;
	}
	
	@GetMapping(value = "/User/CheckingAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CheckingAccount> getCheckingAccount(@CurrentUser UserPrincipal currentUser) throws NoSuchResourceFoundException {
		
		return accountService.getCheckingAccounts();
	}
	
	@PostMapping(value = "/User/SavingsAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsAccount(@CurrentUser UserPrincipal currentUser
			,@RequestBody @Valid SavingsAccount  balance)throws NoSuchResourceFoundException{
		
		 userService.addSavingsAccountByUser(currentUser, balance);
		return balance;
	}
	
	@GetMapping(value = "/User/SavingsAccount")
	@ResponseStatus(HttpStatus.OK)
	public List<SavingsAccount> getSavingsAccount() throws NoSuchResourceFoundException {
		
		return accountService.getSavingsAccounts();
	}
	
	@PostMapping(value = "/User/Personal")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonalCheckingAccount addPersonalCheckingAccount(@CurrentUser UserPrincipal currentUser
			,@RequestBody @Valid PersonalCheckingAccount  balance)throws NoSuchResourceFoundException{
		
		 userService.addPersonalCheckingAccountByUser(currentUser, balance);
		return balance;
	}
	
	@GetMapping(value = "/User/Personal")
	@ResponseStatus(HttpStatus.OK)
	public List<PersonalCheckingAccount> getPersonalCheckingAccount() throws NoSuchResourceFoundException {
		
		return accountService.getPersonalCheckingAccounts();
	}
	
	@PostMapping(value = "/User/DBA")
	@ResponseStatus(HttpStatus.CREATED)
	public DBAAccount addDBAAccount(@CurrentUser UserPrincipal currentUser
			,@RequestBody @Valid DBAAccount  balance)throws NoSuchResourceFoundException{
		
		 userService.addDBAAccountByUser(currentUser, balance);
		return balance;
	}
	
	@GetMapping(value = "/User/DBA")
	@ResponseStatus(HttpStatus.OK)
	public List<DBAAccount> getDBAAccount() throws NoSuchResourceFoundException {
		
		return accountService.getDBAAccounts();
	}
	
	@PostMapping(value = "/User/CDAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDAccount(@CurrentUser UserPrincipal currentUser
			,@RequestBody @Valid CDAccount  balance)throws NoSuchResourceFoundException{
		
		 userService.addCDAccountByUser(currentUser, balance);
		return balance;
	}
	
	@GetMapping(value = "/User/CDAccount")
	@ResponseStatus(HttpStatus.OK)
	public List<CDAccount> getCDAccount() throws NoSuchResourceFoundException {
		
		return accountService.getCDAccount();
	}
	
	@PostMapping(value = "/User/RegularIRA")
	@ResponseStatus(HttpStatus.CREATED)
	public RegularIRA addRegularIRA(@CurrentUser UserPrincipal currentUser
			,@RequestBody @Valid RegularIRA  balance)throws NoSuchResourceFoundException{
		
		 userService.addRegularIRAByUser(currentUser, balance);
		return balance;
	}
	
	@GetMapping(value = "/User/RegularIRA")
	@ResponseStatus(HttpStatus.OK)
	public List<RegularIRA> getRegularIRA() throws NoSuchResourceFoundException {
		
		return accountService.getRegularIRA();
	}
	
	@PostMapping(value = "/User/RolloverIRA")
	@ResponseStatus(HttpStatus.CREATED)
	public RolloverIRA addRolloverIRA(@CurrentUser UserPrincipal currentUser
			,@RequestBody @Valid RolloverIRA  balance)throws NoSuchResourceFoundException{
		
		 userService.addRolloverIRAByUser(currentUser, balance);
		return balance;
	}
	
	@GetMapping(value = "/User/RolloverIRA")
	@ResponseStatus(HttpStatus.OK)
	public List<RolloverIRA> getRolloverIRA() throws NoSuchResourceFoundException {
		
		return accountService.getRolloverIRA();
	}
	
	@PostMapping(value = "/User/RothIRA")
	@ResponseStatus(HttpStatus.CREATED)
	public RothIRA addRothIRA(@CurrentUser UserPrincipal currentUser
			,@RequestBody @Valid RothIRA  balance)throws NoSuchResourceFoundException{
		
		 userService.addRothIRAByUser(currentUser, balance);
		return balance;
	}
	
	@GetMapping(value = "/User/RothIRA")
	@ResponseStatus(HttpStatus.OK)
	public List<RothIRA> getRothIRA() throws NoSuchResourceFoundException {
		
		return accountService.getRothIRA();
	}

}
