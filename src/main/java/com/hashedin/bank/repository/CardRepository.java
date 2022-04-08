package com.hashedin.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashedin.bank.model.Card;

public interface CardRepository extends JpaRepository<Card, Integer>{

}