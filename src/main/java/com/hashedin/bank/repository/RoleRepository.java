package com.hashedin.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashedin.bank.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{ 

}
