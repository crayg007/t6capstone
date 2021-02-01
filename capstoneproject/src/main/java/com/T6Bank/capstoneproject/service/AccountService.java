package com.T6Bank.capstoneproject.service;

import java.util.List;
import java.util.Optional;

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
import com.T6Bank.capstoneproject.repository.AccountRepository;
import com.T6Bank.capstoneproject.repository.CDAccountRepository;
import com.T6Bank.capstoneproject.repository.CheckingRepository;
import com.T6Bank.capstoneproject.repository.PersonalRepository;
import com.T6Bank.capstoneproject.repository.RegularRepository;
import com.T6Bank.capstoneproject.repository.RolloverRepository;
import com.T6Bank.capstoneproject.repository.RothRepository;
import com.T6Bank.capstoneproject.repository.SavingsRepository;
import com.T6Bank.capstoneproject.repository.DBARepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private SavingsRepository savingsRepository;
	
	@Autowired
	private CheckingRepository checkingRepository;
	
	@Autowired
	private PersonalRepository personalRepository;
	
	@Autowired
	private DBARepository DBARepository;
	
	@Autowired
	private RolloverRepository rolloverRepository;
	
	@Autowired
	private RothRepository rothRepository;
	
	@Autowired
	private RegularRepository regularRepository;
	
	@Autowired
	private CDAccountRepository cdAccountRepository;
	
	public AccountHolder addAccount(AccountHolder account) {
		return accountRepository.save(account);
	}
	
	public List<AccountHolder> getAccount() {
		return accountRepository.findAll();
	}
	
	public Optional<AccountHolder> getAccountById(Long id) {
		return accountRepository.findById(id);
	}
	
	public SavingsAccount addSavingsAccountById(SavingsAccount balance, Long id)  {
		savingsRepository.save(accountRepository.getOne(id).addSavingsAccount(balance));
		return balance;
	}
	
	public List<SavingsAccount> getSavingsAccounts(){
		return savingsRepository.findAll();
	}
	
	public CheckingAccount addCheckingAccountById(CheckingAccount balance, Long id)  {
		checkingRepository.save(accountRepository.getOne(id).addCheckingAccount(balance));
		return balance;
	}
	
	public List<CheckingAccount> getCheckingAccounts(){
		return checkingRepository.findAll();
	}
	
	public PersonalCheckingAccount addPersonalCheckingAccountById(PersonalCheckingAccount balance, Long id)  {
		personalRepository.save(accountRepository.getOne(id).addPersonalCheckingAccount(balance));
		return balance;
	}
	
	public List<PersonalCheckingAccount> getPersonalCheckingAccounts(){
		return personalRepository.findAll();
	}

	public DBAAccount addDBAAccountById(DBAAccount balance, Long id)  {
		DBARepository.save(accountRepository.getOne(id).addDBAAccount(balance));
		return balance;
	}
	
	public List<DBAAccount> getDBAAccounts(){
		return DBARepository.findAll();
	}
	
	public RolloverIRA addRolloverIRAById(RolloverIRA balance, Long id)  {
		rolloverRepository.save(accountRepository.getOne(id).addRolloverIRA(balance));
		return balance;
	}
	
	public List<RolloverIRA> getRolloverIRA(){
		return rolloverRepository.findAll();
	}
	
	public RothIRA addRothIRAById(RothIRA balance, Long id)  {
		rothRepository.save(accountRepository.getOne(id).addRothIRA(balance));
		return balance;
	}
	
	public List<RothIRA> getRothIRA(){
		return rothRepository.findAll();
	}
	
	public RegularIRA addRegularIRAById(RegularIRA balance, Long id)  {
		regularRepository.save(accountRepository.getOne(id).addRegularIRA(balance));
		return balance;
	}
	
	public List<RegularIRA> getRegularIRA(){
		return regularRepository.findAll();
	}
	
	public CDAccount addCDAccountById(CDAccount balance, Long id)  {
		cdAccountRepository.save(accountRepository.getOne(id).addCDAccount(balance));
		return balance;
	}
	
	public List<CDAccount> getCDAccount(){
		return cdAccountRepository.findAll();
	}
}
