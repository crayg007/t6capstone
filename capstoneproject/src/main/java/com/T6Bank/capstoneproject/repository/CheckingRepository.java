package com.T6Bank.capstoneproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.T6Bank.capstoneproject.models.BankAccount;
import com.T6Bank.capstoneproject.models.CheckingAccount;



@Repository
public interface CheckingRepository extends JpaRepository<CheckingAccount, Long>{

	void save(BankAccount targetAccount);

	
}
