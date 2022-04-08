package com.hashedin.bank.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
	@Id
    @Column(name = "user_id")
	@GeneratedValue
	private int userId;
    @Column(name = "user_name")
	private String userName;
	private String password;

	@ManyToOne
	private Client client;
	
	@OneToOne(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	private Card card;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinTable(name="user_role",
		joinColumns = @JoinColumn(name="user_id"), 
		inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	public User() {
		
	}
	
	public User(int userId, String userName, String password, int clientId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.card = new Card(1, null);
		this.client = new Client(clientId, "");
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}