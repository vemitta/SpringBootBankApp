package com.hashedin.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashedin.bank.model.Client;
import com.hashedin.bank.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
		
	public List<Client> getAllClients() {
		List<Client> clients = new ArrayList<>();
		clientRepository.findAll().forEach(clients::add);
		return clients;
	}
	
	public Optional<Client> getClient(int id) {
		return clientRepository.findById(id);
	}
	
	public void addClient(Client client) {
		clientRepository.save(client);
	}
	
	public void updateClient(int id, Client client) {
		clientRepository.save(client);
	}
	
	public void deleteClient(int id) {
		clientRepository.deleteById(id);
	}
}