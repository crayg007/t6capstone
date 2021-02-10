package com.T6Bank.capstoneproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.T6Bank.capstoneproject.payload.UserPrincipal;
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
		List<AccountHolder> account = new ArrayList<>();
		accountRepository.findAll()
		.forEach(account::add);
		return account;
	}
	
	public Optional<AccountHolder> getAccountById(Long id) {
		return accountRepository.findById(id);
	}
	
	public SavingsAccount[] addSavingsAccountById(SavingsAccount balance, Long id)  {
		accountRepository.getOne(id).addSavingsAccount(balance);
		return accountRepository.getOne(id).getSavingsAccount();
	}
	
	public SavingsAccount[] getSAvingsAccountById(long id) {
		return accountRepository.getOne(id).getSavingsAccount();
	}
	
	public List<SavingsAccount> getSavingsAccounts(){
		List<SavingsAccount> account = new ArrayList<>();
		savingsRepository.findAll()
		.forEach(account::add);
		return account;
	}
	
	public CheckingAccount[] addCheckingAccountById(CheckingAccount balance, Long id)  {
		checkingRepository.save(accountRepository.getOne(id).addCheckingAccount(balance));
		return accountRepository.getOne(id).getCheckingAccount();
	}
	
	public List<CheckingAccount> getCheckingAccounts(){
		List<CheckingAccount> account = new ArrayList<>();
		checkingRepository.findAll()
		.forEach(account::add);
		return account;
	}
	
	public CheckingAccount[] getCheckingAccountsbyId(Long id) {
		return accountRepository.getOne(id).getCheckingAccount();
	}
	
	public PersonalCheckingAccount[] addPersonalCheckingAccountById(PersonalCheckingAccount balance, Long id)  {
		personalRepository.save(accountRepository.getOne(id).addPersonalCheckingAccount(balance));
		return accountRepository.getOne(id).getPersonalCheckingAccount();
	}
	
	public PersonalCheckingAccount[] getPersonalCheckingAccountById(Long id) {
		return accountRepository.getOne(id).getPersonalCheckingAccount();
	}
	
	public List<PersonalCheckingAccount> getPersonalCheckingAccounts(){
		List<PersonalCheckingAccount> account = new ArrayList<>();
		personalRepository.findAll()
		.forEach(account::add);
		return account;
	}

	public DBAAccount[] addDBAAccountById(DBAAccount balance, Long id)  {
		DBARepository.save(accountRepository.getOne(id).addDBAAccount(balance));
		return accountRepository.getOne(id).getDBAAccount();
	}
	
	public DBAAccount[] getDBAAccountById(Long id) {
		return accountRepository.getOne(id).getDBAAccount();
	}
	
	public List<DBAAccount> getDBAAccounts(){
		List<DBAAccount> account = new ArrayList<>();
		DBARepository.findAll()
		.forEach(account::add);
		return account;
	}
	
	public RolloverIRA[] addRolloverIRAById(RolloverIRA balance, Long id)  {
		rolloverRepository.save(accountRepository.getOne(id).addRolloverIRA(balance));
		return accountRepository.getOne(id).getRolloverIRA();
	}
	
	public RolloverIRA[] getRolloverIRAById(Long id) {
		return accountRepository.getOne(id).getRolloverIRA();
	}
	
	public List<RolloverIRA> getRolloverIRA(){
		List<RolloverIRA> account = new ArrayList<>();
		rolloverRepository.findAll()
		.forEach(account::add);
		return account;
	}
	
	public RothIRA[] addRothIRAById(RothIRA balance, Long id)  {
		rothRepository.save(accountRepository.getOne(id).addRothIRA(balance));
		return accountRepository.getOne(id).getRothIRA();
	}
	
	public RothIRA[] getRothIraById(Long id) {
		return accountRepository.getOne(id).getRothIRA();
	}
	
	public List<RothIRA> getRothIRA(){
		List<RothIRA> account = new ArrayList<>();
		rothRepository.findAll()
		.forEach(account::add);
		return account;
	}
	
	public RegularIRA[] addRegularIRAById(RegularIRA balance, Long id)  {
		regularRepository.save(accountRepository.getOne(id).addRegularIRA(balance));
		return accountRepository.getOne(id).getRegularIRA();
	}
	
	public RegularIRA[] getRegularIRAById(long id) {
		return accountRepository.getOne(id).getRegularIRA();
	}
	
	public List<RegularIRA> getRegularIRA(){
		List<RegularIRA> account = new ArrayList<>();
		regularRepository.findAll()
		.forEach(account::add);
		return account;
	}
	
	public CDAccount[] addCDAccountById(CDAccount balance, Long id)  {
		cdAccountRepository.save(accountRepository.getOne(id).addCDAccount(balance));
		return accountRepository.getOne(id).getCDAccount();
	}
	
	public CDAccount[] getCDAccountById(long id) {
		return accountRepository.getOne(id).getCDAccount();
	}
	
	public List<CDAccount> getCDAccount(){
		List<CDAccount> account = new ArrayList<>();
		cdAccountRepository.findAll()
		.forEach(account::add);
		return account;
	}
}
