package com.hashedin.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashedin.bank.model.User;
import com.hashedin.bank.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(int clientId) {
		List<User> users = new ArrayList<>();
		userRepository.findByClientId(clientId).forEach(users::add);
		return users;
	}
	
	public Optional<User> getUser(int id) {
		return userRepository.findById(id);
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
}
