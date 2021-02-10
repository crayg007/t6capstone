package com.T6Bank.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.T6Bank.capstoneproject.models.BankAccount;
import com.T6Bank.capstoneproject.models.DBAAccount;

@Repository
public interface DBARepository extends JpaRepository<DBAAccount, Long> {
	void save(BankAccount targetAccount);
}
