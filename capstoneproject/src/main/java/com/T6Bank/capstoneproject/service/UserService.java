package com.T6Bank.capstoneproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.T6Bank.capstoneproject.models.AccountHolder;
import com.T6Bank.capstoneproject.models.CDAccount;
import com.T6Bank.capstoneproject.models.CheckingAccount;
import com.T6Bank.capstoneproject.models.DBAAccount;
import com.T6Bank.capstoneproject.models.PersonalCheckingAccount;
import com.T6Bank.capstoneproject.models.RegularIRA;
import com.T6Bank.capstoneproject.models.RolloverIRA;
import com.T6Bank.capstoneproject.models.RothIRA;
import com.T6Bank.capstoneproject.models.SavingsAccount;
import com.T6Bank.capstoneproject.payload.UserPrincipal;
import com.T6Bank.capstoneproject.repository.AccountRepository;
import com.T6Bank.capstoneproject.repository.CDAccountRepository;
import com.T6Bank.capstoneproject.repository.CheckingRepository;
import com.T6Bank.capstoneproject.repository.DBARepository;
import com.T6Bank.capstoneproject.repository.PersonalRepository;
import com.T6Bank.capstoneproject.repository.RegularRepository;
import com.T6Bank.capstoneproject.repository.RolloverRepository;
import com.T6Bank.capstoneproject.repository.RothRepository;
import com.T6Bank.capstoneproject.repository.SavingsRepository;



@Service
public class UserService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	SavingsRepository savingsRepository;
	
	@Autowired
	CDAccountRepository cdAccountRepository;
	
	@Autowired
	CheckingRepository checkingRepository;
	
	@Autowired
	DBARepository dbaRepository;
	
	@Autowired
	PersonalRepository personalRepository;
	
	@Autowired
	RegularRepository regularRepository;
	
	@Autowired
	RolloverRepository rolloverRepository;
	
	@Autowired
	RothRepository rothRepository;
	
	 public List<AccountHolder> getAccountHoldersByUserId(UserPrincipal currentUser) {
		 // Retrieve account by the logged in user
		
		List<AccountHolder> userAccount = new ArrayList<>();
		accountRepository.findByUserIdIn(currentUser.getId())
		.forEach(userAccount::add);
		
		return userAccount;
	}
	 
	 public AccountHolder getAccountHolderByUserId(UserPrincipal currentUser) {
			
		 return accountRepository.findByUserId(currentUser.getId());
	 }
	 
	 public CheckingAccount addCheckingAccountByUser(UserPrincipal currentUser, CheckingAccount balance) {
		 checkingRepository.save((getAccountHolderByUserId(currentUser).addCheckingAccount(balance)));
		 return balance;
	 }
	 
	 public SavingsAccount addSavingsAccountByUser(UserPrincipal currentUser, SavingsAccount balance) {
		 savingsRepository.save((getAccountHolderByUserId(currentUser).addSavingsAccount(balance)));
		 return balance;
	 }
	 
	 public CDAccount addCDAccountByUser(UserPrincipal currentUser, CDAccount balance) {
		 cdAccountRepository.save((getAccountHolderByUserId(currentUser).addCDAccount(balance)));
		 return balance;
	 }
	 
	 public DBAAccount addDBAAccountByUser(UserPrincipal currentUser, DBAAccount balance) {
		 dbaRepository.save(getAccountHolderByUserId(currentUser).addDBAAccount(balance));
		 return balance;
	 }
	 
	 public PersonalCheckingAccount addPersonalCheckingAccountByUser(UserPrincipal currentUser, PersonalCheckingAccount balance) {
		 personalRepository.save(getAccountHolderByUserId(currentUser).addPersonalCheckingAccount(balance));
		 return balance;
	 }
	 
	 public RegularIRA addRegularIRAByUser(UserPrincipal currentUser, RegularIRA balance) {
		 regularRepository.save(getAccountHolderByUserId(currentUser).addRegularIRA(balance));
		 return balance;
	 }
	 
	 public RolloverIRA addRolloverIRAByUser(UserPrincipal currentUser, RolloverIRA balance) {
		 rolloverRepository.save(getAccountHolderByUserId(currentUser).addRolloverIRA(balance));
		 return balance;
	 }
	 
	 public RothIRA addRothIRAByUser(UserPrincipal currentUser, RothIRA balance) {
		 rothRepository.save(getAccountHolderByUserId(currentUser).addRothIRA(balance));
		 return balance;
	 }

}
