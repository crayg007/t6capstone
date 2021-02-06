package com.T6Bank.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.T6Bank.capstoneproject.models.BankAccount;
import com.T6Bank.capstoneproject.models.RothIRA;

@Repository
public interface RothRepository extends JpaRepository <RothIRA, Long>{
	void save(BankAccount targetAccount);
}
