package com.T6Bank.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.T6Bank.capstoneproject.models.PersonalCheckingAccount;



@Repository
public interface PersonalRepository extends JpaRepository<PersonalCheckingAccount, Long> {

}
