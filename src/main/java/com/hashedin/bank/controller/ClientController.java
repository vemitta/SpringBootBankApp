package com.hashedin.bank.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hashedin.bank.model.Client;
import com.hashedin.bank.service.ClientService;

@RestController
@RequestMapping("/secure/rest/api")
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	@GetMapping("/clients")
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}
	
	@GetMapping("/clients/{id}")
	public Optional<Client> getClient(@PathVariable int id) {
		return clientService.getClient(id);
	}
	
	@PostMapping("/clients")
	public void addClient(@RequestBody Client client) {
		clientService.addClient(client);
	}
	
	@PutMapping("/clients/{id}")
	public void updateClient(@PathVariable int id, @RequestBody Client client) {
		clientService.updateClient(id, client);
	}
	
	@DeleteMapping("/clients/{id}")
	public void deleteClient(@PathVariable int id) {
		clientService.deleteClient(id);
	}
	
}
