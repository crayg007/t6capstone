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
public class TransactionService {

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
	
	public BankAccount getWithdrawChecking(UserPrincipal currentUser, double amount, long id) {
		
		CheckingAccount[] c = userService.getCheckingAccount(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		WithdrawTransaction account = new WithdrawTransaction(targetAccount,amount);
		account.process();
		checkingRepository.save(targetAccount);
		return targetAccount;
	}
	
	public BankAccount getDepositChecking(UserPrincipal currentUser, double amount, long id) {
		
		CheckingAccount[] c = userService.getCheckingAccount(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		DepositTransaction account = new DepositTransaction(targetAccount,amount);
		account.process();
		checkingRepository.save(targetAccount);
		return targetAccount;
	}
	
	public BankAccount getWithdrawSavings(UserPrincipal currentUser, double amount, long id) {
		
		SavingsAccount[] c = userService.getSavingsAccount(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		WithdrawTransaction account = new WithdrawTransaction(targetAccount,amount);
		account.process();
		savingsRepository.save(targetAccount);
		return targetAccount;
	}
	
	public BankAccount getDepositSavings(UserPrincipal currentUser, double amount, long id) {
		
		SavingsAccount[] c = userService.getSavingsAccount(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		DepositTransaction account = new DepositTransaction(targetAccount,amount);
		account.process();
		savingsRepository.save(targetAccount);
		return targetAccount;
	}
	
	public BankAccount getWithdrawCD(UserPrincipal currentUser, double amount, long id) {
		
		CDAccount[] c = userService.getCDAccount(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		WithdrawTransaction account = new WithdrawTransaction(targetAccount,amount);
		account.process();
		cdAccountRepository.save(targetAccount);
		return targetAccount;
	}
	
	public BankAccount getDepositCD(UserPrincipal currentUser, double amount, long id) {
		
		CDAccount[] c = userService.getCDAccount(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		DepositTransaction account = new DepositTransaction(targetAccount,amount);
		account.process();
		cdAccountRepository.save(targetAccount);
		return targetAccount;
	}
	
	public BankAccount getWithdrawDBA(UserPrincipal currentUser, double amount, long id) {
		
		DBAAccount[] c = userService.getDBAAccount(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		WithdrawTransaction account = new WithdrawTransaction(targetAccount,amount);
		account.process();
		dbaRepository.save(targetAccount);
		return targetAccount;
	}
	
	public BankAccount getDepositDBA(UserPrincipal currentUser, double amount, long id) {
		
		DBAAccount[] c = userService.getDBAAccount(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		DepositTransaction account = new DepositTransaction(targetAccount,amount);
		account.process();
		dbaRepository.save(targetAccount);
		return targetAccount;
	}
	
	public BankAccount getWithdrawPersonal(UserPrincipal currentUser, double amount, long id) {
		
		PersonalCheckingAccount[] c = userService.getPersonalCheckingAccount(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		WithdrawTransaction account = new WithdrawTransaction(targetAccount,amount);
		account.process();
		personalRepository.save(targetAccount);
		return targetAccount;
	}
	
	public BankAccount getDepositPersonal(UserPrincipal currentUser, double amount, long id) {
		
		PersonalCheckingAccount[] c = userService.getPersonalCheckingAccount(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		DepositTransaction account = new DepositTransaction(targetAccount,amount);
		account.process();
		personalRepository.save(targetAccount);
		return targetAccount;
	}
	
	public BankAccount getWithdrawRegular(UserPrincipal currentUser, double amount, long id) {
		
		RegularIRA[] c = userService.getRegularIRA(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		WithdrawTransaction account = new WithdrawTransaction(targetAccount,amount);
		account.process();
		regularRepository.save(targetAccount);
		return targetAccount;
	}
	
	public BankAccount getDepositRegular(UserPrincipal currentUser, double amount, long id) {
		
		RegularIRA[] c = userService.getRegularIRA(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		DepositTransaction account = new DepositTransaction(targetAccount,amount);
		account.process();
		regularRepository.save(targetAccount);
		return targetAccount;
	}
	
	public BankAccount getWithdrawRollover(UserPrincipal currentUser, double amount, long id) {
		
		RolloverIRA[] c = userService.getRolloverIRA(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		WithdrawTransaction account = new WithdrawTransaction(targetAccount,amount);
		account.process();
		rolloverRepository.save(targetAccount);
		return targetAccount;
	}
	
	public BankAccount getDepositRollover(UserPrincipal currentUser, double amount, long id) {
		
		RolloverIRA[] c = userService.getRolloverIRA(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		DepositTransaction account = new DepositTransaction(targetAccount,amount);
		account.process();
		rolloverRepository.save(targetAccount);
		return targetAccount;
	}
	
	public BankAccount getWithdrawRoth(UserPrincipal currentUser, double amount, long id) {
		
		RothIRA[] c = userService.getRothIRA(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		WithdrawTransaction account = new WithdrawTransaction(targetAccount,amount);
		account.process();
		rothRepository.save(targetAccount);
		return targetAccount;
	}
	
	public BankAccount getDepositRoth(UserPrincipal currentUser, double amount, long id) {
		
		RothIRA[] c = userService.getRothIRA(currentUser);
		for(int i = 0; i < c.length; i++) {
			if (c[i].getId() == id) {
				targetAccount = c[i];
			}
		}
		
		DepositTransaction account = new DepositTransaction(targetAccount,amount);
		account.process();
		rothRepository.save(targetAccount);
		return targetAccount;
	}
}
