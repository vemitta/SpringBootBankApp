package com.hashedin.bank.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="card")
public class Card {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "card_number")
	private long cardNumber;
	
	@Column(name = "card_expiry_date")
	private Date cardExpiryDate;
	
//	@OneToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
//	private Expense expense;
	
	public Card() {
		
	}
	
	public Card(long cardNumber, Date cardExpiryDate) {
		super();
		this.cardNumber = cardNumber;
		this.cardExpiryDate = cardExpiryDate;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getCardExpiryDate() {
		return cardExpiryDate;
	}
	public void setCardExpiryDate(Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
