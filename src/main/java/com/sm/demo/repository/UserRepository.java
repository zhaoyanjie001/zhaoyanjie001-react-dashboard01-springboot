package com.sm.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.demo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	  Optional<User> findByUsername(String username);
	  Optional<User> findByUsername(User user);
	  Boolean existsByUsername(String username);
	  
	  Boolean existsByEmail(String email);
	  List<User> findAll();
}
