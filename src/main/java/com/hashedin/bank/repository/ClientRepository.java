package com.hashedin.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashedin.bank.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
