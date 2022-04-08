package com.hashedin.bank.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="client")
public class Client {
	
	@Id
	@Column(name = "client_id")
	@GeneratedValue
	private int id;
	private String name;
	
	public Client() {
	
	}
	
	public Client(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
