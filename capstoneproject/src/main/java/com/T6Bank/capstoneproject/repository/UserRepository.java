package com.T6Bank.capstoneproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.T6Bank.capstoneproject.models.User;
import com.T6Bank.capstoneproject.payload.UserPrincipal;



@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u WHERE u.username = :username")
	Optional<User> findByUsername(@Param("username")String username);
	
	List<User> findByIdIn(List<Long> userIds);
	Boolean existsByUsername(String username);

	void save(UserPrincipal currentUser);

	
}
