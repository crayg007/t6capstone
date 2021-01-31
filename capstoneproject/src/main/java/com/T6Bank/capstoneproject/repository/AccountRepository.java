package com.T6Bank.capstoneproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.T6Bank.capstoneproject.models.AccountHolder;



@Repository
public interface AccountRepository extends JpaRepository<AccountHolder, Long>{
	
	@Query("SELECT a FROM AccountHolder a where a.user.id = :userId")
    List<AccountHolder> findByUserIdIn(@Param("userId") Long userId);

    @Query("SELECT a FROM AccountHolder a where a.user.id = :userId")
    AccountHolder findByUserId(@Param("userId") Long userId);
    
   
}
