package com.T6Bank.capstoneproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.T6Bank.capstoneproject.models.BankAccount;
import com.T6Bank.capstoneproject.models.CDAccount;
import com.T6Bank.capstoneproject.models.CheckingAccount;
import com.T6Bank.capstoneproject.models.DBAAccount;
import com.T6Bank.capstoneproject.models.PersonalCheckingAccount;
import com.T6Bank.capstoneproject.models.RegularIRA;
import com.T6Bank.capstoneproject.models.RolloverIRA;
import com.T6Bank.capstoneproject.models.RothIRA;
import com.T6Bank.capstoneproject.models.SavingsAccount;
import com.T6Bank.capstoneproject.payload.UserPrincipal;
import com.T6Bank.capstoneproject.repository.CDAccountRepository;
import com.T6Bank.capstoneproject.repository.CheckingRepository;
import com.T6Bank.capstoneproject.repository.DBARepository;
import com.T6Bank.capstoneproject.repository.PersonalRepository;
import com.T6Bank.capstoneproject.repository.RegularRepository;
import com.T6Bank.capstoneproject.repository.RolloverRepository;
import com.T6Bank.capstoneproject.repository.RothRepository;
import com.T6Bank.capstoneproject.repository.SavingsRepository;
import com.T6Bank.capstoneproject.transaction.DepositTransaction;
import com.T6Bank.capstoneproject.transaction.WithdrawTransaction;

@Service
public class DepositService {

	@Autowired
	UserService userService;
	@Autowired
	CheckingRepository checkingRepository;
	@Autowired
	SavingsRepository savingsRepository;
	@Autowired
	CDAccountRepository cdAccountRepository;
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
	BankAccount targetAccount;
	
	String account;
	
	public BankAccount getDeposit(UserPrincipal currentUser, long id, 
			double amount) {
		CheckingAccount[] c = userService.getCheckingAccount(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
				account = "checking";
			}
			
		}
		SavingsAccount[] s = userService.getSavingsAccount(currentUser);
		for(int i = 0; i < s.length; i++) {
			if (s[i].getId() == id) {
				targetAccount = s[i];
				account = "savings";
			}
			
		}
		DBAAccount[] dba = userService.getDBAAccount(currentUser);
		for(int i = 0; i < dba.length; i++) {
			if (dba[i].getId() == id) {
				targetAccount = dba[i];
				account = "dba";
			}
			
		}
		PersonalCheckingAccount[] personal = userService.getPersonalCheckingAccount(currentUser);
		for(int i = 0; i < personal.length; i++) {
			if (personal[i].getId() == id) {
				targetAccount = personal[i];
				account = "personal";
			}
			
		}
		RegularIRA[] reg = userService.getRegularIRA(currentUser);
		for(int i = 0; i < reg.length; i++) {
			if (reg[i].getId() == id) {
				targetAccount = reg[i];
				account = "regular";
			}
			
		}
		RolloverIRA[] roll = userService.getRolloverIRA(currentUser);
		for(int i = 0; i < roll.length; i++) {
			if (roll[i].getId() == id) {
				targetAccount = roll[i];
				account = "roll";
			}
		
		}
		RothIRA[] roth = userService.getRothIRA(currentUser);
		for(int i = 0; i < roth.length; i++) {
			if (roth[i].getId() == id) {
				targetAccount = roth[i];
				account = "roth";
			}
		
		}
		CDAccount[] cd = userService.getCDAccount(currentUser);
		for(int i = 0; i < cd.length; i++) {
			if (cd[i].getId() == id) {
				targetAccount = cd[i];
				account = "cd";
			}
			
		}
		doDeposit(targetAccount,amount,account);
		return targetAccount;
	}
	
	public void doDeposit(BankAccount targetAccount,
			double amount, String account) {
		DepositTransaction withdraw = new DepositTransaction(targetAccount, amount);
		withdraw.process();
		
		if(account.equals("checking")) {
			checkingRepository.save(targetAccount);
		}
		if(account.equals("savings")) {
			savingsRepository.save(targetAccount);
		}
		if(account.equals("dba")) {
			dbaRepository.save(targetAccount);
		}
		if(account.equals("personal")) {
			personalRepository.save(targetAccount);
		}
		if(account.equals("regular")) {
			regularRepository.save(targetAccount);
		}
		if(account.equals("roll")) {
			rolloverRepository.save(targetAccount);
		}
		if(account.equals("roth")) {
			rothRepository.save(targetAccount);
		}
		if(account.equals("cd")) {
			cdAccountRepository.save(targetAccount);
		}
	}
}
