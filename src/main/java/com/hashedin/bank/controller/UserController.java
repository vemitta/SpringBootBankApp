package com.hashedin.bank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hashedin.bank.model.Card;
import com.hashedin.bank.model.Client;
import com.hashedin.bank.model.User;
import com.hashedin.bank.repository.UserRepository;
import com.hashedin.bank.service.CustomUserDetails;
import com.hashedin.bank.service.UserService;
import com.hashedin.bank.util.ExpiryDateGenerator;
import com.hashedin.bank.util.RandomNumberGenerator;

@RestController
@RequestMapping("/secure/rest/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/clients/{id}/users")
	public List<User> getAllUsers(@PathVariable int id) throws Exception {
		final String userName = userDetailsService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getUsername();
		System.out.println("path variable, client id is " + id);
		System.out.println("Authenticated User Name is " + userName);
		System.out.println("Authenticated User client id is " + userRepository.findByUserName(userName).getClient().getId());
		
		
		if (userRepository.findByUserName(userName).getClient().getId() != id) {
			throw new Exception("You cannot add/view users of another client " + userRepository.findByUserName(userName).getClient().getName());
		} else {
			return userService.getAllUsers(id);
		}
	}
	
	@GetMapping("/clients/{clientId}/users/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/clients/{clientId}/users")
	public void addUser(@RequestBody User user, @PathVariable int clientId) {
		user.setClient(new Client(clientId, ""));
		user.setCard(new Card(RandomNumberGenerator.generateRandom(12), ExpiryDateGenerator.getExpiryDate(36)));
		userService.addUser(user);
	}
	
	@PutMapping("/clients/{clientId}/users/{id}")
	public void updateUser(@PathVariable int id, @PathVariable int clientId, @RequestBody User user) {
		user.setClient(new Client(clientId, ""));
		userService.updateUser(user);
	}
	
	@DeleteMapping("/clients/{clientId}/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}

}