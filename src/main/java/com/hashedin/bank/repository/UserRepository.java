package com.hashedin.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashedin.bank.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUserName(String username);
	
	public List<User> findByClientId(int clientId);
}